
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
        {   
            "\t\tOnce upon a time the world was a beautiful and peaceful place,\n" +
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
    public String[] getPartTwo(String playerName, int number)
    {
                
        switch(number)
        {
            case -1:
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
            case 0:
                return new String[] 
                {
                    "\t\tDragon:\n\t\tWelcome, warrior " + playerName,
                    "\t\tI admire your perseverance..\n",
                    "\t\tYou have worked a lot to make your way in here, just to be killed by me?\n" +
                    "\t\tMwhahaha",
                    "\t\tIt's been a while since I my last fight, but I will grant your dying wish!",
                    "\t\t" + playerName + ":\n" +
                    "\t\tA dragon? I was not expecting that!\n" +
                    "\t\tAre you the one who stole the stone from my people?\n" + 
                    "\t\tI shall take that stone back along with your head!",
                    "\t\tDragon: \n\t\tStole?\n\t\tYou humans are the ones who stole\n" +
                    "\t\teverything from us for centuries! Your reign is over, human!",
                    "\t\tThousands laid their lifes before you trying to defeat me!\n" +
                    "\t\tAre you sure the outcome will be any different with you?",
                    "\t\t" + playerName + ":\n" +
                    "\t\tNo. But I will put in everything I've got!"                    
                };
            case 1:
                 return new String[]
                {
                    "\t\tDragon dying:\n" +
                    "\t\tImpresive, mortal..\n" +
                    "\t\tI could almost say you deserve the stone..",
                    "\t\t" + playerName + ":\n" +
                    "\t\tWhat you say does not matter anymore, dragon\n" + 
                    "\t\tWe could have all lived in peace. It did not have to end like this!",
                    "\t\tDragon dying:\n" +
                    "\t\tLive together..?\n" +
                    "\t\tAnd be your entertaining pet, human?\n" +
                    "\t\t*Looking around*\n" +
                    "\t\tAll this treasures are yours now, warrior",
                    "\t\tI would rather have my heart pierced by warrior's blade\n" + 
                    "\t\tand live in hell with my kind!",
                    "\t\t" + playerName + ":\n"+
                    "\t\tAs you wish..\n" +                    
                    "\t\t*slash*"
                };
                
            default:
                return new String[]
                {
                    "\t\tWith the stone back in its place, the world is \n" + 
                    "\t\tnow healing. But there is still a lot of work to do out there.\n",
                    "\t\tHumans are now rebuilding their cities. Warriors are hunting down\n" +
                    "\t\tthe remaining monsters that could threat humanity.",
                    "\t\tAnd " + playerName + "? No one knows what he is up to this days,\n" +
                    "\t\tnor what he had to do to in that tower, but we are all gratefull!\n",
                    "\t\t\n\nThank you for playing!"
                };
        }
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
