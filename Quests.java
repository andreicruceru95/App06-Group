
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quests
{
    private String name;
    private String requirement;
    private String reward;
    private int amount;
    private boolean finished = false;
    private boolean started = false;
    
    public Quests(String name, String requirement, String reward, int amount)
    {
        this.name = name;
        this.requirement = requirement;
        this.reward = reward;
        this.amount = amount;
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getRequirement()
    {
        return requirement;
    }
    
    public String getReward()
    {
        return reward;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public boolean hasStarted()
    {
        return started;
    }
    
    public void start()
    {
        started = true;
    }
    
    public void finish()
    {
        finished = true;
    }
    
    public boolean isFinished()
    {
        return finished;
    }
    
}
