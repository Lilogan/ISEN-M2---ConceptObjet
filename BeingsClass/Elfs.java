package BeingsClass;

public class Elfs extends GoodGuys {
    public void meeting(Elfs e){
        this.addMessages(e.getAllMessage());
        e.addMessages(this.getAllMessage());
    }

    public void move() {
        // TODO

    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }
}
