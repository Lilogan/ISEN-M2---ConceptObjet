package BeingsClass;

import java.util.ArrayList;

import MapClass.Case;
import MapClass.Map;
import Utils.RandomSingleton;

public class Orcs extends BadGuys{
    private static MasterOrc master;

    public Orcs(Map m){
        ArrayList<Case> possibleCases = m.getEmtpyCases();
        Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()-1));
        setCurrentCase(c);
        c.setFilledWith(this);
    }

    public static MasterOrc getMaster(){
        return master;
    }

    public static void setMaster(MasterOrc m){
        if(master == null){
            master = m;
        }
    }

    public void meeting(MasterOrc o){
        o.addMessages(this.getAllMessage());
    }

    public void meeting(Orcs o){
        this.addMessages(o.getAllMessage());
        o.addMessages(this.getAllMessage());
    }

}
