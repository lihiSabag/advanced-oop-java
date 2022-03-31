package zoo;

import animals.*;
import food.IEdible;
import mobility.Point;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ZooActions {
    private static final int MIN_NUM_OF_ANIMALS = 3;
    private static Scanner sc = new Scanner(System.in);

    //simulation method
    public static boolean eat(Object animal, IEdible food) {
        if(animal instanceof  Animal) {
            return ((Animal) animal).eat(food);
        }
        return false;
    }
    public static boolean move(Object animal, Point point) {
        boolean isSuccess = false;
        if (((Animal)animal).move(point) != 0) {
            isSuccess = true;
        }
        return isSuccess;
    }

    //Input verification methods
    private static int intInput(){
        int input = 0;

        while (true) {
            try {
                input = sc.nextInt();
                return input;
            }
             catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please Enter Valid Integer ");
                 System.out.print("Enter your choice: ");
                if (sc.next().isEmpty()) {
                    break;
                }
            }
        }
        sc.close();
        return input;
    }
    private static double doubleInput(){
        double input = 0.0;
        while (true) {
            try {
                input = sc.nextDouble();
                return input;
            }
            catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please Enter Valid Integer ");
                System.out.print("Enter your choice: ");
                if (sc.next().isEmpty()) {
                    break;
                }
            }
        }
        sc.close();
        return input;
    }
    private static Point pointInput(){
        int x = 1;
        int y = 1;
        boolean validInput = false;
        while (!validInput)
        {
            System.out.print("Please enter an integer to the value X of the point (Maximum value-800): ");
            x = intInput();
            validInput = true;
            if(!Point.checkBoundaries(new Point(x,y))){
                System.out.println("The X value is out of bound , please enter a valid value");
                validInput =false;
            }
        }
        validInput = false;
        while (!validInput)
        {
            System.out.print("Please enter an integer to the value Y of the point (Maximum value-600): ");
            y = intInput();
            validInput = true;
            if(!Point.checkBoundaries(new Point(x,y))){
                System.out.println("The Y value is out of bound , please enter a valid values");
                validInput =false;
            }
        }
        Point location = new Point(x,y);
        return location;
    }

    //create animal arr
    private static Animal createAnimalWithLocation(int userSelection,String name,Point location) {

        Animal animal =null;
        switch (userSelection) {
            case 1:
                //Lion
                animal = new Lion(name,location);
                break;
            case 2:
                //Bear
                animal = createBear(name);
                break;
            case 3:
                //Elephant
                animal = createElephant(name);
                break;
            case 4:
                //Giraffe
                animal = createGiraffe(name);
                break;
            case 5:
                //Turtle
                animal = createTurtle(name);
                break;
            case 6:
                // Terminate JVM
                System.exit(0);
                break;
//                    default:
//                        //invalid input
//                        System.out.println("Invalid input, please Enter a number between 1-6");
            //break;
        }
        return  animal;
    }
    private static Animal createAnimal(int userSelection,String name) {

        Animal animal =null;
        switch (userSelection) {
            case 1:
                //Lion
                animal = new Lion(name);
                break;
            case 2:
                //Bear
                animal = createBear(name);
                break;
            case 3:
                //Elephant
                animal = createElephant(name);
                break;
            case 4:
                //Giraffe
                animal = createGiraffe(name);
                break;
            case 5:
                //Turtle
                animal = createTurtle(name);
                break;
            case 6:
                // Terminate JVM
                System.exit(0);
                break;
//                    default:
//                        //invalid input
//                        System.out.println("Invalid input, please Enter a number between 1-6");
            //break;
        }
        return  animal;
    }
    private static Animal[] createAnimalsArr(int size) {
        int userSelection ;
        Animal[] animalsArr = new Animal[size];

        for (int i = 0; i < size; i++) {
            System.out.println("\nAnimal number " + (i + 1));
            System.out.println("Select the animal you want to add: ");
            System.out.println("1. Lion");
            System.out.println("2. Bear");
            System.out.println("3. Elephant");
            System.out.println("4. Giraffe");
            System.out.println("5. Turtle");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            userSelection = intInput();
            while (userSelection <= 0 || userSelection > 6) {
                System.out.println("Invalid input! please Enter a number between 1-6");
                System.out.print("Enter your choice: ");
                userSelection = intInput();
            }

            System.out.println("Please enter the animal's name: ");
            String name = sc.next();

            System.out.println("Do you want to place the animal in a specific location? ");
            System.out.println("1. YES");
            System.out.println("2. NO");
            System.out.print("Choose option: ");
            int selection = intInput();
            if (selection == 1) {
                //point input
                Point location = pointInput();
                animalsArr[i] = createAnimalWithLocation(userSelection, name, location);
            } else {
                animalsArr[i] = createAnimal(userSelection, name);
            }
        }
        return animalsArr;
    }
    private static Elephant createElephant(String name) {
        Elephant elephant =null;
        int userSelection;
        double trunkLength;
        System.out.println("Do you want to choose a specific length for the elephant trunk?: ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            userSelection = intInput();
            switch (userSelection) {
                case 1:
                    //YES
                    System.out.print("Enter length of the trunk (a real number between 0.5 - 3) : ");
                    trunkLength = doubleInput();//TODO check if we need to validate this input
                    elephant = new Elephant(name,trunkLength);
                    return elephant;
                case 2:
                    //NO
                    elephant = new Elephant(name);
                    return elephant;

                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (userSelection != 1 && userSelection != 2);
        return elephant;
    }
    private static Giraffe createGiraffe(String name) {
        Giraffe giraffe = null;
        Scanner sc = new Scanner(System.in);
        int userSelection;
        double neckLength;
        System.out.println("Do you want to choose a specific length for the giraffe's neck? : ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            userSelection = intInput();
            switch (userSelection) {
                case 1:
                    //YES
                    System.out.print("Enter length of the neck (a real number between 1 - 2.5) : ");
                    neckLength = doubleInput();//TODO check if we need to validate this input
                    giraffe = new Giraffe(name,neckLength);
                    return giraffe;
                case 2:
                    //NO
                    giraffe = new Giraffe(name);
                    return giraffe;

                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (userSelection != 1 && userSelection != 2);
        return giraffe;
    }
    private static Turtle createTurtle(String name) {
        Turtle turtle = null;
        Scanner sc = new Scanner(System.in);
        int userSelection;
        int age;
        System.out.println("Do you want to choose a specific age for the Turtle?: ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            userSelection = intInput();
            switch (userSelection) {
                case 1:
                    //YES
                    System.out.print("Enter the age (a integer number between 0 - 500) : ");
                    age = intInput();//TODO check if we need to validate this input
                    turtle = new Turtle(name,age);
                    return turtle;
                case 2:
                    //NO
                    turtle = new Turtle(name);
                    return turtle;

                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (userSelection != 1 && userSelection != 2);
        return turtle;
    }
    private static Bear createBear(String name) {
        Bear bear = null;
        Scanner sc = new Scanner(System.in);
        int userSelection;

        System.out.println("Please select the bear's fur color: ");
        System.out.println("1. White");
        System.out.println("2. Gray");
        System.out.println("3. Black");
        System.out.println("4. default");

        do {
            System.out.print("Enter your choice: ");
            userSelection = intInput();
            switch (userSelection) {
                case 1:
                    //White
                    bear = new Bear(name,"WHITE");
                    break;
                case 2:
                    //Gray
                    bear = new Bear(name,"GRAY");
                    break;
                case 3:
                    //Black
                    bear = new Bear(name,"BLACK");
                    break;
                case 4:
                    //default
                    bear = new Bear(name);
                    break;

                default:
                    System.out.println("Invalid input, please Enter 1 or 2");
            }
        }
        while(userSelection < 1 || userSelection > 4 );
        return bear;
    }

    public static void main(String[] args) {

        int size ;
        Animal[] animalsArr;

        System.out.println("========================= Building the zoo =========================");
        System.out.println("Please enter the number of animals in the zoo (At least 3 animals): ");
        size = intInput();
        while (size < 3) {
            System.out.println("Invalid input, The minimum size is 3 ");
            System.out.print("Enter your choice: ");
            size = intInput();
        }
        animalsArr = createAnimalsArr(size);

        System.out.println("=============== Move Simulation ===============");

        for (Animal animal : animalsArr) {

            System.out.println(animal.getName() + " wants to go for a walk!  Enter the destination for it:");
            Point nextLocation = pointInput();
            if (move(animal, nextLocation)) {
                System.out.println(animal.getName() + " moved! Location updated to " + animal.getLocation());
            }
        }
        System.out.println("=============== End  Simulation ===============");

        System.out.println("===============     Feeding     ===============");
        int raffle = size/2;
        Random random = new Random();
        for (int i = 0; i < raffle; i++){
            int first = random.nextInt(size);
            int second = random.nextInt(size);
            ZooActions.eat(animalsArr[first], animalsArr[second]);
        }
        System.out.println("=============== End  Simulation ===============");

        sc.close();
    }
}
