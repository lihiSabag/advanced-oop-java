package zoo;

import animals.Animal;
import food.IEdible;
import mobility.Point;

public class ZooActions {
    public static boolean eat(Object animal, IEdible food){
        return true;
    }
    public static boolean move(Object animal, Point point){
        if(point.isValid()){

            return true;
        }
        return false;
    }
    public static void Main(String[] args){


    }
}


