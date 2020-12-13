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
        interactions.put(character.SHOP.getCharacter(), "\t\tThis is where you can restock your health potion\n");
        interactions.put(character.BLACKSMITH.getCharacter(),"\t\tThis is where you can upgrade your equipment to provide a better chance of survival\n" +
                                "\t\tAsk him \"enchance armour\" or \"enchance weapon\" or \"enchance potion\".");
        interactions.put(character.STABLE.getCharacter(), "There is a stable there, you soon be able to buy a horse from there");
        interactions.put(character.GUARD.getCharacter(), "Town guard: Ahh, young adventurer, while I was having a drink in the pub last night \n" +
                                "\t\tI overheard some shady characters talking about a teleporter somewhere in the north of the forest");
        interactions.put(character.TELEPORT.getCharacter(), "This must have been what the guard was talking about, I need to make sure i'm ready before going through.");    
        interactions.put(DESSERT,  "\t\tYou see a corpse of a previous adventurer, maybe you should see if he had any notes");
        interactions.put(SPIDER_CAVE, "\t\tA cave? You should be carefull.. Who knows what monsters lives in here.");
        
        interactions.put(character.CORPSE.getCharacter(), "\t\tJurnal: \n\n" +
                        "\t\tI've made it this far, however I don't know how much further I can go on,\n" +
                        "\t\tsomewhere south should be another teleporter but that leads into the spiders den.\n" +
                        "\t\tI think they're the ones that are keeping guard over the mythical stone.\n" +
                        "\t\tI pray that someone is able to carry on my quest and save humanity. To any unfortunate adventurer that reads this,\n" +
                        "\t\tI've stashed some health potions near the rocks west between the two trees\n" +
                        "\t\tI wish you all the best and god speed");
                        
        interactions.put(character.BIOLOGIST.getCharacter(), "Biologist: \n\n" +
                        "\t\tI am developing new potions that will help you in battle\n" +
                        "\t\tand I need someone to collect some herbs for me" +
                        "\t\tI need 10 of each species of flowers. \n" +
                        "\t\tBring them to me and you will be rewarded!");
           
        interactions.put(character.PERSON_1.getCharacter(), "Old Lady: \n\n" +
                        "\t\tMy husband was one of the brave warriors that fought along with \n" +
                        "\t\tthe Gods. You need to find his remains so I can burry him. \n" +
                        "\t\tI owe him that..");
    }
    
    public boolean getInteraction(String object)
    {
         System.out.println(interactions.get(object));
         
         return true;
    }
}
