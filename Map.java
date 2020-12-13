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
    private static final String SQUARE = "   ";
   
    private static final String [][] MAP  = new String[47][35];
        
    public static final Random rand = new Random();
    
    //private String description;
    private final String name;
    
    /**
     * Constructor for the Map
     */
     public Map(String name)//String description)
    {
       // this.description = description;
        this.name = name;

    }
    
    /**
     * Set an object on the map
     */
    public void setOne(int row, int col,String object)
    {
        MAP[row][col] = object;
    }
    
    /**
     * Print a map. Developers only.
     */
    public void printMap()
    {
        for (String[] strings : MAP)
        {
            for (String string : strings)
            {
                System.out.print(string);
            }
            System.out.println("");
        }
    }
    
    /**
     * @return the current map
     */
    public String[][] getMap()
    {
        return MAP;
    }

    /**
     * Get the map name
     */
    public String getName()
    {
        return name;
    }
     
    /**
     * Create a the walls and center of a map.
     */
    public void createMap(String walls,int mapEdge)
    {
        //map walls and empty center
        for (String[] strings : MAP)
        {
            Arrays.fill(strings, SQUARE);
        }
        //top
        for(int i = 0; i < mapEdge; i++)
        {
            Arrays.fill(MAP[i], walls);
        }
        //bottom
        for(int i = MAP.length - mapEdge; i < MAP.length; i++)
        {
            Arrays.fill(MAP[i], walls);
        }
        //left
        for(int i = 0; i < MAP.length; i++)
        {
            for (int j = 0; j < mapEdge; j++)
            {
                MAP[i][j] = walls;
            }
        }
        //right
        for(int i = 0; i < MAP.length; i++)
        {
            for (int j = MAP[i].length - mapEdge; j < MAP[i].length; j++)
            {
                MAP[i][j] = walls;
            }
        }
        
    }
        
    /**
     * Re-spawn a monster in an empty square on the map
     */
    public void addObjects(int columnMin, int columnMax, int rowMin, int rowMax, String object, int amount)
    {
        int randomRow = 0;  
        int randomCol = 0;
        
        for(int i = 0; i < amount; i++)
        {
            
            while(!MAP[randomRow][randomCol].equals(SQUARE))
            {
                randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
                randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
            
            }

            MAP[randomRow][randomCol] = object;
        }
        
    }
        
    /**
     * @return a square value
     */
    public String getSquareValue(int row, int col)
    {
        return MAP[row][col];
        
    }
}    