package MapClass;

import BeingsClass.Beings;

public class Case {
    private int x;
    private int y;
    private Boolean isObstacle;
    private Beings filledWith;

    public Case(int x, int y){
        this.x = x;
        this.y = y;
        isObstacle = false;
        filledWith = null;
    }

    public void becomeObstacle(Beings b){

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
}
