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
    public String printMessage()
    {
        int randomMessage = random.nextInt(5 - 1) + 1;
        
        switch(randomMessage)
        {
            case 1: return "You won't drink away the alcoholism.";
           
            case 2: return "All the problems fade before a hangover";
            
            case 3: return "That one liner 'i'm not drinking too much tonight' never goes as planned...";
            
            case 4: return "I just found out I'm colorblind. The diagnosis came completely out of the purple.";
            
            case 5: return "Alcohol is a perfect solvent: It dissolves marriages, families and careers.";
            
        }
        
        return null;       
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
