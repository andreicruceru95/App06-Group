/**
 * Write a description of class Demo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    private Map map;
    private Input reader = new Input();
    
    /**
     * tester
     */    
    public Main()
    {
        System.out.println("Please enter the player's name:");
        String playerName = reader.getString();
        
        map = new Map (1, "Town", playerName);
        
        //map.printTownMap();
        //map.printDessertMap();
        run(); 
    }
    
    /**
     * Main options.
     */
    public void run()
    {
        boolean finished = false;
        while(!finished)
        {
            System.out.println("Chose direction");
            String choice = reader.getString();
            if (choice.equals("quit"))
            {
                finished = true;
            }
            else if(choice.equals("check"))
            {
                map.getPlayerAttr();
            }
            else
                runMenu(choice);
        }
    }
    
    /**
     * Move the player.
     */
    public void runMenu(String choice)
    {
        map.movePlayer(choice);
    }
    
    // /**
     // * Move player 
     // */
    // public void movePlayer(String direction)
    // {
        // if(direction.equals(UP))
        // {
            // int nextRowUp = playerRowCoord - 1;
            // int check = checkNextSquare(nextRowUp, playerColCoord);
            
            // if(check == 1)
            // {
                // setObject(playerRowCoord ,playerColCoord,"   ");
                
                // this.playerRowCoord --;
            // }
                       
        // }
        // else if(direction.equals(DOWN))
        // {
            // int nextRowDown = playerRowCoord + 1;
            // int check = checkNextSquare(nextRowDown, playerColCoord);
            
            // if(check == 1)
            // {
                // setObject(playerRowCoord ,playerColCoord,"   ");
                
                // this.playerRowCoord ++;
            // }
               
        // }
        // else if(direction.equals(LEFT))
        // {
            // int nextColLeft = playerColCoord - 1;
            // int check = checkNextSquare(playerRowCoord, nextColLeft);
            
            // if(check == 1)
            // {
                // setObject(playerRowCoord ,playerColCoord,"   ");
                
                // this.playerColCoord --;
            // }
               
        // }
        // else if(direction.equals(RIGHT))
        // {
            // int nextColRight = playerColCoord + 1;
            // int check = checkNextSquare(playerRowCoord, nextColRight);
            
            // if(check == 1)
            // {
                // setObject(playerRowCoord ,playerColCoord,"   ");
                
                // this.playerColCoord ++;
            // }
            
        // }
        // else
            // System.out.println("\n\tNot a direction");
            
        // printvisualField();
        // printRoom();
    // }
}

