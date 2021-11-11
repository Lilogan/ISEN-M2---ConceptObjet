package BeingsClass;

public class Humans extends GoodGuys{
    private static MasterHuman master;

    public Humans(){
        if(Humans.master == null){
            Humans.master = new MasterHuman();
        }
    }

    public static MasterHuman getMaster(){
        return master;
    }

    public void meeting(MasterHuman h){
        h.addMessages(this.getAllMessage());
    }

    public void meeting(Humans h){
        this.addMessages(h.getAllMessage());
        h.addMessages(this.getAllMessage());
    }
}


