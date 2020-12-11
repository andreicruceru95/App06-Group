
/**
 * Write a description of class Monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
        
    public Monster(String name, int level)
    {
        super(name, level);
        
        attackForce = initialAttackForce * level;
        shield = initialShield * level;
        currentHealthPoints = currentHealthPoints * level;
        maxHealthPoints = initialMaxHealthPoints * level;
        
    }
    
}
