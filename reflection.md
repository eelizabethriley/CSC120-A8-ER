Use this file to record your reflection on this assignment.

I worked with Katie Wilson on this assignment. We are using the same repo, so her reflection is at the end of this file.

Erin's reflection:
- Tell me about your class! What does it represent?

We created a Robot class representing a robot that, given an object, can perform different actions as follows:
- Grab: pick the object up and add it to the robot's inventory.
- Drop: drop the object and remove it from the robot's inventory.
- Examine: print out the contents of the HashMap, telling the user what objects the user has and what size they are.
- Use: "consumes" this object, removing it from the robot's inventory.
- Walk: prints out symbols representing a path taken by the robot in a given direction (up, down, left, right)
- Fly: prints out symbols representing the robot flying a given distance.
- Shrink: the robot shrinks a given item down to half of its size.
- Grow: the robot enlarges an item to double its size.
- Rest: prints out a message indicating that the robot is resting in one place. Also changes movement_status to false, indicating that the robot has not moved position.
- Undo: an ArrayList, cache, keeps track of actions performed so far in this execution of the program, allowing us to reverse the effects of the most recent
    action, thus "undoing" this action.

- What additional methods (if any) did you implement alongside those listed in the interface?

We added a "showOptions" method to display all of the available methods for this class in a list to make it clear what actions this Robot can perform, an idea we took from the previous assignment where we made the campus map.

- What worked, what didn't, what advice would you give someone taking this course in the future?

This was a fun assignment to work on because working through the contract to come up with our own logic was really interesting and it was cool to see
that we interpreted the same methods from the contracted in very different ways.
We were able to get the methods in the contract implemented to a functioning degree according to our logic.
Katie had a really great idea to create a user interface in the use() method using a series of if/else statements that would allow the user to pick
from the list of methods and easily go through them, asking the user for the object and size using a scanner, however we ran into a lot of confusion when implementing this and in the end weren't able to debug it for this assignment. I thought it was a really clever idea though and would like to revisit this in the future.
While we did get all of the functions to work, we didn't quite get them all to function fully as we hoped, for example the examine method just prints out the whole hasmap rather that just returning the value for a given key, "item". We also were hoping to do something more interesting with "rest" but couldn't
really figure out where to take this method in the context of the rest of our class.

I would advise someone taking this course to be very organized when working on this assignment because things can become very confusing very quickly
if you don't keep things clean. I would also recommend developing a solid idea of what class you want to create before even touching the computer. 
Writing out your ideas on paper is a great starting point that forces you to consider how the different methods will work with each other before turning
your ideas into code.


KATIE'S REFLECTION:
I'm working with Erin Riley :D
This is a robot class meant to simulate the actions a robot can execute. We added an showOptions method to tell the user what they can do with the robot. There's also the inPossesion boolean method that holds a true/false value. I considered using Turtle for the fly method but god is that a lot of work and it would require me to extend to JFrame which felt too complicated for this assignment (maybe final project?). This assignment was enjoyable! I worked with Erin Riley! On our own, we split the methods (Erin doing the one methods and me doing the even ones. Then, we came together, gave each other feedback, debugged, and combined our code. Originally, I wanted there to be more user input for the use method. Although, for some
reason the if/else statement I had wouldn't execute and we eventually agreed the concept was solid but
we should save it for another day. I really liked the freedom and creativity this assignment provided Erin and I. I look forward to the final assignment.