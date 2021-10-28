package BeingsClass;

import java.util.ArrayList;

public abstract class GoodGuys extends Beings {
    final private int nbWord = 3;

    public void meeting(GoodGuys b){
        ArrayList<String> myList = this.getSomeMessage(nbWord);
        ArrayList<String> otherList = b.getSomeMessage(nbWord);

        this.addMessages(myList);
        b.addMessages(otherList);
    }
}
