
/**
 * This class will make the conection between maps.
 *
 * @author Andrei Cruceru
 * @version 28112020
 */
public class World
{

    private static final int MAP_EDGE = 3;
    private static final int FULL_L = 34;
    private static final int FULL_H = 46;

    //objects that appear in the game
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
    
    private int row = 3;
    private int col = 3;
    
    private Map currentMap;
    private final Map town;
    private final Map dessert;
    private final Map spiderCave;
    private final Map userHelp;
    private final Map test;
    
    private static final String square = "   ";
    
    
    //private static final String NAME = "World of Zuul";
    //private Map map;
    
    /**
     * initialising the World
     */
    public World()
    {
        town = new Map("Town");//,"The only safe place left in the world");
        town.createMap(Characters.WALL.getCharacter(),MAP_EDGE);
        addObjectsToTown();
        
        dessert = new Map("Dessert");//,"One of the most dangerous places");
        dessert.createMap(Characters.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToDessert();
        
        spiderCave = new Map("SpiderCave");//,"The home of the Spider Queen");
        spiderCave.createMap(Characters.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToSpiderCave();
        
        test = new Map("test");//, "Developers only");
        test.createMap(Characters.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToTestMap();
        
        userHelp = new Map("Location");//, "Player's location on the map");
        userHelp.createMap(Characters.WALL.getCharacter(),MAP_EDGE);
        
        setCurrentMap("town");
    } 
    
    public void addObjects(int columnMin, int columnMax, int rowMin, int rowMax, String object)
    {
        currentMap.addObjects(columnMin, columnMax, rowMin, rowMax, object, 1);
    }
     
    public String getCurrentMapName()
    {
        return currentMap.getName();
    }
           
    /**
     * set the current map to a given map name
     */
    public void setCurrentMap(String name)
    {
        switch (name.toLowerCase())
        {
            case "town" : currentMap = town;
            case "dessert" : currentMap = dessert;
            case "spidercave" : currentMap = spiderCave;
            case "test" : currentMap = test;
            default : System.out.println("error");
        }
        
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
                town.setOne(i, j, Characters.WALL.getCharacter());
                
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
                town.setOne(i, j, Characters.TREE.getCharacter());
                
            }
        }
        //add instances in town
        town.setOne(SHOP_ROW, SHOP_COL, Characters.SHOP.getCharacter());
        town.setOne(BLACKSMITH_ROW, BLACKSMITH_COL, Characters.BLACKSMITH.getCharacter());
                
        town.setOne(PERSON_1_ROW,PERSON_1_COL, Characters.PERSON_1.getCharacter());
        town.setOne(PERSON_2_ROW,PERSON_2_COL,Characters.PERSON_1.getCharacter());
        town.setOne(PERSON_3_ROW,PERSON_3_COL,Characters.PERSON_1.getCharacter());
        town.setOne(PERSON_4_ROW,PERSON_4_COL,Characters.PERSON_1.getCharacter());
        town.setOne(PERSON_5_ROW,PERSON_5_COL,Characters.PERSON_1.getCharacter());
        town.setOne(GUARD_ROW,GUARD_COL,Characters.GUARD.getCharacter());
        town.setOne(STABLE_ROW,STABLE_COL,Characters.STABLE.getCharacter());
        town.setOne(STABLE_ROW -2,STABLE_COL,Characters.BIOLOGIST.getCharacter());
        
        //add monsters, trees, etc       
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.TREE.getCharacter(), 50);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.BLACK_BEAR.getCharacter(), 30);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.WHITE_TIGER.getCharacter(), 25);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.APE_THROWER.getCharacter(), 20);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.BERA.getCharacter(), 1);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.TIGRIS.getCharacter(), 1);
        town.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.APE_KING.getCharacter(), 1);
            
        //add trees to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town.setOne(i ,j , Characters.TREE.getCharacter());
            }
        }
        
        town.setOne(TOWN_TELEPORT_ROW, TOWN_TELEPORT_COL, Characters.TELEPORT.getCharacter());
        
        town.setOne(T_TEST_ROW, T_TEST_COL, Characters.TELEPORT.getCharacter());

    }
    
    /**
     * initialise DESSERT map
     */
    private void addObjectsToDessert()
    {
        int dessertTeleportRow = 27;
        int dessertTeleportCol = 15;
        int corpseRow = 8;
        int corpseCol = 8;
        int potionRow = 4;
        int potionCol = 4;
         
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.CACTUS.getCharacter(), 50);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.POISON_SPIDER.getCharacter(), 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.RED_SCORPION.getCharacter(), 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.ALBINO_SNAKE.getCharacter(), 30);
        
        //add rocks to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                dessert.setOne(i, j,Characters.ROCK.getCharacter());
            }
        }
        
        dessert.setOne(dessertTeleportRow, dessertTeleportCol, Characters.TELEPORT.getCharacter());
        dessert.setOne(corpseRow, corpseCol, Characters.CORPSE.getCharacter());
        
        dessert.setOne(potionRow - 1, potionCol, Characters.TREE.getCharacter());
        dessert.setOne(potionRow, potionCol, Characters.POTION.getCharacter());
        dessert.setOne(potionRow + 1, potionCol, Characters.TREE.getCharacter());
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
                spiderCave.setOne(i, j, Characters.ROCK.getCharacter());
            }
        }
        //add a wall to the right
        for (int i = FULL_H - opening - thickness; i < FULL_H - opening; i++)
        {
            for(int j = MAP_EDGE + opening; j < FULL_L - MAP_EDGE - opening - thickness; j++)
            {
                spiderCave.setOne(i, j, Characters.ROCK.getCharacter());
            }
        }
        //add wall going up
        for (int i = MAP_EDGE + opening; i < FULL_H - MAP_EDGE - opening; i++)
        {
            for(int j = FULL_L - MAP_EDGE - opening - thickness; j < FULL_L - MAP_EDGE - opening; j++)
            {
                spiderCave.setOne(i, j, Characters.ROCK.getCharacter());
            }
        }
        //add wall right to left
        for (int i = MAP_EDGE + opening; i < MAP_EDGE + opening + thickness; i++)
        {
            for(int j = MAP_EDGE + opening + thickness + opening; j < FULL_L - MAP_EDGE - opening - thickness; j++)
            {
                spiderCave.setOne(i, j,Characters.ROCK.getCharacter());
            }
        }
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.POISON_SPIDER.getCharacter(), 40);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.RED_SCORPION.getCharacter(), 40);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.ALBINO_SNAKE.getCharacter(), 40);
        
        spiderCave.addObjects(SPIDER_QUEEN_COL - 1, SPIDER_QUEEN_COL + 1,SPIDER_QUEEN_ROW - 1, SPIDER_QUEEN_ROW + 1, Characters.SPIDER_QUEEN.getCharacter(), 1);
        spiderCave.addObjects(SPIDER_QUEEN_COL - 1, SPIDER_QUEEN_COL + 1,SPIDER_QUEEN_ROW - 1, SPIDER_QUEEN_ROW + 1, Characters.TELEPORT.getCharacter(), 1);
        
        spiderCave.setOne(CAVE_SHOP_ROW,CAVE_SHOP_COL,Characters.SHOP.getCharacter());
        spiderCave.setOne(CAVE_BLACKSMITH_ROW,CAVE_BLACKSMITH_COL,Characters.BLACKSMITH.getCharacter());
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

        return currentMap.getSquareValue(row, col);
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
        return currentMap.getMap();
    }
    
    /**
     * Add a monster on the map in an empty square
     */
    public void addAnother(String character)
    {
        switch (currentMap.getName().toLowerCase())
        {
            case "town" : currentMap.addObjects(WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
            case "dessert" : dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
            case "spidercave" : spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
        }
    }

    /**
     * Print a empty map for the user with the player's location.
     */
    public void printHelpMap(int pRow, int pCol)
    {
        userHelp.setOne(row, col, "   ");
        userHelp.setOne(pRow, pCol, Characters.PLAYER.getCharacter());
        
        row = pRow;
        col = pCol;
        
        userHelp.printMap();
    }
    
    /**
     * Set values in the help map.
     */
    public void addToHelpMap(int row, int col, String object)
    {
        userHelp.setOne(row, col, object);
        
    }
    
    private void addObjectsToTestMap()
    {
        int townR = 4;
        
        test.setOne(B_TEST_ROW,B_TEST_COL, Characters.BLACKSMITH.getCharacter());
        test.setOne(S_TEST_ROW,S_TEST_COL, Characters.SHOP.getCharacter());
        test.setOne(townR,townR, Characters.TELEPORT.getCharacter());

        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.BLACK_BEAR.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.WHITE_TIGER.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.APE_THROWER.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.POISON_SPIDER.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.RED_SCORPION.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.ALBINO_SNAKE.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.POLAR_BEAR.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.YETI.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.ABOMINABLE_SNOWMAN.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.DEMON.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.CURSED_VAMPIRE.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.WITCH.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.BERA.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.TIGRIS.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.APE_KING.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.SPIDER_QUEEN.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.NINE_TAILS.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.DEATH.getCharacter(), 10);
        test.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.RED_DRAGON.getCharacter(), 10);
          
    }
    
    public boolean goTest(int colCoord)
    {
        return colCoord == T_TEST_COL;
    }
} 