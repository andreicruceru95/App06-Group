
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
    public static final String[] BLACKSMITH_MENU = new String[7];

    private int weaponCost = 5;
    private int armourCost = 5;
    private int amuletCost = 5;
    private int ringCost = 15;
    private int braceletCost = 15;
    private int potionCost = 100;
    private boolean message = false;
    
    /**
     * Enhance an item.
     */
    public boolean enchance(Item item, int gold)
    {
        int itemMultiplier = 10;
        int specialMultiplier = 15;
        
        if(item.getName().toLowerCase().contains("sword"))
        {
            
            if(checkGold(gold, weaponCost))
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                weaponCost += itemMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("armour"))
        {
            
            if(checkGold(gold, armourCost))
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                armourCost += itemMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("potion"))
        {
            
            if(checkGold(gold, potionCost))
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());

                int potionMultiplier = 50;
                potionCost += potionMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("gift"))
        {
            
            if(checkGold(gold, amuletCost))
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                amuletCost += itemMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("ring"))
        {
            
            if(checkGold(gold, ringCost))
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                ringCost += specialMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("trinket"))
        {
            
            if(checkGold(gold, braceletCost))
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                braceletCost += specialMultiplier;
                
                return true;
            }
            
        }
                
        return false;
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
    public void createList(boolean ringExists, boolean braceletExists)
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
        
        if (message)
            BLACKSMITH_MENU[7] = "\n\nNot a option!";
        
    }
        
    /**
     * set message on/off
    */
    public void setMessage()
    {
        message = true;
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
        if(item.getName().toLowerCase().contains("sword"))
        {
            return weaponCost;
        }
        else if(item.getName().toLowerCase().contains("armour"))
        {
            return armourCost;
        }
        else if(item.getName().toLowerCase().contains("potion"))
        {
            return potionCost;
        }
        else if(item.getName().toLowerCase().contains("amulet"))
        {
            return amuletCost;
        }
        else
            return 0;
    }
}
