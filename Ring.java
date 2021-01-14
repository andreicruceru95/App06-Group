
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
    public Ring(String name, int baseStats, int enchantLevel, int bonusPerLevel, int cost, int multiplier, boolean exists)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel, cost, multiplier, exists);
    }
    
    /**
     * Print the ring's stats.
     */
    public void print()
    {
        System.out.println(displayName + "\t + " + displayLevel + "\tChance of double hit : " + enchantStats);
    }
}
