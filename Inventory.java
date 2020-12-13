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

    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {
        INVENTORY.put(Characters.FLOWER_RED.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_BLUE.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_PURPLE.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_YELLOW.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_WHITE.getCharacter(), 0);
        INVENTORY.put(Characters.SNOW_FRAG.getCharacter(), 0);
        INVENTORY.put(Characters.STAR_FRAG.getCharacter(), 0);
        INVENTORY.put(Characters.SPIDER_KEY.getCharacter(), 0);
        INVENTORY.put(Characters.TOWER_KEY.getCharacter(), 0);
        INVENTORY.put(Characters.FOX_KEY.getCharacter(), 0);
        INVENTORY.put(Characters.CHEST_KEY.getCharacter(), 0);
        INVENTORY.put(Characters.HUSBAND_REMAINS.getCharacter(), 0);
        
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
        boolean exists = false;
        try
        {
            if(INVENTORY.get(string) > amount)
            {
                exists = true;
                
                return exists;
            }
            
        }
        catch(Exception e)
        {
             System.out.println("You don't have it");
        }
        
        return exists;
    }
    
    public void printInventory()
    {
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
