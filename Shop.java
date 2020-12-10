
/**
 * Write a description of class ShopTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shop
{
    private static final String QUIT = "quit";
    private static final int POTION_PRICE = 5;
    private static final int ATTACK_PRICE = 500;
    private static final int SHIELD_PRICE = 500;
    private static final int HEALTH_PRICE = 500;
    private static final int ATTACK = 25;
    private static final int SHIELD = 25;
    private static final int HEALTH = 150;
    
    private Display display = new Display();
    private Commands command;
    private Item potion = new Potion("HP Potion", 200, 1, 200);
    
    private String name;
    
    String[] list = new String[]
        {
            command.BUY_POTION.getCommand() + "\t\t" + POTION_PRICE + " Gold",
            command.BUY_ATTACK.getCommand() + ATTACK + "\t\t" + ATTACK_PRICE + " Gold",
            command.BUY_DEFFENCE.getCommand() + SHIELD + "\t\t" + SHIELD_PRICE + " Gold",            
            command.BUY_HEALTH.getCommand() + HEALTH + "\t\t" + HEALTH_PRICE + " Gold" ,
            command.QUIT.getCommand()
        };
           
    public void openShop()
    {
        display.listOptions(list);
        
    }
        
    /**
     * return potion price.
     */
    public int getPotionPrice()
    {
        return POTION_PRICE;    
        
    }
    
    /**
     * return atack price.
     */
    public int getAttackPrice()
    {
        return ATTACK_PRICE;    
        
    }
    
    /**
     * @return attack value
     */
    public int getAtackValue()
    {
        return ATTACK;
        
    }
    
    /**
     * return shield price.
     */
    public int getShieldPrice()
    {
        return SHIELD_PRICE;    
        
    }
    
    /**
     * @return shield value
     */
    public int getShieldValue()
    {
        return SHIELD;
        
    }
    
    /**
     * return health price.
     */
    public int getHealthPrice()
    {
        return HEALTH_PRICE;    
        
    }
    
    /**
     * @return health value
     */
    public int getHealthValue()
    {
        return HEALTH;
        
    }
    
}
