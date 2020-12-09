
/**
 * Write a description of class Weapon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon extends Item
{
    
    public Weapon(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
        
    }
    
    /**
     * Print the weapon's stats.
     */
    public void print()
    {
        System.out.println(displayName + " + " + displayLevel + "\tAttack: " + enchantStats);
    }
    
}
