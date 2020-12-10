
/**
 * Write a description of class Potion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Potion extends Item
{
    int amount = 15;
    
    public Potion(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    public void print()
    {
        System.out.println(displayName + " + " + displayLevel + "\tHeal: " + enchantStats +
                            "\t" + amount);
    }
    
    public void increaseAmount(int amount)
    {
        this.amount += amount;
        
    }
    
    public void decreaseAmount()
    {
        amount --;
        
    }
    
    public int getAmount()
    {
        return amount;
        
    }
}
