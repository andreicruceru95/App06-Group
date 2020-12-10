
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Display
{
    public static final char CLEAR = '\u000c';
    private Commands command;
    private Input reader = new Input();
    
    public void listOptions(String[] list)
    {
        System.out.println(CLEAR);
        
        for(int i = 0; i < list.length; i++)
        {
            System.out.println(list[i]);
        }
        
    }
    
    /**
     * Display a given list as a story.
     */
    public void runStory(String[] part)
    {
        System.out.println(CLEAR);
        
        for(int i = 0; i < part.length; i ++)
        {
            System.out.println(command.PRESS_ANY.getCommand());
            reader.getAny();
            
            System.out.println(CLEAR);
            
            System.out.println(part[i]);
        }
        
    }
}
