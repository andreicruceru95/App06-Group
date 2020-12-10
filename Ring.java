
/**
 * Write a description of class Ring here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ring extends Item
{
    
    public Ring(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    public void print()
    {
        System.out.println(displayName + " + " + displayLevel + "\tChance of double hit : " + enchantStats);
    }
}
