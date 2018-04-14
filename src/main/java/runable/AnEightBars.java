package runable;

import data.EightBars;

/**
 * Created by drncl on 13/04/2018.
 */
public class AnEightBars {

    /* https://stackoverflow.com/questions/869033/how-do-i-copy-an-object-in-java */
    /* Create a copy constructor: */

    public static void main(String[] args) {
        EightBars eightBars = new EightBars();

        EightBars copy = new EightBars(eightBars);

        String transformationId = "2";

        eightBars.transformation(transformationId);
        int compteur = 1;
        while (!(eightBars.equals(copy))) {
            eightBars.transformation(transformationId);
            compteur ++;
            if (compteur  > 100) break;
        }

        if (eightBars.equals(copy)) {
            System.out.println("Ordre : " + compteur);
        }
    }
}
