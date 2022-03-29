package animals;

import diet.Omnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Objects;

public class Bear extends Omnivore {
    private static final EFoodType BEAR = EFoodType.MEAT;
    private static final double STARTING_WEIGHT = 308.2;
    private static final Point STARTING_POSITION = new Point(100, 5);
    private static final String DEFAULT_FURCOLOR = "GRAY";
    private static final String roar = "Stands on its hind legs, roars and scratches its belly";
    private String furColor;

    private enum FurColors {
        WHITE("WHITE"),
        GRAY("GRAY"),
        BLACK("BLACK");

        private final String color;

        FurColors(String color) {
            this.color = color;
        }

        public String getFurcolorValue() {
            return this.color;
        }
    }

    public Bear(String name) {
        super(name, STARTING_POSITION);
        MessageUtility.logConstractor("Bear", this.getName());
        this.setWeight(STARTING_WEIGHT);
        this.setFurColor(DEFAULT_FURCOLOR);
    }

    public Bear(String name, Point location) {
        super(name, location);
        MessageUtility.logConstractor("Bear", this.getName());
        this.setWeight(STARTING_WEIGHT);
        this.setFurColor(DEFAULT_FURCOLOR);
    }

    public Bear(String name, String furColor) {
        super(name, STARTING_POSITION);
        MessageUtility.logConstractor("Bear", this.getName());
        this.setWeight(STARTING_WEIGHT);
        this.setFurColor(furColor);
    }

    public void roar() {
        MessageUtility.logSound(this.getName(), roar);
    }

    public EFoodType getFoodtype() {
        return BEAR;
    }

    public boolean validFurColor(String furColor) {
        for (FurColors color : FurColors.values()) {
            if (color.getFurcolorValue().equals(furColor)) {
                return true;
            }
        }
        return false;
    }
    public boolean setFurColor(String furColor) {
        if(validFurColor(furColor)){
            this.furColor = furColor;
            MessageUtility.logSetter(this.getName(),"setFurColor",this.furColor,true);
            return true;
        }
        else {
            this.furColor = DEFAULT_FURCOLOR;
            MessageUtility.logSetter(this.getName(),"setFurColor",furColor,false);
            return false;
        }
    }

}