
/**
 * Write a description of class BlacksmithTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Blacksmith
{
    public static final String SUCCESS = "\t\tYou have successfully enchanted: ";
    private int weaponCost = 5;
    private int armourCost = 5;
    private int amuletCost = 5;

    private int ringCost = 15;
    private int braceletCost = 15;

    private int potionCost = 100;

    private final Display menu = new Display();

    private final String[] blacksmithMenu = new String[7];



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
        else if(item.getName().toLowerCase().contains("amulet"))
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
    
    public void createList(boolean ringExists, boolean braceletExists)
    {
        blacksmithMenu[0] = Commands.ENCHANCE_WEAPON.getCommand()   + "\t\t\t" + weaponCost   + " Gold";
        blacksmithMenu[1] = Commands.ENCHANCE_ARMOUR.getCommand()   + "\t\t\t" + armourCost   + " Gold";
        blacksmithMenu[2] = Commands.ENCHANCE_POTION.getCommand()   + "\t\t\t" + potionCost   + " Gold";
        blacksmithMenu[3] = Commands.ENCHANCE_AMULET.getCommand()   + "\t\t\t" + amuletCost   + "Gold";
        
        if(ringExists)
            blacksmithMenu[4] = Commands.ENCHANCE_RING.getCommand()     + "\t\t\t" + ringCost     + "Gold";
        else
            blacksmithMenu[4] = " ";
             
        if(braceletExists)
            blacksmithMenu[5] = Commands.ENCHANCE_BRACELET.getCommand() + "\t\t"   + braceletCost + "Gold";
        else
            blacksmithMenu[5] = " ";
            
        blacksmithMenu[6] = "\n\n" + Commands.QUIT.getCommand();
        
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
