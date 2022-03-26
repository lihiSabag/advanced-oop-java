package diet;

import food.EFoodType;
import food.IEdible;
import mobility.Point;

public abstract class Omnivore extends Carnivore{

    public Omnivore(String name, Point location){
        super(name,location);
    }

    public boolean canEat(EFoodType food){
        return food == EFoodType.VEGETABLE ||  food == EFoodType.MEAT;
    }

}
