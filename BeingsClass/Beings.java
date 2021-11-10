package BeingsClass;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import MapClass.Case;

/**
 * EtreVivant
 */

public abstract class Beings {

        final private static Random random = new Random(12345);
        final private static int minWord = 1;
        final private static int maxWord = 4;
        final private static int startingEnergy =10;
        private int energy;
        private Case currentCase;
        private ArrayList<String> messages;
        private int lastMove;

        public ArrayList<String> getAllMessage() {
                return this.messages;
        }

        public ArrayList<String> getSomeMessage(int number) {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                        list.add(this.messages.get(random.nextInt(messages.size())));
                }
                return list;
        }

        public void addMessages(ArrayList<String> messages){
                this.messages.addAll(messages);
        }

        public void meeting(Beings b){
                Boolean win = this.fight(b);
                List<String> diffMessages = new ArrayList<>();
                int nbWord = Beings.random.nextInt(Beings.maxWord - Beings.minWord) + 1 + Beings.minWord;

                if (win) {
                        diffMessages.addAll(b.messages);
                        diffMessages.removeAll(this.messages);
                } else {
                        diffMessages.addAll(this.messages);
                        diffMessages.removeAll(b.messages);
                }

                Collections.shuffle(diffMessages, Beings.random);
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
                return random.nextBoolean();
        }

        public void move(int theEnergy,case theCurrentCase){
                Float percentEnergy = theEnergy/startingEnergy;
                if (percentEnergy == 0){becomeObstacle()}
                else if (percentEnergy >=0.40){
                        int Dir=random.nextInt(3);
                        int nbrCase=random.nextInt(theEnergy);
                        for (int i,1,nbrcase){
                                Case destination = theCurrentCase;
                                if (Dir ==0){//nord 
                                        destination.x=theCurrentCase.x;
                                        destination.y=theCurrentCase.y+1;
                                        if (destination.isObstacle==true){

                                        }
                                        else {
                                              theCurrentCase.x=destination.x
                                              theCurrentCase.y=destination.y  
                                         }
                                }
                                if (Dir ==1){//est
                                        destination.x=theCurrentCase.x+1;
                                        destination.y=theCurrentCase.y;
                                        if (destination.isObstacle==true){

                                        }
                                        else {
                                              theCurrentCase.x=destination.x
                                              theCurrentCase.y=destination.y  
                                         }
                                }
                                if (Dir ==2){//sud
                                        destination.x=theCurrentCase.x;
                                        destination.y=theCurrentCase.y-1;
                                        if (destination.isObstacle==true){

                                        }
                                        else {
                                              theCurrentCase.x=destination.x
                                              theCurrentCase.y=destination.y  
                                         }
                                }
                                if (Dir ==3){//ouest
                                        destination.x=theCurrentCase.x+1;
                                        destination.y=theCurrentCase.y;
                                        if (destination.isObstacle==true){

                                        }
                                        else {
                                              theCurrentCase.x=destination.x
                                              theCurrentCase.y=destination.y  
                                         }
                                }

                }
        }

}