package animals;

import diet.Carnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Random;

public class Lion extends Carnivore {

    private static final EFoodType LION = EFoodType.NOTFOOD;
    private static final double STARTING_WEIGHT = 408.2;
    private static final Point STARTING_POSITION = new Point(20,0);
    private static final String roar= "Roars, then stretches and shakes its mane";
    private int scarCount = 0;
    //Constructors
    public Lion(String name){
        super(name,STARTING_POSITION);
        MessageUtility.logConstractor("Lion", this.getName());
        this.setWeight(STARTING_WEIGHT);

    }
    public Lion(String name,Point location){
        super(name,location);
        MessageUtility.logConstractor("Lion", this.getName());
    }

    //API
    public void roar(){
        MessageUtility.logSound(this.getName(), roar);
    }
    public void addScar(){
        Random random = new Random();
        if(random.nextInt(2) == 1){
            scarCount++;
        }

    }
    //getters
    public EFoodType getFoodtype(){
        return LION;
    }

}