package BeingsClass;

public class Gobelins extends BadGuys {
    public void meeting(Gobelins g){
        this.addMessages(g.getAllMessage());
        g.addMessages(this.getAllMessage());
    }

    public void move() {
        // TODO

    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }
}
