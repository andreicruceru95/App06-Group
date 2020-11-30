
/**
 * Write a description of class Armour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Armour
{
    private int armourPerLevel = 20;
    private int hitPointsPerLevel = 150;
    
    private String name;
    private int shield;
    private int hitPoints;
    private int level;
    private int displayLevel;
    
    /**
     * constructor for armour.
     */
    public Armour()
    {
        this.name = "Steel Plate";
        this.shield = armourPerLevel;
        this.hitPoints = hitPointsPerLevel;
        this.level = 1;
        this.displayLevel = 1;
    }
    
    /**
     * Increment a armour level.
     * Every 9 levels the name changes
     */
    public void enchance()
    {
        int evolution1 = 9;
        int evolution2 = 18;
        int evolution3 = 27;
        int evolution4 = 36;
        
        this.shield += armourPerLevel;
        this.hitPoints += hitPointsPerLevel;
        this.level ++;
        this.displayLevel ++;
        
        if(level > evolution1)
        {
            this.name = "Silver Plate";
            armourPerLevel = 20;
            hitPointsPerLevel = 100;
            this.displayLevel = 1;
        }
        else if(level > evolution2)
        {
            this.name = "Platinum Plate";
            armourPerLevel = 35;
            hitPointsPerLevel = 170;
            this.displayLevel = 1;
        }
        else if(level > evolution3)
        {
            this.name = "Lion Plate";
            armourPerLevel = 55;
            hitPointsPerLevel = 280;
            this.displayLevel = 1;
        }
        else if(level > evolution4)
        {
            this.name = "Black Steel Plate";
            armourPerLevel = 80;
            hitPointsPerLevel = 420;
            this.displayLevel = 1;
        }
    }
    
    /**
     * @return shield value.
     */
    public int getArmourShield()
    {
        return level * armourPerLevel;
    }
    
    /**
     * @return bonus hit points value.
     */
    public int getArmourHItPoints()
    {
        return level * hitPointsPerLevel;
    }
    
    /**
     * @return armour attributes
     */
    public String getArmourAttributes()
    {
        return "Armour: " + name + " + " + displayLevel + " Defence: " + shield;
    }
    
    /**
     * @return armour per level
     */
    public int getArmorPerLevel()
    {
        return armourPerLevel;
    }
    
    /**
     * @return hit points per level
     */
    public int getHitPointsPerLevel()
    {
        return hitPointsPerLevel;
    }
}
