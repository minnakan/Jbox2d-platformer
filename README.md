# Jbox2d Project

This project is a platformer java game where the player should pick up objects to progress to the next level. There are three levels in the game and each of them have different obstacles. The main objective of the game is to complete it hence no scoring system was introduced.
Features included in the game:

### The playable character

This is a walker class with a controller that moves the character. The characters image changes depending on the direction it moves. The playable character has a health attribute and an item collected attribute. The health is passed on between levels and the item collected is set to zero at the beginning of each level.

### Levels

The game consists of three levels which extend from a base level abstract class. Each of these levels implements timers which are responsible for the projectiles and enemy movement. The base level builds the outline for each world and level details are built in the level classes.

### Control Panel

There are six buttons present in the control panel. The ‘+’ and ‘-‘ control the background music volume. A ‘Quit’ ‘Pause’ and ‘Restart’ button is also present. The restart button restarts the current level and not the game. The last button is to switch between levels.

### Sound

Each level has its own background music. A sound is played when an item is picked up or the player takes damage. The volume of the background music can be adjusted from the control panel present on the top of the play window. When the enemy is killed in level 3 the background music stops and a victory sound is played.

### Timers

Timers are implemented in all three levels and are responsible for spawning the projectiles. A timer in level 2 is used to move an enemy character as well. The timer stops when the user pauses the game.

### Key coding challenges involved

The first implementation of collision listeners was quite the challenge but it got easier from the second implementation onwards. I also found passing on the health attribute and switching background music across all three of my levels to be quite the challenge. I also had trouble implementing sound based on the state of the game i.e. when the enemy is killed in level three but manged to do it after many failed attempts.
Overall the entire game coding experience was quite the challenge from start to finish.
