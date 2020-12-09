
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private static final VisualField VISUAL_FIELD = new VisualField();
    
    private Characters character;
    
    public static final Item SWORD = new Weapon("Steel Sword", 20, 1, 12);
    public static final Item ARMOUR = new Armour("Steel Armour", 10, 1, 8);
    public static final Item POTION = new Potion("HP Potion", 200, 1, 200);
    public static final Item AMULET = new Amulet("Hellen's Gift", 50, 1, 100);
    
    private int potionAmount = 15;
    private int goldAmount = 1000;
    private int score = 0;
       
    private int playerRowCoord = 6;
    private int playerColCoord = 6;
    
    /**
     * Constructor for player class.
     */
    public Player(String name, int level)
    {
        super(name, level);
        
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
        
        update();
    }
    
    /**
     * Increase attack force.
     */
    public void increaseAttackForce(int value)
    {
        this.attackForce += value;
        
    }
    
    /**
     * set player's health to 100%
     */
    public void setFullHealth()
    {
        currentHealthPoints = maxHealthPoints;
        
    }
    
    /**
     * @return the hit points
     */
    public int getHitPoints()
    {
        return currentHealthPoints;
        
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
    public void increaseHealthPoints(int value)
    {
        this.maxHealthPoints += value;
        
    }
    
    /**
     * increase potion amount
     */
    public void increasePotionAmount (int amount)
    {
        this.potionAmount += amount;
        
    }
    
    /**
     * add score to the player
     */
    public void addScore(int score)
    {
        this.score += score;
    }
    
    /**
     * @return score.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * update the visual field.
     */
    public void updateVisualField(String[][] map)
    {
        VISUAL_FIELD.setVisualField(map, playerRowCoord, playerColCoord);
        
    }
    
    /**
     * Update the player's stats.
     */
    public void update()
    {
        attackForce = initialAttackForce + SWORD.getStats();
        shield = initialShield + ARMOUR.getStats();
        maxHealthPoints = initialMaxHealthPoints + AMULET.getStats();
        currentHealthPoints += AMULET.getStats();
        
        check();
    }
    
    /**
     * Keep the current health points lower or equal then maximum.
     */
    public void check()
    {
        if(maxHealthPoints < currentHealthPoints)
        {
            currentHealthPoints = maxHealthPoints;
        }
        
    }
    
    public Item getWeapon()
    {
        return SWORD;
    }
    
    public Item getArmour()
    {
        return ARMOUR;
    }
    
    public Item getPotion()
    {
        return POTION;
    }
    
    public Item getAmulet()
    {
        return AMULET;
    }
    
    /**
     * set player's coordinates
     */
    public void setCoordinates(int playerRowCoord, int playerColCoord)
    {
        this.playerRowCoord = playerRowCoord;
        this.playerColCoord = playerColCoord;
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
            currentHealthPoints += POTION.getStats();
            potionAmount --;
            check();
        }
        else
            System.err.println("Not enough potions");
            
        if(currentHealthPoints > maxHealthPoints)
            changeImage(character.PLAYER2.toString());
    }
    
    /**
     * Check the visual field for an object
     */
    public boolean checkVisualField(String object)
    {
        return VISUAL_FIELD.checkVisualField(object);
        
    }
    
    /**
     * Change the player's image.
     */
    public void changeImage(String image)
    {
        VISUAL_FIELD.changeImage(image);
        
    }
    
    /**
     * @return current health.
     */
    public int getCurrentHealth()
    {
        return currentHealthPoints;
        
    }
    
    /**
     * @return full health.
     */
    public int getFullHealth()
    {
        return maxHealthPoints;
        
    }
}
