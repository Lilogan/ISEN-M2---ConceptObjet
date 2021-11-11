package BeingsClass;

import java.util.Arrays;
import java.util.HashSet;

public class Orcs extends BadGuys{
    private static MasterOrc master;

    public Orcs(){
        if(Orcs.master == null){
            Orcs.master = new MasterOrc();
        }
    }

    public static MasterOrc getMaster(){
        return master;
    }

    public void meeting(MasterOrc o){
        o.addMessages(this.getAllMessage());
    }

    public void meeting(Orcs o){
        this.addMessages(o.getAllMessage());
        o.addMessages(this.getAllMessage());
    }

}
