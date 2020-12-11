import java.util.Random;

/**
 * Write a description of class Monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    private String drop;
        
    public Monster(String name, int level, String drop)
    {
        super(name, level);
        
        attackForce = initialAttackForce * level;
        shield = initialShield * level;
        currentHealthPoints = currentHealthPoints * level;
        maxHealthPoints = initialMaxHealthPoints * level;
        
        this.drop = drop;
    }
    
    private int dropGold()
    {
        int goldDrop = 50; //%
        int goldChance = random.nextInt(total - goldDrop) + goldDrop;
        
        if(goldChance <= goldDrop)
                    return level;
        
        return 0;
        
    }
    
    private boolean dropItem()
    {
        int miskDrop = 40; //%
        int miskChance = random.nextInt(total - miskDrop) + miskDrop;
        
        if(miskChance <= miskDrop)
            return true;
        
        return false;
        
    }
    
    /**
     * @return the item dropped.
     */
    private String getDrop()
    {
        return drop;
    }
}
