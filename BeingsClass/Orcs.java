package BeingsClass;

public class Orcs extends BadGuys{
    public void meeting(MasterOrc o){
        o.addMessages(this.getAllMessage());
    }

}
