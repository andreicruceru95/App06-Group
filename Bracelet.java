
/**
 * Player's bracelet.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Bracelet extends Item
{
    
    /**
     *Initialise Bracelet. 
     */
    public Bracelet(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    /**
     * Print bracelet stats.
     */
    public void print()
    {
        System.out.println(displayName + "\t + " + displayLevel + "\tChance of evasion : " + enchantStats);
    }
}
