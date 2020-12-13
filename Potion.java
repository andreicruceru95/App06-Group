import java.util.Random;

/**
 * Write a description of class Potion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Potion extends Item
{
    int amount = 15;
    private Random random = new Random();
    
    public Potion(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    public void print()
    {
        System.out.println(displayName + "\t\t + " + displayLevel + "\tHeal: " + enchantStats +
                            "\tAmount " + amount);
    }
    
    public void printMessage()
    {
        int randomMessage = random.nextInt(5 - 1) + 1;
        
        switch(randomMessage)
        {
            case 1: System.out.println("You drunk a potion");
            case 2:
            case 3:
            case 4:
            case 5:
            
        }
       
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
