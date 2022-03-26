package plants;

import food.EFoodType;
import food.IEdible;
import mobility.Ilocatable;
import mobility.Point;

public abstract class Plant implements IEdible, Ilocatable {

    private static final EFoodType PLANT = EFoodType.VEGETABLE;

    public EFoodType getFoodtype(){
        return PLANT;
    }
    public Point getLocation(){

    }
    public boolean setLocation(Point location){}

}
