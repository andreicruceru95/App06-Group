import java.util.*;

/**
 * The player's visual field on the map.
 * The rest of the map will be hidden.
 *
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Map
{
    private static final char CLEAR = '\u000c';
    
    //maps
    private static final String currentMap[][] = new String[47][35];
    private static final String town[][] = new String[47][35];
    private static final int MAP_EDGE = 3;
    private static final int MAP_L = 27;
    private static final int MAP_H = 39;
    private static final int FULL_L = 34;
    private static final int FULL_H = 46;
    
    //player's visual field
    private static final String visualField[][] = new String[7][7];
    private static final int initialPlayerRow = 2;
    private static final int initialPlayerCol = 2;
    
    //objects that apear in the game
    private static final int SHOP_ROW = 10;
    private static final int SHOP_COL = 3;
    private static final int BLACKSMITH_ROW = 13;
    private static final int BLACKSMITH_COL = 9;
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
    private static final int GUARD_ROW = 33;
    private static final int GUARD_COL = 11;
    private static final int STABLE_ROW = 35;
    private static final int STABLE_COL = 3;
    private static final int WALL_START = 10;
    private static final int WALL_END = 13;
    private static final int FOREST_ENTRANCE_START = 31;
    private static final int FOREST_ENTRANCE_END = 36;
    
    
    private static final String PERSON_1 = " ⛹";
    private static final String PERSON_2 = " ⛹";
    private static final String PERSON_3 = " ⛹";
    private static final String PERSON_4 = " ⛹";
    private static final String PERSON_5 = " ⛹";
    private static final String GUARD = " ⏳ ";
    private static final String STABLE = " ♞";
    
    private static final String PLAYER = "P";
    private static final String UP = "w";
    private static final String DOWN = "s";
    private static final String LEFT = "a";
    private static final String RIGHT = "d";
    private static final String WALL = "[/]";
    private static final String BLACKSMITH = " B ";
    private static final String SHOP = " S ";
    private static final String CHEST = "!?";
    private static final String GOLD = "$";
    private static final String ITEM = "!^";
    private static final String TREE = " ¥";
    
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
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_5 = 5;
    private static final int LEVEL_10 = 10;
    private static final int LEVEL_15 = 15;
    private static final int LEVEL_20 = 20;
    private static final int LEVEL_25 = 25;
    private static final int LEVEL_30 = 30;
    private static final int LEVEL_35 = 35;
    private static final int LEVEL_40 = 40;
    private static final int LEVEL_45 = 45;
    private static final int LEVEL_50 = 50;
    private static final int LEVEL_55 = 55;
    
    //bosses    
    private static final String BERA = " Ⓑ ";
    private static final String TIGRIS = " Ⓣ ";
    private static final String APE_KING = " Ⓐ ";
    private static final String SPIDER_QUEEN = " Ⓢ ";
    private static final String NINE_TAILS = " Ⓝ ";
    private static final String DEATH = " Ⓓ ";
    private static final String RED_DRAGON = " Ⓡ ";
    private static final int LEVEL_9 = 9;
    private static final int LEVEL_14 = 14;
    private static final int LEVEL_19 = 19;
    private static final int LEVEL_34 = 34;
    private static final int LEVEL_49 = 49;
    private static final int LEVEL_60 = 60;
    private static final int LEVEL_70 = 70;
    
    private static final String ABANDONED_HOUSE = "H";
    private static final String MAIN_QUEST = "!";
    private static final String QUEST_HUSBAND = "Q1";
    private static final String QUEST_FARM = "Q2";
    private static final String QUEST_WOLF = "Q3";
    private static final String MISSING_HUSBAND = "??";
    
    private Random rand;
    private Player player;
    private int playerHp;
    //A list of monsters name, level
    private HashMap <String, Integer> monsters = new HashMap<String, Integer>();
    private ArrayList<Item> items = new ArrayList<Item>();
    
    private String square = "   ";
    
    private String description;
    private String name;
    private int level;
    private int playerRowCoord = 0;
    private int playerColCoord = 0;
    
    /**
     * Constructor for the Map
     */
     public Map(int level, String name, String playerName)
    {
        createMap(town);
        rand = new Random();
        this.description = description;
        this.level = level;
        this.name = name;
        player = new Player(playerName);
        
        setCurrentMap("town");
        // create monsters
        monsters.put(BLACK_BEAR,LEVEL_1);
        monsters.put(WHITE_TIGER, LEVEL_5);
        monsters.put(APE_THROWER, LEVEL_10);
        monsters.put(POISON_SPIDER, LEVEL_15);
        monsters.put(RED_SCORPION,LEVEL_20);
        monsters.put(ALBINO_SNAKE,LEVEL_25);
        monsters.put(POLAR_BEAR,LEVEL_30);
        monsters.put(YETI,LEVEL_35);
        monsters.put(ABOMINABLE_SNOWMAN,LEVEL_40);
        monsters.put(DEMON,LEVEL_45);
        monsters.put(CURSED_VAMPIRE,LEVEL_50);
        monsters.put(WITCH,LEVEL_55);
        monsters.put(BERA,LEVEL_9);
        monsters.put(TIGRIS,LEVEL_14);
        monsters.put(APE_KING,LEVEL_19);
        monsters.put(SPIDER_QUEEN,LEVEL_34);
        monsters.put(NINE_TAILS,LEVEL_49);
        monsters.put(DEATH,LEVEL_60);
        monsters.put(RED_DRAGON,70);
    }
    
    /**
     * Player's visual field 7x7
     */
    public void printVisualField()
    {
        playerRowCoord = player.getRowCoord();
        playerColCoord = player.getColCoord();
        
        for (int i = 0; i < visualField.length; i++)
        {
            
            for (int j = 0; j < visualField.length; j++)
            {
                visualField[0][0] = currentMap[playerRowCoord - 3][playerColCoord - 3];
                visualField[0][1] = currentMap[playerRowCoord - 3][playerColCoord - 2];
                visualField[0][2] = currentMap[playerRowCoord - 3][playerColCoord - 1];
                visualField[0][3] = currentMap[playerRowCoord - 3][playerColCoord];
                visualField[0][4] = currentMap[playerRowCoord - 3][playerColCoord + 1];
                visualField[0][5] = currentMap[playerRowCoord - 3][playerColCoord + 2];
                visualField[0][6] = currentMap[playerRowCoord - 3][playerColCoord + 3];
                
                visualField[1][0] = currentMap[playerRowCoord - 2][playerColCoord - 3];
                visualField[1][1] = currentMap[playerRowCoord - 2][playerColCoord - 2];
                visualField[1][2] = currentMap[playerRowCoord - 2][playerColCoord - 1];
                visualField[1][3] = currentMap[playerRowCoord - 2][playerColCoord];
                visualField[1][4] = currentMap[playerRowCoord - 2][playerColCoord + 1];
                visualField[1][5] = currentMap[playerRowCoord - 2][playerColCoord + 2];
                visualField[1][6] = currentMap[playerRowCoord - 2][playerColCoord + 3];
                
                visualField[2][0] = currentMap[playerRowCoord - 1][playerColCoord - 3];
                visualField[2][1] = currentMap[playerRowCoord - 1][playerColCoord - 2];
                visualField[2][2] = currentMap[playerRowCoord - 1][playerColCoord - 1];
                visualField[2][3] = currentMap[playerRowCoord - 1][playerColCoord];
                visualField[2][4] = currentMap[playerRowCoord - 1][playerColCoord + 1];
                visualField[2][5] = currentMap[playerRowCoord - 1][playerColCoord + 2];
                visualField[2][6] = currentMap[playerRowCoord - 1][playerColCoord + 3];
                
                visualField[3][0] = currentMap[playerRowCoord][playerColCoord - 3];
                visualField[3][1] = currentMap[playerRowCoord][playerColCoord - 2];
                visualField[3][2] = currentMap[playerRowCoord][playerColCoord - 1];
                visualField[3][3] = " " + PLAYER + " ";
                visualField[3][4] = currentMap[playerRowCoord][playerColCoord + 1];
                visualField[3][5] = currentMap[playerRowCoord][playerColCoord + 2];
                visualField[3][6] = currentMap[playerRowCoord][playerColCoord + 3];
                
                visualField[4][0] = currentMap[playerRowCoord + 1][playerColCoord - 3];
                visualField[4][1] = currentMap[playerRowCoord + 1][playerColCoord - 2];
                visualField[4][2] = currentMap[playerRowCoord + 1][playerColCoord - 1];
                visualField[4][3] = currentMap[playerRowCoord + 1][playerColCoord];
                visualField[4][4] = currentMap[playerRowCoord + 1][playerColCoord + 1];
                visualField[4][5] = currentMap[playerRowCoord + 1][playerColCoord + 2];
                visualField[4][6] = currentMap[playerRowCoord + 1][playerColCoord + 3];
                
                visualField[5][0] = currentMap[playerRowCoord + 2][playerColCoord - 3];
                visualField[5][1] = currentMap[playerRowCoord + 2][playerColCoord - 2];
                visualField[5][2] = currentMap[playerRowCoord + 2][playerColCoord - 1];
                visualField[5][3] = currentMap[playerRowCoord + 2][playerColCoord];
                visualField[5][4] = currentMap[playerRowCoord + 2][playerColCoord + 1];
                visualField[5][5] = currentMap[playerRowCoord + 2][playerColCoord + 2];
                visualField[5][6] = currentMap[playerRowCoord + 2][playerColCoord + 3];
                
                visualField[6][0] = currentMap[playerRowCoord + 3][playerColCoord - 3];
                visualField[6][1] = currentMap[playerRowCoord + 3][playerColCoord - 2];
                visualField[6][2] = currentMap[playerRowCoord + 3][playerColCoord - 1];
                visualField[6][3] = currentMap[playerRowCoord + 3][playerColCoord];
                visualField[6][4] = currentMap[playerRowCoord + 3][playerColCoord + 1];
                visualField[6][5] = currentMap[playerRowCoord + 3][playerColCoord + 2];
                visualField[6][6] = currentMap[playerRowCoord + 3][playerColCoord + 3];
                
                System.out.print(visualField[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Set a single object on the map at given location
     */
    public void setObject(int row, int col, String obj)
    {
        for (int i = 0; i < currentMap.length; i++)
        {
            for (int j = 0; j < currentMap.length; j++)
            {
                currentMap[row][col] = obj;
            }
        }
    }
    
    /**
     * print the current room. Developers only
     */
    public void printCurrentRoom()
    {
        playerRowCoord = player.getRowCoord();
        playerColCoord = player.getColCoord();
               
        for (int i = 0; i < FULL_H; i++)
        {
            for (int j = 0; j < FULL_L; j++)
            {
                currentMap[playerRowCoord][playerColCoord] = " " + PLAYER + " ";
                System.out.print(currentMap[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Move player on the map.
     */
    public void movePlayer(String direction)
    {
        System.out.println(CLEAR);
        System.out.println("\tHP " + playerHp + "\tScore " + player.getScore());
        playerRowCoord = player.getRowCoord();
        playerColCoord = player.getColCoord();
        
        if(direction.equals(UP))
        {
            int nextRowUp = playerRowCoord - 1;
            int check = checkNextSquare(nextRowUp, playerColCoord);
            
            if(check == 1)
            {
                setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(nextRowUp, playerColCoord);
                //this.playerRowCoord --;
            }
                       
        }
        else if(direction.equals(DOWN))
        {
            int nextRowDown = playerRowCoord + 1;
            int check = checkNextSquare(nextRowDown, playerColCoord);
            
            if(check == 1)
            {
                setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(nextRowDown, playerColCoord);
                //this.playerRowCoord ++;
            }
               
        }
        else if(direction.equals(LEFT))
        {
            int nextColLeft = playerColCoord - 1;
            int check = checkNextSquare(playerRowCoord, nextColLeft);
            
            if(check == 1)
            {
                setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(playerRowCoord, nextColLeft);
                //this.playerColCoord --;
            }
               
        }
        else if(direction.equals(RIGHT))
        {
            int nextColRight = playerColCoord + 1;
            int check = checkNextSquare(playerRowCoord, nextColRight);
            
            if(check == 1)
            {
                setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(playerRowCoord, nextColRight);
                //this.playerColCoord ++;
            }
            
        }
        else
            System.out.println("\n\tNot a direction");
            
        printVisualField();
        //printCurrentRoom();
    }
    
    /**
     * Check the next square
     */
    public int checkNextSquare(int nextRow, int nextCol)
    {
        if (currentMap[nextRow][nextCol].contains("  "))
        {
            return 1;
        }
        else if(currentMap[nextRow][nextCol].contains(WALL))
        {
            System.out.println("Cannot go through walls");
            return 0;
        }
        else if(currentMap[nextRow][nextCol].contains(SHOP))
        {
            //see shop
            return 0;
        }
        else if(currentMap[nextRow][nextCol].contains(BLACKSMITH))
        {
            //SEE BLACKSMITH
            return 0;
        }
        else if(currentMap[nextRow][nextCol].contains(CHEST))
        {
            //SEE CHEST
            return 1;
        }
        else if(currentMap[nextRow][nextCol].contains(GOLD))
        {
            //take gold
            return 1;
        }
        else if(currentMap[nextRow][nextCol].contains(ITEM))
        {
            //take random item
            return 1;
        }
        else 
        {
            String character = currentMap[nextRow][nextCol];
            Monster monster = findMonster(character);
            
            if (monster != null)
            {
                 
                int result = action(monster);
                
                if(result > 0)
                {
                    return 1;
                }
            }
            playerHp = player.getHitPoints();
        }
        return 0;
    }
    
    /**
     * get the map description
     */
    public void getDescription()
    {
        System.out.println(description);
    }
    
    /**
     * get the map level
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     * Get the map name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Find which monster we are dealing with.
     */
    private Monster findMonster(String character)
    {
        for (String monsterName : monsters.keySet())     
        {
            if (monsterName.equals(character))
            {
                int monsterLevel = monsters.get(monsterName);
                
                Monster monster = new Monster(monsterName,monsterLevel);
                
                return monster;
            }
        }
        return null;
    }
    
    /**
     * fast-forward fight
     */
    public int action(Monster monster)//move into Game
    {
        //Monster monster = findMonster(level);
        //Monster boss = findMonster(lvl - 1);
        
        if (monster != null)// || boss!= null)
        {
            int playerAtk = player.atack();
            int monsterAtk = monster.atack();
            
            do
            {
                monster.recieveDmg(playerAtk);
                player.recieveDmg(monsterAtk);
                
            }
            while(player.checkHealth() == true && monster.checkHealth() == true);
            
        }
        
        return player.getHitPoints();
    }
    
    /**
     * create a the walls and center of a given map name
     */
    public void createMap(String [][] name)
    {
        //map walls and empty center
        for(int i = 0; i < FULL_H;i++)
        {
            for(int j = 0; j < FULL_L; j++)
            {
                name[i][j] = square;
            }
        }
        //top
        for(int i = 0; i < MAP_EDGE; i++)
        {
            for (int j = 0; j < FULL_L; j++)
            {
                name[i][j] = WALL;
            }
        }
        //bottom
        for(int i = FULL_H - MAP_EDGE; i < FULL_H; i++)
        {
            for (int j = 0; j < FULL_L; j++)
            {
                name[i][j] = WALL;
            }
        }
        //left
        for(int i = 0; i < FULL_H; i++)
        {
            for (int j = 0; j < MAP_EDGE; j++)
            {
                name[i][j] = WALL;
            }
        }
        //right
        for(int i = 0; i < FULL_H; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                name[i][j] = WALL;
            }
        }
        
    }
    
    /**
     * add an amount of objects in a map.
     */
    private void addObjects(String[][] map,int columnMin, int columnMax, int rowMin, int rowMax, String object, int amount)
    {
        
        for(int i = 0; i < amount; i++)
        {
            int randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
            int randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
            
            map[randomRow][randomCol] = object;
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
                town[i][j] = WALL;
            }
        }
        //add forest entrance
         for (int i = FOREST_ENTRANCE_START; i < FOREST_ENTRANCE_END; i++)
        {
            for(int j = WALL_START; j < WALL_END; j++)
            {
                town[i][j] = square;
            }
        }
        //add objects
        for (int i = 0; i < FULL_H; i++)
        {
            for(int j = 0; j < FULL_L; j++)
            {
                town[SHOP_ROW][SHOP_COL] = SHOP;
                town[BLACKSMITH_ROW][BLACKSMITH_COL] = BLACKSMITH;
                town[PERSON_1_ROW][PERSON_1_COL] = PERSON_1;
                town[PERSON_2_ROW][PERSON_2_COL] =PERSON_2;
                town[PERSON_3_ROW][PERSON_3_COL] =PERSON_3;
                town[PERSON_4_ROW][PERSON_4_COL] =PERSON_4;
                town[PERSON_5_ROW][PERSON_5_COL] =PERSON_5;
                town[GUARD_ROW][GUARD_COL] = GUARD;
                town[STABLE_ROW][STABLE_COL] = STABLE;
                
            }
        }
        
        for(int i = 0; i < FULL_H; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town[i][j] = TREE;
            }
        }
        
        //add monsters, trees, etc
        addObjects(town, WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, TREE, 100);
        addObjects(town, WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, BLACK_BEAR, 20);
        addObjects(town, WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, WHITE_TIGER, 15);
        addObjects(town, WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, APE_THROWER, 10);
        addObjects(town, WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, BERA, 1);
        addObjects(town, WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, TIGRIS, 1);
        addObjects(town, WALL_END + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, APE_KING, 1);
            
        //add trees to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town[i][j] = TREE;
            }
        }
    }
    
    /**
     * print town map. Developers only
     */
    public void printTownMap()
    {
        createMap(town);
        addObjectsToTown();
        for(int i = 0; i < FULL_H; i++)
        {
            for(int j = 0; j < FULL_L; j++)
            {
               System.out.print(town[i][j]);
            }
            System.out.println("");
        }
        
    }
    
    /**
     * set the curent map to a given map name
     */
    public void setCurrentMap(String name)
    {
        if (name.toLowerCase().equals("town"))
        {
            createMap(town);
            addObjectsToTown();         
            for(int i = 0; i < FULL_H; i++)
            {
                for(int j = 0; j < FULL_L; j++)
                {
                    currentMap[i][j] = town[i][j];
                }
            }
        }
        else
            System.out.println("error");
        
    }
    
        public void getPlayerAttr()
    {
        player.getPlayerAttributes();
    }
}    