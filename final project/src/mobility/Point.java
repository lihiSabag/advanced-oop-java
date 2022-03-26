package mobility;

public class Point {
    private static final int MAX_X_VAL = 800;
    private static final int MAX_Y_VAL = 600;


    private int x;
    private int y;

    public Point(int x, int y){
        if(x < MAX_X_VAL && x > 0 && y< MAX_Y_VAL && y > 0){
            this.x = x;
            this.y = y;
        }

    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}

    public boolean isValid(){
        return this.x <= MAX_X_VAL && this.x >= 0 && this.y <= MAX_Y_VAL && this.y >= 0;
    }

}
