package BeingsClass;

import java.util.ArrayList;

import MapClass.Case;
import MapClass.Map;
import Utils.RandomSingleton;

public class MasterOrc extends Orcs{
    public MasterOrc(Map m){
        super(m);
        ArrayList<Case> possibleCases = m.getRaceSafeZone("Orcs");
        Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()-1));
        getCurrentCase().setFilledWith(null);
        setCurrentCase(c);
        getCurrentCase().setFilledWith(this);
    }
}
