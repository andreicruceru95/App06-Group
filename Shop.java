
/**
 * In game shop.
 * The player can buy potions and other items here.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Shop
{
    //shop items
    public static final int POTION_PRICE = 5;
    public static final int CHEST_KEY_PRICE = 50;
       
    public static final Display DISPLAY = new Display();

    public static final String[] LIST = new String[]
    {
        Commands.BUY_POTION.getCommand() + "\t\t" + POTION_PRICE + " Gold",
        Commands.BUY_KEY.getCommand() + "\t\t" + CHEST_KEY_PRICE + " Gold",
        Commands.QUIT.getCommand()
    };
    
    /**
     * Display the shop options.
     */    
    public void openShop()
    {
        DISPLAY.listOptions(LIST);
        
    }
        
    /**
     * return potion price.
     */
    public int getPotionPrice()
    {
        return POTION_PRICE;    
        
    }
    
    /**
     * return attack price.
     */
    public int getKeyPrice()
    {
        return CHEST_KEY_PRICE;    
        
    }
    
}