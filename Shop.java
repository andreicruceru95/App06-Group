
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
    public static final String[] LIST = new String[6];    
    
    private boolean message = false;
    private boolean success = false;
    
    /**
     * Display the shop options.
     */    
    public void openShop(int goldAmount)
    {
        LIST[0] = Commands.QUIT.getCommand();
        LIST[1] = Commands.BUY_POTION.getCommand() + "\t\t" + POTION_PRICE + " Gold";
        LIST[2] = Commands.BUY_KEY.getCommand() + "\t\t" + CHEST_KEY_PRICE + " Gold";
        LIST[3] = "\n\t\tYour gold amount: " + goldAmount;
        if(message)
        {
            LIST[4] = "\n\n\t\tNot an option!";
            
            message = false;
        }
        else 
            LIST[4] = null;
            
        if(success)
        {
            LIST[5] = "\n\n\t\tSuccess!";
            
            success = false;
        }            
        else
            LIST[5] = null;
            
        DISPLAY.listOptions(LIST);
    }
        
    /**
     * set message on/off
    */
    public void setMessage(int number)
    {
        switch(number)
        {
            case 0:
                message = true;
                success = false;
                break;
                
            case 1:
                message = false;
                success = true;
                break;
        }
        
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