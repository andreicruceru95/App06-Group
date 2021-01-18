/**
 * The game Monster.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Monster extends Actor
{
    private final String drop;
    protected int expMultiplier = 150; 
    
    /**
     * Initialising the Monster.
     */
    public Monster(String name, int level, String drop)
    {
        super(name, level);
        
        attackForce = initialAttackForce * level;
        shield = (initialShield * level) / 2;
        currentHealthPoints = currentHealthPoints * level;
        maxHealthPoints = initialMaxHealthPoints * level;
        exp = expMultiplier * level;
        
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
    public String dropItem()
    {
        int miscDrop = 40; //%
        int miscChance = random.nextInt(total - 1) + 1;

        if(miscChance <= miscDrop)
            return drop;
        
        return null;  
    }
    
    /**
     * @return weather or not this monster will drop a chest.
     */
    public String dropChest()
    {
        int chestDrop = 15;
        int chestChance = random.nextInt(total - 1) + 1;

        if(chestChance <= chestDrop)
            return Characters.CHEST.getCharacter();
          
        return null;
    }
    
    /**
     * @return weather or not this monster will drop remains.
     */
    public String dropRemains()
    {
        int remainsDrop = 15;
        int remainsChance = random.nextInt(total - 1) + 1;

        if(remainsChance <= remainsDrop)
            return Characters.REMAINS.getCharacter();
            
        return null;
    }
    
    /**
     * @return weather or not this monster will drop keys.
     */
    public String dropKey()
    {
        int keyDrop = 25;
        int keyChance = random.nextInt(total - 1) + 1;

        if(keyChance <= keyDrop)
            return Characters.CHEST_KEY.getCharacter();
            
        return null;
    }
    
    /**
     * @return weather or not this monster will drop keys.
     */
    public String dropPotion()
    {
        int potionDrop = 25;
        int potionChance = random.nextInt(total - 1) + 1;

        if(potionChance <= potionDrop)
            return Characters.POTION.getCharacter();
            
        return null;
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
