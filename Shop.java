
/**
 * Write a description of class ShopTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shop
{
    private static final int POTION_PRICE = 5;
    private static final int ATTACK_PRICE = 500;
    private static final int SHIELD_PRICE = 500;
    private static final int HEALTH_PRICE = 500;
    private static final int ATTACK = 25;
    private static final int SHIELD = 25;
    private static final int HEALTH = 150;
    
    private static final Display DISPLAY = new Display();

    String[] list = new String[]
        {
                Commands.BUY_POTION.getCommand() + "\t\t" + POTION_PRICE + " Gold",
                Commands.BUY_ATTACK.getCommand() + ATTACK + "\t\t" + ATTACK_PRICE + " Gold",
                Commands.BUY_DEFENCE.getCommand() + SHIELD + "\t\t" + SHIELD_PRICE + " Gold",
                Commands.BUY_HEALTH.getCommand() + HEALTH + "\t\t" + HEALTH_PRICE + " Gold" ,
                Commands.QUIT.getCommand()
        };
           
    public void openShop()
    {
        DISPLAY.listOptions(list);
        
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
    public int getAttackPrice()
    {
        return ATTACK_PRICE;    
        
    }
    
    /**
     * @return attack value
     */
    public int getAttackValue()
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
