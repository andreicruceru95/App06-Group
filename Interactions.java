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
    
    public static final HashMap<String, String> INTERACTIONS = new HashMap<>();
    
    //private Characters character;
    
    public Interactions()
    {
        INTERACTIONS.put(Characters.SHOP.getCharacter(), "\t\tThis is where you can restock your health potion\n");
        INTERACTIONS.put(Characters.BLACKSMITH.getCharacter(),"\t\tThis is where you can upgrade your equipment to provide a better chance of survival\n" +
                                "\t\tAsk him \"enchance armour\" or \"enchance weapon\" or \"enchance potion\".");
        INTERACTIONS.put(Characters.STABLE.getCharacter(), "There is a stable there, you soon be able to buy a horse from there");
        INTERACTIONS.put(Characters.GUARD.getCharacter(), "Town guard: Ahh, young adventurer, while I was having a drink in the pub last night \n" +
                                "\t\tI overheard some shady characters talking about a teleporter somewhere in the north of the forest");
        INTERACTIONS.put(Characters.TELEPORT.getCharacter(), "This must have been what the guard was talking about, I need to make sure i'm ready before going through.");
        INTERACTIONS.put(DESSERT,  "\t\tYou see a corpse of a previous adventurer, maybe you should see if he had any notes");
        INTERACTIONS.put(SPIDER_CAVE, "\t\tA cave? You should be careful.. Who knows what monsters lives in here.");

        INTERACTIONS.put(Characters.CORPSE.getCharacter(), 
                "\t\tJurnal:" + 

                "\t\tI've made it this far, however I don't know how much further I can go on,"+
                "\t\tsomewhere south should be another teleporter but that leads into the spiders den." +
                "\t\tI think they're the ones that are keeping guard over the mythical stone." +
                "\t\tI pray that someone is able to carry on my quest and save humanity. To any unfortunate "+
                "\t\tadventurer that reads this,"+
                "\t\tI've stashed some health potions near the rocks west between the two trees"+
                "\t\tI wish you all the best and god speed");

        INTERACTIONS.put(Characters.BIOLOGIST.getCharacter(), 
               " Biologist:" +

                "\t\tI am developing new potions that will help you in battle"+
                "\t\tand I need someone to collect some herbs for me\t\tI need 10 of each species of flowers."+
                "\t\tBring them to me and you will be rewarded!");

        INTERACTIONS.put(Characters.PERSON_1.getCharacter(), 
                "Old Lady:"+

                "\t\tMy husband was one of the brave warriors that fought along with"+
                "\t\tthe Gods. You need to find his remains so I can bury him."+
                "\t\tI owe him that..");
    }
    
    public boolean getInteraction(String object)
    {
         System.out.println(INTERACTIONS.get(object));
         
         return true;
    }
}
