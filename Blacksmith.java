
/**
 * The game blacksmith. 
 * Will improve the player's items.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Blacksmith
{
    public static final String SUCCESS = "\t\tYou have successfully enchanted: ";
    public static final Display DISPLAY = new Display();
    public static final String[] BLACKSMITH_MENU = new String[9];
    public static final String SWORD = "Steel Sword";
    public static final String ARMOUR ="Steel Armour";
    public static final String POTION = "HP Potion";
    public static final String AMULET = "Hellen's Gift";
    public static final String RING = "Potus's Ring";
    public static final String BRACELET = "Spirit Trinket";

    private int weaponCost = 5;
    private int armourCost = 5;
    private int amuletCost = 5;
    private int ringCost = 15;
    private int braceletCost = 15;
    private int potionCost = 100;
    private boolean message = false;
    private boolean success = false;
    
    /**
     * Enhance an item.
     */
    public boolean enchance(Item item, int gold)
    {
        int itemMultiplier = 10;
        int specialMultiplier = 15;
        String name = item.getName();
        
        switch(name)
        {
            case SWORD:
                if(checkGold(gold, weaponCost))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    weaponCost += itemMultiplier;
                    
                    return true;
                }
                
            case ARMOUR:
                if(checkGold(gold, armourCost))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    armourCost += itemMultiplier;
                    
                    return true;
                }
                
            case POTION:
                if(checkGold(gold, potionCost))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
    
                    int potionMultiplier = 50;
                    potionCost += potionMultiplier;
                    
                    return true;
                }
                
            case AMULET:
                if(checkGold(gold, amuletCost))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    amuletCost += itemMultiplier;
                    
                    return true;
                }
                
            
            case RING:
                if(checkGold(gold, ringCost))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    ringCost += specialMultiplier;
                    
                    return true;
                }
                
            case BRACELET:
                if(checkGold(gold, braceletCost))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    braceletCost += specialMultiplier;
                    
                    return true;
                }
                
            default:
                return false;
        }
    }
    
    /**
     * Check if the gold required exists in the user's account.
     */
    public boolean checkGold(int gold, int cost)
    {
        return gold >= cost;
    }
    
    /**
     * Create list of options
     */
    public void createList(boolean ringExists, boolean braceletExists, int goldAmount)
    {
        BLACKSMITH_MENU[0] = Commands.ENCHANCE_WEAPON.getCommand()   + "\t\t\t" + weaponCost   + " Gold";
        BLACKSMITH_MENU[1] = Commands.ENCHANCE_ARMOUR.getCommand()   + "\t\t\t" + armourCost   + " Gold";
        BLACKSMITH_MENU[2] = Commands.ENCHANCE_POTION.getCommand()   + "\t\t\t" + potionCost   + " Gold";
        BLACKSMITH_MENU[3] = Commands.ENCHANCE_AMULET.getCommand()   + "\t\t\t" + amuletCost   + "Gold";
        
        if(ringExists)
            BLACKSMITH_MENU[4] = Commands.ENCHANCE_RING.getCommand()     + "\t\t\t" + ringCost     + "Gold";
             
        if(braceletExists)
            BLACKSMITH_MENU[5] = Commands.ENCHANCE_BRACELET.getCommand() + "\t\t"   + braceletCost + "Gold";
            
        BLACKSMITH_MENU[6] = "\n\n" + Commands.QUIT.getCommand();
        BLACKSMITH_MENU[7] = "\n\t\tYour gold amount: " + goldAmount;
        if(message)
        {
            BLACKSMITH_MENU[8] = "\n\n\t\tNot an option!";
            
            message = false;
        }
        else 
            BLACKSMITH_MENU[8] = null;
            
        if(success)
        {
            BLACKSMITH_MENU[8] = "\n\n\t\tSuccess!";
            
            success = false;
        }            
        else
            BLACKSMITH_MENU[8] = null;
    }
        
    /**
     * set message on
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
     * Display the blacksmith options.
     */
    public void openBlacksmithShop()
    {
        DISPLAY.listOptions(BLACKSMITH_MENU);
        
    }
    
    /**
     * @return the cost of enchantment.
     */
    public int getCost(Item item)
    {
        String name = item.getName();
        
        switch (name)
        {
            case SWORD:
                return weaponCost;
                
            case ARMOUR:
                return armourCost;
                
            case POTION:
                return potionCost;
                
            case AMULET:
                return amuletCost;
            
            case RING:
                return ringCost;
                
            case BRACELET:
                return braceletCost;
                
            default:
                return 0;
        }
    }
}
