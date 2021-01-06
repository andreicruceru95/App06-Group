import java.util.*;

/**
 * This class contains the dialogs of the game characters.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Interactions
{
    public static final String DESSERT = "dessert";
    public static final String SPIDER_CAVE = "spidercave";
    
    public static final HashMap<String, String> INTERACTIONS = new HashMap<>();
        
    /**
     * Constructor method.
     * Adding the interactions to a hash map.
     */
    public Interactions()
    {
        INTERACTIONS.put(Characters.SHOP.getCharacter(), "\t\tThis is where you can restock your health potion\n");
        
        INTERACTIONS.put(Characters.BLACKSMITH.getCharacter(),"\t\tThis is where you can upgrade your equipment to provide a better chance of survival\n" +
                                "\t\tAsk him \"enchance armour\" or \"enchance weapon\" or \"enchance potion\".");
                                
        INTERACTIONS.put(Characters.STABLE.getCharacter(), "\t\tThere is a stable there, you soon be able to buy a horse from there");
        
        INTERACTIONS.put(Characters.GUARD.getCharacter(), "\t\tTown guard:\n\n \t\tAhh, young adventurer, while I was having a drink in the pub last night \n" +
                                "\t\tI overheard some shady characters talking about a teleporter somewhere in the north of the forest");
                                
        INTERACTIONS.put(Characters.TELEPORT.getCharacter(), "\t\tThis must have been what the guard was talking about, I need to make sure i'm ready before going through.");    
        
        INTERACTIONS.put(DESSERT,  "\t\tYou see a corpse of a previous adventurer, maybe you should see if he had any notes");
        
        INTERACTIONS.put(SPIDER_CAVE, "\t\tA cave? You should be carefull.. Who knows what monsters lives in here.");
        
        INTERACTIONS.put(Characters.CORPSE.getCharacter(), "\n\t\tJurnal: \n\n" +
                        "\t\tI've made it this far, however I don't know how much further I can go on,\n" +
                        "\t\tsomewhere south should be another teleporter but that leads into the spiders den.\n" +
                        "\t\tI think they're the ones that are keeping guard over the mythical stone.\n" +
                        "\t\tI pray that someone is able to carry on my quest and save humanity. To any unfortunate adventurer that reads this,\n" +
                        "\t\tI've stashed some health potions near the rocks west between the two trees\n" +
                        "\t\tI wish you all the best and god speed");
                        
        INTERACTIONS.put(Characters.BIOLOGIST.getCharacter(), "\n\t\tBiologist: \n\n" +
                        "\t\tI am developing new potions that will help you in battle\n" +
                        "\t\tand I need someone to collect some herbs for me.\n" +
                        "\t\tI need 10 of each species of flowers, " +
                        "bring them to me and you will be rewarded!");
                        
        INTERACTIONS.put(Characters.BIOLOGIST_2.getCharacter(), "\n\t\tBiologist: \n\n" +
                        "\t\tYou brought me the flowers?\n" +
                        "\t\tBriliant! \n" +
                        "\t\tI will pay you 10$ for each flower.\n" +
                        "\t\tBring me more and you will be rewarded!");
           
        INTERACTIONS.put(Characters.PERSON_3.getCharacter(), "\n\t\tOld Lady: \n\n" +
                        "\t\tMy husband was one of the brave warriors that fought along with \n" +
                        "\t\tthe Gods. You need to find his remains so I can burry him. \n" +
                        "\t\tI owe him that..");
        
        INTERACTIONS.put(Characters.PERSON_4.getCharacter(), "\n\t\tOld Lady: \n\n" +
                        "\t\tThank you, kind stranger.\n" +
                        "\t\tHere, I found this in my husband remains. \n" +
                        "\t\tA ring that will bring you luck");
                        
        INTERACTIONS.put(Characters.PERSON_5.getCharacter(), "\n\t\tJeweler: \n\n" +
                        "\t\tI am making some jewelery, and I need some more items. \n" +
                        "\t\tBring me 10 star fragments and I will reward you.\n" +
                        "\t\tGo now.");   
        INTERACTIONS.put(Characters.PERSON_6.getCharacter(), "\n\t\tJeweler: \n\n" +
                        "\t\tThank you, stranger.\n" +
                        "\t\tI will give you one of my finest pieces, a bracelet \n" +
                        "\t\tmade out of the finest materials."); 
                        
        INTERACTIONS.put(Characters.PERSON_7.getCharacter(), "\n\t\tFarmer: \n\n" +
                        "\t\tYesterday, a pack of wolves destroyed my farm.\n" +
                        "\t\tKill 50 creatures for me, and I will reward you.\n" +
                        "\t\tGo now."); 
                       
        INTERACTIONS.put(Characters.PERSON_8.getCharacter(), "\n\t\tFarmer: \n\n" +
                        "\t\tThank you, warrior.\n" +
                        "\t\tI don't kave a lot left to give you, but here.\n\n" +
                        "\t\tYou receive 500$."); 
                        
        INTERACTIONS.put(Characters.PERSON_9.getCharacter(), "\n\t\tDrunk Person: \n\n" +
                        "\t\tI used to be an adventurer like you..\n" +
                        "\t\tbut one day i took an arrow to my knee and my strength died wit it.\n" +
                        "\t\tTake this stone. It's unique material will allow you to\n" +
                        "\t\tfast travel between locations you discovered.\n" +
                        "\t\tThank me later.");   
        
        INTERACTIONS.put(Characters.PERSON_10.getCharacter(), "\n\t\tSoldier: \n\n" +
                        "\t\tYou need to hurry up and bring the Mythical Stone back.\n" +
                        "\t\tWe don't have much time.\n" +
                        "\t\tGo!");  
                        
        INTERACTIONS.put(Characters.PERSON_11.getCharacter(), "\n\t\tSoldier: \n\n" +
                        "\t\tSomeone reported to have seen a dragon flying in the dessert.\n" +
                        "\t\tYou should investigate that.\n" ); 
                        
        INTERACTIONS.put(Characters.PERSON_12.getCharacter(), "\n\t\tSoldier: \n\n" +
                        "\t\tThere is a mountain east from the forest.\n" +
                        "\t\tSomeone reported to have seen a hideous creature, hell like.\n" +
                        "\t\tWe need to destroy it!");
               
        INTERACTIONS.put(Characters.PERSON_13.getCharacter(), "\n\t\tSoldier: \n\n" +
                        "\t\tGood luck in your adventure!");  
                        
        INTERACTIONS.put(Characters.STONE_SPOT.getCharacter(), "\nVoice: \n\n" +
                        "\t\tYou need to find the mythical stone, and place it here." +
                        "\t\tGo! There isn't much time!");  
                        
        INTERACTIONS.put(Characters.STONE_SPOT_2.getCharacter(), "\nVoice: \n\n" +
                        "\t\tWith the mythical stone back where it belongs," +
                        "\t\tThe human kind is safe again." +
                        "\t\tAll because of you, brave warrior!");
                               
        INTERACTIONS.put(Characters.MYTHICAL_STONE.getCharacter(), "\nVoice: \n\n" +
                        "\t\tYou found the mythical stone. Go and place it in the church.");                     
    }
    
    /**
     * @return the interactions for a given object.
     * @param object is the game object.
     */
    public boolean getInteraction(String object)
    {
         System.out.println(INTERACTIONS.get(object));
         
         return true;
    }
}