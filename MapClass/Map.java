package MapClass;

import java.util.ArrayList;
import BeingsClass.Beings;

/**
 * Map
 */
public class Map {

    private int m;
    private int n;
    private int sizeSafeZone;
    private ArrayList<Case> allCase;


    public Map(int m, int n, int sizeSafeZone){
        this.m=m;
        this.n=n;
        this.sizeSafeZone=sizeSafeZone;
    }
    
    public void display(){

    }

    public ArrayList<Case> allCasePossible(int x, int y){
        return new ArrayList<>();
    }

    
    public ArrayList<Case> findPathSafeZone(Beings b){
        return new ArrayList<>();
    }
    

}