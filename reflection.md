Use this file to record your reflection on this assignment.

I worked with Katie Wilson on this assignment. 

- Tell me about your class! What does it represent?

We created a Robot class representing a robot that, given an object, can perform different actions as follows:
- Grab: pick the object up and add it to the robot's inventory.
- Drop: drop the object and remove it from the robot's inventory.
- Examine: tells the user what an object is called and what size it is, in pounds.
- Use: "consumes" this object, removing it from the robot's inventory.
- Walk: prints out symbols representing a path taken by the robot in a given direction (up, down, left, right)
- Fly: prints out symbols representing the robot flying a given distance.
- Shrink: the robot shrinks a given item down to half of its size.
- Grow: the robot enlarges an item to double its size.
- Rest: prints out symbols & a message indicating that the robot is resting in one place. Also changes movementstatus to false, indicating that the robot has not moved position.
- Undo: an ArrayList, cache, keeps track of actions performed so far in this execution of the program, allowing us to reverse the effects of the most recent
    action, thus "undoing" this action.


- What additional methods (if any) did you implement alongside those listed in the interface?

We added a "showOptions" method to display all of the available methods for this class to make it more user friendly to input what method
to use since we did include a Scanner and wanted to take in user input.

- What worked, what didn't, what advice would you give someone taking this course in the future?
