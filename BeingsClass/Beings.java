package BeingsClass;


import java.util.ArrayList;
import MapClass.Case;

/**
 * EtreVivant
 */

public abstract class Beings {

        private int energy;
        private Case currentCase;
        private ArrayList<String> messages;
        private int lastMove;

        public void meeting(Beings b){
            
        }

        public abstract void move();
    
}