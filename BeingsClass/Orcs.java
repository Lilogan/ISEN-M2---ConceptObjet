package BeingsClass;

import java.util.Arrays;
import java.util.HashSet;

public class Orcs extends BadGuys{

    final private static HashSet<String> initalWords = new HashSet<>(Arrays.asList("h1","h2","h3"));

    public void meeting(Orcs o){
        this.addMessages(o.getAllMessage());
        o.addMessages(this.getAllMessage());
    }
}
