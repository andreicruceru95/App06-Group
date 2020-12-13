import java.util.*;

/**
 * Write a description of class Quests here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quests
{
    public static final HashMap<String,Quest> QUESTS = new HashMap<>();
    //public static final HashMap<String,Quest> ACTIVE_QUESTS = new HashMap<>();
    
    //private Characters character;
    
    public Quests()
    {
        QUESTS.put("Main[1][1]", new Quest("Main", "Speak to the shop owner",1,Characters.GOLD.getCharacter(), 50));
        QUESTS.put("biologist1", new Quest("Main", "Collect 10 Red Flowers (" + Characters.FLOWER_RED.getCharacter() + ")",10,
                Characters.GOLD.getCharacter(), 100));
        QUESTS.put("biologist2", new Quest("Main", "Collect 10 Blue Flowers (" + Characters.FLOWER_BLUE.getCharacter() + ")",10,
                Characters.GOLD.getCharacter(), 200));
        QUESTS.put("biologist3", new Quest("Main", "Collect 10 Yellow Flowers (" + Characters.FLOWER_YELLOW.getCharacter() + ")",10,
                Characters.GOLD.getCharacter(), 300));
        QUESTS.put("biologist4", new Quest("Main", "Collect 10 Purple Flowers (" + Characters.FLOWER_PURPLE.getCharacter() + ")",10,
                Characters.GOLD.getCharacter(), 400));
        QUESTS.put("biologist5", new Quest("Main", "Collect 10 White Flowers (" + Characters.FLOWER_WHITE.getCharacter() + ")",10,
                Characters.GOLD.getCharacter(), 100));
                                
        QUESTS.put("Main[1][2]", new Quest("Main", "Find missing husband in the forest (" + Characters.CORPSE.getCharacter() + ")",10,
                Characters.GOLD.getCharacter(), 100));
                                
    }
    
    public void printQuestList()
    {
        int count = 0;    
        
        for (String object : QUESTS.keySet())
        {
            //String key = object.toString();
            Quest quest = QUESTS.get(object);  
            
            if(quest.hasStarted())
            {
                System.out.println("\t\t\t\n\nActive Quests:");
                
                System.out.println(quest.print());   
                
                count ++;
            }
            
        }
        
        if (count == 0)
            System.out.println("You have no active quests");
    }
    
    public void startQuest(String string)
    {
        Quest quest = QUESTS.get(string);
        
        quest.start();
    }
    
    private void finishQuest(Quest quest)
    {
        //Quest quest = QUESTS.get(string);
        
        quest.finish();
    }
    
    public boolean checkQuestStatus(String string)
    {
        Quest quest = QUESTS.get(string);
        
        return quest.isFinished();
    }
    
    public int getRewardAmount(String string)
    {
        Quest quest = QUESTS.get(string);
        
        finishQuest(quest);
        
        return quest.getAmount();
    }
    
    public int getRequirementAmount(String string)
    {
        Quest quest = QUESTS.get(string);
        
        return quest.getRequirementAmount();
    }
    
    public String getRequirement(String string)
    {
        Quest quest = QUESTS.get(string);
        
        return quest.getRequirement();
    }
}
