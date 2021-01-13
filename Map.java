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
    public static final String SQUARE = "   ";
    public static final String TOWN = "Town";
    public static final String FORTRESS = "Fortress";
    public String map[][]  = new String[47][35];
    public static final Random RAND = new Random();
    
    //private String description;
    private String name;
    
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
     * Add barels and bags on the map
     */
    public void addBarrels(int mapEdge,int amount, String wall, String character)
    {
        int minAmount = 1;
        int length = 0;
        
        // switch (name)
        // {
            // case FORTRESS: 
                // for (int i = mapEdge; i < map.length - mapEdge; i ++)
                // {
                            
                    // for(int j = mapEdge; j < map[i].length - 1; j++)
                    // {
                                
                         // if(map[i][j].equals(wall))
                         // {
                             // addObjects(-i, i + 1, -j, j + 1, character, 1);
                 
                             // minAmount++;
                         // }
                                
                         // if(minAmount == amount)  
                             // break;
                    // }  
                            
                // }            
                // break;
             
            // case TOWN: 
                // for (int i = mapEdge; i < map.length - mapEdge; i ++)
                // {
                            
                    // for(int j = mapEdge; j < 10; j++)
                    // {
                                
                         // if(map[i][j].equals(wall))
                         // {
                             // addObjects(-i, i + 1, -j, j + 1, character, 1);
                 
                             // minAmount++;
                         // }
                                
                         // if(minAmount == amount)  
                             // break;
                    // }  
                            
                // }
                // break;
        //}
        
        
        
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
            randomRow = RAND.nextInt(rowMax - rowMin) + rowMin;
            randomCol = RAND.nextInt(columnMax - columnMin) + columnMin;
                
            if(map[randomRow][randomCol] != SQUARE)
            {
                amount--;     
                
            }
            
            map[randomRow][randomCol] = object;
        }
        
    }
    
    // /**
     // * add an amount of objects in an empty square on the map
     // */
    // public void addObjects(int columnMin, int columnMax, int rowMin, int rowMax, String object, int amount)
    // {
        // int randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
        // int randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
        // //int i = 0;
        // while(true)
        // {
            
            // if(map[randomRow][randomCol] != SQUARE)
            // {
                // randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
                // randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
                    // // i++;
                    // // if(i % 5 == 0)
                        // // break;
                    // // System.out.println(i);
            // }
            // else
            // {
                // map[randomRow][randomCol] = object;
                // randomRow = rand.nextInt(rowMax - rowMin) + rowMin;
                // randomCol = rand.nextInt(columnMax - columnMin) + columnMin;
                    
                // amount --;
                    
                // if(amount == 0)
                    // break;
                        
            // }
            
        // }
    // }
        
    /**
     * @return a square value
     */
    public String getSquareValue(int row, int col)
    {
        return map[row][col];
        
    }
}    