import java.util.Random;

/**
 * A blue print for a monster atagonist.
 *
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Monster
{
    private final static int MIN_HEALTH = 0;
    
    private Random random;
    
    private int attackForce = 15;
    private int shield = 6;
    private int currentHitPoints = 40;
    private int level;
          
    private String name;
       
    /**
     * Add a name and a level for the monster.
     * @param name is the input name.
     * @param level is the input level.
     */
    public Monster(String name, int level)
    {
        random = new Random();
        this.name = name;
        this.level = level;
        this.attackForce *= level;
        this.shield *= level;
        this.currentHitPoints *= level;
    }
    
    /**
     * Send an atack.
     * @param value is the a random value.
     */
    public int attack()
    {
        int minAttackForce = attackForce - 3;
        int maxAttackForce = attackForce + 3;
        
        int value = random.nextInt(maxAttackForce - minAttackForce) + minAttackForce;
         
        return value;
    }
    
    /**
     * Recieve an atack.
     * @param value is the value we recieve.
     * @return the value we recieved.
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
        //System.out.println("monster:" + received);
        return received;   
    }
    
    /**
     * Check the health status.
     * @return false if monster died.
     * @return true if monster is still alive.
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
     * @return health
     */
    public int getHealth()
    {
        return currentHitPoints;
    }
    
    /**
     * @return level
     */
    public int getLevel()
    {
        return level;
    }
}
