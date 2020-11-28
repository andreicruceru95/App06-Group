import java.util.*;

/**
 * This class will make the conection between maps.
 *
 * @author Andrei Cruceru
 * @version 28112020
 */
public class World
{
    private static final String [][] fMap = new String [24][37];
    
    private HashMap<String, Map> map = new HashMap<String, Map>(); 
    
    private String name;
    
    public World(String name)
    {
        // Room home = new Room(1,"Home","\tThis is your home in Wycombe Valley town.\nThere is only few people around the town. What is going on?", "   ", " # "," # "," # ", "   ");
        // Room shop = new Room(2,"Shop","\tA small shop still operating in town.\nThe owner thought he is too old to leave and start a new life..."
                                // + "\nHave a look! He might sell something ussefull", " # ","   ", " # "," # ", " S ");
        // Room blacksmith = new Room(3,"Blacksmith","\tYou can improve your equipment here!\nIt can't be free unfortunately, we all need some coins.", " # ", " # "," # ","   ", " B ");
        // Room house1 = new Room(4,"House","\tIt seems to be an old, abandoned house.\nI can't see an entrance..", " # ", " # "," # "," # ", "   ");
        // Room stable = new Room(5,"Stable","\tThis could be ussefull!.\nYou don't know how to ride a horse unfortunately!", " # ", " # "," # "," # ", " S ");
        // Room market = new Room(6,"Market","\tThis was once one of the busiest towns.\nWe hope one day someone could save the world from the " +
                                // "evil who caused this, and restore the peace.",  "  ","  ","  ","  ", " ? ");
        // Room forest = new Room(7, "Forest", "\tThe forest around the town. \nBe carefull, the creatures are violent.","   ", " # "," # "," # ", " # "); 
    }
        
}