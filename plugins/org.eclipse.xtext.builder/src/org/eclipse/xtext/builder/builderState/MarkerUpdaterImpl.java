/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MarkerUpdaterImpl implements IMarkerUpdater {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private MarkerCreator markerCreator;

	@Inject
	private IStorage2UriMapper mapper;

	private final static Logger log = Logger.getLogger(MarkerUpdaterImpl.class);

	public void updateMarker(ResourceSet resourceSet, ImmutableList<Delta> resourceDescriptionDeltas,
			IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, Messages.MarkerUpdaterImpl_ValidateResources,
				resourceDescriptionDeltas.size());
		subMonitor.subTask(Messages.MarkerUpdaterImpl_ValidateResources);
		for (Delta delta : resourceDescriptionDeltas) {
			if (subMonitor.isCanceled())
				throw new OperationCanceledException();
			if (delta.getNew() != null) {
				Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(delta.getNew().getURI());
				SubMonitor child = subMonitor.newChild(1);
				child.setWorkRemaining(3);
				for (Pair<IStorage, IProject> pair : storages) {
					child.setWorkRemaining(3);
					if (pair.getFirst() instanceof IFile) {
						IFile file = (IFile) pair.getFirst();
						if (file.isAccessible() && pair.getSecond().isAccessible() && !pair.getSecond().isHidden()) {
							Resource resource = resourceSet.getResource(delta.getNew().getURI(), true);
							addMarkers(file, resource, child.newChild(2));
						}
					} else {
						child.worked(1);
					}
				}
			} else {
				Iterable<Pair<IStorage, IProject>> storages = mapper.getStorages(delta.getOld().getURI());
				for (Pair<IStorage, IProject> pair : storages) {
					if (pair.getFirst() instanceof IFile) {
						IFile file = (IFile) pair.getFirst();
						if (file.isAccessible() && pair.getSecond().isAccessible() && !pair.getSecond().isHidden()) {
							try {
								file.deleteMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_ZERO);
								file.deleteMarkers(MarkerTypes.NORMAL_VALIDATION, true, IResource.DEPTH_ZERO);
							} catch (CoreException ex) {
								log.error(ex.getMessage(), ex);
							}
						}
					}
				}
				subMonitor.worked(1);
			}
		}
	}

	protected void addMarkers(IFile file, Resource resource, final IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
		try {
			IResourceServiceProvider provider = 
				resourceServiceProviderRegistry.getResourceServiceProvider(resource.getURI());
			if (provider == null)
				return;

			IResourceValidator resourceValidator = provider.getResourceValidator();
			List<Issue> list = resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, getCancelIndicator(subMonitor));
			if (subMonitor.isCanceled())
				throw new OperationCanceledException();
			subMonitor.worked(1);
			file.deleteMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_ZERO);
			file.deleteMarkers(MarkerTypes.NORMAL_VALIDATION, true, IResource.DEPTH_ZERO);
			for (Issue issue : list) {
				markerCreator.createMarker(issue, file, MarkerTypes.forCheckType(issue.getType()));
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
	}

	private CancelIndicator getCancelIndicator(final IProgressMonitor monitor) {
		return new CancelIndicator() {
			public boolean isCanceled() {
				return monitor.isCanceled();
			}
		};
	}

}
