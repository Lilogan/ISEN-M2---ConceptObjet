package BeingsClass;

import java.util.ArrayList;

import MapClass.*;
import Utils.RandomSingleton;

public class Elfs extends GoodGuys {
    private static MasterElf master;

    public Elfs(Map m){
        ArrayList<Case> possibleCases = m.getEmtpyCases();
        Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()));
        setCurrentCase(c);
        c.setFilledWith(this);

    }

    public static MasterElf getMaster(){
        return master;
    }

    public static void setMaster(MasterElf m){
        if(master == null){
            master = m;
        }
    }
    public void meeting(MasterElf e){
        e.addMessages(this.getAllMessage());
    }
    
    public void meeting(Elfs e){
        this.addMessages(e.getAllMessage());
        e.addMessages(this.getAllMessage());
    }

}
