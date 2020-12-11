
/**
 * Write a description of class Storyline here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Storyline
{
    private Commands command;
    
    public String[] getPartOne()
    {
        String [] partOne = new String[] 
        {
            "\t\tOnce upon a time the world was once a beautiful and peaceful place,\n" + 
            "\tbut one day things changed when evil creatures start appearing everywhere..",
            "\t\tPeople of the lands known as gladiators,\n\tthe best of the human race had to offer " + 
            "were ready for such a day to come \n\tbut when their people needed them most...they vanished....",
            "\t\tNow people talk about the next \"gladiators\" known as reborns ",
            "\t\tAlthough they are of unknown origin, they have the power\n\tto take on the darkness looming over our world...",
            "\t\tBut I believe they will save the world....."
            
        };
        
        return partOne;
    }
    
    public String[] getPartTwo(String playerName)
    {
            
        String [] partTwo = new String[] 
        {
            "\t\tOne day, a young warrior stepped in our town.\n\tThe only safe place left for humans..",
            "\t\tPeople loved this warrior.\n\tThey called him " + playerName + "..",
            "\t\tHe promised that he will travel the world \n\tand find the root of this evil",
            "\t\tBut will he be able to do it..?\n\tOr is he just another scared cat..?\n\n",
            command.HELP.getCommand()
            
        };    
        
        return partTwo;
    }
    
    public String[] getHelp()
    {
        String[] help = 
        {
            command.UP_INSTRUCTION.getCommand(),
            command.DOWN_INSTRUCTION.getCommand(),
            command.LEFT_INSTRUCTION.getCommand(),
            command.RIGHT_INSTRUCTION.getCommand(),
            command.QUIT.getCommand(),
            command.POTION.getCommand(),
            command.DATABASE.getCommand(),
            command.SEE_STATS.getCommand(),
            command.SEE_LOCATION.getCommand(),
            command.SHOW_STATS.getCommand(),
            command.HIDE_STATS.getCommand(),
            command.SHOW_ITEMS.getCommand(),
            command.HIDE_ITEMS.getCommand()
        };
        
        return help;
    }
}
