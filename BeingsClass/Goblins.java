package BeingsClass;

import java.util.Arrays;
import java.util.HashSet;

public class Goblins extends BadGuys {

    final private static HashSet<String> initalWords = new HashSet<>(Arrays.asList("g1","g2","g3"));

    public void meeting(MasterGoblin g){
        g.addMessages(this.getAllMessage());
    }

    public void meeting(Goblins g){
        this.addMessages(g.getAllMessage());
        g.addMessages(this.getAllMessage());
    }
}
