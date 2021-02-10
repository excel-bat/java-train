package algorithm.ortools;

import com.google.ortools.sat.CpModel;
import com.google.ortools.sat.CpSolver;
import com.google.ortools.sat.CpSolverSolutionCallback;
import com.google.ortools.sat.IntVar;

/**
 * @author shanyb
 * @title: OrtoolsCpModelSolution
 * @description: 题目：
 * 有x,y,z三个变量，取值范围都是[0,1,2]的整数，约束条件是 x!=y ，求 x,y,z的所有可能组合。
 * 解：
 * 使用ortools求出全部解
 * 采用Original-CP Cpmodel的方式，而非CP-SAT
 * 通过采用约束的方式规避无效解
 * @create: 2019-12-17 17:31
 * @link https://zhuanlan.zhihu.com/p/55580840
 */
public class OrtoolsCpModelSolution {
    static {
        ORToolsLoader.load();
    }
    
    public static void main(String[] args) {
        CpModel cpModel = new CpModel();
        IntVar x = cpModel.newIntVar(0, 2, "x");
        IntVar y = cpModel.newIntVar(0, 2, "y");
        IntVar z = cpModel.newIntVar(0, 2, "z");
        cpModel.addDifferent(x, y);
        //cpModel.
        CpSolver solver = new CpSolver();
        
        VarArraySolutionPrinter cb = new VarArraySolutionPrinter(new IntVar[]{x, y, z});
        solver.searchAllSolutions(cpModel, cb);
        
        System.out.println(cb.getSolutionCount() + " solutions found.");
    }
    
    
    static class VarArraySolutionPrinter extends CpSolverSolutionCallback {
        private final IntVar[] variableArray;
        private int solutionCount;
        
        public VarArraySolutionPrinter(IntVar[] variables) {
            variableArray = variables;
        }
        
        @Override
        public void onSolutionCallback() {
            System.out.printf("Solution #%d: time = %.02f s%n", solutionCount, wallTime());
            for (IntVar v : variableArray) {
                System.out.printf("  %s = %d%n", v.getName(), value(v));
            }
            solutionCount++;
        }
        
        public int getSolutionCount() {
            return solutionCount;
        }
    }
    
    
}
