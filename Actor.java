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
    protected int initialAttackForce = 100;
    protected int attackForce = 100;
    protected int initialShield = 70;
    protected int shield = 70;
    protected int initialMaxHealthPoints = 1000;
    protected int maxHealthPoints = 1000;
    protected int currentHealthPoints = 1000;
    
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
        int chance = 5;//%
        
        int minAttackForce = attackForce - (attackForce / chance);
        int maxAttackForce = attackForce + (attackForce / chance);
        
        int value = random.nextInt(maxAttackForce - minAttackForce) + minAttackForce;
         
        return value;
    }
    
    /**
     * receive an attack.
     * @param value is the value we receive.
     * @return the value we received.
     */
    protected int receiveDmg(int value)
    {
        int received = 0;
        
        if (shield >= value)
        {
            received = -1;
            currentHealthPoints -= 1;
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
        return "Attack: " + attackForce + "\n\tDeffence: " + shield +
                "\n\tHealth: " + currentHealthPoints + " / " + maxHealthPoints;
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
