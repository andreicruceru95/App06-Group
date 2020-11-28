/**
 * The attributes of our items.
 *
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Item
{
    //The item attributes
    private int id;
    private String name;
    private int atack;
    private int shield;
    private int heal;
    private int hitPoints;
    private int quantity;
    private int level = 1;
    

    /**
     * Initialising attributes.
     * @param id is the item's id.
     * @param name is the item name.
     * @param atack is the weapon atack.
     * @param shield is the armour shield.
     * @param heal is the potion restore health amount.
     * @param hitPoints is the armour health bonus.
     * @param quantity is the item's qunatity.
     */
    public Item(int id,String name,int atack,int shield,int heal,int hitPoints,int quantity, int level)
    {
        this.id = id;
        this.name = name;
        this.heal = heal;
        this.quantity = quantity;
        this.level = level;
        this.atack = atack * level;
        this.shield = shield* level;
        this.hitPoints = hitPoints * level;
    }
    
    /**
     * See a weapon item.
     */
    public void seeWeapon()
    {
        System.out.println("\n    " + name + ":\n");
        System.out.println("atack: " + atack);
    }
    
    /**
     * @return a weapon's attributes.
     */
    public String returnWeaponAttr()
    {
        return "\n    Name +" + name + "\natack: " + atack;
    }
    
    /**
     * Enchance a weapon.
     * @return the new atack.
     */
    public int enchanceWeapon()
    {
        atack += 10;
        
        return atack;
    }
    
    /**
     * See an armour item.
     */
    public void seeArmour()
    {
        System.out.println("\n    " + getName() + ":\n");
        System.out.println("shield :" + shield);
        System.out.println("hitPoints: "+ hitPoints);
    }
    
    /**
     * @return an armour attributes.
     */
    public String returnArmourAttr()
    {
        return "\n    Name +" + name + getName() + "\natack: " + shield + "\nhitPoints: " + hitPoints;
    }
    
    /**
     * Enchance an armour shieldense.
     * @return the new shieldense value;
     */
    public int enchanceArmourshield()
    {
        shield += 10;
        
        return shield;
    }
    
    /**
     * Enchance an armour hit points bonus.
     * @return the new hitPoints value.
     */
    public int enchanceArmourhitPoints()
    {
        hitPoints += 10;
        
        return hitPoints ;
    }
    
    /**
     * See a potion item.
     */
    public void seePotion()
    {
        System.out.println("\n    " + getName() + ":\n");
        System.out.println("Restore hitPoints: " + heal);
        System.out.println("Quantity: " + quantity);
    }
    
    /**
     * @return a potion attributes.
     */
    public String returnPotionAttr()
    {
        return "\n    Name +" + getName() + "\nHeal: " + heal + "\n" + quantity;
    }
    
    /**
     * @return the item's id.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * @return the item's name.
     */
    public String getName()
    {
        return name + " " + level;
    }
    
    /**
     * @return the item's shield.
     */
    public int getShield()
    {
        return shield;
    }
    
    /**
     * @return the item's hitPoints.
     */
    public int getHitPoints()
    {
        return hitPoints;
    }
    
    /**
     * @return the heal value of an item.
     */
    public int getHeal()
    {
        return heal;
    }
    
    /**
     * @return the quantity of an item.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * @return an item's atack value.
     */
    public int getAtack()
    {
        return atack;
    }
}
