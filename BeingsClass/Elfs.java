package BeingsClass;

public class Elfs extends GoodGuys {
    public void meeting(MasterElf e){
        e.addMessages(this.getAllMessage());
    }
}
