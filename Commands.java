
/**
 * Enumeration class Commands - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Commands
{
    DATABASE ("\t\tEnter \'database\' to see infrmation about the visuals"),
    PRESS_ANY ("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue.."),
    UP_INSTRUCTION ("\t\tEnter \'w\' to move forward"),  
    DOWN_INSTRUCTION ("\t\tEnter \'s\' to move back"),  
    LEFT_INSTRUCTION ("\t\tEnter \'a\' to move left"),  
    RIGHT_INSTRUCTION ("\t\tEnter \'d\' to move right"),
    HELP ("\t\tEnter \'help\' for a list of commands"),
    SEE_STATS ("\t\tEnter \'see stats\' for a list of monster stats"),
    SEE_LOCATION ("\t\tEnter \'see location\' to see the location of the player on the big map"),
    
    QUIT ("\t\tEnter \'quit\' to quit game or quit window"),
    POTION ("\t\tEnter \'potion\' to use health potion and restore health"),
    BUY_POTION ("\t\tEnter \'buy potion\' to buy HealthPotion"),
    BUY_ATTACK ("\t\tEnter \'buy attack\' to buy attack value by "),
    BUY_DEFFENCE ("\t\tEnter \'buy deffence\' to buy deffence value by "),
    BUY_HEALTH ("\t\tEnter \'buy health\' to buy increase your maximum health by "),
    ENCHANCE_WEAPON ("\t\tEnter \'enchance weapon\' to enchance your weapon"),
    ENCHANCE_ARMOUR ("\t\tEnter \'enchance armour\' to enchance your armour"),
    ENCHANCE_POTION ("\t\tEnter \'enchance potion\' to enchance your potion"),
    ENCHANCE_AMULET ("\t\tEnter \'enchance amulet\' to enchance your amulet");
    
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
