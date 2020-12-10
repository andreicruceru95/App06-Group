import java.util.*;

/**
 * Write a description of class Interactions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Interactions
{
    public static final String DESSERT = "dessert";
    public static final String SPIDER_CAVE = "spidercave";
    
    private HashMap<String, String> interactions = new HashMap<>();
    
    private Characters character;
    
    public Interactions()
    {
        interactions.put(character.SHOP.getCharacter(), "There is a shop there, you can buy health potions and other things from there");
        interactions.put(character.BLACKSMITH.getCharacter(),"There is a blacksmith there, you can ask him to improve your items for a price.\n" +
                                "Ask him \"enchance armour\" or \"enchance weapon\" or \"enchance potion\".");
        interactions.put(character.STABLE.getCharacter(), "There is a stable there, you soon be able to buy a horse from there");
        interactions.put(character.GUARD.getCharacter(), "Town guard: \t\tHey, You! \n\t\tCome here. \n\tAre you that warrior " + 
                                "everyone is talking about?\n\tIf you are that brave, why don't you go" + 
                                "and kill some wolves for us?\n\tThey have been killing our people for a while.\n");
        interactions.put(character.TELEPORT.getCharacter(), "There is a teleporter there, you can go to a different map.");    
        interactions.put(DESSERT, "This was once a beautifull forrest. Now it's a dangerous death field. Be aware!");
        interactions.put(SPIDER_CAVE, "A cave? You should be carefull.. Who knows what monsters lives in here.");
    }
    
    public boolean getInteraction(String object)
    {
         System.err.println(interactions.get(object));
         
         return true;
    }
}
