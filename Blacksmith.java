import java.util.Random;

/**
 * Write a description of class Blacksmith here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Blacksmith
{
    private Player player;
    private Random rand;
    
    private Weapon weapon ;
    private Armour armour ;
    private Potion potion ;
    
    private int weaponCost;
    private int armourCost;
    private int potionCost;
    
    /**
     * Constructor for blacksmith
     */
    public Blacksmith(Player player, Weapon weapon, Armour armour, Potion potion)
    {
        this.player = player;
        this.weapon = weapon;
        this.armour = armour;
        this.potion = potion;
        
        rand = new Random();
        weaponCost = 5;
        armourCost = 5;
        potionCost = 100;
        
    }
    
    /**
     * See blacksmith prices.
     */
    public void openBlacksmithShop()
    {
        String[] list = new String[] 
        {
            "\tEnchance weapon" + "\t\t" + weaponCost + " Gold",
            "\tEnchance armour" + "\t\t" + armourCost + " Gold",
            "\tEnchance potion" + "\t\t" + potionCost + " Gold",
            "\tQuit" + "\t\t\t\tquit"
        };                                  
        
        for(int i = 0; i < list.length; i++)
        {
            System.err.println(list[i]);
        }
    }
    
    /**
     * increase armour level;
     */
    public boolean enchanceArmour(int playerGold)
    {
        int multiplier = 12;
        
        if(playerGold >= armourCost)
        {
            armour.enchance();
            armourCost += multiplier;
            
            return true;
        }
        else
        {
            System.out.println("Blacksmith: Not enough gold");
            
            return false;
        }
    }
    
    /**
     * increase weapon level;
     */
    public boolean enchanceWeapon(int playerGold)
    {
        int multiplier = 12;
        
        if(playerGold >= weaponCost)
        {
            weapon.enchance();
            weaponCost += multiplier;
            
            return true;
        }
        else
        {
            System.out.println("Blacksmith: Not enough gold");   
            
            return false;
        }
        
    }
    
    /**
     * increase potion level;
     */
    public boolean enchancePotion(int playerGold)
    {
        int multiplier = 50;
        
        if(playerGold >= potionCost)
        {
            potion.enchance();
            potionCost += multiplier;
            
            return true;
        }
        else
        {
            System.out.println("Blacksmith: Not enough gold");   
        
            return false;
        }
    }
    
    /**
     * @return potion cost
     */
    public int getPotionCost()
    {
        return potionCost;
    }
    
    /**
     * @return armour cost
     */
    public int getArmourCost()
    {
        return potionCost;
    }
    
    /**
     * @return weapon cost
     */
    public int getWeaponCost()
    {
        return weaponCost;
    }
}
