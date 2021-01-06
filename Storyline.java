
/**
 * This class contains parts of the game story line and methods that will
 * return them.
 *
 * @authors Andrei Cruceru, Rory, Warren Frank
 * @version 1.0.12
 */
public class Storyline
{

    /**
     * @return the first part of the story line.
     */
    public String[] getPartOne()
    {

        return new String[]
        {   "\t\tOnce upon a time the world was a beautiful and peaceful place,\n" +
            "\t\tBut one day evil creatures start appearing out of knowhere..",

            "\t\tThe animals become violent, enraged, attacking anyone on sight..\n" +
            "\t\tMillions have died, cities were wiped off the face of the earth",

            "\t\tThe king, Potus, sent armies to slay the creatures,\n" +
            "\t\tbut whenever a creature was defeated, more would appear out of nowhere.\n\n" +
            "\t\tHis armies were eventually outnumbered and defeated",

            "\t\tThe stone is now out there between armies of demons, ready to be found \n" +
            "\t\t and brought to the city, where it belongs.",

            "\t\tThis mythical stone was so pure and powerful that it would destroy\n" +
            "\t\tany evil creature if placed in the gods house - the church.",

            "\t\tWith no other choice, Zeus, the strongest of the gods, used his last powers to \n" +
            "\t\trip a piece of the heart of the sun and sent it to earth"
        };
    }
    
    /**
     * @return the second part of the story.
     */
    public String[] getPartTwo(String playerName)
    {

        return new String[]
        {
            "\t\tWelcome young adventurer " + playerName + ", this is where your story begins.",
            "\t\tYou find yourself in the last settlement of humankind.\n" +
            "\t\tIn this land of trepidations you must slay your way\n" +
            "\t\tthough the now uncharted territory and retrieve the mythical stone\n" +
            "\t\tand place it back in the centre of town where it belongs.",
            "\t\tUpon your quest you will have to fight monsters, upgrade your gear and level up.",
            Commands.HELP.getCommand()

        };
    }
    
    /**
     * @return the game commands.
     */
    public String[] getHelp()
    {

        return new String[]
        {
                Commands.UP_INSTRUCTION.getCommand(),
                Commands.DOWN_INSTRUCTION.getCommand(),
                Commands.LEFT_INSTRUCTION.getCommand(),
                Commands.RIGHT_INSTRUCTION.getCommand(),
                Commands.QUIT.getCommand(),
                Commands.POTION.getCommand(),
                Commands.DATABASE.getCommand(),
                Commands.SEE_STATS.getCommand(),
                Commands.SEE_LOCATION.getCommand(),
                Commands.SHOW_STATS.getCommand(),
                Commands.HIDE_STATS.getCommand(),
                Commands.SHOW_ITEMS.getCommand(),
                Commands.HIDE_ITEMS.getCommand()
        };
    }
    
}
