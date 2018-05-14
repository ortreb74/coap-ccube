package eight_bars.runable;

import eight_bars.data.EightBars;
import eight_bars.poe.Solver;

/**
 * Created by drncl on 02/05/2018.
 */
public class ComputeSolveEightBars {

    public static void main(String[] args) {

        EightBars eightBars = new EightBars('o','y','w','w','o','y','r','r');
        Integer constMaxBound = 10000;

        Solver solver = new Solver(eightBars,constMaxBound);
        solver.computeSolveIdentityGoal(10000);
        solver.report();

        solver.computeSolveEquivalent(10000);
        solver.report();

        solver.computeSolveEqual(10000);
        solver.report();


    }

}
