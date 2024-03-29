/*
 * Copyright (C) 2008-2009 Holger Arndt, A. Naegele and M. Bundschus
 *
 * This file is part of the Java Data Mining Package (JDMP).
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership and licensing.
 *
 * JDMP is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * JDMP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with JDMP; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.jdmp.core.module;

import java.lang.reflect.Constructor;
import java.util.logging.Level;

import org.jdmp.core.AbstractCoreObject;
import org.jdmp.core.algorithm.Algorithm;
import org.jdmp.core.dataset.DataSet;
import org.jdmp.core.sample.Sample;
import org.jdmp.core.util.DefaultObservableMap;
import org.jdmp.core.variable.Variable;
import org.ujmp.core.interfaces.GUIObject;

public abstract class AbstractModule extends AbstractCoreObject implements Module {
	private transient GUIObject guiObject = null;

	protected final DefaultObservableMap<Algorithm> algorithms = new DefaultObservableMap<Algorithm>();

	protected final DefaultObservableMap<Sample> samples = new DefaultObservableMap<Sample>();

	protected final DefaultObservableMap<DataSet> dataSets = new DefaultObservableMap<DataSet>();

	protected final DefaultObservableMap<Variable> variables = new DefaultObservableMap<Variable>();

	protected final DefaultObservableMap<Module> modules = new DefaultObservableMap<Module>();

	public DefaultObservableMap<Module> getModules() {
		return modules;
	}

	public final DefaultObservableMap<DataSet> getDataSets() {
		return dataSets;
	}

	public final DefaultObservableMap<Algorithm> getAlgorithms() {
		return algorithms;
	}

	public final DefaultObservableMap<Variable> getVariables() {
		return variables;
	}

	public final DefaultObservableMap<Sample> getSamples() {
		return samples;
	}

	public void clear() {
		algorithms.clear();
		dataSets.clear();
		modules.clear();
		samples.clear();
		variables.clear();
	}

	public final GUIObject getGUIObject() {
		if (guiObject == null) {
			try {
				Class<?> c = Class.forName("org.jdmp.gui.module.ModuleGUIObject");
				Constructor<?> con = c.getConstructor(new Class<?>[] { Module.class });
				guiObject = (GUIObject) con.newInstance(new Object[] { this });
			} catch (Exception e) {
				logger.log(Level.WARNING, "cannot create module gui object", e);
			}
		}
		return guiObject;
	}

	@Override
	public final String toString() {
		if (getLabel() == null) {
			return getClass().getSimpleName();
		} else {
			return getClass().getSimpleName() + " [" + getLabel() + "]";
		}
	}

	public void notifyGUIObject() {
		if (guiObject != null) {
			guiObject.fireValueChanged();
		}
	}

}
