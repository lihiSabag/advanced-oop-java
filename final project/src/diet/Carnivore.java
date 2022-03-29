package diet;

import food.EFoodType;
import food.IEdible;
import animals.*;
import mobility.Point;

public abstract class Carnivore extends Animal implements IDiet{

    private static final String sound = "ROAR";
    public Carnivore(String name, Point location){
        super(name,location);
        IDiet diet = this;
        this.setDiet(this);

    }

    public boolean canEat(EFoodType food){
        return food == EFoodType.MEAT;
    }
    public double eat(Animal animal, IEdible food){
        if(this.canEat(food.getFoodtype())){
            return animal.getWeight() * 0.07;
        }
        return 0;
    }
//    public boolean eat(IEdible food){
//        return canEat(food.getFoodtype());
//    }
    public void makeSound(){
        this.roar();
    }
    public abstract void roar();
}
