package BeingsClass;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import MapClass.Case;
import Utils.RandomSingleton;

/**
 * EtreVivant
 */

public abstract class Beings {

        final private static int minWord = 1;
        final private static int maxWord = 4;
        final private static int startingEnergy =10;
        private int energy;
        private Case currentCase;
        private Case startCase;
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
                        diffMessages.addAll(b.messages);
                        diffMessages.removeAll(this.messages);
                } else {
                        diffMessages.addAll(this.messages);
                        diffMessages.removeAll(b.messages);
                }

                Collections.shuffle(diffMessages, RandomSingleton.getInstance().getRandom());
                nbWord = nbWord > diffMessages.size() ? diffMessages.size() : nbWord;
                diffMessages = diffMessages.subList(0,nbWord);

                if (win) {
                        this.messages.addAll(diffMessages);
                        b.messages.removeAll(diffMessages);
                } else {
                        b.messages.addAll(diffMessages);
                        this.messages.removeAll(diffMessages);
                }

        }

        public Boolean fight(Beings b) {
                return RandomSingleton.getInstance().nextBoolean();
        }

        public void move(){
                Float percentEnergy = (float)(energy/startingEnergy);
                startCase=currentCase;
                if (percentEnergy == 0){
                        currentCase.becomeObstacle();
                } else if ( percentEnergy >= 0.4 ) {
                        int nbrCase=RandomSingleton.getInstance().nextInt((int)0.4*startingEnergy);
                        for (int i=0;i<nbrCase; i++){
                                for (int k=0; k<currentCase.getMap().allCasePossible(currentCase.getX(), currentCase.getY()).size();k++){
                                        if(currentCase.getMap().allCasePossible.Case[k]!=(startCase.getX(),startCase.getY()) {
                                                ArrayList<Case> cases = currentCase.getMap().allCasePossible(currentCase.getX(), currentCase.getY());
                                                Case c = cases.get(RandomSingleton.getInstance().nextInt(cases.size() - 1));
                                                if (c.checkIsObstacle()) {
                                                        break;
                                                }
                                                else if(c.checkIsSomeone()){
                                                        meeting();
                                                        break;
                                                }
                                                //add condition to start fight if there is someone on c
                                                else {
                                                        currentCase = c;
                                                }
                                        }
                                }
                                //}
                        }
                }
        }
        public void returnToMaster(){
                case posMaster= new(case); //faut voir comment avoir la case ou se trouve master
                while (((currentCase.getX+1==posMaster.getX)&&(currentCase.getY==posMaster.getY))||((currentCase.getX-1==posMaster.getX)&&(currentCase.getY==posMaster.getY))||((currentCase.getX==posMaster.getX)&&(currentCase.getY+1==posMaster.getY))||((currentCase.getX==posMaster.getX)&&(currentCase.getY-1==posMaster.getY))){
                          if (currentCase.getX<posMaster.getX){
                                  if(c.checkIsObstacle()){
                                        break;
                                }
                                //add condition to start fight if there is someone on c
                                else {
                                        // comment on remplace?
                                        currentCase = ;
                                }

                          }
                          if (currentCase.getX>posMaster.getX){
                                  if(c.checkIsObstacle()){
                                        break;
                                }
                                //add condition to start fight if there is someone on c
                                else {
                                        // comment on remplace?
                                        currentCase = ;
                                }

                          }
                          if (currentCase.getY<posMaster.getY){
                                  if(c.checkIsObstacle()){
                                        break;
                                }
                                //add condition to start fight if there is someone on c
                                else {
                                        // comment on remplace?
                                        currentCase = ;
                                }

                          }
                          if (currentCase.getY>posMaster.getY){
                                  if(c.checkIsObstacle()){
                                        break;
                                }
                                //add condition to start fight if there is someone on c
                                else {
                                        // comment on remplace?
                                        currentCase = ;
                                }

                          }
                }
        }

}