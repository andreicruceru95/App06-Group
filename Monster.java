
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
        
        attackForce = initialAttackForce * level;//(level * 2);
        shield = initialShield * level;//(level * 2);
        currentHealthPoints = currentHealthPoints * level;//(level * 2);
        maxHealthPoints = initialMaxHealthPoints * level;//(level * 2);
    }
    
}
