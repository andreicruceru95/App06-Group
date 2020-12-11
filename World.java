import java.util.*;

/**
 * This class will make the conection between maps.
 *
 * @author Andrei Cruceru
 * @version 28112020
 */
public class World
{
    private static final String TOWN[][] = new String[47][35];
    private static final String DESSERT[][] = new String[47][35];
    private static final String SPIDER_CAVE[][]  = new String[47][35];
    private static final String USER_HELP[][] = new String[47][35];
    private static final String TEST[][] = new String[47][35];
    
    private static final int MAP_EDGE = 3;
    private static final int MAP_L = 27;
    private static final int MAP_H = 39;
    private static final int FULL_L = 34;
    private static final int FULL_H = 46;
    
    //player's visual field
    
    private static final int initialPlayerRow = 4;
    private static final int initialPlayerCol = 2;
    
    //objects that apear in the game
    private static final int S_TEST_ROW = 6;
    private static final int S_TEST_COL = 5;
    private static final int B_TEST_ROW = 6;
    private static final int B_TEST_COL = 7;
    private static final int T_TEST_ROW = 6;
    private static final int T_TEST_COL = 9;
    
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
    
    
    private Map currentMap;
    private Map town;
    private Map dessert;
    private Map spiderCave;
    private Map userHelp;
    private Map test;
    
    private Random rand;
    private Characters character;
       
    private String square = "   ";
    
    
    private String name;
    private Map map;
    
