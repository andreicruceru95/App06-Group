
/**
 * Display messages.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class Display
{
    public static final char CLEAR = '\u000c';
    public static final Input READER = new Input();
    
    /**
     * Print a list.
     */
    public void listOptions(String[] list)
    {
        System.out.println(CLEAR);

        for (String s : list)
        {
            if(s != null)
                System.out.println(s);
        }
        
    }
    
    /**
     * Display a given list as a story.
     */
    public void runStory(String[] part)
    {
        System.out.println(CLEAR);

        for (String s : part)
        {
            System.out.println(Commands.PRESS_ANY.getCommand());
            READER.getAny();

            System.out.println(CLEAR);

            System.out.println(s);
        }
        
    }
}
