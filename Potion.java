import java.util.Random;

/**
 * Health Potion.
 * Restores player's Health
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Potion extends Item
{
    int amount = 15;
    private static final Random random = new Random();
    
    /**
     * Initialise the potion.
     */
    public Potion(String name, int baseStats, int enchantLevel, int bonusPerLevel)
    {
        super(name, baseStats, enchantLevel, bonusPerLevel);
    }
    
    /**
     * Print the potions stats.
     */
    public void print()
    {
        System.out.println(displayName + "\t\t + " + displayLevel + "\tHeal: " + enchantStats +
                            "\tAmount " + amount);
    }
    
    /**
     * Print a random message each time a potion is used.
     */
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
    
    /**
     * Increase the amount of potions.
     */
    public void increaseAmount(int amount)
    {
        this.amount += amount;
        
    }
    
    /**
     * Decrese the amount of potions.
     */
    public void decreaseAmount()
    {
        amount --;
        
    }
    
    /**
     * @return the amount of potions.
     */
    public int getAmount()
    {
        return amount;
        
    }
}
