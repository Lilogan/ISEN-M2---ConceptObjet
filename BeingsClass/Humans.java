package BeingsClass;

public class Humans extends GoodGuys{
    public void meeting(Humans h){
        this.addMessages(h.getAllMessage());
        h.addMessages(this.getAllMessage());
    }

    public void move() {
        // TODO

    }
}
