package BeingsClass;

import java.util.ArrayList;

import MapClass.Case;
import MapClass.Map;
import Utils.RandomSingleton;

public class MasterHuman extends Humans{
    public MasterHuman(Map m){
        super(m);
        ArrayList<Case> possibleCases = m.getRaceSafeZone("Humans");
        Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()-1));
        getCurrentCase().setFilledWith(null);
        setCurrentCase(c);
        getCurrentCase().setFilledWith(this);
    }
}
