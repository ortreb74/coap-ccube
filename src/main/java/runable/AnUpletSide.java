package runable;

import data.DraftAtom;

/**
 * Created by drncl on 28/01/2018.
 */

public class AnUpletSide {

    public static void main(String[] args) {

        DraftAtom baseAtom = new DraftAtom(1,2,3);

        System.out.println("baseAtom.getUpletSide().size() : " + baseAtom.getUpletSide().size());

        for(DraftAtom atom : baseAtom.getUpletSide()) {
            atom.display();
        }

    }

}
