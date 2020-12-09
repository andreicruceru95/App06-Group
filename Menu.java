
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    public Menu()
    {
    }
    
    public void listOptions(String[] list)
    {
        
        for(int i = 0; i < list.length; i++)
        {
            System.out.println(list[i]);
        }
        
    }
}
