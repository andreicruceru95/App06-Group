
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Display
{
    public static final char CLEAR = '\u000c';
    private final Input reader = new Input();
    
    public void listOptions(String[] list)
    {
        System.out.println(CLEAR);

        for (String s : list)
        {
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
            reader.getAny();

            System.out.println(CLEAR);

            System.out.println(s);
        }
        
    }
}
