package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

public class Giraffe extends Herbivore {

    private static final EFoodType GIRAFFE = EFoodType.MEAT;
    private static final double STARTING_WEIGHT = 450;
    private static final Point STARTING_POSITION = new Point(50,0);
    private static final double MIN_NECK_LENGTH = 1;
    private static final double MAX_NECK_LENGTH = 2.5;
    private static final double DEFAULT_NECK_LENGTH = 1.5;
    private static final String chew ="Bleats and Stomps its legs, then chews";

    private double neckLength;
    //Constructors
    public Giraffe(String name){
        super(name,STARTING_POSITION);
        MessageUtility.logConstractor("Giraffe", this.getName());
        this.setWeight(STARTING_WEIGHT);
        this.setNeckLength(DEFAULT_NECK_LENGTH);
    }
    public Giraffe(String name,Point location){
        super(name,location);
        MessageUtility.logConstractor("Giraffe", this.getName());
        this.setWeight(STARTING_WEIGHT);
        this.setNeckLength(DEFAULT_NECK_LENGTH);
    }
    public Giraffe(String name, double neckLength){
        super(name,STARTING_POSITION);
        MessageUtility.logConstractor("Giraffe", this.getName());
        this.setWeight(STARTING_WEIGHT);
        this.setNeckLength(neckLength);
    }

    //API
    public void chew(){
        MessageUtility.logSound(this.getName(),chew );
    }

    //setters
    public boolean setNeckLength(double neckLength){
        if(neckLength > MIN_NECK_LENGTH && neckLength < MAX_NECK_LENGTH){
            this.neckLength = neckLength;
            MessageUtility.logSetter(this.getName(),"setNeckLength",neckLength,true);

            return true;
        }
        MessageUtility.logSetter(this.getName(),"setNeckLength",neckLength,false);
        return false;
    }
    //getters
    public EFoodType getFoodtype() {
        return GIRAFFE;
    }

}