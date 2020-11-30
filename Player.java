import java.util.*;

/**
 * A player for our game.
 * Each new player receives a basic armour, weapon and 5 health potions.
 * 
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Player
{
    private Random random;
    private Weapon weapon ;
    private Armour armour ;
    private Potion potion ;
    
    private int maxHitPoints = 0;
    private int currentHitPoints = 0;
    private int potionAmount = 15;
    
    private int attackForce = 0;
    private int shield = 0;
    
    private int goldAmount = 1000;
            
    private String name;
    private int score = 0;
    private int deathScore = 0;
    private int playerRowCoord = 6;
    private int playerColCoord = 6;
    /**
     * Add a name for the player.
     * @param name is the input name.
     */
    public Player(String name)
    {
        this.name = name;
        weapon = new Weapon();
        armour = new Armour();
        potion = new Potion();
        
        this.attackForce = weapon.getAttackValue();
        this.shield = armour.getArmourShield();
        this.maxHitPoints += armour.getArmourHItPoints();
        this.currentHitPoints += armour.getArmourHItPoints();
        
        random = new Random();
        goldAmount = 0;
                
    }
        
    /**
     * Verify that the curent Hp isn't bigger then max Hp.
     */
    private void verify()
    {
        if (currentHitPoints > maxHitPoints)
        {
            currentHitPoints = maxHitPoints;
        }
    }
    
    /**
     * add score to the player
     */
    public void addScore(int score)
    {
        this.score += score;
    }
        
    /**
     * @return the score.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Send an attack.
     * @param value is the a random value.
     */
    public int attack()
    {
        int chance = 5;//%
        
        int minAttackForce = attackForce - (attackForce - chance);
        int maxAttackForce = attackForce + (attackForce - chance);
        
        int value = random.nextInt(maxAttackForce - minAttackForce) + minAttackForce;
         
        return value;
    }
    
    /**
     * receive an attack.
     * @param value is the value we receive.
     * @return the value we received.
     */
    public int receiveDmg(int value)
    {
        int received = 0;
        
        if (shield >= value)
        {
            received = -1;
            currentHitPoints -= 1;
        }
        else
        { 
            received = value - shield;
            
            currentHitPoints -= (value - shield);
        }
        //System.out.println("player:" + received);
        return received;   
    }
    
    /**
     * Receieve gold.
     */
    public void addGold(int gold)
    {
        if(gold > 0)
        {
            System.err.println("\t\t\tReceived " + gold + "Gold");
        }
        
        this.goldAmount += gold;
        score ++;
    }
    
    /**
     * return the gold amount
     */
    public int getGold()
    {
        return goldAmount;
    }
    
    /**
     * Pay for enchantment.
     */
    public void pay(int cost)
    {
        goldAmount -= cost;
        
        updateStats();
    }
    
    /**
     * Update Player stats.
     */
    private void updateStats()
    {
        this.attackForce = weapon.getAttackValue();
        this.shield = armour.getArmourShield();
        this.maxHitPoints = armour.getArmourHItPoints();
        this.currentHitPoints = armour.getArmourHItPoints();
        
    }
        
    /**
     * Increase attack force.
     */
    public void increaseAttackForce(int value)
    {
        this.attackForce += value;
        
    }
    
    /**
     * Increase shield.
     */
    public void increaseShield(int value)
    {
        this.shield += value;
        
    }
    
    /**
     * Increase maximum hit points.
     */
    public void increaseHitPoints(int value)
    {
        this.maxHitPoints += value;
        
    }
    
    /**
     * increase potion amount
     */
    public void increasePotionAmount (int amount)
    {
        this.potionAmount += amount;
        
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
            return false;
        }
        else
            return true;
            
    }
        
    /**
     * @return the hit points
     */
    public int getHitPoints()
    {
        return currentHitPoints;
        
    }
    
    /**
     * set player's health to 100%
     */
    public void setFullHealth()
    {
        currentHitPoints = maxHitPoints;
        
    }
    
    /**
     * @return name
     */
    public String getName()
    {
        return name;
        
    }
    
    /**
     * return the player's attributes
     */
    public String getPlayerAttributes()
    {
        return "\n\tName: " + name + "\t Score: " + score + "\tGold: " + goldAmount +
                "\n\tAttack: " + attackForce + "\tDefense" + shield + "\tCurrent HP: " 
                + currentHitPoints + "/" + maxHitPoints + "\n\n";
    }
    
    /**
     * set player's coordinates
     */
    public void setCoordinates(int rowCoord, int colCoord)
    {
        this.playerRowCoord = rowCoord;
        this.playerColCoord = colCoord;
    }
    
    /**
     * @return player's row coordinates
     */
    public int getRowCoord()
    {
        return playerRowCoord;
    }
    
    /**
     * @return player's column coordinates
     */
    public int getColCoord()
    {
        return playerColCoord;
    }
    
    /**
     * Drink a health potion.
     */
    public void drinkPotion()
    {
        if(potionAmount > 0)
        {
            currentHitPoints += potion.getHeal();
            potionAmount --;
            verify();
        }
        else
            System.err.println("Not enough potions");
    }
    
    /**
     * @return items attributes
     */
    public String getItemsAttributes()
    {
        return weapon.getWeaponAttributes() + "\n" + armour.getArmourAttributes() + "\n" + potion.getName() + ":" + potion.getHeal() + " " + potionAmount;
    }
    
    /**
     * @return weapon
     */
    public Weapon getWeapon()
    {
        return weapon;
    }
    
    /**
     * @return armour
     */
    public Armour getArmour()
    {
        return armour;
    }
    
    /**
     * @return potion
     */
    public Potion getPotion()
    {
        return potion;
    }
}
