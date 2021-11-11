package BeingsClass;

public class Gobelins extends BadGuys {
    public void meeting(Gobelins g){
        this.addMessages(g.getAllMessage());
        g.addMessages(this.getAllMessage());
    }
}
