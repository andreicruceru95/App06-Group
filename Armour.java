
/**
 * Write a description of class Armour here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Armour extends Item
{
        
    public Armour(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
        
    }
    
    public void print()
    {
        System.out.println(displayName + "\t + " + displayLevel + "\tDefence: " + (enchantStats));
    }
}