    /**
     * initialising the World
     */
    public World(String name)
    {
        this.name = name;
        
        town = new Map("Town", TOWN,"The only safe place left in the world");
        town.createMap(character.WALL.getCharacter(),MAP_EDGE);
        addObjectsToTown();
        
        dessert = new Map("Dessert",DESSERT,"One of the most dangerous places");
        dessert.createMap(character.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToDessert();
        
        spiderCave = new Map("SpiderCave",SPIDER_CAVE,"The home of the Spider Queen");
        spiderCave.createMap(character.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToSpiderCave();
        
        test = new Map("test", TEST, "Developers only");
        test.createMap(character.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToTestMap();
        
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
        else if(name.toLowerCase().equals("test"))
        {
            currentMap = test;
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
                town.setOne(i, j, character.WALL.getCharacter());
                
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
        
        //Might be a mistake
        for(int i = 0; i < FULL_H; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town.setOne(i, j, character.TREE.getCharacter());
                
            }
        }
        //add instances in town
        town.setOne(SHOP_ROW, SHOP_COL, character.SHOP.getCharacter());
        town.setOne(BLACKSMITH_ROW, BLACKSMITH_COL, character.BLACKSMITH.getCharacter());
                
        town.setOne(PERSON_1_ROW,PERSON_1_COL, character.PERSON_1.getCharacter());
        town.setOne(PERSON_2_ROW,PERSON_2_COL,character.PERSON_1.getCharacter());
        town.setOne(PERSON_3_ROW,PERSON_3_COL,character.PERSON_1.getCharacter());
        town.setOne(PERSON_4_ROW,PERSON_4_COL,character.PERSON_1.getCharacter());
        town.setOne(PERSON_5_ROW,PERSON_5_COL,character.PERSON_1.getCharacter());
        town.setOne(GUARD_ROW,GUARD_COL,character.GUARD.getCharacter());
        town.setOne(STABLE_ROW,STABLE_COL,character.STABLE.getCharacter());
        
        //add monsters, trees, etc       
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.TREE.getCharacter(), 50);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.BLACK_BEAR.getCharacter(), 30);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.WHITE_TIGER.getCharacter(), 25);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.APE_THROWER.getCharacter(), 20);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.BERA.getCharacter(), 1);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.TIGRIS.getCharacter(), 1);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.APE_KING.getCharacter(), 1);
            
        //add trees to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town.setOne(i ,j , character.TREE.getCharacter());
            }
        }
        
        town.setOne(TOWN_TELEPORT_ROW, TOWN_TELEPORT_COL, character.TELEPORT.getCharacter());
        
        town.setOne(T_TEST_ROW, T_TEST_COL, character.TELEPORT.getCharacter());

    }
    
    /**
     * initialise DESSERT map
     */
    private void addObjectsToDessert()
    {
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.CACTUS.getCharacter(), 50);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.POISON_SPIDER.getCharacter(), 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.RED_SCORPION.getCharacter(), 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.ALBINO_SNAKE.getCharacter(), 30);
        
        //add rocks to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                dessert.setOne(i, j,character.ROCK.getCharacter());
            }
        }
        
        dessert.setOne(DESSERT_TELEPORT_ROW, DESSERT_TELEPORT_COL, character.TELEPORT.getCharacter());
        dessert.setOne(DESSERT_SHOP_ROW, DESSERT_SHOP_COL, character.SHOP.getCharacter());
        dessert.setOne(DESSERT_BLACKSMITH_ROW, DESSERT_BLACKSMITH_COL, character.BLACKSMITH.getCharacter());
    }
    
    /**
     * Initialise Spider dungeon map
     */
    private void addObjectsToSpiderCave()
    {
        int thickness = 3;
        int opening = 5;
        
        //add a wall going down in the cave
        for (int i = 0; i < FULL_H - MAP_EDGE - opening; i++)
        {
            for(int j = MAP_EDGE + opening; j < MAP_EDGE + opening + thickness; j++)
            {
                spiderCave.setOne(i, j, character.ROCK.getCharacter());
            }
        }
        //add a wall to the right
        for (int i = FULL_H - opening - thickness; i < FULL_H - opening; i++)
        {
            for(int j = MAP_EDGE + opening; j < FULL_L - MAP_EDGE - opening - thickness; j++)
            {
                spiderCave.setOne(i, j, character.ROCK.getCharacter());
            }
        }
        //add wall going up
        for (int i = MAP_EDGE + opening; i < FULL_H - MAP_EDGE - opening; i++)
        {
            for(int j = FULL_L - MAP_EDGE - opening - thickness; j < FULL_L - MAP_EDGE - opening; j++)
            {
                spiderCave.setOne(i, j, character.ROCK.getCharacter());
            }
        }
        //add wall right to left
        for (int i = MAP_EDGE + opening; i < MAP_EDGE + opening + thickness; i++)
        {
            for(int j = MAP_EDGE + opening + thickness + opening; j < FULL_L - MAP_EDGE - opening - thickness; j++)
            {
                spiderCave.setOne(i, j,character.ROCK.getCharacter());
            }
        }
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.POISON_SPIDER.getCharacter(), 40);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.RED_SCORPION.getCharacter(), 40);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.ALBINO_SNAKE.getCharacter(), 40);
        
        spiderCave.addObjects(SPIDER_QUEEN_COL - 1, SPIDER_QUEEN_COL + 1,SPIDER_QUEEN_ROW - 1, SPIDER_QUEEN_ROW + 1, character.SPIDER_QUEEN.getCharacter(), 1);
        spiderCave.addObjects(SPIDER_QUEEN_COL - 1, SPIDER_QUEEN_COL + 1,SPIDER_QUEEN_ROW - 1, SPIDER_QUEEN_ROW + 1, character.TELEPORT.getCharacter(), 1);
        
        spiderCave.setOne(CAVE_SHOP_ROW,CAVE_SHOP_COL,character.SHOP.getCharacter());
        spiderCave.setOne(CAVE_BLACKSMITH_ROW,CAVE_BLACKSMITH_COL,character.BLACKSMITH.getCharacter());
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
     * @return the current map as a 2d array.
     */
    public String[][] getMapAsArray()
    {
        return currentMap.getmap();
    }
    
    /**
     * Add a monster on the map in an empty square
     */
    public void addAnother(String character)
    {
        if (currentMap.getName().toLowerCase().equals("town"))
        {
            currentMap.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
        }
        else if (currentMap.getName().toLowerCase().equals("dessert"))
        {
            dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
        }
        else if (currentMap.getName().toLowerCase().equals("spidercave"))
        {
            spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
        }
    }
    
    public void printMaps()
    {
        town.printMap();
        dessert.printMap();
        spiderCave.printMap();
    }
    
    /**
     * Print a empty map for the user with the player's location.
     */
    public void printHelpMap(int row, int col)
    {
        userHelp = new Map("Location", USER_HELP, "Player's location on the map");
        userHelp.createMap(character.WALL.getCharacter(),MAP_EDGE);
        
        userHelp.setOne(row, col, character.PLAYER.getCharacter());
        
        userHelp.printMap();
    }
    
    private void addObjectsToTestMap()
    {
        int townR = 4;
        
        test.setOne(B_TEST_ROW,B_TEST_COL, character.BLACKSMITH.getCharacter());
        test.setOne(S_TEST_ROW,S_TEST_COL, character.SHOP.getCharacter());
        test.setOne(townR,townR, character.TELEPORT.getCharacter());

        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.BLACK_BEAR.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.WHITE_TIGER.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.APE_THROWER.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.POISON_SPIDER.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.RED_SCORPION.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.ALBINO_SNAKE.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.POLAR_BEAR.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.YETI.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.ABOMINABLE_SNOWMAN.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.DEMON.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.CURSED_VAMPIRE.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.WITCH.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.BERA.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.TIGRIS.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.APE_KING.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.SPIDER_QUEEN.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.NINE_TAILS.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.DEATH.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character.RED_DRAGON.getCharacter(), 10);
          
    }
    
    public boolean goTest()
    {
        return true;
    }
} 