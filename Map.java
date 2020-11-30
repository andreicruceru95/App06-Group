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
    private static final String CURRENT_MAP[][] = new String[47][35];
    private static final String visualField[][] = new String[7][7];
    private String map[][]  = new String[47][35];
    private static final String PLAYER = "O";
    
    private Random rand;
    private String square = "   ";
    
    private String description;
    private String name;
    
    
    /**
     * Constructor for the Map
     */
     public Map(String name, String[][] map,String description, int height,int length)
    {
        rand = new Random();
        this.description = description;
        this.name = name;
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < length; j++)
            {
                this.map[i][j] = map[i][j];
            }
        }
        
    }
        
    /**
     * Set a single object on the map at given location
     */
    public void setObject(int row, int col, String obj, int height, int length)
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < length; j++)
            {
                map[i][i] = obj;
            }
        }
    }
    
    /**
     * Set an object on the map
     */
    public void setOne(int row, int col,String object)
    {
        map[row][col] = object;
    }
    
    /**
     * print a map
     */
    public void printMap(int height, int length)
    {
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < length; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * @return the current map
     */
    public String[][] getmap()
    {
        return map;
    }
    
    /**
     * get the map description
     */
    public void getDescription()
    {
        System.out.println(description);
    }
    
    /**
     * Get the map name
     */
    public String getName()
    {
        return name;
    }
     
    /**
     * create a the walls and center of a given map name
     */
    public void createMap(String walls,int height, int length, int mapEdge)
    {
        //map walls and empty center
        for(int i = 0; i < height;i++)
        {
            for(int j = 0; j < length; j++)
            {
                map[i][j] = square;
            }
        }
        //top
        for(int i = 0; i < mapEdge; i++)
        {
            for (int j = 0; j < length; j++)
            {
                map[i][j] = walls;
            }
        }
        //bottom
        for(int i = height - mapEdge; i < height; i++)
        {
            for (int j = 0; j < length; j++)
            {
                map[i][j] = walls;
            }
        }
        //left
        for(int i = 0; i < height; i++)
        {
            for (int j = 0; j < mapEdge; j++)
            {
                map[i][j] = walls;
            }
        }
        //right
        for(int i = 0; i < height; i++)
        {
            for (int j = length - mapEdge; j < length; j++)
            {
                map[i][j] = walls;
            }
        }
        
    }
    
    /**
     * add an amount of objects in a map.
     */
    public void addObjects(int columnMin, int columnMax, int rowMin, int rowMax, String object, int amount)
    {
        for(int i = 0; i < amount; i++)
        {
            int randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
            int randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
            
            map[randomRow][randomCol] = object;
        }
    }
    
    /**
     * Re-spawn a monster in an empty square on the map
     */
    public void reSpawn(int columnMin, int columnMax, int rowMin, int rowMax, String object)
    {
        int randomRow = 0;  
        int randomCol = 0;
        
        while(map[randomRow][randomCol] != square)
        {
            randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
            randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
            
        }
        map[randomRow][randomCol] = object;
    }
    
    
    /**
     * Player's visual field 7x7
     */
    public void printVisualField(int playerRowCoord, int playerColCoord)
    {
        for (int i = 0; i < visualField.length; i++)
        {
            for (int j = 0; j < visualField.length; j++)
            {
                visualField[0][0] = map[playerRowCoord - 3][playerColCoord - 3];
                visualField[0][1] = map[playerRowCoord - 3][playerColCoord - 2];
                visualField[0][2] = map[playerRowCoord - 3][playerColCoord - 1];
                visualField[0][3] = map[playerRowCoord - 3][playerColCoord];
                visualField[0][4] = map[playerRowCoord - 3][playerColCoord + 1];
                visualField[0][5] = map[playerRowCoord - 3][playerColCoord + 2];
                visualField[0][6] = map[playerRowCoord - 3][playerColCoord + 3];
                
                visualField[1][0] = map[playerRowCoord - 2][playerColCoord - 3];
                visualField[1][1] = map[playerRowCoord - 2][playerColCoord - 2];
                visualField[1][2] = map[playerRowCoord - 2][playerColCoord - 1];
                visualField[1][3] = map[playerRowCoord - 2][playerColCoord];
                visualField[1][4] = map[playerRowCoord - 2][playerColCoord + 1];
                visualField[1][5] = map[playerRowCoord - 2][playerColCoord + 2];
                visualField[1][6] = map[playerRowCoord - 2][playerColCoord + 3];
                
                visualField[2][0] = map[playerRowCoord - 1][playerColCoord - 3];
                visualField[2][1] = map[playerRowCoord - 1][playerColCoord - 2];
                visualField[2][2] = map[playerRowCoord - 1][playerColCoord - 1];
                visualField[2][3] = map[playerRowCoord - 1][playerColCoord];
                visualField[2][4] = map[playerRowCoord - 1][playerColCoord + 1];
                visualField[2][5] = map[playerRowCoord - 1][playerColCoord + 2];
                visualField[2][6] = map[playerRowCoord - 1][playerColCoord + 3];
                
                visualField[3][0] = map[playerRowCoord][playerColCoord - 3];
                visualField[3][1] = map[playerRowCoord][playerColCoord - 2];
                visualField[3][2] = map[playerRowCoord][playerColCoord - 1];
                visualField[3][3] = " " + PLAYER + " ";
                visualField[3][4] = map[playerRowCoord][playerColCoord + 1];
                visualField[3][5] = map[playerRowCoord][playerColCoord + 2];
                visualField[3][6] = map[playerRowCoord][playerColCoord + 3];
                
                visualField[4][0] = map[playerRowCoord + 1][playerColCoord - 3];
                visualField[4][1] = map[playerRowCoord + 1][playerColCoord - 2];
                visualField[4][2] = map[playerRowCoord + 1][playerColCoord - 1];
                visualField[4][3] = map[playerRowCoord + 1][playerColCoord];
                visualField[4][4] = map[playerRowCoord + 1][playerColCoord + 1];
                visualField[4][5] = map[playerRowCoord + 1][playerColCoord + 2];
                visualField[4][6] = map[playerRowCoord + 1][playerColCoord + 3];
                
                visualField[5][0] = map[playerRowCoord + 2][playerColCoord - 3];
                visualField[5][1] = map[playerRowCoord + 2][playerColCoord - 2];
                visualField[5][2] = map[playerRowCoord + 2][playerColCoord - 1];
                visualField[5][3] = map[playerRowCoord + 2][playerColCoord];
                visualField[5][4] = map[playerRowCoord + 2][playerColCoord + 1];
                visualField[5][5] = map[playerRowCoord + 2][playerColCoord + 2];
                visualField[5][6] = map[playerRowCoord + 2][playerColCoord + 3];
                
                visualField[6][0] = map[playerRowCoord + 3][playerColCoord - 3];
                visualField[6][1] = map[playerRowCoord + 3][playerColCoord - 2];
                visualField[6][2] = map[playerRowCoord + 3][playerColCoord - 1];
                visualField[6][3] = map[playerRowCoord + 3][playerColCoord];
                visualField[6][4] = map[playerRowCoord + 3][playerColCoord + 1];
                visualField[6][5] = map[playerRowCoord + 3][playerColCoord + 2];
                visualField[6][6] = map[playerRowCoord + 3][playerColCoord + 3];
                
                System.out.print(visualField[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Check the visual field of the player for a given character
     */
    public boolean checkVisualField(String character)
    {
        for(int i = 0; i < visualField.length; i++)
        {
            for(int j = 0; j < visualField.length; j++)
            {
                if (visualField[i][j].contains(character))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * @return a square value
     */
    public String getSquareValue(int row, int col)
    {
        return map[row][col];
        
    }
}    