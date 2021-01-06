/**
 * The game Monster.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Monster extends Actor
{
    private final String drop;
    
    /**
     * Initialising the Monster.
     */
    public Monster(String name, int level, String drop)
    {
        super(name, level);
        
        attackForce = initialAttackForce * level;
        shield = initialShield * level;
        currentHealthPoints = currentHealthPoints * level;
        maxHealthPoints = initialMaxHealthPoints * level;
        
        this.drop = drop;
    }
    
    /**
     * @return weather or not this monster drops gold.(50% chance)
     */
    public int dropGold()
    {
        int goldDrop = 50; //%
        int goldChance = random.nextInt(total - 1) + 1;
        
        if(goldChance <= goldDrop)
                    return level;
        
        return 0;
        
    }
    
    /**
     * @return weather or not this monster will drop an item.
     */
    public boolean dropItem()
    {
        int miscDrop = 40; //%
        int miscChance = random.nextInt(total - 1) + 1;

        return miscChance <= miscDrop;

    }
    
    /**
     * @return weather or not this monster will drop a chest.
     */
    public boolean dropChest()
    {
        int chestDrop = 15;
        int chestChance = random.nextInt(total - 1) + 1;

        return chestChance <= chestDrop;

    }
    
    /**
     * @return weather or not this monster will drop remains.
     */
    public boolean dropRemains()
    {
        int remainsDrop = 15;
        int remainsChance = random.nextInt(total - 1) + 1;

        return remainsChance <= remainsDrop;

    }
    
    /**
     * @return weather or not this monster will drop keys.
     */
    public boolean dropKey()
    {
        int keyDrop = 25;
        int keyChance = random.nextInt(total - 1) + 1;

        return keyChance <= keyDrop;

    }
    
    /**
     * @return weather or not this monster will drop keys.
     */
    public boolean dropPotion()
    {
        int potionDrop = 25;
        int potionChance = random.nextInt(total - 1) + 1;

        return potionChance <= potionDrop;

    }
    
    /**
     * @return the drop amount.
     */
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
