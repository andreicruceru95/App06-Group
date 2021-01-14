
/**
 * Player's Armour.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Armour extends Item
{
    
    /**
     * Initialise the armour.
     */
    public Armour(String name, int baseStats, int enchantLevel, int bonusPerLevel, int cost, int multiplier, boolean exists)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel, cost, multiplier, exists);
        
    }
    
    /**
     * Print the armour stats.
     */
    public void print()
    {
        System.out.println(displayName + " + " + displayLevel + "\tDeffence: " + (enchantStats));
    }
}
