package BeingsClass;

import java.util.Arrays;
import java.util.HashSet;

public class Humans extends GoodGuys{

    final private static HashSet<String> initalWords = new HashSet<>(Arrays.asList("h1","h2","h3"));

    public void meeting(Humans h){
        this.addMessages(h.getAllMessage());
        h.addMessages(this.getAllMessage());
    }
}
