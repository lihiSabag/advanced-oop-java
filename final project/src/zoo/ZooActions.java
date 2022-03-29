package zoo;

import animals.Animal;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import food.IEdible;
import mobility.Point;

public class ZooActions {
    public static boolean eat(Object animal, IEdible food){
        if(animal instanceof Omnivore){
            return ((Omnivore)animal).canEat(food.getFoodtype());
        }
        else if(animal instanceof Carnivore){
            return ((Carnivore)animal).canEat(food.getFoodtype());
        }
        else if(animal instanceof Herbivore){
            return((Herbivore)animal).canEat(food.getFoodtype());

        }
        return false;

    }
    public static boolean move(Object animal, Point point){
        if(Point.checkBoundaries(point)){

            return true;
        }
        return false;
    }
    public static void Main(String[] args){


    }
}
