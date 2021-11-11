package BeingsClass;

import java.util.ArrayList;

import MapClass.*;
import Utils.RandomSingleton;

public class Humans extends GoodGuys{
    private static MasterHuman master;

    public Humans(Map m){
        ArrayList<Case> possibleCases = m.getEmtpyCases();
        Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()-1));
        setCurrentCase(c);
        c.setFilledWith(this);
    }

    public static MasterHuman getMaster(){
        return master;
    }

    public static void setMaster(MasterHuman m){
        if(master == null){
            master = m;
        }
    }

    public void meeting(MasterHuman h){
        h.addMessages(this.getAllMessage());
    }

    public void meeting(Humans h){
        this.addMessages(h.getAllMessage());
        h.addMessages(this.getAllMessage());
    }
}


