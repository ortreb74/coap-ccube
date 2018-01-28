package data;

/**
 * Created by drncl on 28/01/2018.
 */
public class Atom {

    // l'ordre
    int order;

    // la Composition
    int[] colors;

    // les coordonnées ?
    // ou les faces ?

    //  Variadic function
    // https://stackoverflow.com/questions/3960236/what-does-the-mean-in-a-parameter-list-doinbackgroundstring-params
    public Atom(int...colors) {
        this.colors = colors;
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
}
