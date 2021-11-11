package BeingsClass;

import java.util.ArrayList;

import MapClass.Case;
import MapClass.Map;
import Utils.RandomSingleton;

public class Gobelins extends BadGuys {
    private static MasterGobelin master;

    public Gobelins(Map m){
        ArrayList<Case> possibleCases = m.getEmtpyCases();
        Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()-1));
        setCurrentCase(c);
        c.setFilledWith(this);
    }

    public static MasterGobelin getMaster(){
        return master;
    }

    public static void setMaster(MasterGobelin m){
        if(master == null){
            master = m;
        }
    }

    public void meeting(MasterGobelin g){
        g.addMessages(this.getAllMessage());
    }

    public void meeting(Gobelins g){
        this.addMessages(g.getAllMessage());
        g.addMessages(this.getAllMessage());
    }
}
