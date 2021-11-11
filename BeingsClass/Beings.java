package BeingsClass;


import MapClass.Case;
import MapClass.SafeZoneCase;
import Utils.RandomSingleton;

import java.security.interfaces.ECKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * EtreVivant
 */

public abstract class Beings {

        final private static int minWord = 1;
        final private static int maxWord = 4;
        final private static int startingEnergy =20;
        private int energy = 20;
        private Case startCase;
        private Case currentCase;
        private ArrayList<String> messages;

        public ArrayList<String> getAllMessage() {
                return this.messages;
        }

        public ArrayList<String> getSomeMessage(int number) {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                        list.add(this.messages.get(RandomSingleton.getInstance().nextInt(messages.size())));
                }
                return list;
        }

        public void addMessages(ArrayList<String> messages){
                this.messages.addAll(messages);
        }

        public void meeting(Beings b){
                Boolean win = this.fight(b);
                List<String> diffMessages = new ArrayList<>();
                int nbWord = RandomSingleton.getInstance().nextInt(Beings.minWord, Beings.maxWord);

                if (win) {
                        if(b.messages != null && b.messages.size() > 0){
                                diffMessages.addAll(b.messages);
                                diffMessages.removeAll(this.messages);
                        }
                } else {
                        if(this.messages != null && this.messages.size() > 0){
                                diffMessages.addAll(this.messages);
                                diffMessages.removeAll(b.messages);
                        }
                        
                }

                Collections.shuffle(diffMessages, RandomSingleton.getInstance().getRandom());
                nbWord = nbWord > diffMessages.size() ? diffMessages.size() : nbWord;
                diffMessages = diffMessages.subList(0,nbWord);

                if (win) {
                        if(diffMessages.size() > 0){
                                this.messages.addAll(diffMessages);
                                b.messages.removeAll(diffMessages);
                        }
                        
                } else {
                        if(diffMessages.size() > 0){
                                b.messages.addAll(diffMessages);
                                this.messages.removeAll(diffMessages);
                        }
                }

        }

        public Boolean fight(Beings b) {
                return RandomSingleton.getInstance().nextBoolean();
        }

        protected Case getCurrentCase(){
                return currentCase;
        }

        protected void setCurrentCase(Case c){
                currentCase = c;
        }

        public int getEnergy(){
                return energy;       
        }

        public void move() {
                startCase = currentCase;
                if (energy <= 0 || (int)(0.3*energy) <= 0) {
                    currentCase.becomeObstacle(this);
                } else {
                    int nbrCase = RandomSingleton.getInstance().nextInt(energy);
                    for (int i = 0; i < nbrCase; i++) {
                        if(energy <= 0.4*startingEnergy){
                                if(returnToMaster()){
                                        break;
                                }
                        }
                        ArrayList<Case> casesPossible= currentCase.getMap().allCasePossible(currentCase.getX(), currentCase.getY());
                        if (casesPossible.size() == 1) {
                            currentCase.setFilledWith(null);
                            currentCase=casesPossible.get(0);
                            currentCase.setFilledWith(this);
                            energy--;
                        }
                        else {
                            Case toRm = null;
                            ArrayList<Case> possibleCases = currentCase.getMap().allCasePossible(currentCase.getX(), currentCase.getY());
                            for (Case c : possibleCases) {
                                if (c == startCase) {
                                    toRm = c;
                                    break;
                                }
                            }
                            if (toRm != null) {
                                possibleCases.remove(toRm);
                            }
                            Case c = possibleCases.get(RandomSingleton.getInstance().nextInt(possibleCases.size()-1));
                            if (c.checkIsObstacle()) {
                                break;
                            } else if (c.checkFilledWith() != null) {
                                meeting(c.checkFilledWith());
                            } else {
                                    currentCase.setFilledWith(null);
                                    currentCase = c;
                                    currentCase.setFilledWith(this);
                                    energy--;
                            }
                        }
                        if(energy == 0){
                                currentCase.becomeObstacle(this);
                        }
                    }
                }

                if(currentCase instanceof SafeZoneCase){
                        SafeZoneCase szc = (SafeZoneCase)currentCase;
                        if(this instanceof Orcs && szc.getRaceName()=="Orcs"){
                                energy = startingEnergy;
                        }else if(this instanceof Elfs && szc.getRaceName() == "Elfs"){
                                energy=startingEnergy;
                        }else if(this instanceof Humans && szc.getRaceName() == "Human"){
                                energy=startingEnergy;
                        }else if(this instanceof Gobelins && szc.getRaceName() == "Gobelins"){
                                energy=startingEnergy;
                        }else{
                                energy = 0;
                        }

                }
            }
        public boolean returnToMaster(){
                Beings master;
                if(this instanceof Humans){
                        master = Humans.getMaster();
                }else if(this instanceof Elfs){
                        master = Elfs.getMaster();
                }else if(this instanceof Orcs){
                        master = Orcs.getMaster();
                }else if(this instanceof Gobelins){
                        master = Gobelins.getMaster();
                }else{
                        return false;
                }
                int distance = (int)Math.sqrt((master.getCurrentCase().getX() - this.currentCase.getX())^2 + (master.getCurrentCase().getY() - this.currentCase.getY())^2);
                if(energy > distance+5){
                        ArrayList<Case> possibleCases = currentCase.getMap().allCasePossible(master.getCurrentCase().getX(), master.getCurrentCase().getY());
                        for(Case c: possibleCases){
                                if(c instanceof SafeZoneCase){
                                        currentCase.setFilledWith(null);
                                        currentCase = c;
                                        currentCase.setFilledWith(this);
                                        return true;
                                }
                        }
                }

                return false;


        }

}