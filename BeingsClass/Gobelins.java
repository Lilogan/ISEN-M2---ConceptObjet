package BeingsClass;

public class Gobelins extends BadGuys {
    public void meeting(MasterGobelin g){
        g.addMessages(this.getAllMessage());
    }

    public void meeting(Gobelins g){
        this.addMessages(g.getAllMessage());
        g.addMessages(this.getAllMessage());
    }
}
