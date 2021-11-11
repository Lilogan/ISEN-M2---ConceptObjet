package BeingsClass;

import java.util.Arrays;
import java.util.HashSet;

public class Elfs extends GoodGuys {
    public void meeting(MasterElf e){
        e.addMessages(this.getAllMessage());
    }
    
    public void meeting(Elfs e){
        this.addMessages(e.getAllMessage());
        e.addMessages(this.getAllMessage());
    }

}
