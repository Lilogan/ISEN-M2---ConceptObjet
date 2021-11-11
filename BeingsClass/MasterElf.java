package BeingsClass;

public class MasterElf extends Elfs {

  private static MasterElf instance;

  private MasterElf() {
    super();
  }

  public final static MasterElf getInstance() {
    if (MasterElf.instance == null){
      MasterElf.instance = new MasterElf();
    }

    return MasterElf.instance;
  }

}
