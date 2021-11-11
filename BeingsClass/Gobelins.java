package BeingsClass;

public class Gobelins extends BadGuys {
    public void meeting(MasterGobelin g){
        g.addMessages(this.getAllMessage());
    }
}
