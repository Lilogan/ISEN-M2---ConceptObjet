package BeingsClass;

public class MasterHuman extends Humans implements Master<Humans>{

  private static MasterHuman instance;

  private MasterHuman() {
    super();
  }

  public final static MasterHuman getInstance() {
    if (MasterHuman.instance == null){
      MasterHuman.instance = new MasterHuman();
    }

    return MasterHuman.instance;
  }
}
