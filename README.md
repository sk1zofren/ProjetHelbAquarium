![image](https://github.com/sk1zofren/ProjetHelbAquarium/assets/120064745/37751c42-c79c-4c2a-a674-30a9f7dd1540)


# Game build with Java Swing 


# Feature  



- The fish move freely throughout the aquarium. I've implemented a method that allows each of my fish to move in the aquarium, either vertically, horizontally, or diagonally. For this, I've created a method called "move" that checks for each position around the fish if it's a valid position. It checks for 8 possible positions, and if it finds a valid position, it adds it to two array lists of possible movements for the x and y coordinates. Then, the method calculates the shortest distance between the fish's position and its target so that the fish can move there using the distance formula between two points.
  
- The orange fish is a random fish, meaning it constantly moves in a random direction within the aquarium's space. I've implemented a function that allows the orange fish to change direction when it hits an obstacle. To do this, I define my obstacles as rectangles forming hit boxes, and I check if the position of my orange fish is the same as that of my obstacle. If the position is the same, the target for my fish will be a new random coordinate.


- The red fish is a predator fish that eats all fish except itself. I've implemented two functions for this red fish. The first one, called "research," searches for the nearest fish to it from the prey list, which includes all fish except itself. To do this, it calculates the distance of each fish from the list and compares them to keep only the smallest distance.
The second function, called "eat," checks if the red fish has the same coordinates as one of its prey. If so, it holds the prey in a variable and calls another method called "removeFromListPrey" to remove the fish from the prey list. Then, it calls the "research" method again to continuously search for a new target.

- The blue fish is a social fish that always moves in the direction of the nearest blue or purple fish. I've implemented a function that searches for the nearest fish by calculating the lowest distance among the list of friendly fish "listFriendFish" and comparing them to each other. But since the fish can follow another blue fish, I've added a new condition that compares their hash codes and verifies that they are not the same, so the fish avoids following itself. Once the condition is valid, the new target of the blue fish will be the position of the nearest fish among the list of friendly fish.

- The purple fish, on the other hand, is a timid fish that always moves in the opposite direction of the nearest red fish. For this, I've implemented a method called "go" that calculates the closest distance among the list of red fish using the distance formula, comparing them to each other. Once it has found the closest fish, its new target will be the nearest edge in the same direction as the red fish. This means that if the red fish comes from the left, the purple fish will move towards the right edge. The purple fish is also stimulated by the number of decorations. For this, I've added a variable "numberOfDeco" that increments with each new decoration in the aquarium and is then added to the base speed of the purple fish.

- Regarding decorations.
Decorations are scattered throughout the aquarium, and fish cannot pass through them. That's why I had to implement a method to check if a fish's target is the same as that of a decoration. If so, it's considered an invalid position, meaning the fish must go around them to reach their target.

- Now let's talk about fish speed.
Each fish has a base speed, with the blue fish having a higher base speed than the others. Therefore, I add a speed to all fish using my "speed" variable in the constructor of my parent class "fish", and I define it in the constructor of each of my child classes "fish". Additionally, I also define a maximum speed "maxSpeed" equal to twice the speed of my orange fish.

- Regarding the aquarium temperature.
The aquarium has three possible configurations:
In the cold configuration, the red fish have a speed penalty compared to their base speed, making them slower than all other types of fish. To achieve this, I added a String variable "temperature" initialized to "warm". When it is set to "cold", the "speed" variable of the red fish is equal to the base speed minus 20.
In the warm configuration, the red fish have a speed bonus, making them faster than all other types of fish. Again, I added a String variable "temperature" initialized to "warm". When it is set to "cold", the "speed" variable of the red fish is equal to the base speed plus 20.
The temperature change is visible through a change in the background color of the aquarium. I check the value of the "temperature" variable using a .equals("") method. When the variable is initialized to "warm", the background is by default set to "colors.Black". When it is initialized to "cold", I use setBackground to change the color to "color.Yellow", and finally, when it is set to "hot", I use setBackground to change the color to "color.Green".

- Regarding the edible pellets.
When a fish comes into contact with a pellet, all other fish that are not the same color as it cannot move anymore. To achieve this, I implemented a method that checks if, among the list of fish, a fish has the same x and y positions as the pellet. If this is the case, it retains the pellet and then removes it by calling a method called "removeFromPast". Then, it will iterate through the list of fish again to check all fish that do not have the same color as it, and it will set a boolean to false to deactivate the "move" function of the fish. At the same time, a counter will be initialized to 10,000 and will be decremented with each update. When the counter drops below zero, the boolean will be set to true, and the fish will be able to move again.

- Regarding the edible insects:
When a fish comes into contact with an insect, it will receive a speed bonus for a certain period of time, and this period of time will depend on the type of insect. To achieve this, I implemented a method that checks if, among the list of fish, a fish has the same positions as an insect. If this is the case, it retains the insect and removes it by calling another method called "removeFromInsect". Then, it modifies the speed of the fish that touched the insect and simultaneously initializes a counter to a certain duration, which depends on the type of insect the fish has touched. The counter will start decrementing, and when it becomes less than zero, the speed of the fish will be reset to its base speed. There are three types of insects: Butterfly with a time bonus of 9999, Cockroach with a time bonus of 8888, and LadyBug with a time bonus of 7777.

- Regarding reproduction:
When two fish of the same color intersect, they disappear, and three new fish of the same color appear. To achieve this, I implemented a method that checks among the list of fish if two fish have exactly the same coordinates. Then, I added a new condition to check if these two fish have the same color. If this is the case, I retain the two fish and call a method called "removeFromFish" to remove them. Afterward, I add three new fish of the same color as the fish that was removed.

- Regarding aquarium commands:
Each keyboard key corresponds to a different action:
* 0: Reset the aquarium. I clear all my created lists, reset the number of decorations to 0, set the background color back to default, then set the temperature to "tiède", and finally, call the "initGame" method.
* 1: Set the aquarium temperature to cold. I set the background color to "colors.Yellow" and then set the temperature variable to "cold".
* 2: Set the aquarium temperature to tiède. I set the background color to "colors.Black" and then set the temperature variable to "tiède".
* 3: Set the aquarium temperature to chaud. I set the background color to "colors.Green", then set the temperature variable to "hard".
* 4: Add an insect at a random position. I call my "addBug()" method.
* 5: Add an edible pellet at a random position. I call my "addPast()" method.
* 6: Switch to insectivore mode. In this mode, all fish that are not stopped move toward the nearest insect. I set my boolean "insect" to call my "insectivorMod" method.
* 7: Switch to pellet mode. In this mode, all fish that are not stopped move toward the nearest pellet, if there is one in the aquarium. I set my boolean "past" to call my "pastMod" method.
* 8: Switch to reproduction mode. In this mode, all fish that are not stopped seek to encounter the nearest fish of the same color. I set my boolean "reprod" to call my "reproductionMod" method.
* 9: Add a fish of random type at a random position in the aquarium. I use a switch case with a random number from 1 to 4, and based on the result, a new random fish appears.
* r: This stops all fish except the red ones. I iterate through my fish list, and for each fish that is different from the red fish, I set the "move" boolean to "true" to stop their movements.
* b: This allows stopping all fish except the blue one. I iterate through my fish list, and for each fish that is different from the blue fish, I set the "move" boolean to "true" to stop their movements.
* m: This allows stopping all fish except the purple ones. I iterate through my fish list, and for each fish that is different from the purple fish, I set the "move" boolean to "true" to stop their movements.
* o: This allows stopping all fish except the orange ones. I iterate through my fish list, and for each fish that is different from the orange fish, I set the "move" boolean to "true" to stop their movements.

- My additional feature is the addition of a pink pill in the aquarium that teleports the fish that comes into contact with it. To achieve this, I implemented a method that checks among the list of fish if a fish has the same positions as a pink pill. If so, my method calls another method to remove the pill from the list of pills. Then, the position of my fish will be set to random values, causing the fish to appear in a random place in the aquarium.



# Running
Execute the run.sh preferably in a Linux environment.
# Resources
Building Game with JavaSwing - https://www.jmdoudoux.fr/java/dej/chap-swing.htm
  
# Author
Sow Michel - www.linkedin.com/in/michel-sow
# License

Copyright (c) 2023 Sow Michel http://github.com/sk1zofren


