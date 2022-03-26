package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;

public class Turtle extends Herbivore {

    private static final EFoodType TURTLE = EFoodType.MEAT;
    private static final double STARTING_WEIGHT = 1;
    private static final Point STARTING_POSITION = new Point(80,0);
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 500;
    private static final int DEFAULT_AGE = 1;

    private int age;

    public Turtle(String name){
        super(name, STARTING_POSITION);

    }
    public Turtle(String name,Point location){
        super(name,location);

    }
    public void chew(){}

    public EFoodType getFoodtype(){
        return TURTLE;
    }
}
