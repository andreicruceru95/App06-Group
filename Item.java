
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    protected int goldMultiplier = 1;   
    protected int goldRequired = 10 * goldMultiplier; 
   
    public Item(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        this.bonusPerLevel = bonusPerLevel;
        
        this.name = name;
        displayName = EVO_NAME_1 + " " + name;
        
        this.enchantLevel = enchantLevel;
        displayLevel = enchantLevel;
        
        this.baseStats = baseStats;
        enchantStats = baseStats * enchantLevel;
        
        update();
    }
    
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
            
            enchantStats = (baseStats + ( enchantLevel * bonusPerLevel ));
            
            goldMultiplier ++;
            
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
            
            return true;
        }
        else if(enchantLevel >= EVO_LEVEL_2)
        {
            displayLevel = enchantLevel % EVO_LEVEL_1;
            
            displayName = EVO_NAME_3 + " " + name;
            
            return true;
        }
        else if(enchantLevel >= EVO_LEVEL_3)
        {
            displayLevel = enchantLevel % EVO_LEVEL_1;
            
            displayName = EVO_NAME_4 + " " + name;
            
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
        return goldRequired;
    }
    
    /**
     * @return an item's name.
     */
    protected String getName()
    {
        return name;
    }
}

