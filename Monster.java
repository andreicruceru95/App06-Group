/**
 * Write a description of class Monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    private final String drop;
        
    public Monster(String name, int level, String drop)
    {
        super(name, level);
        
        attackForce = initialAttackForce * level;
        shield = initialShield * level;
        currentHealthPoints = currentHealthPoints * level;
        maxHealthPoints = initialMaxHealthPoints * level;
        
        this.drop = drop;
    }
    
    public int dropGold()
    {
        int goldDrop = 50; //%
        int goldChance = random.nextInt(total - 1) + 1;
        
        if(goldChance <= goldDrop)
                    return level;
        
        return 0;
        
    }
    
    public boolean dropItem()
    {
        int miscDrop = 40; //%
        int miscChance = random.nextInt(total - 1) + 1;

        return miscChance <= miscDrop;

    }
    
    public boolean dropChest()
    {
        int chestDrop = 15;
        int chestChance = random.nextInt(total - 1) + 1;

        return chestChance <= chestDrop;

    }
    
    public int getDropAmount()
    {
        int multiplier = 5;
        
        return random.nextInt(multiplier - 1) + 1;
        
    }
    
    /**
     * @return the item dropped.
     */
    public String getDrop()
    {
        return drop;
    }
}
