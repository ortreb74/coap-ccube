package eight_bars;

import eight_bars.data.EightBars;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by drncl on 02/05/2018.
 */
public class IdentityGoal {

    List<EightBars> availableGoals = new ArrayList<EightBars>();

    public IdentityGoal() {
        EightBars identity = new EightBars();
        availableGoals.add(identity);

        for (int i = 0 ; i < 3 ; i++) {
            EightBars eb = new EightBars(identity.tDownTranslation());
            availableGoals.add(eb);
        }
    }

    public boolean Goal(EightBars candidate) {
        for (EightBars goal : availableGoals) {
            if (goal.equivalent(candidate)) return true;
        }

        return false;
    }
}
