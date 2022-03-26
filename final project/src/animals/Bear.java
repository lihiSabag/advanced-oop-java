package animals;

import food.EFoodType;
import mobility.Point;

public class Bear extends Animal{
    private static final EFoodType BEAR = EFoodType.MEAT;
    private static final double STARTING_WEIGHT = 308.2;
    private static final Point STARTING_POSITION = new Point(100,5);
    private String furColor;


    public Bear(String name){
        super(name,STARTING_POSITION);
    }
    public Bear(String name, Point location){
        super(name,location);
    }

    public void roar(){}

    public EFoodType getFoodtype() {
        return BEAR;
    }
}
