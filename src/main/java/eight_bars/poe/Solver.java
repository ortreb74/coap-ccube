package eight_bars.poe;

import eight_bars.IdentityGoal;
import eight_bars.data.EightBars;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by drncl on 02/05/2018.
 */

public class Solver {

    EightBars identity = new EightBars();

    EightBars constGuessWork;
    Integer constMaxBound = 10;

    String inMethodName;
    Integer inTestWeight;

    Integer outNbFail;
    Integer outTotalMove;

    public Solver(EightBars constGuessWork, Integer constMaxBound) {
        this.constGuessWork = constGuessWork;
        this.constMaxBound = constMaxBound;
    }

    public void computeSolveIdentityGoal(Integer testWeight) {
        outNbFail = 0;
        outTotalMove = 0;

        inTestWeight = testWeight;
        inMethodName = "Identity Goal";

        for (int i = 0 ; i < testWeight ; i++) {
            Integer resultNumberOrCode = solveIdentityGoal();

            if (resultNumberOrCode == - 1) outNbFail ++; else outTotalMove += resultNumberOrCode;
        }
    }

    public void computeSolveEquivalent(Integer testWeight) {
        outNbFail = 0;
        outTotalMove = 0;

        inTestWeight = testWeight;
        inMethodName = "Equivalence";

        for (int i = 0 ; i < testWeight ; i++) {
            Integer resultNumberOrCode = solveEquivalent();

            if (resultNumberOrCode == - 1) outNbFail ++; else outTotalMove += resultNumberOrCode;
        }
    }

    public void computeSolveEqual(Integer testWeight) {
        outNbFail = 0;
        outTotalMove = 0;

        inTestWeight = testWeight;
        inMethodName = "Equivalence";

        for (int i = 0 ; i < testWeight ; i++) {
            Integer resultNumberOrCode = solveEqual();

            if (resultNumberOrCode == - 1) outNbFail ++; else outTotalMove += resultNumberOrCode;
        }
    }

    public void report() {
        System.out.println("Hypothèses : ");
        System.out.println("Nombre maximum d'essai : " + constMaxBound);
        System.out.println("Position recherchée : " + constGuessWork.toWord());

        System.out.println("Nom de la transformation : " + inMethodName);

        if (outNbFail.equals(inTestWeight)) {
            System.out.println("La solution n'a jamais été trouvée");
        } else {
            if (outNbFail == 0) System.out.println("la solution a toujours été trouvée"); else {
                System.out.println("la solution a été trouvée " + (inTestWeight - outNbFail) + "/" + inTestWeight + " : " + (inTestWeight - outNbFail) * 100 / inTestWeight + "% des fois");
            }

            System.out.println("Nombre d'essais moyen pour trouver la solution : " + outTotalMove / (inTestWeight - outNbFail));
        }
    }

    private Integer solveIdentityGoal() {
        Integer compteur = 0;

        EightBars eightBars = new EightBars(constGuessWork);

        IdentityGoal goals = new IdentityGoal();

        while (!(goals.Goal(eightBars))) {
            // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
            String transformationId = String.valueOf(ThreadLocalRandom.current().nextInt(0, 2 + 1));
            // combination += transformationId;
            eightBars.transformation(transformationId);
            compteur++;
            if (compteur > constMaxBound) return -1;
        }

        return compteur;
    }

    private Integer solveEquivalent() {
        Integer compteur = 0;

        EightBars eightBars = new EightBars(constGuessWork);

        while (!eightBars.equivalent(identity)) {
            // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
            String transformationId = String.valueOf(ThreadLocalRandom.current().nextInt(0, 2 + 1));
            // combination += transformationId;
            eightBars.transformation(transformationId);
            compteur++;
            if (compteur > constMaxBound) return -1;
        }

        return compteur;
    }

    private Integer solveEqual() {
        Integer compteur = 0;

        EightBars eightBars = new EightBars(constGuessWork);

        while (!eightBars.equals(identity)) {
            // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
            String transformationId = String.valueOf(ThreadLocalRandom.current().nextInt(0, 2 + 1));
            // combination += transformationId;
            eightBars.transformation(transformationId);
            compteur++;
            if (compteur > constMaxBound) return -1;
        }

        return compteur;
    }


}
