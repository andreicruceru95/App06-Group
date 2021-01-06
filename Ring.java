
/**
 * Player's Ring.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Ring extends Item
{
    
    /**
     * Initialise Ring.
     */
    public Ring(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    /**
     * Print the ring's stats.
     */
    public void print()
    {
        System.out.println(displayName + "\t + " + displayLevel + "\tChance of double hit : " + enchantStats);
    }
}
