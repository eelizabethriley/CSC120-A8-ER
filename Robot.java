import java.util.ArrayList;
import java.util.HashMap;

public class Robot implements Contract {

    String name;
    ArrayList<String> inventory;
    HashMap<String, Integer> invent;
    private boolean movement_status;
    private double robot_size;
    private int distance;
    private String position;
    ArrayList<String> cache;

    /** Constructor for a Robot.
     * 
     */
    public Robot() {
        this("Mr.Robot 2000");
        movement_status = false;
    }

    public Robot(String name) {
        this.name = name;
    }

    public void showOptions() {
        System.out.println("What would you like " + this.name + " to do :]? \n + grab() \n + drop() \n + examine() \n + use() \n + walk() \n + fly() \n + shrink() \n + grow() \n + rest()");
    }

    public void grab(String item) {
        // Add item to inventory
        inventory.add(item);
        invent.putIfAbsent(item, 10);
        System.out.println("I have grabbed the " + item + ", beep boop!");
        cache.add("grab");
    }
    
    public String drop(String item) {
        inventory.remove(item);
        System.out.println("Beep beep, I dropped the " + item + "!");
        return item;
    }

    public void examine(String item) {
        // Print out some details about this item. Change its value from "unknown" to "known"
    }

    public void use(String item) {
        inventory.remove(item);
    }

    public boolean walk(String direction) {
        movement_status = true;
        distance += 1;
        position = direction;
        System.out.println(this.name + " moved 1 space to the " + direction);
        return movement_status;
    }

    public boolean fly(int x, int y) {
        movement_status = false;
        return movement_status;
    }

    public Number shrink() {
        return robot_size / 2;
    }

    public Number grow() {
        System.out.println(" ascii ");
        return robot_size * 2;
    }

   public void rest() {

    }

    public void undo() {
        // Go to the last place in the cache, perform the opposite 
        String last_action = cache.get(cache.size()  - 1);
        if (last_action == "grab") {
            inventory.remove(inventory.size() - 1);
        if (last_action == "walk") {
            movement_status = false;
            distance -= 1;
            position = "home";
        }
        }
    }

    public static void main(String[] args) {
    Robot henry = new Robot("Henry");
    henry.showOptions(); 
    }
}
