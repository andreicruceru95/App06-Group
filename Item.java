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
    private int atackForce;
    private int shield;
    private int heal;
    private int hitPoints;
    private int quantity;
    private int level = 1;
    

    /**
     * Initialising attributes.
     * @param id is the item's id.
     * @param name is the item name.
     * @param atk is the weapon atk.
     * @param def is the armour def.
     * @param heal is the potion restore health amount.
     * @param hp is the armour health bonus.
     * @param quantity is the item's qunatity.
     */
    public Item(int id,String name,int atackForce,int shield,int heal,int hitPoints,int quantity, int level)
    {
        this.id = id;
        this.name = name;
        this.heal = heal;
        this.quantity = quantity;
        this.level = level;
        this.atackForce = atackForce * level;
        this.shield = shield* level;
        this.hitPoints = hitPoints * level;
    }
    
    /**
     * See a weapon item.
     */
    public void seeWeapon()
    {
        System.out.println("\n    " + name + ":\n");
        System.out.println("Atk: " + atackForce);
    }
    
    /**
     * @return a weapon's attributes.
     */
    public String returnWeaponAttributes()
    {
        return "\n    Name +" + name + "\nAtack Force: " + atackForce;
    }
    
    /**
     * Enchance a weapon.
     * @return the new atackForce.
     */
    public int enchanceWeapon()
    {
        atackForce += 10;
        
        return atackForce;
    }
    
    /**
     * See an armour item.
     */
    public void seeArmour()
    {
        System.out.println("\n    " + getName() + ":\n");
        System.out.println("Def :" + shield);
        System.out.println("HP: "+ hitPoints);
    }
    
    /**
     * @return an armour attributes.
     */
    public String returnArmourAttributes()
    {
        return "\n    Name +" + name + getName() + "\nAtack Force: " + shield + "\nHit Points: " + hitPoints;
    }
    
    /**
     * Enchance an armour defense.
     * @return the new defense value;
     */
    public int enchanceArmourShield()
    {
        shield += 10;
        
        return shield;
    }
    
    /**
     * Enchance an armour hit points bonus.
     * @return the new hp value.
     */
    public int enchanceArmourHitPoints()
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
        System.out.println("Restore Hit Points: " + heal);
        System.out.println("Quantity: " + quantity);
    }
    
    /**
     * @return a potion attributes.
     */
    public String returnPotionAttributes()
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
     * @return the item's hit points.
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
    public int getAtackForce()
    {
        return atackForce;
    }
}
