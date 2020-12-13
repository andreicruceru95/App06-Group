
/**
 * Write a description of class Characters here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public enum Characters
{
    ABOMINABLE_SNOWMAN(" ⑨ "),
    ALBINO_SNAKE(" ⑥ "),
    APE_KING(" Ⓐ "),
    APE_THROWER(" ③ "),
    BERA(" Ⓑ "),
    BIOLOGIST(" ☣ "),
    BLACKSMITH(" B "),
    BLACK_BEAR(" ① "),
    CACTUS(" ¥ "),
    CHEST(" ⛋ "),
    CHEST_KEY(" ⚿ "),
    CORPSE(" ☠ "),
    CURSED_VAMPIRE(" ⑪ "),
    DEATH(" Ⓓ "),
    DEMON(" ⑩ "),
    FLOWER_BLUE(" ⚙ "),
    FLOWER_PURPLE(" ⚛ "),
    FLOWER_RED(" ⚘ "),
    FLOWER_WHITE(" ⚜ "),
    FLOWER_YELLOW(" ⚚ "),
    FOX_KEY(" ⚴ "),
    GOLD(" $ "),
    GUARD(" ⏳ "),
    HUSBAND_REMAINS(" ⛆ "),
    NINE_TAILS(" Ⓝ "),
    PERSON_1(" ⛹"),
    PLAYER("⚉"),
    PLAYER2("☠"),

    POISON_SPIDER(" ④ "),
    POLAR_BEAR(" ⑦ "),
    POTION(" ⚱ "),
    RED_DRAGON(" Ⓡ "),
    RED_SCORPION(" ⑤ "),
    ROCK(" ⛰ "),
    SHOP(" S "),
    SNOW_FRAG(" ☃ "),
    SPIDER_KEY(" ⚵ "),
    SPIDER_QUEEN(" Ⓢ "),
    STABLE(" ♞ "),
    STAR_FRAG(" ⚝ "),
    TELEPORT(" ↈ "),
    TIGRIS(" Ⓣ "),
    TOWER_KEY(" ⚷ "),
    TREE(" ⍋ "),
    WALL("[/]"),
    WHITE_TIGER(" ② "),
    WITCH(" ⑫ "),
    YETI(" ⑧ ");

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
