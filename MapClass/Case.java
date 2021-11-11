package MapClass;

import BeingsClass.Beings;

public class Case {
    private int x;
    private int y;
    private Boolean isObstacle;
    private Beings filledWith;
    private Map map;

    public Case(int x, int y, Map m){
        this.x = x;
        this.y = y;
        this.map = m;
        isObstacle = false;
        filledWith = null;
    }

    public void becomeObstacle(Beings b){

    }

    public Map getMap(){
        return map;
    }

    public void becomeObstacle(){
        isObstacle = true;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    

    public boolean checkIsObstacle(){
        return isObstacle;
    }
    public Beings checkFilledWith(){
        return filledWith;
    }
    public void setFilledWith(Beings b){
        filledWith=b;
    }
}
