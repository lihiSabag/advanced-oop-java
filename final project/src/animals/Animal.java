package animals;

import diet.IDiet;
import food.EFoodType;
import mobility.Mobile;
import mobility.Point;
import food.IEdible;
import utilities.MessageUtility;

public abstract class Animal extends Mobile implements IEdible {

    private String name;
    private double weight;
    private IDiet diet;

    public Animal(String name, Point location){
        super(location);
        MessageUtility.logConstractor("Animal",name);
        this.setName(name);
    }
    //abstract method
    public abstract void makeSound();
    public abstract EFoodType getFoodtype();

    //API
    public boolean eat(IEdible food){
        double gain = diet.eat( this, food);
        if(gain!=0){
            this.makeSound();
            if(this instanceof Lion){
                ((Lion)this).addScar();
            }
            MessageUtility.logBooleanFunction(this.getName(),"eat",food.toString(),true);
            return this.setWeight(this.getWeight()+gain);
        }
        MessageUtility.logBooleanFunction(this.getName(),"eat",food.toString(),false);
        return false;
    }
    public double move(Point nextLocation) {
        double distance =  super.move(nextLocation);
        this.setWeight(getWeight() - (distance * getWeight() * 0.00025));
        return distance;
    }

    //setters
    public boolean setName(String name){
        if(name.length() > 0) {
            this.name = name;
            MessageUtility.logSetter(name,"setName",this.name,true);
            return true;
        }
        this.name = " Empty name ";
        MessageUtility.logSetter(name,"setName",this.name,false);
        return false;
    }
    public boolean setWeight(double weight){
        if(weight > 0) {
            this.weight = weight;
            MessageUtility.logSetter(name,"setWeight",weight,true);
            return true;
        }
        this.weight = 0;
        MessageUtility.logSetter(name,"setWeight",weight,false);
        return false;
    }
    public boolean setDiet(IDiet diet) {
        boolean isSuccess = true;
        this.diet = diet;
        MessageUtility.logSetter(getName(), "setDiet", getDiet(), isSuccess);
        return isSuccess;
    }
    //getters
    public String getName(){
        return this.name;
    }
    public double getWeight(){
        return this.weight;
    }
    public IDiet getDiet() {
        MessageUtility.logGetter(getName(), "getDiet", this.diet);
        return diet;
    }

    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }
}