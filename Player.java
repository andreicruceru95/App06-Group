import java.util.*;

/**
 * A player for our game.
 * Each new player recieves a basic armour, weapon and 5 health potions.
 * 
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Player
{
    private final static int MIN_HEALTH = 0;
    
    private int atackForce = 15;
    private int shield = 0;
    private int maxHitPoints = 100;
    private int currentHitPoints = 100;
    
    private Random random;
        
    private ArrayList<Item> inventory;
    private ArrayList<Item> equipment;
       
    private String name;
    private int score = 0;
    private int playerRowCoord = 5;
    private int playerColCoord = 5;
    /**
     * Add a name for the player.
     * @param name is the input name.
     */
    public Player(String name)
    {
        this.name = name;
        random = new Random();
        
        inventory = new ArrayList<Item>();
        equipment = new ArrayList<Item>();
        
        inventory.add(new Item(10,"Steel Sword ", 5, 0,0,0,0,1));
        inventory.add(new Item(20,"Steel Armour", 0, 10,0,10,0,1));        
        inventory.add(new Item(30,"HP Potion", 100, 0,0,0,5,1));
        equip("Steel Sword");
        equip("Steel Armour");
    }
        
    /**
     * Print a list of items.
     * @param list is the given list.
     */
    private void seeItems(ArrayList<Item> list)
    {
        for (Item item : list)
        {
            System.out.println("\n" + item.getName());
        }
    }
    
    /**
     * Print inventory.
     */
    public void printInventory()
    {
        seeItems(inventory);
    }
    
    /**
     * Print the equiped items.
     */
    public void printEquiped()
    {
        if (equipment.size() > 0)
        {
            seeItems(equipment);
        }
        else    
            System.out.println("\n    Nothing equipped");
    }
    
    /**
     * See an item.
     * @param name is the input name of the item we want to see.
     */
    public void seeItem(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {
            int id = item.getID();
            
            if(id < 20)
            {
                item.seeWeapon();
                
            }
            else if(id < 30)
            {
                item.seeArmour();
                
            }
            else if(id == 30)
            {
                item.seePotion();
                
            }
            else
                System.out.println("error");
        }
        else
            System.out.println("Don't be ridiculous..");
    }
    
    /**
     * Equip an item.
     * @param name is th input name of the item we want to equip.
     */
    public void equip(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {
            if (item.getID() == 30)
            {
                currentHitPoints += item.getHeal();
                verify(currentHitPoints);
            }
            else
                swapEquipment(item);
        }  
        else
            System.out.println("Don't be ridiculous..");
    }
    
    /**
     * Verify that the curent Hp isn't bigger then max Hp.
     */
    private void verify(int hitPoints)
    {
        if (hitPoints > maxHitPoints)
        {
            currentHitPoints = maxHitPoints;
        }
    }
    
    /**
     * Equip an item in a item slot.
    */
    private void swapEquipment(Item item)
    {
        if (item.getID() < 20)
        {
            equipment.add(item);            
                        
            atackForce = item.getAtack();
        }
        else if(item.getID() < 30)
        {
            equipment.add(item);
                     
            maxHitPoints += item.getHitPoints();
            shield = item.getShield(); 
        }
        else
            System.out.println("Error");
                
    }
    
    /**
     * Discard an item.
     * @param name is the input name of the item we want to discard.
     */
    public void discard(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {
            int id = item.getID();
            
            if(id < 20)
            {
                atackForce -= item.getAtack();
            }
            else if(id < 30)
            {
                shield -= item.getShield();
                maxHitPoints -= item.getHitPoints();
            }
            else
                System.out.println("error");
        }
        else
            System.out.println("Don't be ridiculous..");
    }
    
    /**
     * Find an item in the inventory.
     * @param name is the name of the item we are looking for.
     */
    private Item findItem(String name)
    {
        for (Item item : inventory)
        {
            if (item.getName().contains((name)))
            {
                return item;
            }
        }
        
        return null;
    }
    
    /**
     * Pick an item.
     * @param name is the name of the item we want to pick.
     */
    public void pickItem(Item item)
    {
        inventory.add(item);
        
        score += 10;
    }
    
    /**
     * Distroy an item from the inventory.
     * @param name is the name of the item we want to destroy.
     */
    public void throwItem(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {   
            inventory.remove(item);
        }
        else
            System.out.println("error");
    }
    
    /**
     * @return the score.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Send an atack.
     * @param value is the a random value.
     */
    public int atack()
    {
        int minatackForce = atackForce - 3;
        int maxatackForce = atackForce + 3;
        
        int value = random.nextInt(maxatackForce) + minatackForce;
         
        return value;
    }
    
    /**
     * Recieve an atack.
     * @param value is the value we recieve.
     * @return the value we recieved.
     */
    public int recieveDmg(int value)
    {
        int recieved = 0;
        
        if (shield >= value)
        {
            recieved = -1;
            currentHitPoints -= 1;
        }
        else
        { 
            recieved = value - shield;
            currentHitPoints -= (value - shield);
        }
        
        return recieved;   
    }
    
    /**
     * Check the health status.
     * @return false if player died.
     * @return true if player is still alive.
     */
    public boolean checkHealth()
    {
        if (currentHitPoints <= 0)
        {
            System.out.println("\t\t\t\tYou Lost!");
            
            return false;
        }
        else
            return true;
    }
    
    public int getHitPoints()
    {
        return currentHitPoints;
    }
    
    public void getPlayerAttributes()
    {
        System.out.println("\nName: " + name);
        System.out.println("Score: " + score);
        System.out.println("Attack: " + atackForce);
        System.out.println("Defense" + shield);
        System.out.println("Current HP: " + currentHitPoints + "/" + maxHitPoints);
    }
    
    /**
     * 
     */
    public void setCoordinates(int rowCoord, int colCoord)
    {
        this.playerRowCoord = rowCoord;
        this.playerColCoord = colCoord;
    }
    
    public int getRowCoord()
    {
        return playerRowCoord;
    }
    
    public int getColCoord()
    {
        return playerColCoord;
    }
    
}
