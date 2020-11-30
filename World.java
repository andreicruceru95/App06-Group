import java.util.*;

/**
 * This class will make the conection between maps.
 *
 * @author Andrei Cruceru
 * @version 28112020
 */
public class World
{
    //private static final String CURRENT_MAP[][] = new String[47][35];
    private static final String TOWN[][] = new String[47][35];
    private static final String DESSERT[][] = new String[47][35];
    private static final String SPIDER_CAVE[][]  = new String[47][35];
    
    
    private static final int MAP_EDGE = 3;
    private static final int MAP_L = 27;
    private static final int MAP_H = 39;
    private static final int FULL_L = 34;
    private static final int FULL_H = 46;
    
    //player's visual field
    
    private static final int initialPlayerRow = 4;
    private static final int initialPlayerCol = 2;
    
    //objects that apear in the game
    
    private static final int PERSON_1_ROW = 17;
    private static final int PERSON_1_COL = 4;
    private static final int PERSON_2_ROW = 21;
    private static final int PERSON_2_COL = 7;
    private static final int PERSON_3_ROW = 24;
    private static final int PERSON_3_COL = 5;
    private static final int PERSON_4_ROW = 28;
    private static final int PERSON_4_COL = 9;
    private static final int PERSON_5_ROW = 32;
    private static final int PERSON_5_COL = 8;
    private static final int TOWN_TELEPORT_ROW = 3;
    private static final int TOWN_TELEPORT_COL = 25;
    private static final int DESSERT_TELEPORT_ROW = 27;
    private static final int DESSERT_TELEPORT_COL = 15;
    private static final int DESSERT_SHOP_ROW = 4;
    private static final int DESSERT_SHOP_COL = 4;
    private static final int DESSERT_BLACKSMITH_ROW = 8;
    private static final int DESSERT_BLACKSMITH_COL = 8;
    private static final int CAVE_SHOP_ROW = 4;
    private static final int CAVE_SHOP_COL = 4;
    private static final int CAVE_BLACKSMITH_ROW = 8;
    private static final int CAVE_BLACKSMITH_COL = 8;
    private static final int SHOP_ROW = 10;
    private static final int SHOP_COL = 3;
    private static final int BLACKSMITH_ROW = 13;
    private static final int BLACKSMITH_COL = 9;
    private static final int GUARD_ROW = 33;
    private static final int GUARD_COL = 11;
    private static final int STABLE_ROW = 35;
    private static final int STABLE_COL = 3;
    private static final int FOREST_ENTRANCE_START = 31;
    private static final int FOREST_ENTRANCE_END = 36;
    private static final int SPIDER_QUEEN_ROW = 26;
    private static final int SPIDER_QUEEN_COL = 15;
    private static final int WALL_START = 10;
    private static final int WALL_END = 13;
    
    private static final String TELEPORT = "  ↈ ";
    private static final String PERSON_1 = " ⛹";
    private static final String PERSON_2 = " ⛹";
    private static final String PERSON_3 = " ⛹";
    private static final String PERSON_4 = " ⛹";
    private static final String PERSON_5 = " ⛹";
    private static final String GUARD = " ⏳ ";
    private static final String STABLE = " ♞";
    
    private static final String PLAYER = "P";
    
    private static final String WALL = "[/]";
    private static final String BLACKSMITH = " B ";
    private static final String SHOP = " S ";
    private static final String CHEST = "!?";
    private static final String GOLD = "$";
    private static final String ITEM = "!^";
    private static final String TREE = " ⍋";
    private static final String CACTUS =" ¥ ";
    private static final String ROCK = " ⛰ ";
        
    //monsters
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
        
    //bosses    
    private static final String BERA = " Ⓑ ";
    private static final String TIGRIS = " Ⓣ ";
    private static final String APE_KING = " Ⓐ ";
    private static final String SPIDER_QUEEN = " Ⓢ ";
    private static final String NINE_TAILS = " Ⓝ ";
    private static final String DEATH = " Ⓓ ";
    private static final String RED_DRAGON = " Ⓡ ";
        
    private Map currentMap;
    private Map town;
    private Map dessert;
    private Map spiderCave;
    
    private Random rand;
       
    private String square = "   ";
    
    
    private String name;
    private Map map;
    
