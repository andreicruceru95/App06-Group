
/**
 * Write a description of class Potion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Potion
{
    private static final int HEAL_PER_LEVEL = 50;
    private String name;
    private int heal;
    private int level;
    private int displayLevel;
        
    /**
     * constructor for potion.
     */
    public Potion()
    {
        this.name = "Health Potion";
        this.heal = HEAL_PER_LEVEL;
        this.level = 1;
        this.displayLevel = 1;
    }
    
    /**
     * Increment the potion level.
     * Every 9 levels the potion name changes.
     */
    public void enchance()
    {
        int basic = 9;
        int advanced = 18;
        this.heal += HEAL_PER_LEVEL;
        this.level ++;
        if(level > basic)
            this.name = "Advanced Health Potion";
        else if(level > advanced)
            this.name = "Extreme Health Potion";
        
    }
    
    /**
     * @return the heal amount
     */
    public  int getHeal()
    {
        return level * HEAL_PER_LEVEL;
    }
    
    /**
     * @return the name of the potion
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return heal value per level
     */
    public int getHealPerLevel()
    {
        return HEAL_PER_LEVEL;
    }
}
