
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quest
{
    private final String name;
    private final String requirement;
    private final int requirementAmount;
    private final String reward;
    private final int amount;
    private boolean finished = false;
    private boolean started = false;
    
    public Quest(String name, String requirement, int requirementAmount, String reward, int amount)
    {
        this.name = name;
        this.requirement = requirement;
        this.requirementAmount = requirementAmount;
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
    
    public int getRequirementAmount()
    {
        return requirementAmount;
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
    
    public String print()
    {
        return "\t" + name + "\n\t" + requirement + "\n\t" + "Reward:\t" + amount + " " + reward;
    }
    
}
