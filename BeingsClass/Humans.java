package BeingsClass;

public class Humans extends GoodGuys{
    public void meeting(MasterHuman h){
        h.addMessages(this.getAllMessage());
    }
}
