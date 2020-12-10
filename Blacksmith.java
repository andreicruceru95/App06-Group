
/**
 * Write a description of class BlacksmithTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Blacksmith
{
    public static final String SUCCESS = "\t\tYou have succesfully enchanted: ";
    private int weaponCost = 5;
    private int armourCost = 5;
    private int amuletCost = 5; 
    private int itemMultiplier = 10;
    
    private int ringCost = 15;
    private int braceletCost = 15;
    private int specialMultiplier = 15;
        
    private int potionCost = 100;
    private int potionMultiplier = 50;
        
    private Display menu = new Display();
    private Commands command;
    
    private String name; 
    
    private String[] blacksmithMenu = new String[7];
      
    /**
     * Enchance an item.
     */
    public boolean enchance(Item item, int gold)
    {
               
        if(item.getName().toLowerCase().contains("sword"))
        {
            
            if(checkGold(gold, weaponCost) == true)
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                weaponCost += itemMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("armour"))
        {
            
            if(checkGold(gold, armourCost) == true)
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                armourCost += itemMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("potion"))
        {
            
            if(checkGold(gold, potionCost) == true)
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                potionCost += potionMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("amulet"))
        {
            
            if(checkGold(gold, amuletCost) == true)
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                amuletCost += itemMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("ring"))
        {
            
            if(checkGold(gold, ringCost) == true)
            {
                item.enchance();
                
                System.err.println(SUCCESS + item.getName());
                
                ringCost += specialMultiplier;
                
                return true;
            }
            
        }
        else if(item.getName().toLowerCase().contains("trinket"))
        {
            
            if(checkGold(gold, braceletCost) == true)
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
        if(gold >= cost)
        {
            return true;
        }
        else   
            return false;
    }
    
    public void createList()
    {
        blacksmithMenu[0] = command.ENCHANCE_WEAPON.getCommand()   + "\t\t\t" + weaponCost   + " Gold";
        blacksmithMenu[1] = command.ENCHANCE_ARMOUR.getCommand()   + "\t\t\t" + armourCost   + " Gold";
        blacksmithMenu[2] = command.ENCHANCE_POTION.getCommand()   + "\t\t\t" + potionCost   + " Gold";
        blacksmithMenu[3] = command.ENCHANCE_RING.getCommand()     + "\t\t\t" + ringCost     + "Gold";
        blacksmithMenu[4] = command.ENCHANCE_AMULET.getCommand()   + "\t\t\t" + amuletCost   + "Gold";
        blacksmithMenu[5] = command.ENCHANCE_BRACELET.getCommand() + "\t\t"   + braceletCost + "Gold\n";
        blacksmithMenu[6] = command.QUIT.getCommand();
        
    }
    
    public void openBlacksmithShop()
    {
        menu.listOptions(blacksmithMenu);
    }
    
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
