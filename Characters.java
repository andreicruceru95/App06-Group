
/**
 * Write a description of class Characters here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public enum Characters
{
    TELEPORT (" ↈ "),
    PERSON_1 (" ⛹"),
    GUARD (" ⏳ "),
    STABLE (" ♞ "),
    BLACK_BEAR (" ① "),
    WHITE_TIGER (" ② "),
    APE_THROWER (" ③ "),
    POISON_SPIDER (" ④ "),
    RED_SCORPION (" ⑤ "),
    ALBINO_SNAKE (" ⑥ "),
    POLAR_BEAR (" ⑦ "),
    YETI (" ⑧ "),
    ABOMINABLE_SNOWMAN (" ⑨ "),
    DEMON (" ⑩ "),
    CURSED_VAMPIRE (" ⑪ "),
    WITCH (" ⑫ "),
    BERA (" Ⓑ "),
    TIGRIS (" Ⓣ "),
    APE_KING (" Ⓐ "),
    SPIDER_QUEEN (" Ⓢ "),
    NINE_TAILS (" Ⓝ "),
    DEATH (" Ⓓ "),
    RED_DRAGON (" Ⓡ "),
    PLAYER ("⚉"),
    PLAYER2("☠"),
    CORPSE (" ☠ "),
    POTION(" ⚱ "),
    BIOLOGIST(" ☣ "),
    HUSBAND_REMAINS (" ⛆ "),
           
    ROCK (" ⛰ "),
    WALL ("[/]"),
    BLACKSMITH (" B "),
    SHOP (" S "),
    CHEST (" ⛋ "),
    GOLD (" $ "),
    ITEM (" !^"),
    TREE (" ⍋ "),
    CACTUS (" ¥ "),
    FLOWER_RED (" ⚘ "),
    FLOWER_BLUE (" ⚙ "),
    FLOWER_YELLOW (" ⚚ "),
    FLOWER_PURPLE (" ⚛ "),
    FLOWER_WHITE (" ⚜ "),
    SNOW_FRAG (" ☃ "),
    STAR_FRAG (" ⚝ "),
    SPIDER_KEY (" ⚵ "),
    TOWER_KEY (" ⚷ "), 
    FOX_KEY (" ⚴ "),
    CHEST_KEY (" ⚿ ");
    
    private final String character;
 
    Characters(String character) 
    {
        this.character = character;
    }
 
    public String getCharacter() 
    {
        return character;
    }
}
