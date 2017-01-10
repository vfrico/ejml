/*
 * Copyright (c) 2009-2017, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Efficient Java Matrix Library (EJML).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ejml.alg.dense.linsol.svd;

import org.ejml.alg.dense.linsol.GenericLinearSolverChecks_R64;
import org.ejml.alg.dense.linsol.GenericSolvePseudoInverseChecks_R64;
import org.ejml.data.DMatrixRow_F64;
import org.ejml.interfaces.linsol.LinearSolver;
import org.junit.Test;

/**
 * @author Peter Abeles
 */
public class TestSolvePseudoInverseSvd_R64 extends GenericLinearSolverChecks_R64 {

    public TestSolvePseudoInverseSvd_R64() {
        this.shouldFailSingular = false;
    }

    @Override
    protected LinearSolver<DMatrixRow_F64> createSolver(DMatrixRow_F64 A ) {
        return new SolvePseudoInverseSvd_R64(A.numRows,A.numCols);
    }

    @Test
    public void checkSingularBasic() {
        LinearSolver<DMatrixRow_F64> solver = new SolvePseudoInverseSvd_R64(10,10);
        GenericSolvePseudoInverseChecks_R64 checks = new GenericSolvePseudoInverseChecks_R64(solver);

        checks.all();
    }
}