import java.util.*;

/**
 * Contains information about the in-game characters.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Database
{
    public static final char CLEAR = '\u000c';
    
    public static final HashMap<String, String> DATABASE_OBJECTS = new HashMap<>();
    public static final HashMap<String, String> DATABASE_MONSTERS = new HashMap<>();
    public static final HashMap<String, String> DATABASE_BOSSES = new HashMap<>();
    public static final HashMap<String, String> DATABASE_ITEMS = new HashMap<>();
   
    /**
     * Adding the objects and descriptions to a hash map.
     */
    public Database()
    {
        DATABASE_OBJECTS.put(Characters.TELEPORT.getCharacter(), "\t\tA portal. It will send you to a different map.");
        DATABASE_OBJECTS.put(Characters.PERSON.getCharacter(), "\t\tPeople in the game. Some can interact with you.");
        DATABASE_OBJECTS.put(Characters.GUARD.getCharacter(), "\t\tThe town guardian. He protects the city from the evil creatures.");
        DATABASE_OBJECTS.put(Characters.STABLE.getCharacter(), "\t\tA stable. You can buy a horse from there.");
        DATABASE_OBJECTS.put(Characters.BLACKSMITH.getCharacter(), "\t\tA blacksmith. You can enchance your equipment there.");
        DATABASE_OBJECTS.put(Characters.PLAYER.getCharacter(), "\t\tThe player location on the map.");
        DATABASE_OBJECTS.put(Characters.PLAYER2.getCharacter(), "\t\tThe player location on the map, when the player's health drops under 50%");
        DATABASE_OBJECTS.put(Characters.ROCK.getCharacter(), "\t\tRock wall");
        DATABASE_OBJECTS.put(Characters.WALL.getCharacter(), "\t\tConcrete wall.");
        DATABASE_OBJECTS.put(Characters.SHOP.getCharacter(), "\t\tLocal earning his living by selling things.");
        DATABASE_OBJECTS.put(Characters.CHEST.getCharacter(), "\t\tLucky chest. Can drop gold or items.");
        DATABASE_OBJECTS.put(Characters.GOLD.getCharacter(), "\t\tGold. Currency.");        
        DATABASE_OBJECTS.put(Characters.TREE.getCharacter(), "\t\tTree. Found in forests.");
        DATABASE_OBJECTS.put(Characters.CACTUS.getCharacter(), "\t\tCactus. Found in dessert areas.");
        DATABASE_OBJECTS.put(Characters.GOLD_2.getCharacter(), "\t\tA pile of gold.");
        DATABASE_OBJECTS.put(Characters.POTION.getCharacter(), "\t\tHealth potion. Restores player's health.");
        DATABASE_OBJECTS.put(Characters.LUCK.getCharacter(), "\t\tCasino. You can gamble your gold there.");
        DATABASE_OBJECTS.put(Characters.ANVIL.getCharacter(), "\t\tAnvil. You can improve your items there.");
        DATABASE_OBJECTS.put(Characters.BAG.getCharacter(), "\t\tBag of resources. You can find items in them");
        DATABASE_OBJECTS.put(Characters.BARREL.getCharacter(), "\t\tUnopened barrel. Contains items");
        DATABASE_OBJECTS.put(Characters.OPENED_BARREL.getCharacter(), "\t\tOpened barrel. Can be distroyed");
        DATABASE_OBJECTS.put(Characters.NURSE.getCharacter(), "\t\tNurse. Can heal the player.");
        DATABASE_OBJECTS.put(Characters.PERSON_2.getCharacter(), "\t\t.Person in game that has a task for you.");
        DATABASE_OBJECTS.put(Characters.BIOLOGIST.getCharacter(), "\t\tBiologist. Will give you gold in exchange of herbs.");
        
        DATABASE_MONSTERS.put(Characters.BLACK_BEAR.getCharacter(), "\t\tBlack Bear - level 1 monster.");
        DATABASE_MONSTERS.put(Characters.WHITE_TIGER.getCharacter(), "\t\tWhite Tiger - level 2 monster.");
        DATABASE_MONSTERS.put(Characters.APE_THROWER.getCharacter(), "\t\tApe Thrower - level 3 monster.");
        DATABASE_MONSTERS.put(Characters.POISON_SPIDER.getCharacter(), "\t\tPoison Spider - level 4 monster.");
        DATABASE_MONSTERS.put(Characters.RED_SCORPION.getCharacter(), "\t\tRed Scorpion - level 5 monster.");
        DATABASE_MONSTERS.put(Characters.ALBINO_SNAKE.getCharacter(), "\t\tAlbino Snake - level 6 monster.");
        DATABASE_MONSTERS.put(Characters.POLAR_BEAR.getCharacter(), "\t\tPolar Bear - level 7 monster.");
        DATABASE_MONSTERS.put(Characters.YETI.getCharacter(), "\t\tYeti - level 8 monster.");
        DATABASE_MONSTERS.put(Characters.ABOMINABLE_SNOWMAN.getCharacter(), "\t\tAbominable Snowman - level 9 monster.");
        DATABASE_MONSTERS.put(Characters.DEMON.getCharacter(), "\t\tDemon - level 10 monster.");
        DATABASE_MONSTERS.put(Characters.CURSED_VAMPIRE.getCharacter(), "\t\tCursed Vampire - level 11 monster.");
        DATABASE_MONSTERS.put(Characters.WITCH.getCharacter(), "\t\tWitch - level 12 monster.");
        
        DATABASE_BOSSES.put(Characters.BERA.getCharacter(), "\t\tBERA - The biggest and strongest bear humanity have ever seen.");
        DATABASE_BOSSES.put(Characters.TIGRIS.getCharacter(), "\t\tTIGRIS - A scary, blood-stained tiger. King of the jungle.");
        DATABASE_BOSSES.put(Characters.APE_KING.getCharacter(), "\t\tAPE KING - The king of apes. Dominates a part of the jungle.");
        DATABASE_BOSSES.put(Characters.SPIDER_QUEEN.getCharacter(), "\t\tSPIDER QUEEN - The queen of spiders. A dangerous creature no man can defeat.");
        DATABASE_BOSSES.put(Characters.NINE_TAILS.getCharacter(), "\t\tNINE TAILS - A cursed fox born with 9 tails. She protects the ice land.");
        DATABASE_BOSSES.put(Characters.DEATH.getCharacter(), "\t\tDEATH - The death itself. A scary creature unseen to human eye before.");
        DATABASE_BOSSES.put(Characters.RED_DRAGON.getCharacter(), "\t\tRED DRAGON - A dragon that spits fire and destroys everything around itself.");
        
        DATABASE_ITEMS.put(Characters.FLOWER_RED.getCharacter(), "Red Flower");
        DATABASE_ITEMS.put(Characters.FLOWER_BLUE.getCharacter(), "Blue Flower");
        DATABASE_ITEMS.put(Characters.FLOWER_PURPLE.getCharacter(), "Purple Flower ");
        DATABASE_ITEMS.put(Characters.FLOWER_YELLOW.getCharacter(), "Yellow Flower");
        DATABASE_ITEMS.put(Characters.FLOWER_WHITE.getCharacter(), "");
        DATABASE_ITEMS.put(Characters.SNOW_FRAG.getCharacter(), "Snow Fragment");
        DATABASE_ITEMS.put(Characters.STAR_FRAG.getCharacter(), "Star Fragment");
        DATABASE_ITEMS.put(Characters.SPIDER_KEY.getCharacter(), "Key for spider cave doors");
        DATABASE_ITEMS.put(Characters.TOWER_KEY.getCharacter(), "Key for tower doors");
        DATABASE_ITEMS.put(Characters.FOX_KEY.getCharacter(), "Key for mountain gate");
        DATABASE_ITEMS.put(Characters.CHEST_KEY.getCharacter(), "Key to open chests");
        DATABASE_ITEMS.put(Characters.REMAINS.getCharacter(), "Monster remains");
        DATABASE_ITEMS.put(Characters.MYTHICAL_STONE.getCharacter(), "Mythical Stone");
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
        printDatabase(DATABASE_ITEMS);
        
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
