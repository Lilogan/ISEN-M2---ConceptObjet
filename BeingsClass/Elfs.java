package BeingsClass;

import java.util.Arrays;
import java.util.HashSet;

public class Elfs extends GoodGuys {

    final private static HashSet<String> initalWords = new HashSet<>(Arrays.asList("e1","e2","e3"));

    public void meeting(Elfs e){
        this.addMessages(e.getAllMessage());
        e.addMessages(this.getAllMessage());
    }
}
