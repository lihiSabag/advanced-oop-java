package animals;

import diet.IDiet;
import food.EFoodType;
import mobility.Mobile;
import mobility.Point;
import food.IEdible;
public abstract class Animal extends Mobile implements IEdible {

    private String name;
    private double weight;
    private IDiet diet;


    public Animal(String name, Point location){
        super(location);
        this.setName(name);
    }

    public abstract void makeSound();

    public boolean eat(IEdible food){
        if(food.getFoodtype() == EFoodType.VEGETABLE){
            double weightGain = this.weight * 0.07;
            this.weight += weightGain;
            return true;
        }
        else if(food.getFoodtype() == EFoodType.MEAT){
            double weightGain = this.weight * 0.1;
            this.weight += weightGain;
            return true;
        }
        else return false;

    }

    protected boolean setWeight(double weight){
        if(weight > 0) {
            this.weight = weight;
            return true;
        }
        this.weight = 0;
        return false;
    }

    public abstract EFoodType getFoodtype();

    //setters
    protected boolean setName(String name){
        if(name.length() > 0) {
            this.name = name;
            return true;
        }
        this.name = " Empty name ";
        return false;
    }

    public double getWeight(){
        return this.weight;
    }
}
