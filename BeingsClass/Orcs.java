package BeingsClass;

public class Orcs extends BadGuys{
    public void meeting(Orcs o){
        this.addMessages(o.getAllMessage());
        o.addMessages(this.getAllMessage());
    }

    public void move() {
        // TODO

    }

}
