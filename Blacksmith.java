
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
    public Item weapon;
    public Item armour;
    public Item potion;
    public Item amulet;
    public Item ring;
    public Item bracelet;
    private boolean message = false;
    private boolean success = false;
    
    /**
     * add items
     */
    public void addItems(Item weapon, Item armour, Item potion, Item amulet, Item ring, Item bracelet)
    {
        this.weapon = weapon;
        this.armour = armour;
        this.potion = potion;
        this.amulet = amulet;
        this.ring = ring;
        this.bracelet = bracelet;
    }
    
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
                if(checkGold(gold, weapon.getGoldRequired()))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                                        
                    return true;
                }
                
            case ARMOUR:
                if(checkGold(gold, armour.getGoldRequired()))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    return true;
                }
                
            case POTION:
                if(checkGold(gold, potion.getGoldRequired()))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
    
                    return true;
                }
                
            case AMULET:
                if(checkGold(gold, amulet.getGoldRequired()))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    return true;
                }
                
            
            case RING:
                if(checkGold(gold, ring.getGoldRequired()))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
                    return true;
                }
                
            case BRACELET:
                if(checkGold(gold, bracelet.getGoldRequired()))
                {
                    item.enchance();
                    
                    System.err.println(SUCCESS + item.getName());
                    
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
    public void createList(int goldAmount)
    {
        BLACKSMITH_MENU[0] = Commands.ENCHANCE_WEAPON.getCommand()   + "\t\t\t" + weapon.getGoldRequired()   + " Gold" +
                             "\n\t\tAttack : +" + weapon.getStats() + "\t=> +" + weapon.getNextStats() + "\n";
        BLACKSMITH_MENU[1] = Commands.ENCHANCE_ARMOUR.getCommand()   + "\t\t\t" + armour.getGoldRequired()   + " Gold" +
                            "\n\t\tDeffence: +" + armour.getStats() + "\t=> +" + armour.getNextStats() + "\n";
        BLACKSMITH_MENU[2] = Commands.ENCHANCE_POTION.getCommand()   + "\t\t\t" + potion.getGoldRequired()   + " Gold" +
                            "\n\t\tRecover: +" + potion.getStats() + "\t=> +" + potion.getNextStats() + "\n";
        BLACKSMITH_MENU[3] = Commands.ENCHANCE_AMULET.getCommand()   + "\t\t\t" + amulet.getGoldRequired()   + "Gold" + 
                            "\n\t\tHealth: +" + amulet.getStats() + "\t=> +" + amulet.getNextStats() + "\n";
        
        if(ring.checkVisibility())
            BLACKSMITH_MENU[4] = Commands.ENCHANCE_RING.getCommand()     + "\t\t\t" + ring.getGoldRequired() + "Gold" +
                                "\n\t\tDouble Hit:+" + ring.getStats() + "%" + "\t=> +" + ring.getNextStats() + "%\n";
             
        if(bracelet.checkVisibility())
            BLACKSMITH_MENU[5] = Commands.ENCHANCE_BRACELET.getCommand() + "\t\t"   + bracelet.getGoldRequired() + "Gold" +
                                "\n\t\tDodge:+" + bracelet.getStats() + "%" + "\t=> +" + bracelet.getNextStats() + "%\n";
            
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
    
}
