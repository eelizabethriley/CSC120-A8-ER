import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Robot implements Contract {

    String name;
    HashMap<String, Integer> invent;
    String object;
    int objectSize;
    String prompt;
    int xCoordinate;
    int yCoordinate;
    ArrayList<String> flyingX = new ArrayList<String>();
    ArrayList<String> flyingY = new ArrayList<String>();
    private int distance;
    private String position;
    ArrayList<String> cache;

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
    }

    public Robot(String name) {
        this.name = name;
    }

    public void showOptions() {
        System.out.println("What would you like me to do" + this.name +  " to do? :] + Type 'A' for me to examine \n + Type 'B' for me to walk \n + Type 'C' for me to fly \n + Type 'D' for me to shrink \n + Type 'E' for me to grow \n + Type 'F' for me to rest \n + Type 'G' for me to undo \n + Type 'H' for me to grab that object");
        String prompt = myObj.nextLine();
        prompt = this.prompt;
        System.out.println("And what object do you have?");
        String object = myObj.nextLine();
        object = this.object;
        System.out.println("What size is this object in lbs?");
        int objectSize = myObj.nextInt(0);
        objectSize = this.objectSize;
        invent.put(object, objectSize);
        use(prompt);
    }

    public void grab(String item) {
        // Add item to inventory

        invent.putIfAbsent(item, 10);
        System.out.println("I have grabbed the " + item + ", beep boop!");
        cache.add("grab");
        inPossession(true);
        // grabUndo = true;
    }
    
    public String drop(String item) {
        if (invent.containsKey(object) && inPossession(true)) {
            invent.remove(item);
            System.out.println("Beep beep, I dropped the " + item + "!");
            cache.add("drop");
        }
        else {
            System.out.println("Silly human, I'm not holding anything. Try again");
            showOptions();
        }
        return item;
    }

    public void examine(String item) {
        // Print out some details about this item. Change its value from "unknown" to "known"
        Set<String> inventory = invent.keySet();
        System.out.println(inventory + "eee");
        for (Map.Entry<String, Integer> set: invent.entrySet()) {
            System.out.println("Your object is " + set.getKey() + " and it weighs " + set.getValue());
        }
    }

    public void use(String item) {
        // "Consume" the item by removing it from the inventory.
        invent.remove(item);
        System.out.println(robot + ">>>" + item + "has been used!");
    }

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
        return movement_status;
    }

    public boolean fly(int x, int y) {
        this.movement_status = true;
        return movement_status;
    }

    public Number shrink() {
        objectSize /= 2;
        invent.put(object, objectSize);
        return objectSize;
    }

    public Number grow() {
        objectSize *= 2;
        invent.put(object, objectSize);
        return objectSize;
    }

   public void rest() {
        // Display the robot having a rest.
        this.movement_status = false;
        position = "home";
        System.out.println("Beep beep...powering down for a nap" + robot);
    }

    public void undo() {
        // Go to the last place in the cache, perform the opposite 
        String last_action = cache.get(cache.size()  - 1);
        if (last_action == "grab") {
            this.drop(object);
        }
        else if (last_action == "drop") {
            this.grab(object);
        }
        else if (last_action == "walk") {
            distance -= 1;
            position = "home";
            this.movement_status = false;
        }
        else if (last_action == "fly") {
            position = "home";
            this.movement_status = false;
        }
        else if (last_action == "shrink") {
            this.grow();
        }
    }

    public boolean inPossession(boolean have){
        return false;
    }

    public static void main(String[] args) {
    Robot henry = new Robot("Henry");
    henry.showOptions();
    henry.grab("apple");
    henry.examine("apple");
    }
}

