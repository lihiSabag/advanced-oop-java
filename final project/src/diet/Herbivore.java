package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
import mobility.Point;

public abstract class Herbivore extends Animal implements IDiet{


    public Herbivore(String name, Point location){
        super(name,location);
    }
    public boolean canEat(EFoodType food){
        return food == EFoodType.VEGETABLE;
    }

    public boolean eat(IEdible food){
        double weight = eat(this,food);
        if(weight != 0 ) {
            this.setWeight(weight);
            return true;
        }
        return false;
    }
    public double eat(Animal animal, IEdible food){
        if(canEat(food.getFoodtype())){
            return animal.getWeight() * 0.07;
        }
        return 0;
    }

}
