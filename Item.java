
/**
 * The Player item.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Item
{
    public static final int EVO_LEVEL_1 = 10;
    public static final int EVO_LEVEL_2 = 20;
    public static final int EVO_LEVEL_3 = 30;
    public static final int EVO_LEVEL_4 = 39;
    public static final String EVO_NAME_1 = "Basic";
    public static final String EVO_NAME_2 = "Advanced"; 
    public static final String EVO_NAME_3 = "Epic";
    public static final String EVO_NAME_4 = "Legendary";
    
    protected int bonusPerLevel;
    protected String name;
    protected String displayName;
    protected int displayLevel;
    protected int enchantLevel;
    protected int baseStats;
    protected int enchantStats;     
    protected int cost = 0; 
    protected int multiplier = 0;
    protected int bonusPerAdvancement = 10;
    protected boolean exists;
   
    /**
     * Initialising the item.
     * @param name - item name.
     * @param baseStats = the basic status of an item.
     * @param enchantLevel = the enchantment level of the item at creation. 
     * Usefull in the future where the player can gain random items each with a random enchantment level.
     * @param bonusPerLevel = the rate of status upgrade for each level.
     * @param cost = the cost of enchantment for each level.
     * @param multiplier = the rate of cost changing.
     * @param exists = visibility of the item(obtained/not obtained).
     */
    public Item(String name, int baseStats, int enchantLevel, int bonusPerLevel, int cost, int multiplier, boolean exists)
    {
        this.bonusPerLevel = bonusPerLevel;
        this.cost = cost;
        this.multiplier = multiplier;
        this.name = name;
        this.exists = exists;
        
        displayName = EVO_NAME_1 + " " + name;
        
        this.enchantLevel = enchantLevel;
        displayLevel = enchantLevel;
        
        this.baseStats = baseStats;
        enchantStats = baseStats * enchantLevel;
        
        update();
    }
    
    /**
     * @return the enchantment stats.
     */
    protected int getStats()
    {
        return enchantStats;
    }
    
    /**
     * Increment an item level.
     * Every 9 levels the name changes
     */
    public void enchance()
    {
        if(enchantLevel < EVO_LEVEL_4)
        {
            enchantLevel ++;
            displayLevel ++;
            cost += multiplier;
            
            enchantStats = (baseStats + ( enchantLevel * bonusPerLevel ));
            
            
            update();
        }   
        else
            System.out.println("\t\tMaximum level reached");
    }
    
    /**
     * Update the item's name.
     */
    protected boolean update()
    {
        if(enchantLevel >= EVO_LEVEL_1)
        {
            displayLevel = enchantLevel % EVO_LEVEL_1;
            
            displayName = EVO_NAME_2 + " " + name;
            
            bonusPerLevel += bonusPerAdvancement;
            
            return true;
        }
        else if(enchantLevel >= EVO_LEVEL_2)
        {
            displayLevel = enchantLevel % EVO_LEVEL_1;
            
            displayName = EVO_NAME_3 + " " + name;
            
            bonusPerLevel += bonusPerAdvancement;
            
            return true;
        }
        else if(enchantLevel >= EVO_LEVEL_3)
        {
            displayLevel = enchantLevel % EVO_LEVEL_1;
            
            displayName = EVO_NAME_4 + " " + name;
            
            bonusPerLevel += bonusPerAdvancement;
            
            return true;
        }
        else
            return false;
    }
        
    /**
     * @return the amount of gold required.
     */
    public int getGoldRequired()
    {
        return cost;
    }
    
    /**
     * get next stats
     */
    public int getNextStats()
    {
        return enchantStats + bonusPerLevel;
    }
    
    /**
     * @return an item's name.
     */
    protected String getName()
    {
        return name;
    }
    
    /**
     * Check if item exists
     */
    public boolean checkVisibility()
    {
        return exists;
    }
    
    public void setVisibility()
    {
        exists = true;
    }
}

