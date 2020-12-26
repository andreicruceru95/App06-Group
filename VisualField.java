
/**
 * Write a description of class VisualField here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VisualField
{
    public final static String[][] VISUAL_FIELD = new String[7][7];
    
    private Characters character;
    private String player = character.PLAYER.getCharacter();
    
    /**
     * Set values in the visual field.
     */
    public void setVisualField(String [][] map, int playerRowCoord, int playerColCoord)
    {
        VISUAL_FIELD[0][1] = map[playerRowCoord - 3][playerColCoord - 2];
        VISUAL_FIELD[0][2] = map[playerRowCoord - 3][playerColCoord - 1];
        VISUAL_FIELD[0][3] = map[playerRowCoord - 3][playerColCoord];
        VISUAL_FIELD[0][4] = map[playerRowCoord - 3][playerColCoord + 1];
        VISUAL_FIELD[0][5] = map[playerRowCoord - 3][playerColCoord + 2];
        VISUAL_FIELD[0][6] = map[playerRowCoord - 3][playerColCoord + 3];
                
        VISUAL_FIELD[1][0] = map[playerRowCoord - 2][playerColCoord - 3];
        VISUAL_FIELD[1][1] = map[playerRowCoord - 2][playerColCoord - 2];
        VISUAL_FIELD[1][2] = map[playerRowCoord - 2][playerColCoord - 1];
        VISUAL_FIELD[1][3] = map[playerRowCoord - 2][playerColCoord];
        VISUAL_FIELD[1][4] = map[playerRowCoord - 2][playerColCoord + 1];
        VISUAL_FIELD[1][5] = map[playerRowCoord - 2][playerColCoord + 2];
        VISUAL_FIELD[1][6] = map[playerRowCoord - 2][playerColCoord + 3];
                
        VISUAL_FIELD[2][0] = map[playerRowCoord - 1][playerColCoord - 3];
        VISUAL_FIELD[2][1] = map[playerRowCoord - 1][playerColCoord - 2];
        VISUAL_FIELD[2][2] = map[playerRowCoord - 1][playerColCoord - 1];
        VISUAL_FIELD[2][3] = map[playerRowCoord - 1][playerColCoord];
        VISUAL_FIELD[2][4] = map[playerRowCoord - 1][playerColCoord + 1];
        VISUAL_FIELD[2][5] = map[playerRowCoord - 1][playerColCoord + 2];
        VISUAL_FIELD[2][6] = map[playerRowCoord - 1][playerColCoord + 3];
                
        VISUAL_FIELD[3][0] = map[playerRowCoord][playerColCoord - 3];
        VISUAL_FIELD[3][1] = map[playerRowCoord][playerColCoord - 2];
        VISUAL_FIELD[3][2] = map[playerRowCoord][playerColCoord - 1];
        VISUAL_FIELD[3][3] = " " + player +  " ";
        VISUAL_FIELD[3][4] = map[playerRowCoord][playerColCoord + 1];
        VISUAL_FIELD[3][5] = map[playerRowCoord][playerColCoord + 2];
        VISUAL_FIELD[3][6] = map[playerRowCoord][playerColCoord + 3];
                
        VISUAL_FIELD[4][0] = map[playerRowCoord + 1][playerColCoord - 3];
        VISUAL_FIELD[4][1] = map[playerRowCoord + 1][playerColCoord - 2];
        VISUAL_FIELD[4][2] = map[playerRowCoord + 1][playerColCoord - 1];
        VISUAL_FIELD[4][3] = map[playerRowCoord + 1][playerColCoord];
        VISUAL_FIELD[4][4] = map[playerRowCoord + 1][playerColCoord + 1];
        VISUAL_FIELD[4][5] = map[playerRowCoord + 1][playerColCoord + 2];
        VISUAL_FIELD[4][6] = map[playerRowCoord + 1][playerColCoord + 3];
                
        VISUAL_FIELD[5][0] = map[playerRowCoord + 2][playerColCoord - 3];
        VISUAL_FIELD[5][1] = map[playerRowCoord + 2][playerColCoord - 2];
        VISUAL_FIELD[5][2] = map[playerRowCoord + 2][playerColCoord - 1];
        VISUAL_FIELD[5][3] = map[playerRowCoord + 2][playerColCoord];
        VISUAL_FIELD[5][4] = map[playerRowCoord + 2][playerColCoord + 1];
        VISUAL_FIELD[5][5] = map[playerRowCoord + 2][playerColCoord + 2];
        VISUAL_FIELD[5][6] = map[playerRowCoord + 2][playerColCoord + 3];
                
        VISUAL_FIELD[6][0] = map[playerRowCoord + 3][playerColCoord - 3];
        VISUAL_FIELD[6][1] = map[playerRowCoord + 3][playerColCoord - 2];
        VISUAL_FIELD[6][2] = map[playerRowCoord + 3][playerColCoord - 1];
        VISUAL_FIELD[6][3] = map[playerRowCoord + 3][playerColCoord];
        VISUAL_FIELD[6][4] = map[playerRowCoord + 3][playerColCoord + 1];
        VISUAL_FIELD[6][5] = map[playerRowCoord + 3][playerColCoord + 2];
        VISUAL_FIELD[6][6] = map[playerRowCoord + 3][playerColCoord + 3];
        
        printVisualField();
    }
        
    /**
     * Check the visual field of the player for a given character
     */
    public boolean checkVisualField(String character)
    {
        for (int i = 0; i < VISUAL_FIELD.length; i++)
        {
            for (int j = 0; j < VISUAL_FIELD[i].length; j++)
            {

                if(VISUAL_FIELD[i][j].contains(character))
                {
                    return true;
                        
                }
                
            }
        
        }
        
        return false;
    }
    
    /**
     * Player's visual field 7x7
     */
    public void printVisualField()
    {
        for (int i = 0; i < VISUAL_FIELD.length; i++)
        {
            for (int j = 0; j < VISUAL_FIELD[i].length; j++)
            {
                System.out.print(VISUAL_FIELD[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Change player's image.
     */
    public void changeImage(String image)
    {
        player = image;
    }
}
