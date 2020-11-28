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
    private static final String currentMap[][] = new String[39][39];
    private static final int MAP_L = 27;
    private static final int MAP_H = 39;
    
    private static final String visualField[][] = new String[5][5];
    private static final int initialPlayerRow = 2;
    private static final int initialPlayerCol = 2;
    
    private static final String dessert[][]= new String[39][39];
    
    private static final int ROOM_L = 10;
    private static final String town[][] = new String[40][28];
    
    private static final String PLAYER = "P";
    private static final String UP = "w";
    private static final String DOWN = "s";
    private static final String LEFT = "a";
    private static final String RIGHT = "d";
    private static final String WALL = "[/]";
    private static final String BLACKSMITH = "B";
    private static final String SHOP = "S";
    private static final String CHEST = "!?";
    private static final String GOLD = "$";
    private static final String ITEM = "!^";
    private static final String MONSTER = "①";
    private static final String BOSS = "!B";
    private static final String ABANDONED_HOUSE = "H";
    private static final String MAIN_QUEST = "!";
    private static final String QUEST_HUSBAND = "Q1";
    private static final String QUEST_FARM = "Q2";
    private static final String QUEST_WOLF = "Q3";
    private static final String MISSING_HUSBAND = "??";
    
    private Random rand;
    private Player player;
    
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private ArrayList<Item> items = new ArrayList<Item>();
    
    private String square = "   ";
    
    private String description;
    private String name;
    private int level;
    private int playerRowCoord = 3;
    private int playerColCoord = 3;
    
    /**
     * Contructor method for the room.
     * Room(map) has a name, a description and  a level which will define the items and monsters range of levels.
     * The room can have up to 4 exists defined at the creation. and a possible npc.
     */
    public Map(int level, String name, String playerName)
    {
        rand = new Random();
        this.description = description;
        this.level = level;
        this.name = name;
        player = new Player(playerName);
        
        //createRoom(e1,e2,e3,e4,npc);
        printTownMap();
        setCurrentMap("town");
        // create monsters
        monsters.add(new Monster("Black Bear", 1));
        monsters.add(new Monster("White Tiger", 5));
        monsters.add(new Monster("Ape Thrower", 10));
        monsters.add(new Monster("Ape General", 15));
        monsters.add(new Monster("Scorpion", 20));
        monsters.add(new Monster("Snake Archer", 25));
        monsters.add(new Monster("Grizly Bear", 30));
        monsters.add(new Monster("Yeti", 35));
        monsters.add(new Monster("Demon", 40));
        monsters.add(new Monster("Cursed Zombie", 45));
        monsters.add(new Monster("Bera", 4));
        monsters.add(new Monster("Tigris", 9));
        monsters.add(new Monster("Ape King", 14));
        monsters.add(new Monster("Spider Queen", 29));
        monsters.add(new Monster("Nine Tails", 34));
        monsters.add(new Monster("Death", 44));
                
    }
    
    /**
     * Visual field of the player.
     */
    public void printVisualField()
    {
        playerRowCoord = player.getRowCoord();
        playerColCoord = player.getColCoord();
        
        for (int i = 0; i < visualField.length; i++)
        {
            
            for (int j = 0; j < visualField.length; j++)
            {
                visualField[0][0] = currentMap[playerRowCoord - 2][playerColCoord - 2];
                visualField[0][1] = currentMap[playerRowCoord - 2][playerColCoord - 1];
                visualField[0][2] = currentMap[playerRowCoord - 2][playerColCoord];
                visualField[0][3] = currentMap[playerRowCoord - 2][playerColCoord + 1];
                visualField[0][4] = currentMap[playerRowCoord - 2][playerColCoord + 2];
                
                visualField[1][0] = currentMap[playerRowCoord - 1][playerColCoord - 2];
                visualField[1][1] = currentMap[playerRowCoord - 1][playerColCoord - 1];                
                visualField[1][2] = currentMap[playerRowCoord - 1][playerColCoord];
                visualField[1][3] = currentMap[playerRowCoord - 1][playerColCoord + 1];
                visualField[1][4] = currentMap[playerRowCoord - 1][playerColCoord + 2];
                
                visualField[2][0] = currentMap[playerRowCoord][playerColCoord - 2];
                visualField[2][1] = currentMap[playerRowCoord][playerColCoord -1];
                visualField[2][2] = " " + PLAYER + " ";
                visualField[2][3] = currentMap[playerRowCoord][playerColCoord + 1];
                visualField[2][4] = currentMap[playerRowCoord][playerColCoord + 2];
                
                visualField[3][0] = currentMap[playerRowCoord + 1][playerColCoord - 2];
                visualField[3][1] = currentMap[playerRowCoord + 1][playerColCoord - 1];
                visualField[3][2] = currentMap[playerRowCoord + 1][playerColCoord];
                visualField[3][3] = currentMap[playerRowCoord + 1][playerColCoord + 1];
                visualField[3][4] = currentMap[playerRowCoord + 1][playerColCoord + 2];
                
                visualField[4][0] = currentMap[playerRowCoord + 2][playerColCoord - 2];
                visualField[4][1] = currentMap[playerRowCoord + 2][playerColCoord -1];
                visualField[4][2] = currentMap[playerRowCoord + 2][playerColCoord];
                visualField[4][3] = currentMap[playerRowCoord + 2][playerColCoord + 1];
                visualField[4][4] = currentMap[playerRowCoord + 2][playerColCoord + 2];
                
                System.out.print(visualField[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Set values in the 2D map.
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
     * Print the room. Will be hidden to the player.
     */
    public void printCurrentRoom()
    {
        playerRowCoord = player.getRowCoord();
        playerColCoord = player.getColCoord();
        
        for (int i = 0; i < currentMap.length; i++)
        {
            for (int j = 0; j < currentMap.length; j++)
            {
                currentMap[playerRowCoord][playerColCoord] = " " + PLAYER + " ";
                System.out.print(currentMap[i][j]);
            }
            System.out.println("");
        }
    }
        
    /**
     * move player in a direction
     */
    public void movePlayer(String direction)
    {
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
     * check the next square.
     * @return 1 if the next square can be walked uppon/modified,
     * @return 0 if it cannot.
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
        else if(currentMap[nextRow][nextCol].contains(MONSTER) )//|| currentMap[nextRow][nextCol].equals(BOSS))
        {
            int result = action();
            
            if(result > 0)
            {
                return 1;
            }
        }
        
        else
        {
            System.out.println("\t\t\t\tYou can't do that");
            return 0;
        }   
        return 0;    
    }
    
    /**
     * Get the room/map description.
     */
    public void getDescription()
    {
        System.out.println(description);
    }
    
    /**
     * return the map level.
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     * return the map name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Skip-forward in a fight.
     */
    public int action()//move into Game
    {
        Monster monster = findMonster(level);
        //Monster boss = findMonster(lvl - 1);
        
        if (monster != null)// || boss!= null)
        {
            int playerAtk = player.atack();
            int monsterAtk = monster.atack();
            
            do
            {
                monster.recieveDamage(playerAtk);
                player.recieveDamage(monsterAtk);
                
            }
            while(player.checkHealth() == true && monster.checkHealth() == true);
            
        }
        
        return player.getHitPoints();
    }
    
    /**
     * Find a monster's level. (Monster level will be in the same range as the map).
     */
    private Monster findMonster(int level)
    {
        for (Monster monster : monsters)
        {
            if (monster.getLevel() == level)
            {
                return monster;
            }
        }
        return null;
    }
    
    private void createMap(String [][] mapName)
    {
        //external walls and empty squares
        for (int i = 0; i < MAP_H; i++)
        {
            for (int j = 0; j < MAP_L; j++)
            {
                town[i][j] = square;
                town[i][0] = WALL;
                town[i][26] = WALL;
                town[0][j] = WALL;
                town[38][j] =WALL;                
            }
        }
                
    }
    
    private void addObjects(String[][] map,int columnMin, int columnMax, int rowMin, int rowMax, String object, int amount)
    {
        //adding trees in random squares in the forest
        for(int i = 0; i < amount; i++)
        {
            int randomRow = rand.nextInt(rowMax) + rowMin;
            int randomCol = rand.nextInt(columnMax) + columnMin;
            town[randomRow][randomCol] = object;
        }
        
        // //adding monsters in random squares on the map
        // for(int i = 0; i < 25; i++)
        // {
            // int randomCol = rand.nextInt(25) + 1;
            // int randomRow = rand.nextInt(17) + 17;
            // town[randomRow][randomCol] = " M1";
        // }
    }
    
    private void createTownMapObjects()
    {
        createMap(town);
        //wall at row 0-15, col 6
        for(int i = 0; i < 15; i++)
        {
            town[i][6] = WALL;// + " ";
            //town[i][22] = " " + WALL + " ";
            town[i][23] = WALL;
            town[i][24] = WALL;
            town[i][25] = WALL;
        }
                
        //wall at row 0-5, col 13
        for(int i = 0; i < 5; i++)
        {
            town[i][13] = WALL;
        }
        
        //wall at row 5, col 0-14
        for(int j = 0; j < 14; j++)
        {
            town[5][j] = WALL;
        }
        
        //walls at rows 10-14 col 0-6
        for(int j = 0; j < 6; j++)
        {
            town[10][j] = WALL;
            town[12][j] = WALL;
            town[13][j] = WALL;
            town[14][j] = WALL;
        }
        
        //wall separating the market and the forest
        for(int j = 0; j < MAP_L; j++)
        {
            town[15][j] = WALL;
        }
        
        //adding doors/walkways/items/quest and people on the map
        town[2][6] = square;
        town[2][13] = square;
        town[4][22] = square;
        town[4][23] = square;
        town[4][24] = square;   
        town[4][25] = square;
        town[10][3] = square;
        town[10][22] = square;
        town[10][23] = square;
        town[10][24] = square;
        town[10][25] = square;
        town[11][1] = square;
        town[11][2] = square;
        town[11][3] = square;
        town[11][4] = square;
        town[11][5] = square;
        town[11][6] = square;
        town[15][12] = square;
        town[15][13] = square;
        town[15][14] = square;
        town[15][15] = square;
        
        //add people/quests on the map.
        town[2][22] = " " + SHOP+ " ";
        town[4][25] = " " + CHEST;
        town[8][22] = " " + BLACKSMITH + " ";
        town[13][22] = " " + ABANDONED_HOUSE + " ";
        town[4][12] = " " + MAIN_QUEST + " ";
        town[9][8] = " " + QUEST_HUSBAND;
        town[14][10] = " " + QUEST_FARM;
        town[13][18] = " " + QUEST_WOLF;
        town[33][22] = " " + MISSING_HUSBAND;
        
        addObjects(town,1, 24, 17, 19, " ¥ ", 50);
        addObjects(town,1, 24, 17, 19, " " + MONSTER, 25);
        
        //add farm walls
        for (int i = 33; i < MAP_H; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                town[33][j] = WALL;
                town[i][10] = WALL;
                
            }
        }
        town[36][10] = square;
    
    }
    
    public void printTownMap()
    {
        createTownMapObjects();
                 
        for(int i = 0; i < MAP_H; i++)
        {
            for(int j = 0; j < MAP_L; j++)
            {
               System.out.print(town[i][j]);
            }
            System.out.println("");
        }
        
    }
    
    public void setCurrentMap(String name)
    {
        if (name.toLowerCase().equals("town"))
        {
                       
            for(int i = 0; i < MAP_H; i++)
            {
                for(int j = 0; j < MAP_L; j++)
                {
                    currentMap[i][j] = town[i][j];
                }
            }
        }
        else
            System.out.println("error");
        
        printCurrentRoom();
    }
    
    /**
     * Create map Dessert
     */
    public void createDessertMapObjects()
    {
        createMap(dessert);
        createDessertMapObjects();
    }
    
    /**
     * 
     */
    public void createDesertMapObjects()
    {
        addObjects(dessert,1, MAP_L, 1, MAP_H, " M1", 25);
        addObjects(dessert,1, MAP_L, 1, MAP_H, " M2", 50);
        addObjects(dessert,1, MAP_L, 1, MAP_H, " M3", 75);
    }
    
    public void printDessertMap()
    {
        createDessertMapObjects();
        
        for(int i = 0; i < MAP_H; i++)
        {
            for(int j = 0; j < MAP_L; j++)
            {
               System.out.print(dessert[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void getPlayerHp()
    {
        player.getPlayerAttributes();
    }
}    