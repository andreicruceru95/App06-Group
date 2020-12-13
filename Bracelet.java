
/**
 * Write a description of class Bracelet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bracelet extends Item
{
    public Bracelet(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    public void print()
    {
        System.out.println(displayName + "\t + " + displayLevel + "\tChance of evasion : " + enchantStats);
    }
}
