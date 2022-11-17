import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**A class Robot that represents a robot with various actions it can perform on an object. Implements the Contract with grab(), drop(), examine(), use(), walk(), fly(), shrink(), grow(), rest(), undo() */
public class Robot implements Contract {

    String name;
    HashMap<String, Integer> inventory = new HashMap<String, Integer>();
    String object;
    int objectSize = 10;
    String prompt;
    int xCoordinate;
    int yCoordinate;
    ArrayList<String> flyingX = new ArrayList<String>();
    ArrayList<String> flyingY = new ArrayList<String>();
    private int distance;
    private String position;
    ArrayList<String> cache = new ArrayList();

    Scanner myObj = new Scanner(System.in);
    String robot = "🤖";

    int howMuchBigger;

    private boolean movement_status = false;

    /** Constructor for a Robot.
     * 
     */
    public Robot() {
        this("Mr.Robot 2000");
        System.out.println("You have made a robot 🤖");
        //invent.put("computer", 2);

    }

    /**
     * Overloaded constructor for a robot with a specified.
     * @param name a name for the robot.
     */
    public Robot(String name) {
        this.name = name;
    }

    /** A method showOptions that prints out a list of methods for this Robot. */
    public void showOptions() {
        System.out.println("What would you like me to do" + this.name +  " to do? :] + examine() \n + walk() \n + fly() \n + shrink() \n + grow() \n + rest() \n + undo() \n + grab()");
    }

    /**  A method use that consumes a specified item, removing it from the inventory, a HashMap.
     * @param item a specified item in the inventory
     */
    public void use(String item){
        // Remove the object from the inventory, "consuming" it.
        inventory.remove(object);
        System.out.println("Beep boop, the " + item + " has been used.");
    }

    /** A method grab that adds the item to the inventory and prints out a statement.
     * @param item a specified String, item, to grab
     */
    public void grab(String item) {
        // Add item to inventory
        inventory.put(item, 10);
        System.out.println("I have grabbed the " + item + ", beep boop!");
        cache.add("grab");
        inPossession(true);
        this.object = item;
        // grabUndo = true;
    }
    
    /** A method drop that removes the item from the inventory and prints out a statement.
     * @param item a specified String, item, to drop.
     */
    public String drop(String item) {
        if (inventory.containsKey(item) || inPossession(true)) {
            inventory.remove(item);
            System.out.println("Beep beep, I dropped the " + item + "!");
            cache.add("drop");
        }
        else {
            System.out.println("Silly human, I'm not holding anything. Try again");
            showOptions();
        }
        return item;
    }

    /** A method examine that prints out the contents of the inventory, a HashMap 
     * @param item an item in the inventory
    */
    public void examine(String item) {
        // Print out some details about this item. Change its value from "unknown" to "known"
        for (Map.Entry<String, Integer> set: inventory.entrySet()) {
            System.out.println("Your object is " + set.getKey() + " and it weighs " + set.getValue());
        }
    }


    /** A method walk that prints out a series of asterisks indication the robot's movement ina given direction.
     * @param direction a string, U, D, R, or L, that specifies which position the robot should be in relation to the asterisks.
     */
    public boolean walk(String direction) {
        distance += 5;
        position = direction;
        System.out.println(this.name + " moved 1 space to the " + direction);

        if (direction == "U") {
            System.out.println(robot + "\n*\n*\n*\n*\n*");
        }
        else if (direction == "D") {
            System.out.println("*\n*\n*\n*\n*\n" + robot);
        }
        else if (direction == "R") {
            System.out.println("*****" + robot);
        }
        else if (direction == "L") {
            System.out.println(robot + "*****");
        }
        this.movement_status = true;
        cache.add("walk");
        return movement_status;
    }

    /** A method fly that takes in x and y coordinates and prints out symbols to indicate the robot flying this distance.
     * @param x a specified x coordinate int that indicates how many symbols should be printed horizontally.
     * @param y a specified y coordinate int that indicates how many symbols should be printed vertically.
     */
    public boolean fly(int x, int y) {
        System.out.println("Commence flying: ");
        System.out.println(robot);
        for (int i = 0; i < x; i++) {
            flyingX.add("placeholder");
          }
        for (int i = 0; i < y; i++) {
            flyingY.add("placeholder");
          }
          System.out.print(robot);
          for(String s: flyingX){
            System.out.println("|");
          }
          for(String s: flyingY){
            System.out.print("--");
          }
        this.movement_status = true;
        cache.add("fly");
        return movement_status;
    }

    /** A method shrink that halves the size of this object */
    public Number shrink() {
        System.out.println("And what object do you have?");
        String object = myObj.nextLine();
        this.object = object;
        System.out.println("What size is the object in lbs?");
        int objectSize = myObj.nextInt();
        this.objectSize /= 2;
        objectSize = this.objectSize;
        inventory.put(object, objectSize);
        System.out.println("I shrank the object down by half, beep beep! :]");
        cache.add("shrink");
        return objectSize;
    }

    /** A method grow that doubles the size of this object */
    public Number grow() {
        System.out.println("And what object do you have?");
        String object = myObj.nextLine();
        this.object = object;
        System.out.println("What size is the object in lbs?");
        int objectSize = myObj.nextInt();
        objectSize *= 2;
        inventory.put(object, objectSize);
        System.out.println("I doubled the object's size, beep beep! :]" );
        cache.add("grow");
        return objectSize;
    }

    /** A method rest that changes movement status to false and outputs a statement indicating that the robot is resting. */
   public void rest() {
        // Display the robot having a rest.
        this.movement_status = false;
        position = "home";
        System.out.println("Beep beep...powering down for a nap" + robot);
    }

    /** A method undo that performs the reverse the action of the most recently called method (if the method is grab, drop, walk, or fly) */
    public void undo() {
        // Go to the last place in the cache, perform the opposite method for grab, drop, walk, and fly.
        String last_action = cache.get(cache.size()  - 1);
        if (last_action == "grab") {
            this.drop(this.object);
        }
        else if (last_action == "drop") {
            this.grab(object);
        }
        else if (last_action == "walk") {
            distance -= 1;
            position = "home";
            this.movement_status = false;
            System.out.println("\nReturned to home.");
        }
        else if (last_action == "fly") {
            position = "home";
            this.movement_status = false;
            System.out.println("\nReturned to home.");
        }
    }

    /** Indicates when an object is grabbed or dropped. 
     * @param have a boolean that indicates whether this object is in the robot's inventory.
    */
    public boolean inPossession(boolean have){
        return false;
    }

    public static void main(String[] args) {
        Robot henry = new Robot("Henry");
        // henry.showOptions();
        henry.grab("book");
        henry.grab("rock");
        henry.grow();
        henry.undo();
        henry.examine("book");
        
    }
}

