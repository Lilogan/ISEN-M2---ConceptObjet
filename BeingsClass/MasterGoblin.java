package BeingsClass;

public class MasterGoblin extends Goblins{

  private static MasterGoblin instance;

  private MasterGoblin() {
    super();
  }

  public final static MasterGoblin getInstance() {
    if (MasterGoblin.instance == null){
      MasterGoblin.instance = new MasterGoblin();
    }

    return MasterGoblin.instance;
  }
}
