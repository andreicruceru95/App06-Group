
/**
 * This class contains all the characters we use in the game.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public enum Characters
{
    ABOMINABLE_SNOWMAN(" ⑨ "),
    ALBINO_SNAKE(" ⑥ "),
    APE_KING(" Ⓐ "),
    APE_THROWER(" ③ "),
    BERA(" Ⓑ "),
    BIOLOGIST("!☣ "),
    BIOLOGIST_2(" ☣ "),
    BIOLOGIST_3("bio"),
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
    REMAINS(" ⛆ "),
    NINE_TAILS(" Ⓝ "),
    PERSON(" ⛹"),
    PERSON_2("!⛹"),
    PERSON_3("A"),
    PERSON_4("B"),
    PERSON_4_2("M"),
    PERSON_5("C"),
    PERSON_6("D"),
    PERSON_6_2("N"),
    PERSON_7("F"),
    PERSON_8("G"),
    PERSON_8_2("O"),
    PERSON_9("H"),
    PERSON_10("I"),
    PERSON_11("J"),
    PERSON_12("K"),
    PERSON_13("L"),
    PERSON_14("N"),
    PLAYER(" ⚉ "),
    PLAYER2("☠"),    
    MYTHICAL_STONE(" ⍟ "),
    STONE_SPOT(" ⌬ "),
    STONE_SPOT_2("!⌬ "),
    NURSE(" H "),
    BARREL (" Ô "),
    OPENED_BARREL(" Ø "),
    BAG (" Û "),
    ANVIL(" ⇧ "), 
    RED_DRAGON_B(" ! "),
    GOLD_2("$$$"),
    LUCK(" ☘ "),
    
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
    
    /**
     * Add character.
     */
    Characters(String character)
    {
        this.character = character;
    }
    
    /**
     * @return character.
     */
    public String getCharacter()
    {
        return character;
    }
}
