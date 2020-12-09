
/**
 * Write a description of class BlacksmithTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Blacksmith
{
    private int weaponCost = 5;
    private int armourCost = 5;
    private int amuletCost = 5;    
    private int potionCost = 100;
    
    private Menu menu = new Menu();
    private Commands command;
    
    private String name; 
    
    String[] list = new String[] 
        {
            command.ENCHANCE_WEAPON.getCommand() + "\t\t" + weaponCost + " Gold",
            command.ENCHANCE_ARMOUR.getCommand() + "\t\t" + armourCost + " Gold",
            command.ENCHANCE_POTION.getCommand() + "\t\t" + potionCost + " Gold",
            command.ENCHANCE_AMULET.getCommand() + "\t\t" + amuletCost + "Gold\n",
            command.QUIT.getCommand()
        };                                  
        
    
    public Blacksmith(String name)
    {
       this.name = name;
       
    }
    
    /**
     * Enchance an item.
     */
    public void enchance(Item item, int gold)
    {
        
        if(item.getName().toLowerCase().contains("sword"))
        {
            
            if(checkGold(gold, weaponCost) == true)
            {
                item.enchance();
                
                weaponCost += weaponCost;
            }
            
        }
        else if(item.getName().toLowerCase().contains("armour"))
        {
            
            if(checkGold(gold, armourCost) == true)
            {
                item.enchance();
                
                armourCost += weaponCost;
            }
            
        }
        else if(item.getName().toLowerCase().contains("potion"))
        {
            
            if(checkGold(gold, potionCost) == true)
            {
                item.enchance();
                
                potionCost += weaponCost;
            }
            
        }
        else if(item.getName().toLowerCase().contains("amulet"))
        {
            
            if(checkGold(gold, amuletCost) == true)
            {
                item.enchance();
                
                amuletCost += weaponCost;
            }
            
        }
        else
            System.out.println("\n\t\tNot an option");
    }
    
    /**
     * Check if the gold required exists in the user's account.
     */
    public boolean checkGold(int gold, int compare)
    {
        if(gold >= compare)
        {
            return true;
        }
        else   
            return false;
    }
    
    public void openBlacksmithShop()
    {
        menu.listOptions(list);
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