    /**
     * initialising the World
     */
    public World(String name)
    {
        this.name = name;
        
        town = new Map("Town", TOWN,"The only safe place left in the world", FULL_H, FULL_L);
        town.createMap(ROCK, FULL_H, FULL_L,MAP_EDGE);
        addObjectsToTown();
        
        dessert = new Map("Dessert",DESSERT,"One of the most dangerous places", FULL_H, FULL_L);
        dessert.createMap(ROCK, FULL_H, FULL_L,MAP_EDGE);
        addObjectsToDessert();
        
        spiderCave = new Map("SpiderCave",SPIDER_CAVE,"The home of the Spider Queen", FULL_H, FULL_L);
        spiderCave.createMap(ROCK, FULL_H, FULL_L,MAP_EDGE);
        addObjectsToSpiderCave();
        
        setCurrentMap("town");
    } 
     
    public String getCurrentMapName()
    {
        return currentMap.getName();
    }
           
    /**
     * set the curent map to a given map name
     */
    public void setCurrentMap(String name)
    {
        if (name.toLowerCase().equals("town"))
        {
            currentMap = town;
        }
        else if(name.toLowerCase().equals("dessert"))
        {
            currentMap = dessert;
        }
        else if(name.toLowerCase().equals("spidercave"))
        {
            currentMap = spiderCave;
        }
        else
             System.out.println("error");
        
    }
    
    /**
     * add object to the town map
     */
    private void addObjectsToTown()
    {
        //add wall
        for (int i = 0; i < FULL_H; i++)
        {
            for(int j = WALL_START; j < WALL_END; j++)
            {
                town.setOne(i, j, WALL);
                
            }
        }
        //add forest entrance
        for (int i = FOREST_ENTRANCE_START; i < FOREST_ENTRANCE_END; i++)
        {
            for(int j = WALL_START; j < WALL_END; j++)
            {
                town.setOne(i, j, square);
                
            }
        }
                  
        for(int i = 0; i < FULL_H; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town.setOne(i, j, TREE);
                
            }
        }
        //add instances in town
        town.setOne(SHOP_ROW, SHOP_COL, SHOP);
        //TOWN[SHOP_ROW][SHOP_COL] = SHOP;
        town.setOne(BLACKSMITH_ROW, BLACKSMITH_COL, BLACKSMITH);
        //TOWN[BLACKSMITH_ROW][BLACKSMITH_COL] = BLACKSMITH;
        
        town.setOne(PERSON_1_ROW,PERSON_1_COL, PERSON_1);
        town.setOne(PERSON_2_ROW,PERSON_2_COL,PERSON_2);
        town.setOne(PERSON_3_ROW,PERSON_3_COL,PERSON_3);
        town.setOne(PERSON_4_ROW,PERSON_4_COL,PERSON_4);
        town.setOne(PERSON_5_ROW,PERSON_5_COL,PERSON_5);
        town.setOne(GUARD_ROW,GUARD_COL,GUARD);
        town.setOne(STABLE_ROW,STABLE_COL,STABLE);
        
