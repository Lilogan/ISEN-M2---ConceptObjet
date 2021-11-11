package BeingsClass;

import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.HashSet;

public class Elfs extends GoodGuys {
    private static MasterElf master;

    public Elfs(){
        if(Elfs.master == null){
            Elfs.master = new MasterElf();
        }
    }

    public static MasterElf getMaster(){
        return master;
    }

    public void meeting(MasterElf e){
        e.addMessages(this.getAllMessage());
    }
    
    public void meeting(Elfs e){
        this.addMessages(e.getAllMessage());
        e.addMessages(this.getAllMessage());
    }

}
