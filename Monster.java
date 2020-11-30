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
    
    private int atackForce = 10;
    private int shield = 12;
    private int currentHp = 25;
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
        this.atackForce *= level;
        this.shield *= level;
        this.currentHp *= level;
    }
    
    /**
     * Send an atack.
     * @param value is the a random value.
     */
    public int atack()
    {
        int minAtackForce = atackForce - 3;
        int maxAtackForce = atackForce + 3;
        
        int value = random.nextInt(maxAtackForce) + minAtackForce;
         
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
            currentHp -= 1;
        }
        else
        { 
            recieved = value - shield;
            currentHp -= (value - shield);
        }
        
        return recieved;   
    }
    
    /**
     * Check the health status.
     * @return false if monster died.
     * @return true if monster is still alive.
     */
    public boolean checkHealth()
    {
        if (currentHp <= 0)
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
        return currentHp;
    }
    
    /**
     * @return level
     */
    public int getLevel()
    {
        return level;
    }
}
