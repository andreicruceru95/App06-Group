import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This class contains the Main method that will run the game.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Main
{
    private static final char CLEAR = '\u000c';
    private Game game;
    
    /**
     * Run the game
     */    
    public Main()
    {
        System.out.println(CLEAR);
        
        game = new Game();
        
        try
        {
            saveGame();
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
    
    /**
     * Save player's data
     */
    private void saveGame() throws Exception
    {
        final FileOutputStream FOS = new FileOutputStream("Game-data.txt");
        final ObjectOutputStream OOS = new ObjectOutputStream(FOS);
        
        OOS.writeObject(game);
        
        OOS.close();
        
        final FileInputStream FIS = new FileInputStream("Game-data.txt");
        final ObjectInputStream OIS = new ObjectInputStream(FIS);          
        Game newGame = (Game) OIS.readObject();
        
        newGame.run();
        
        OIS.close();
    }
    
}