        //add monsters, trees, etc       
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, TREE, 50);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, BLACK_BEAR, 30);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, WHITE_TIGER, 25);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, APE_THROWER, 20);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, BERA, 1);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, TIGRIS, 1);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, APE_KING, 1);
            
        //add trees to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town.setOne(i ,j , TREE);
            }
        }
        
        town.setOne(TOWN_TELEPORT_ROW, TOWN_TELEPORT_COL, TELEPORT);
    }
    
    /**
     * print town map. Developers only
     */
    private void printTownMap()
    {
        town.printMap(FULL_H, FULL_L);
                   
    }
    
    /**
     * initialise DESSERT map
     */
    private void addObjectsToDessert()
    {
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, CACTUS, 50);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, POISON_SPIDER, 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, RED_SCORPION, 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, ALBINO_SNAKE, 30);
        
        //add rocks to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                dessert.setOne(i, j,ROCK);
            }
        }
        
        dessert.setOne(DESSERT_TELEPORT_ROW, DESSERT_TELEPORT_COL, TELEPORT);
        dessert.setOne(DESSERT_SHOP_ROW, DESSERT_SHOP_COL, SHOP);
        dessert.setOne(DESSERT_BLACKSMITH_ROW, DESSERT_BLACKSMITH_COL, BLACKSMITH);
    }
    
    /**
     * Initialise Spider dungeon map
     */
    private void addObjectsToSpiderCave()
    {
        int thickness = 3;
        int opening = 5;
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, POISON_SPIDER, 30);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, RED_SCORPION, 30);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, ALBINO_SNAKE, 30);
        
        //add a wall going down in the cave
        for (int i = 0; i < FULL_H - MAP_EDGE - opening; i++)
        {
            for(int j = MAP_EDGE + opening; j < MAP_EDGE + opening + thickness; j++)
            {
                spiderCave.setOne(i, j, ROCK);
            }
        }
        //add a wall to the right
        for (int i = FULL_H - opening - thickness; i < FULL_H - opening; i++)
        {
            for(int j = MAP_EDGE + opening; j < FULL_L - MAP_EDGE - opening - opening; j++)
            {
                spiderCave.setOne(i, j, ROCK);
            }
        }
        //add wall going up
        for (int i = MAP_EDGE + opening; i < FULL_H - MAP_EDGE - opening; i++)
        {
            for(int j = FULL_L - MAP_EDGE - opening - thickness; j < FULL_L - MAP_EDGE - opening; j++)
            {
                spiderCave.setOne(i, j, ROCK);
            }
        }
        //add wall right to left
        for (int i = MAP_EDGE + opening; i < MAP_EDGE + opening + thickness; i++)
        {
            for(int j = MAP_EDGE + opening + thickness + opening; j < FULL_L - MAP_EDGE - opening - thickness; j++)
            {
                spiderCave.setOne(i, j,ROCK);
            }
        }
        
        spiderCave.addObjects(SPIDER_QUEEN_COL - 1, SPIDER_QUEEN_COL + 1,SPIDER_QUEEN_ROW - 1, SPIDER_QUEEN_ROW + 1, SPIDER_QUEEN, 1);
        spiderCave.addObjects(SPIDER_QUEEN_COL - 1, SPIDER_QUEEN_COL + 1,SPIDER_QUEEN_ROW - 1, SPIDER_QUEEN_ROW + 1, TELEPORT, 1);
        
        spiderCave.setOne(CAVE_SHOP_ROW,CAVE_SHOP_COL,SHOP);
        spiderCave.setOne(CAVE_BLACKSMITH_ROW,CAVE_BLACKSMITH_COL,BLACKSMITH);
    }
    
    /**
     * print cave map, Developers only
     */
    private void printCaveMap()
    {
        addObjectsToSpiderCave();
        
        spiderCave.printMap(FULL_H, FULL_L);
    }
    
    /**
     * print dessert map. developers only
     */
    private void printDesertMap()
    {
        addObjectsToDessert();
        
        dessert.printMap(FULL_H, FULL_L);
    }
    
    /**
     * return the current map
     */
    public Map getCurrentMap()
    {
        return currentMap;
    }
    
    /**
     * return the value of a square in the map
     */
    public String getSquareValue(int row, int col)
    {
        String value = currentMap.getSquareValue(row, col);
        
        return value;
    }
    
    /**
     * Set an object at a given location
     */
    public void setObject(int playerRowCoord, int playerColCoord, String value)
    {
        currentMap.setOne(playerRowCoord, playerColCoord, value);
    }
    
    /**
     * print the player's visual field
     */
    public void printVisualField(int playerRowCoord, int playerColCoord)
    {
        currentMap.printVisualField(playerRowCoord, playerColCoord);
    }
    
    /**
     * Add a monster on the map in an empty square
     */
    public void addAnotherMonster(String character)
    {
        if (currentMap.getName().toLowerCase().equals("town"))
        {
            currentMap.reSpawn(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character);
        }
        else if (currentMap.getName().toLowerCase().equals("dessert"))
        {
            dessert.reSpawn(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character);
        }
        else if (currentMap.getName().toLowerCase().equals("spidercave"))
        {
            spiderCave.reSpawn(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character);
        }
    }
    
    /**
     * Check the player's visual field
     */
    public boolean checkVisualField(String character)
    {
        if(currentMap.checkVisualField(character) == true)
        
            return true;
        
        else
            return false;
    }
    
}