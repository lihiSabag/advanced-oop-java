package animals;

import food.EFoodType;
import mobility.Point;

public class Giraffe extends Animal{

    private static final EFoodType GIRAFFE = EFoodType.MEAT;
    private static final double STARTING_WEIGHT = 450;
    private static final Point STARTING_POSITION = new Point(50,0);
    private static final double MIN_NECK_LENGTH = 1;
    private static final double MAX_NECK_LENGTH = 2.5;
    private static final double DEFAULT_NECK_LENGTH = 1.5;


    private double neckLength;

    public Giraffe(String name){
        super(name,STARTING_POSITION);
    }
    public Giraffe(String name,Point location){
        super(name,location);
    }
    public void chew(){}

    public EFoodType getFoodtype() {
        return GIRAFFE;
    }
}
