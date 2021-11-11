package BeingsClass;

import java.util.ArrayList;

import MapClass.Case;
import MapClass.Map;
import Utils.RandomSingleton;

public class MasterGobelin extends Gobelins{
    public MasterGobelin(Map m){
        super(m);
        ArrayList<Case> possibleCases = m.getRaceSafeZone("Gobelins");
        Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()-1));
        getCurrentCase().setFilledWith(null);
        setCurrentCase(c);
        getCurrentCase().setFilledWith(this);
    }
}
