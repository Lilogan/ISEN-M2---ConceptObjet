package Utils;

import java.util.ArrayList;
import java.util.Collections;

import BeingsClass.Beings;
import BeingsClass.Elfs;
import BeingsClass.Gobelins;
import BeingsClass.Humans;
import BeingsClass.MasterElf;
import BeingsClass.MasterGobelin;
import BeingsClass.MasterHuman;
import BeingsClass.MasterOrc;
import BeingsClass.Orcs;
import MapClass.Map;


/**
 * Main
 */
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) {
        Map m = new Map(20, 20, 5);
        Elfs.setMaster(new MasterElf(m));
        Gobelins.setMaster(new MasterGobelin(m));
        Humans.setMaster(new MasterHuman(m));
        Orcs.setMaster(new MasterOrc(m));
        ArrayList<Beings> characters = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            characters.add(new Elfs(m));
            characters.add(new Humans(m));
            characters.add(new Gobelins(m));
            characters.add(new Orcs(m));
        }
        ArrayList<Beings> toRm = new ArrayList<>();
        while(true){
            toRm.clear();
            m.display();
            Collections.shuffle(characters);
            for(Beings b: characters){
                b.move();
            }
            
            // for(Beings b: characters){
            //     if(b.getEnergy() == 0){
            //         toRm.add(b);
            //     }
            // }

            // characters.removeAll(toRm);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("ERROR");
            }
            
        }
    }

}