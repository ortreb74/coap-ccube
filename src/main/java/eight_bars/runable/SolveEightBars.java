package eight_bars.runable;

import eight_bars.IdentityGoal;
import eight_bars.data.EightBars;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by drncl on 13/04/2018.
 */
public class SolveEightBars {

    public static int max = 100000;

    public static void main(String[] args) {
        EightBars eightBars = new EightBars('o','y','w','w','o','y','r','r');

        //eightBars = new EightBars('r','r','y','y','o','o','w','w');

        EightBars identity = new EightBars();

        System.out.println(eightBars.toWord());
        System.out.println(identity.toWord());

        int compteur = 0;

        String combination = "";

        // eightBars.equals(identity)
        // eightBars.equivalent(identity)

        IdentityGoal goals = new IdentityGoal();

        while (!(goals.Goal(eightBars))) {
            // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
            String transformationId = String.valueOf(ThreadLocalRandom.current().nextInt(0, 2 + 1));
            combination += transformationId;
            eightBars.transformation(transformationId);
            compteur ++;
            if (compteur  > max) break;
        }

        if (compteur  <= max) {
            System.out.println("Soluce : (" + combination.length() + ") : " + combination);
        }

        System.out.println(eightBars.toWord());
    }
}
