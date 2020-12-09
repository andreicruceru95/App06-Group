
/**
 * Write a description of class Amulet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Amulet extends Item
{
    
    public Amulet(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    public void print()
    {
        System.out.println(displayName + " + " + displayLevel + "\tBonus HP : " + (enchantStats));
    }
}
