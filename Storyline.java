
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
            "\t\tOnce upon a time the world was a beautiful and peaceful place,\n" +
            "\t\tBut one day evil creatures start appearing out of knowhere..",
            
            "\t\tThe animals become violent, enraged, attacking anyone on sight..\n" +
            "\t\tMilions have died, cities were wiped off the face of the earth",
            
            "\t\tThe king, Potus, sent armies to slay the creatures,\n" +
            "\t\tbut whenever a creature was defeated, more would apear out of knowhere..\n" +
            "\t\tHis armies were eventualy outnumbered and defeated",
            
            "\t\tKing Potus turned to the gods and the gods responded..\n" + 
            "\t\tThe gods themself come to battle this creatures..",
            
            "\t\tBut it was not easy at all, and one by one, the gods fell in battle..",
            
            "\t\tWith no other choice, Zeus, the strongest of the gods, used his last powers to \n" +
            "\t\trip a piece of the heart of the sun and sent it to earth",
            
            "\t\tThis mythical stone was so pure and powerfull that it would distroy\n" +
            "\t\tany evil creature if placed in the gods house - the church.",
            
            "\t\tThe stone is now out there between armies of demons, ready to be found \n" +
            "\t\t and brought to the city, where it belongs."
            
        };
        
        return partOne;
    }
    
    public String[] getPartTwo(String playerName)
    {
            
        String [] partTwo = new String[] 
        {
            "\t\tWelcome young adventurer " + playerName + ", this is where your story begins.",
            
            "\t\tYou find yourself in the last settlement of humankind.\n" +
            "\t\tIn this land of trepidations you must slay your way\n" +
            "\t\tthough the now uncharted territory and retrieve the mythical stone\n" +
            "\t\tand place it back in the centre of town where it belongs.",
            
            "\t\tUpon your quest you will have to fight monsters, upgrade your gear and level up.",
        
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
