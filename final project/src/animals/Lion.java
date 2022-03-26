package animals;

import diet.Carnivore;
import food.EFoodType;
import mobility.Point;

public class Lion extends Carnivore {

    private static final EFoodType LION = EFoodType.NOTFOOD;
    private static final double STARTING_WEIGHT = 408.2;
    private static final Point STARTING_POSITION = new Point(20,0);

    private int scarCount;

    public Lion(String name){
        super(name,STARTING_POSITION);
    }
    public Lion(String name,Point location){
        super(name,location);
    }
    public void roar(){}

    public EFoodType getFoodtype(){
        return LION;
    }
}
