
/**
 * Write a description of class Weapon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon
{
    public int attackPerLevel = 12;
    
    private String name;
    private int attackForce;
    private int level;
    private int displayLevel;
    
    /**
     * constructor for weapon.
     */
    public Weapon()
    {
        this.name = "Steel Sword";
        this.attackForce = attackPerLevel;
        this.level = 1;
        this.displayLevel = 1;
    }
    
    /**
     * Increment a weapon level.
     * Every 9 levels the name changes
     */
    public void enchance()
    {
        int evolution1 = 9;
        int evolution2 = 18;
        int evolution3 = 27;
        int evolution4 = 36;
        
        this.attackForce += attackPerLevel;
        
        this.level ++;
        this.displayLevel ++;
        if(level > evolution1)
        {
            this.name = "Silver Sword";
            attackPerLevel = 15;
            this.displayLevel = 1;
        }
        else if(level > evolution2)
        {
            this.name = "Full Moon Sword";
            attackPerLevel = 25;
            this.displayLevel = 1;
        }
        else if(level > evolution3)
        {
            this.name = "Dragon Sword";
            attackPerLevel = 40;
            this.displayLevel = 1;
        }
        else if(level > evolution4)
        {
            this.name = "Poison Sword";
            attackPerLevel = 80;
            this.displayLevel = 1;
        }
    }
    
    /**
     * @return attack value.
     */
    public int getAttackValue()
    {
        return level * attackPerLevel;
    }
    
    /**
     * @return weapon attributes
     */
    public String getWeaponAttributes()
    {
        return "Weapon: " + name + " + " + displayLevel + " Attack: " + attackForce;
    }
    
    /**
     * @return attack per level
     */
    public int getAttackPerLevel()
    {
        return attackPerLevel;
    }
}
