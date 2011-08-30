/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@ImplementedBy(BuilderParticipant.class)
public interface IXtextBuilderParticipant {

	/**
	 * Allows clients to perform additional steps in the build process such as code generation. It is not expected that
	 * any object in the resource set will be modified by a builder participant.
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	void build(IBuildContext context, IProgressMonitor monitor) throws CoreException;
	
	/**
	 * @noextend
	 */
	public static interface IBuildContext {
		IProject getBuiltProject();
		List<IResourceDescription.Delta> getDeltas();
		ResourceSet getResourceSet();
		BuildType getBuildType();
		void needRebuild();
	}
	
	public static enum BuildType {
		INCREMENTAL,
		FULL,
		CLEAN,
		/**
		 * Triggered if the persisted builder state could not be loaded.
		 */
		RECOVERY
	}
}
