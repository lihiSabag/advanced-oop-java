package mobility;

import utilities.MessageUtility;

public class Point {
    private static final int MAX_X_VAL = 800;
    private static final int MAX_Y_VAL = 600;


    private int x;
    private int y;

    public Point(int x, int y){
        if(!(this.setX(x))){
            //MessageUtility.logConstractor("Point", "Default x = 0");
        }
        if(!(this.setY(y))){
            //MessageUtility.logConstractor("Point", "Default y = 0");
        }
    }

    public boolean setX(int x){
        if(x < MAX_X_VAL && x > 0 ){
            this.x = x;
            return true;
        }
        this.x = 0;
        return false;
    }
    public boolean setY(int y){
        if(y < MAX_Y_VAL && y > 0 ){
            this.y = y;
            return true;
        }
        this.y = 0;
        return false;
    }
    public Point(Point other) {
        this.setX(other.getX());
        this.setY(other.getY());
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}

    public static boolean checkBoundaries(Point p){
        return p.x <= MAX_X_VAL && p.x >= 0 && p.y <= MAX_Y_VAL && p.y >= 0;
    }

}
