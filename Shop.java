
/**
 * Write a description of class Shop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shop
{
    private static final Potion POTION = new Potion(); 
    private static final int POTION_PRICE = 5;
    private static final int ATTACK_PRICE = 500;
    private static final int SHIELD_PRICE = 500;
    private static final int HEALTH_PRICE = 500;
    private static final int ATTACK = 25;
    private static final int SHIELD = 25;
    private static final int HEALTH = 150;
    
    
    public void openShop()
    {
        String[] list = new String[]
        {
            "\tBuy Potion \t\t" + POTION_PRICE + " Gold",
            "\tBuy Attack +" + ATTACK + "\t\t" + ATTACK_PRICE + " Gold",
            "\tBuy Deffence +" + SHIELD + "\t\t" + SHIELD_PRICE + " Gold",            
            "\tBuy Health +" + HEALTH + "\t\t" + HEALTH_PRICE + " Gold"            
        };
        
        for(int i = 0; i < list.length; i++)
        {
            System.err.println(list[i]);
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
