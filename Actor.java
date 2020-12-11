import java.util.Random;

/**
 * Write a description of class Actor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Actor
{
    protected String name;
    protected int level;
    protected int doubleHitChance = 0;
    protected int initialDoubleHitChance = 0;
    protected int evasionChance = 0;
    protected int initialEvasionChance = 0;
    protected int initialAttackForce = 100;
    protected int attackForce = 100;
    protected int initialShield = 70;
    protected int shield = 70;
    protected int initialMaxHealthPoints = 1000;
    protected int maxHealthPoints = 1000;
    protected int currentHealthPoints = 1000;
    
    private int chance = 5;//%
    private int total = 100; //%
    
    protected Random random = new Random();
    
    public Actor(String name, int level)
    {
        this.name = name;
        this.level = level;
        
    }
        
    /**
     * Send an attack.
     * @param value is the a random value.
     */
    protected int attack()
    {
              
        int minAttackForce = attackForce - (attackForce / chance);
        int maxAttackForce = attackForce + (attackForce / chance);
        
        int value = random.nextInt(maxAttackForce - minAttackForce) + minAttackForce;
        
        int hitChance = random.nextInt(total - 1) + 1;
            
        if(hitChance > 1 && hitChance <= doubleHitChance)
        {
            value += value;
        }
         
        return value;
    }
    
    /**
     * receive an attack.
     * @param value is the value we receive.
     * @return the value we received.
     */
    protected int receiveDmg(int value)
    {
        int received = random.nextInt(chance - 1) + 1;
        int hitChance = random.nextInt(total - 1) + 1;
        
        if (shield >= value)
        {
            currentHealthPoints -= received;
            
        }
        else if(hitChance >= 1 && hitChance <= evasionChance)
        {
            received = 0;
        }
        else 
        { 
            received = value - shield;
            
            currentHealthPoints -= (value - shield);
        }
        
        return received;   
    }
    
    /**
     * @return the attack value.
     */
    public int getAttackValue()
    {
        return attackForce;   
    }
    
    /**
     * @return the actor's stats.
     */
    public String getStats()
    {
        return "\t\tAttack: " + attackForce + "\n\tDeffence: " + shield;
                
    }
    
    public String getHealthInfo()
    {
        return "\t\tHealth: " + currentHealthPoints + " / " + maxHealthPoints;
    }
    
    /**
     * Check the health status.
     * @return false if monster died.
     * @return true if monster is still alive.
     */
    public boolean checkHealth()
    {
        if (currentHealthPoints <= 0)
        {
            return false;
        }
        else
            
            return true;
    }
    
    /**
     * @return health
     */
    public int getHealth()
    {
        return currentHealthPoints;
    }
    
    /**
     * @return level
     */
    public int getLevel()
    {
        return level;
        
    }
    
    /**
     * @return name
     */
    public String getName()
    {
        return name;
        
    }
}
