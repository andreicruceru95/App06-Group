import java.util.*;

/**
 * The game map.
 * Creates the map edges and square values.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Map
{
    private static final String SQUARE = "   ";
   
    private String map[][]  = new String[47][35];
        
    private Random rand = new Random();
    
    //private String description;
    private String name;
    
    /**
     * Constructor for the Map
     */
     public Map(String name)
    {
        //rand = 
        //this.description = description;
        this.name = name;
        
        //this.map = map;
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
    public void printMap()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
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
     * Get the map name
     */
    public String getName()
    {
        return name;
    }
     
    /**
     * Create the walls and center of a map.
     */
    public void createMap(String walls,int mapEdge)
    {
        //map walls and empty center
        for(int i = 0; i < map.length;i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                map[i][j] = SQUARE;
            }
        }
        //top
        for(int i = 0; i < mapEdge; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j] = walls;
            }
        }
        //bottom
        for(int i = map.length - mapEdge; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j] = walls;
            }
        }
        //left
        for(int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < mapEdge; j++)
            {
                map[i][j] = walls;
            }
        }
        //right
        for(int i = 0; i < map.length; i++)
        {
            for (int j = map[i].length - mapEdge; j < map[i].length; j++)
            {
                map[i][j] = walls;
            }
        }
        
    }
    /**
     * Check if the map contains monsters.
     * Tower only.
     */
    public boolean checkForMonsters()
    {
        for (int i = 0; i < map.length; i++)
        {

            for (int j = 0; j < map[i].length; j++)
            {

                if(map[i][j] != SQUARE)
                    return false;

            }

        }
        return true;
    }
        
    /**
     * add an amount of objects in an empty square on the map
     */
    public void addObjects(int columnMin, int columnMax, int rowMin, int rowMax, String object, int amount)
    {
        int randomRow = 0;  
        int randomCol = 0;
        
        for(int i = 0; i < amount; i++)
        {
            
            while(map[randomRow][randomCol] != SQUARE)
            {
                randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
                randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
            
            }
            
            map[randomRow][randomCol] = object;
        }
        
    }
        
    /**
     * @return a square value
     */
    public String getSquareValue(int row, int col)
    {
        return map[row][col];
        
    }
}    