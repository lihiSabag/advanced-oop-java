package animals;

import food.EFoodType;
import mobility.Point;

public class Elephant extends Animal{

    private static final EFoodType ELEPHANT = EFoodType.MEAT;
    private static final double STARTING_WEIGHT = 500;
    private static final Point STARTING_POSITION = new Point(50,90);
    private static final double MIN_TRUNK_LENGTH = 0.5;
    private static final double MAX_TRUNK_LENGTH = 3;
    private static final double MAX_NECK_LENGTH = 2.5;
    private static final double DEFAULT_TRUNK_LENGTH = 1;

    private double trunkLength;

    public Elephant(String name){
        super(name,STARTING_POSITION);
    }
    public Elephant(String name, Point location){
        super(name,location);
    }

    public void chew(){}

    public EFoodType getFoodtype() {
        return ELEPHANT;
    }
}
