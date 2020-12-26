import java.util.*;

/**
 * Write a description of class Database here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Database
{
    public static final char CLEAR = '\u000c';
    
    public static final HashMap<String, String> DATABASE_OBJECTS = new HashMap<>();
    public static final HashMap<String, String> DATABASE_MONSTERS = new HashMap<>();
    public static final HashMap<String, String> DATABASE_BOSSES = new HashMap<>();

    private static final String TELEPORT = " ↈ ";
    private static final String PERSON_1 = " ⛹ ";
    private static final String GUARD = " ⏳ ";
    private static final String STABLE = " ♞ ";
    private static final String BLACK_BEAR = " ① ";
    private static final String WHITE_TIGER = " ② ";
    private static final String APE_THROWER = " ③ ";
    private static final String POISON_SPIDER = " ④ ";
    private static final String RED_SCORPION = " ⑤ ";
    private static final String ALBINO_SNAKE = " ⑥ ";
    private static final String POLAR_BEAR = " ⑦ ";
    private static final String YETI = " ⑧ ";
    private static final String ABOMINABLE_SNOWMAN = " ⑨ ";
    private static final String DEMON = " ⑩ ";
    private static final String CURSED_VAMPIRE = " ⑪ ";
    private static final String WITCH = " ⑫ ";
    private static final String BERA = " Ⓑ ";
    private static final String TIGRIS = " Ⓣ ";
    private static final String APE_KING = " Ⓐ ";
    private static final String SPIDER_QUEEN = " Ⓢ ";
    private static final String NINE_TAILS = " Ⓝ ";
    private static final String DEATH = " Ⓓ ";
    private static final String RED_DRAGON = " Ⓡ ";
    private static final String PLAYER = " ☺ ";
    private static final String PLAYER2 = " ☹ ";
    
    private static final String ROCK = " ⛰ ";
    private static final String WALL = " [/] ";
    private static final String BLACKSMITH = " B ";
    private static final String SHOP = " S ";
    private static final String CHEST = "!? ";
    private static final String GOLD = " $ ";
    private static final String ITEM = " !^ ";
    private static final String TREE = " ⍋ ";
    private static final String CACTUS =" ¥ ";
    
    public Database()
    {
        DATABASE_OBJECTS.put(TELEPORT, "\t\tA portal. It will send you to a different map.");
        DATABASE_OBJECTS.put(PERSON_1, "\t\tPeople in the game. Some can interact with you.");
        DATABASE_OBJECTS.put(GUARD, "\t\tThe town guardian. He protects the city from the evil creatures.");
        DATABASE_OBJECTS.put(STABLE, "\t\tA stable. You can buy a horse from there.");
        DATABASE_OBJECTS.put(BLACKSMITH, "\t\tA blacksmith. You can enchance your equipment there.");
        DATABASE_OBJECTS.put(PLAYER, "\t\tThe player location on the map.");
        DATABASE_OBJECTS.put(PLAYER2, "\t\tThe player location on the map, when the player's health drops under 50%");
        DATABASE_OBJECTS.put(ROCK, "\t\tRock wall");
        DATABASE_OBJECTS.put(WALL, "\t\tConcrete wall.");
        DATABASE_OBJECTS.put(SHOP, "\t\tLocal earning his living by selling things.");
        DATABASE_OBJECTS.put(CHEST, "\t\tLucky chest. Can drop gold or items.");
        DATABASE_OBJECTS.put(GOLD, "\t\tGold. Currency.");
        DATABASE_OBJECTS.put(ITEM, "\t\tItem.");
        DATABASE_OBJECTS.put(TREE, "\t\tTree. Found in forests.");
        DATABASE_OBJECTS.put(CACTUS, "\t\tCactus. Found in dessert areas.");
        
        DATABASE_MONSTERS.put(BLACK_BEAR, "\t\tBlack Bear - level 1 monster.");
        DATABASE_MONSTERS.put(WHITE_TIGER, "\t\tWhite Tiger - level 2 monster.");
        DATABASE_MONSTERS.put(APE_THROWER, "\t\tApe Thrower - level 3 monster.");
        DATABASE_MONSTERS.put(POISON_SPIDER, "\t\tPoison Spider - level 4 monster.");
        DATABASE_MONSTERS.put(RED_SCORPION, "\t\tRed Scorpion - level 5 monster.");
        DATABASE_MONSTERS.put(ALBINO_SNAKE, "\t\tAlbino Snake - level 6 monster.");
        DATABASE_MONSTERS.put(POLAR_BEAR, "\t\tPolar Bear - level 7 monster.");
        DATABASE_MONSTERS.put(YETI, "\t\tYeti - level 8 monster.");
        DATABASE_MONSTERS.put(ABOMINABLE_SNOWMAN, "\t\tAbominable Snowman - level 9 monster.");
        DATABASE_MONSTERS.put(DEMON, "\t\tDemon - level 10 monster.");
        DATABASE_MONSTERS.put(CURSED_VAMPIRE, "\t\tCursed Vampire - level 11 monster.");
        DATABASE_MONSTERS.put(WITCH, "\t\tWitch - level 12 monster.");
        
        DATABASE_BOSSES.put(BERA, "\t\tBERA - The biggest and strongest bear humanity have ever seen.");
        DATABASE_BOSSES.put(TIGRIS, "\t\tTIGRIS - A scary, blood-stained tiger. King of the jungle.");
        DATABASE_BOSSES.put(APE_KING, "\t\tAPE KING - The king of apes. Dominates a part of the jungle.");
        DATABASE_BOSSES.put(SPIDER_QUEEN, "\t\tSPIDER QUEEN - The queen of spiders. A dangerous creature no man can defeat.");
        DATABASE_BOSSES.put(NINE_TAILS, "\t\tNINE TAILS - A cursed fox born with 9 tails. She protects the ice land.");
        DATABASE_BOSSES.put(DEATH, "\t\tDEATH - The death itself. A scary creature unseen to human eye before.");
        DATABASE_BOSSES.put(RED_DRAGON, "\t\tRED DRAGON - A dragon that spits fire and destroys everything around itself.");
                               
    }
    
    /**
     * Display the key/value of a given Hashmap.
     * @param database is the hashmap printed.
     */
    public void printDatabase(HashMap<String, String> database)
    {
        for (String object : database.keySet())
        {
            String key = object.toString();
            String value = database.get(object).toString();  
            
            System.out.println("\t" + key + " " + value);  
            
        }
    }
    
    /**
     * Print a full list of game characters.
     */
    public void printAll()
    {
        System.out.println(CLEAR);
        
        printDatabase(DATABASE_MONSTERS);
        printDatabase(DATABASE_BOSSES);
        printDatabase(DATABASE_OBJECTS);
        
    }
    
    /**
     * Print the stats of the game monsters.
     */
    public void getMonsterList(ArrayList< Monster> monsters)
    {
        for(Monster monster : monsters)
        {
            System.out.println(monster.getName() + " : \t" + monster.getStats() + "\n" + monster.getHealthInfo() + 
                                "\nCan drop: " + monster.getDrop());
        }
       
    }
}
