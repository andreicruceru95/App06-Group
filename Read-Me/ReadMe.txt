The game is in development, many functions may change!

A player has atack force/ defence etc and can equip 2 items (possibly more later on)

The items have atack force/ defence/ bonus hit points etc and potions (only one existant that heals)

The player's stats are dependent to the equipped item's stats.

The Monster is no different than the player except that it cannot use items. The monster's stats are are increasing with the monster's level and each map containts monsters with a similar lvl as the map (+-1)

The map is a 2D array and contains the representations of several objects in it's squares. 
It has a visual field of 3x3  that the user will see.


What I am planning to implement:

A "teleporter" - each time the player is going through a door he will be "teleported" into the next room. When the player gets to the end of the map he can be moved the same way to another map.

(I am still debating if I should have several rooms->maps->world or just several maps->world.)

Each time the player kills a monster, there will be 10-20% chance of dropping gold or an item around the map's level.
The monster/gold is removed off the map once killed/collected. 

The map could contain lucky chests that will randomly drop gold/items. 

 I am still working on the story, and potentialy adding some quests for the player. 

Could potentially spawn the map objects in a random order so each map is built different.

The player will have an energy level required to complete the game/ map and a score. Each move will cost energy, the more energy left to the end, the higher the score.