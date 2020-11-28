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
    private int currentHitPoints = 25;
    private int level;
          
    private String name;
       
    /**
     * Add a name and a level for the monster.
     * @param name is the input name.
     * @param lvl is the input lvl.
     */
    public Monster(String name, int level)
    {
        random = new Random();
        this.name = name;
        this.level = level;
        this.atackForce *= level;
        this.shield *= level;
        this.currentHitPoints *= level;
    }
    
    /**
     * Send an atack.
     * @param value is the a random value.
     */
    public int atack()
    {
        int minAtk = atackForce - 3;
        int maxAtk = atackForce + 3;
        
        int value = random.nextInt(maxAtk) + minAtk;
         
        return value;
    }
    
    /**
     * Recieve an atack.
     * @param value is the value we recieve.
     * @return the value we recieved.
     */
    public int recieveDamage(int value)
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
     * @return false if monster died.
     * @return true if monster is still alive.
     */
    public boolean checkHealth()
    {
        if (currentHitPoints <= 0)
        {
            System.out.println("\t\t\t\tYou Win!");
            return false;
        }
        else
            
            return true;
    }
    
    /**
     * @return monster's hit points.
     */
    public int getHealth()
    {
        return currentHitPoints;
    }
    
    /**
     * @return monster's level.
     */
    public int getLevel()
    {
        return level;
    }
}
