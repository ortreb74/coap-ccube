package data;

/**
 * Created by drncl on 13/04/2018.
 */
public class Atom {

    int id;
    int idColor;

    static String[] color = {"red","yellow","orange","white","blue","green"};

    public Atom(int i) {
        id = i;
        idColor = i / 2;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public String dump() {
        return "(" + String.valueOf(id) + "," + String.valueOf(idColor) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atom atom = (Atom) o;

        if (id != atom.id) return false;
        return idColor == atom.idColor;
    }

    public boolean equivalent(Atom other) {
        return other.idColor == idColor;
    }

    public static Integer getColorIndex(char color) {
        switch (color) {
            case 'r' : return 0;
            case 'y' : return 1;
            case 'o' : return 2;
            case 'w' : return 3;
        }

        return 10;
    }


}
