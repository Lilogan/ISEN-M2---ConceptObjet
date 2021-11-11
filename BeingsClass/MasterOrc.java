package BeingsClass;

public class MasterOrc extends Orcs implements Master<Orcs> {

  private static MasterOrc instance;

  private MasterOrc() {
    super();
  }

  public final static MasterOrc getInstance() {
    if (MasterOrc.instance == null){
      MasterOrc.instance = new MasterOrc();
    }

    return MasterOrc.instance;
  }
}
