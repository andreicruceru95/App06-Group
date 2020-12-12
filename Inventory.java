import java.util.*;

/**
 * Write a description of class Inventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Inventory
{
    private static final HashMap<String, Integer> INVENTORY = new HashMap<>();
    
    private Characters character;

    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {
        INVENTORY.put(character.FLOWER_RED.getCharacter(), 0);
        INVENTORY.put(character.FLOWER_BLUE.getCharacter(), 0);
        INVENTORY.put(character.FLOWER_PURPLE.getCharacter(), 0);
        INVENTORY.put(character.FLOWER_YELLOW.getCharacter(), 0);
        INVENTORY.put(character.FLOWER_WHITE.getCharacter(), 0);
        INVENTORY.put(character.SNOW_FRAG.getCharacter(), 0);
        INVENTORY.put(character.STAR_FRAG.getCharacter(), 0);
        INVENTORY.put(character.SPIDER_KEY.getCharacter(), 0);
        INVENTORY.put(character.TOWER_KEY.getCharacter(), 0);
        INVENTORY.put(character.FOX_KEY.getCharacter(), 0);
        INVENTORY.put(character.CHEST_KEY.getCharacter(), 0);
        
    }

    public void addToInventory(String string, int amount)
    {
        INVENTORY.put(string, INVENTORY.get(string) + amount);
    }
    
    public void removeFromInventory(String string, int amount)
    {
        INVENTORY.put(string, INVENTORY.get(string) - amount);
    }
    
    public boolean checkInventory(String string, int amount)
    {
        if(INVENTORY.get(string) > amount)
            return true;
            
        return false;    
    }
    
    public void printInventory()
    {
        // if(INVENTORY.isEmpty())
            // System.out.println("\t\tInventory is empty");
        int count = 0;    
        for (String object : INVENTORY.keySet())
        {
            String key = object.toString();
            int value = INVENTORY.get(object);  
            
            if(value > 0)
            {
                System.out.println("\t" + key + "\t" + value);   
                count ++;
            }
        }
        
        if (count == 0)
            System.out.println("\t\tInventory is empty");
            
    }
}
