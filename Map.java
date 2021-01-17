import java.util.*;
import java.io.Serializable;

/**
 * The game map.
 * Creates the map edges and square values.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Map implements Serializable
{
    public static final String SQUARE = "   ";
    public static final String TOWN = "Town";
    public static final String FORTRESS = "Fortress";
    public String map[][]  = new String[47][35];
    public static final Random RAND = new Random();
    
    //private String description;
    private String name;
    int amount = 0;
    /**
     * Constructor for the Map
     */
     public Map(String name)
    {
        this.name = name;
        
    }
    
    /**
     * Set an object on the map
     */
    public void setOne(int row, int col,String object)
    {
        map[row][col] = object;
        
    }
    
    public int getAmount()
    {
        return amount;
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
     * Add an anvil on the map
     */
    public void addAnvil(int i, int j)
    {
        map[i][j - 1] = Characters.ROCK.getCharacter();
        map[i][j + 1] = Characters.ROCK.getCharacter();
        map[i + 1][j - 1] = Characters.ROCK.getCharacter();
        map[i + 1][j] = Characters.ROCK.getCharacter();
        map[i + 1][j + 1] = Characters.ROCK.getCharacter();
        map[i][j] = Characters.ANVIL.getCharacter();
    }
    
    /**
     * Check if the map contains monsters.
     * Tower only.
     */
    public int checkForMonsters(String object)
    {
        amount = 0;
        
        for(int i = 14; i < 28; i++)
        {
            
            for(int j = 10; j < 23; j++)
            {
                
                if(map[i][j].equals(object))
                    amount ++;
                    
            }
            
        }
        
        return amount;
    }
    
    /**
     * 
     */
    public void addSmashable(int rowMin, int rowMax, int colMin, int colMax, String object)
    {
        for(int i = rowMin; i < rowMax; i ++)
        {
            
            for(int j = colMin; j < colMax; j++)
            {
                
                if(map[i][j].equals(Characters.WALL.getCharacter()))                
                    if(RAND.nextBoolean())
                        addObjects(j - 1, j + 1, i - 1, i + 1, object, 1);
                    
            }
            
        }
    }
    
    /**
     * add an amount of objects in an empty square on the map
     */
    public void addObjects(int columnMin, int columnMax, int rowMin, int rowMax, String object, int amount)
    {
        int randomRow = 0;  
        int randomCol = 0;
        int maxCombinations = 8;
        
        for(int i = 0; i < amount; i++)
        {
            randomRow = RAND.nextInt(rowMax - rowMin) + rowMin;
            randomCol = RAND.nextInt(columnMax - columnMin) + columnMin;
                
            if(map[randomRow][randomCol] != SQUARE)
            {
                amount--;     
                maxCombinations --;
            }
            else
                map[randomRow][randomCol] = object;
            
            if(maxCombinations == 0)
                break;
                
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