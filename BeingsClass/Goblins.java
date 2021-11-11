package BeingsClass;

public class Goblins extends BadGuys {
    public void meeting(Goblins g){
        this.addMessages(g.getAllMessage());
        g.addMessages(this.getAllMessage());
    }
}
