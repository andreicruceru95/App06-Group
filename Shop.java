
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
    public static final String[] LIST = new String[3];    
    
    private boolean message = false;
    
    /**
     * Display the shop options.
     */    
    public void openShop()
    {
        LIST[0] = Commands.QUIT.getCommand();
        LIST[1] = Commands.BUY_POTION.getCommand() + "\t\t" + POTION_PRICE + " Gold";
        LIST[2] = Commands.BUY_KEY.getCommand() + "\t\t" + CHEST_KEY_PRICE + " Gold";
        
        if (message)
            LIST[3] = "\n\nNot a option!";
            
        DISPLAY.listOptions(LIST);
        
        message = false;
    }
        
    /**
     * set message on/off
    */
    public void setMessage()
    {
        message = true;
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