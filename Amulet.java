
/**
 * Player's Amulet.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Amulet extends Item
{
    
    /**
     * Initialise Amulet.
     */
    public Amulet(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    /**
     * Print amulet stats.
     */
    public void print()
    {
        System.out.println(displayName + " + " + displayLevel + "\tBonus HP : " + (enchantStats));
    }
}
