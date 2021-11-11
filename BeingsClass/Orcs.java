package BeingsClass;

public class Orcs extends BadGuys{
    public void meeting(MasterOrc o){
        o.addMessages(this.getAllMessage());
    }

    public void meeting(Orcs o){
        this.addMessages(o.getAllMessage());
        o.addMessages(this.getAllMessage());
    }

}
