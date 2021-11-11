package BeingsClass;

public class Gobelins extends BadGuys {
    private static MasterGobelin master;

    public Gobelins(){
        if(Gobelins.master == null){
            Gobelins.master = new MasterGobelin();
        }
    }

    public static MasterGobelin getMaster(){
        return master;
    }

    public void meeting(MasterGobelin g){
        g.addMessages(this.getAllMessage());
    }

    public void meeting(Gobelins g){
        this.addMessages(g.getAllMessage());
        g.addMessages(this.getAllMessage());
    }
}
