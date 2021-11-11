package MapClass;

import java.util.ArrayList;

import BeingsClass.Beings;
import BeingsClass.Elfs;
import BeingsClass.Gobelins;
import BeingsClass.Humans;
import BeingsClass.MasterElf;
import BeingsClass.MasterGobelin;
import BeingsClass.MasterHuman;
import BeingsClass.MasterOrc;
import BeingsClass.Orcs;
import Utils.Main;
import Utils.RandomSingleton;
/**
 * Map
 */
public class Map {

    private int m;
    private int n;
    private ArrayList<Case> allCase = new ArrayList<>();

    public Map(int m, int n, int sizeSafeZone){
        this.m=m;
        this.n=n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i < sizeSafeZone && j < sizeSafeZone){
                    allCase.add(new SafeZoneCase(i, j, this));
                } else if(i < sizeSafeZone && j >= m-sizeSafeZone){
                    allCase.add(new SafeZoneCase(i, j, this));
                } else if(i >= n - sizeSafeZone && j < sizeSafeZone){
                    allCase.add(new SafeZoneCase(i, j, this));
                } else if(i >= n-sizeSafeZone && j >= m-sizeSafeZone){
                    allCase.add(new SafeZoneCase(i, j, this));
                }else{
                    Case c = new Case(i,j, this);
                    if(RandomSingleton.getInstance().nextInt(10) == 1){
                        c.becomeObstacle();
                    }
                    allCase.add(c);
                }
            }
        }
    }

    public void display(){
        Case[][] sortedCases = new Case[n][m];
        for (Case c: allCase){
            sortedCases[c.getX()][c.getY()] = c;
        }

        for (Case[] row: sortedCases){
            for(Case c: row){
                //print safe zones
                if(c.checkFilledWith() != null){
                    Beings b = c.checkFilledWith();
                    String color = Main.ANSI_RESET;
                    if(b instanceof Elfs){
                        color = Main.ANSI_BLUE;
                    } else if (b instanceof Orcs){
                        color = Main.ANSI_RED;
                    } else if (b instanceof Humans){
                        color = Main.ANSI_GREEN;
                    } else if (b instanceof Gobelins){
                        color = Main.ANSI_YELLOW;
                    }
                    if(b instanceof MasterElf || b instanceof MasterOrc || b instanceof MasterHuman || b instanceof MasterGobelin){
                        System.out.print(color + "M" + Main.ANSI_RESET);
                    }else{
                        System.out.print(color + "+" + Main.ANSI_RESET);
                    }
                } else if(c instanceof SafeZoneCase){
                    System.out.print("*");
                } else if (c.checkIsObstacle()){
                    System.out.print("x");
                }else {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }

    public ArrayList<Case> allCasePossible(int x, int y){
        Case[][] sortedCases = new Case[n][m];
        for (Case c: allCase){
            sortedCases[c.getX()][c.getY()] = c;
        }

        ArrayList<Case> possibleCases = new ArrayList<>();

        int minX = -1;
        int maxX = 1;
        int minY = -1;
        int maxY = 1;
        if(x == 0){
            minX = 0;
        }
        if(x == n-1){
            maxX=0;
        }
        if(y == 0){
            minY=0;
        }
        if(y==m-1){
            maxY=0;
        }

        for(int x2=minX; x2 <= maxX; x2++){
            for(int y2=minY; y2 <= maxY; y2++){
                if(x2 == 0 && y2 == 0){
                    continue;
                }
                possibleCases.add(sortedCases[x+x2][y+y2]);
            }
        }

        return possibleCases;
    }


    public ArrayList<Case> findPathSafeZone(Beings b){
        return new ArrayList<>();
    }


}