package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drncl on 28/01/2018.
 */
public class DraftAtom {

    // l'ordre
    int order;

    // la Composition
    int[] colors;

    // les coordonnées ?
    // ou les faces ?
    int x;
    int y;
    int f = 0;

    //  Variadic function
    // https://stackoverflow.com/questions/3960236/what-does-the-mean-in-a-parameter-list-doinbackgroundstring-params
    public DraftAtom(int...colors) {
        this.colors = colors;
    }

    public DraftAtom(DraftAtom atom) {
        colors = atom.colors;
    }

    public int getOrder() {
        return colors.length;
    }

    public void display() {
        String result;
        result = "(";

        for (int index = 0 ; index < getOrder() ; index++) {
            if (index != 0) result += ", ";
            result += colors[index];

        }
        result += ")";
        System.out.println(result);
    }

    public List<DraftAtom> getUpletSide() {
        List<DraftAtom> atoms = new ArrayList<DraftAtom>();

        DraftAtom atom = new DraftAtom(this);

        atom.setx(0);
        atom.sety(0);

        atoms.add(atom);

        DraftAtom vertex = new DraftAtom(colors[0], colors[1]);
        vertex.setx(1);
        vertex.sety(0);

        atoms.add(vertex);

        DraftAtom copy = new DraftAtom(vertex);

        copy.setx(2);

        atoms.add(copy);

        return atoms;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }
}
