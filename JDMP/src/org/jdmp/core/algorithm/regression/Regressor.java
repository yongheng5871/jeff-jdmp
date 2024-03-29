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

package org.jdmp.core.algorithm.regression;

import org.jdmp.core.dataset.RegressionDataSet;
import org.jdmp.core.sample.Sample;
import org.ujmp.core.Matrix;

public interface Regressor {

	public static final String INPUT = "Input";

	public static final String WEIGHT = "Weight";

	public static final String PREDICTED = "Predicted";

	public static final String DIFFERENCE = "Difference";

	public static final String RMSE = "RMSE";

	public void train(RegressionDataSet dataSet) throws Exception;

	public void reset() throws Exception;

	public void train(Matrix input, Matrix sampleWeight, Matrix target) throws Exception;

	public void predict(Sample sample) throws Exception;

	public Matrix predict(Matrix input) throws Exception;

	public void train(Matrix input, Matrix target) throws Exception;

	public Matrix predict(Matrix input, Matrix sampleWeight) throws Exception;

	public void train(Sample sample) throws Exception;

	public void predict(RegressionDataSet dataSet) throws Exception;

	public Regressor emptyCopy() throws Exception;

}
