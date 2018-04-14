package data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Créé par Pierre le vendredi 13 avril 2018.
 *
 * Je peux utiliser un nommage litéral pour éviter la confusion avec les opérations
 *
 */

public class EightBars {

    /* une chaîne : un premier niveau d'abstraction */

    /* je crée un tableau */
    // https://stackoverflow.com/questions/1200621/how-do-i-declare-and-initialize-an-array-in-java

    // donc je veux faire une copie qui ne soit pas simplement un mirroir.

    Atom [] atoms = new Atom[8];

    // le buffer permet de sauvegarder un atome
    Atom buffer;


    public EightBars() {
        for (int i = 0 ; i < atoms.length ; i++) {
            atoms[i] = new Atom(i);
        }
    }

    public EightBars(EightBars other) {
        for (int i = 0 ; i < atoms.length ; i++) {
            atoms[i] = other.atoms[i];
        }
    }

    public EightBars(char...colors) {
        Set<Integer> reminder = new HashSet<Integer>();

        for (int i = 0 ; i < colors.length ; i++) {
            Integer colorIndex = Atom.getColorIndex(colors[i]);
            if (reminder.contains(colorIndex)) {
                atoms[i] = new Atom(colorIndex * 2 + 1);
            } else {
                reminder.add(colorIndex);
                atoms[i] = new Atom(colorIndex * 2);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        EightBars other = (EightBars) obj;

        for (int i = 0 ; i < atoms.length ; i++) {
            if (! atoms[i].equals(other.atoms[i])) {
                //System.out.println ("gauche : " + atoms[i].dump());
                //System.out.println ("droite : " + other.atoms[i].dump());
                return false;
            }
        }

        return true;
    }

    public boolean equivalent(EightBars other) {

        for (int i = 0 ; i < atoms.length ; i++) {
            if (! atoms[i].equivalent(other.atoms[i])) return false;
        }

        return true;
    }

    public void transformation(String transformationId) {
        String log = transformationId + " : " + toWord();
        switch (transformationId) {
            case "0" : tHalfRorate(); break;
            case "1" : tHalfTranslation(); break;
            case "2" : tTranslation(); break;
        }

        log += " ==> " + toWord();
        System.out.println(log);
    }

    private void save(int x, int y) {
        buffer = atoms[x*2+y];
    }

    private void move(int xEnd, int yEnd, int xStart, int yStart) {
        atoms[xEnd * 2 + yEnd] = atoms[xStart * 2 + yStart];
    }

    private void getback(int x, int y) {
        atoms[x*2+y] = buffer;
    }

    public void tHalfRorate() {

        save(0,0);
        move(0,0,0,1); // [0,0] <-- [0,1]
        getback(0,1);

    }

    public void tHalfTranslation() {

        save(0,0);

        move(0,0,1,0); // [0,0] <-- [1,0]
        move(1,0,2,0); // [1,0] <-- [2,0]
        move(2,0,3,0); // [2,0] <-- [3,0]


        getback(3,0);
    }


    public void tTranslation() {
        tHalfTranslation();

        save(0,1);

        move(0,1,1,1); // [0,1] <-- [1,1]
        move(1,1,2,1); // [1,1] <-- [2,1]
        move(2,1,3,1); // [2,1] <-- [3,1]

        getback(3,1);
    }


    public String toWord() {
        String result = "";

        for (int i = 0 ; i < atoms.length ; i++) {
            result += atoms[i];
        }

        return result;
    }
}
