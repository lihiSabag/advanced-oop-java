package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;


public class Omnivore extends Carnivore{

    private IDiet herbivore;

    public Omnivore(){
        this.herbivore = new Herbivore();
    }


    public boolean canEat(EFoodType food){
        return food == EFoodType.VEGETABLE ||  food == EFoodType.MEAT;
    }

    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodtype()) && !(animal == food)) {
            if (food.getFoodtype() == EFoodType.MEAT) {
                return super.eat(animal, food);
            } else {
                return herbivore.eat(animal, food);
            }
        }
        return 0;
    }

}
