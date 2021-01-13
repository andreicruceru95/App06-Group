import java.util.*;

/**
 * The player's inventory.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Inventory
{
    private static final HashMap<String, Integer> INVENTORY = new HashMap<>();
    
    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {
        INVENTORY.put(Characters.FLOWER_RED.getCharacter(), 20);
        INVENTORY.put(Characters.FLOWER_BLUE.getCharacter(), 20);
        INVENTORY.put(Characters.FLOWER_PURPLE.getCharacter(), 20);
        INVENTORY.put(Characters.FLOWER_YELLOW.getCharacter(), 20);
        INVENTORY.put(Characters.FLOWER_WHITE.getCharacter(), 20);
        
        INVENTORY.put(Characters.SNOW_FRAG.getCharacter(), 120);
        INVENTORY.put(Characters.STAR_FRAG.getCharacter(), 51);
        INVENTORY.put(Characters.SPIDER_KEY.getCharacter(), 2);
        INVENTORY.put(Characters.TOWER_KEY.getCharacter(), 2);
        INVENTORY.put(Characters.FOX_KEY.getCharacter(), 2);
        INVENTORY.put(Characters.CHEST_KEY.getCharacter(), 12);
        INVENTORY.put(Characters.REMAINS.getCharacter(), 12);
        INVENTORY.put(Characters.MYTHICAL_STONE.getCharacter(), 2);
        
    }
    
    /**
     * Add an amount of items to inventory.
     */
    public void addToInventory(String string, int amount)
    {
        INVENTORY.put(string, INVENTORY.get(string) + amount);
    }
    
    /**
     * @remove an item from inventory.
     */
    public void removeFromInventory(String string, int amount)
    {
        INVENTORY.put(string, INVENTORY.get(string) - amount);
    }
    
    /**
     * Check if an amount of items exists in the inventory.
     */
    public boolean checkInventory(String string, int amount)
    {
        boolean exists = false;
        String key = null;
        int value = 0;
        
        for (String object : INVENTORY.keySet())
        {
            key = object.toString();
            value = INVENTORY.get(key);
            
            if(key.equals(string))
            {
                key = string;
                
                break;
            }
        } 
        
        if(key == null)
            exists = false;
            
        else 
        { 
            
            if(value >= amount)
                exists = true;
               
        }
        
        return exists;
    }
    
    /**
     * Count how many flowers is in the inventory.
     * Set each flower amount to 0.
     * @return 10 times the amount of flowers as gold reward.
     */
    public int countFlowers()
    {
        int value = 
                INVENTORY.get(Characters.FLOWER_RED.getCharacter()) + 
                INVENTORY.get(Characters.FLOWER_BLUE.getCharacter()) +
                INVENTORY.get(Characters.FLOWER_PURPLE.getCharacter()) +  
                INVENTORY.get(Characters.FLOWER_YELLOW.getCharacter()) +
                INVENTORY.get(Characters.FLOWER_WHITE.getCharacter());
                
        INVENTORY.put(Characters.FLOWER_RED.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_BLUE.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_PURPLE.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_YELLOW.getCharacter(), 0);
        INVENTORY.put(Characters.FLOWER_WHITE.getCharacter(), 0);
        
        return value * 10;
    }
        
    /**
     * print the inventory items.
     * print a message if empty.
     */
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