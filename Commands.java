
/**
 * Enumeration class Commands - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Commands
{
    DATABASE ("\t\tEnter 'database' to see information about the visuals"),
    PRESS_ANY ("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue.."),
    UP_INSTRUCTION ("\t\tEnter 'w' to move forward"),
    DOWN_INSTRUCTION ("\t\tEnter 's' to move back"),
    LEFT_INSTRUCTION ("\t\tEnter 'a' to move left"),
    RIGHT_INSTRUCTION ("\t\tEnter 'd' to move right"),
    HELP ("\t\tEnter 'help' for a list of commands"),
    SEE_STATS ("\t\tEnter 'see monsters' for a list of monster stats"),
    SEE_LOCATION ("\t\tEnter 'see location' to see the location of the player on the big map"),
    SHOW_STATS ("\t\tEnter 'show stats' to show player's stats"),
    HIDE_STATS ("\t\tEnter 'hide stats' to hide player's stats"),
    SHOW_ITEMS ("\t\tEnter 'show items' to show player's items"),
    HIDE_ITEMS ("\t\tEnter 'hide items' to hide player's items"),
    
    QUIT ("\t\tEnter 'quit' to quit game or quit window"),
    POTION ("\t\tEnter 'potion' to use health potion and restore health"),
    BUY_POTION ("\t\tEnter 'buy potion' to buy HealthPotion"),
    BUY_ATTACK ("\t\tEnter 'buy attack' to buy attack value by "),
    BUY_DEFENCE ("\t\tEnter 'buy defence' to buy defence value by "),
    BUY_HEALTH ("\t\tEnter 'buy health' to buy increase your maximum health by "),
    ENCHANCE_WEAPON ("\t\tEnter 'enchance weapon' to enchance your weapon"),
    ENCHANCE_ARMOUR ("\t\tEnter 'enchance armour' to enchance your armour"),
    ENCHANCE_POTION ("\t\tEnter 'enchance potion' to enchance your potion"),
    ENCHANCE_AMULET ("\t\tEnter 'enchance amulet' to enchance your amulet"),
    ENCHANCE_RING ("\t\tEnter 'enchance ring' to enchance your ring"),
    ENCHANCE_BRACELET ("\t\tEnter 'enchance bracelet' to enchance your bracelet");
    
    private final String command;
 
    Commands(String command) 
    {
        this.command = command;
    }
 
    public String getCommand() 
    {
        return command;
    }
}
