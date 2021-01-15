import java.util.*;

/**
 * The main Game class.
 * This class will read the user's actions and display something back.
 * 
 * @authors Andrei Cruceru
 * @version 1.0.12 
 */

public class Game 
{
    public static final String SQUARE = "   ";
    //to be changed
    public static final String AGREE = "agreeyessurewhynotofcourse";
    public static final String TEST = "test";
    public static final String STABLE = " ♞ ";
    public static final String MOUNT = "mount";
    public static final String DISMOUNT = "dismount";
    public static final String TOWER = "tower";
    public static final String TOWN = "town";
    public static final String DESSERT = "dessert";
    public static final String SPIDER_CAVE = "spidercave";
    public static final String MOUNTAIN = "mountain";
    public static final String FOREST = "forest";
    public static final String FORTRESS = "fortress";
    public static final String HELP = ("help");
    public static final String QUIT = ("quit");
    public static final String POTION = ("potion");
    public static final String SEE_DATABASE = ("database");
    public static final String SEE_MONSTERS = ("seemonsters");
    public static final String SEE_LOCATION = ("seelocation");
    public static final String SHOW_STATS =("showstats");
    public static final String HIDE_STATS = ("hidestats");
    public static final String SHOW_ITEMS = ("showitems");
    public static final String HIDE_ITEMS = ("hideitems");
    public static final String INVENTORY = ("inventory");
    public static final String QUEST = ("quest");
    public static final String TELEPORT = ("teleport");
    public static final String ADD_TELEPORT = ("addteleport");
    public static final String ENCHANCE_WEAPON = "enchanceweapon";
    public static final String ENCHANCE_ARMOUR = "enchancearmour";
    public static final String ENCHANCE_POTION = "enchancepotion";
    public static final String ENCHANCE_AMULET = "enchanceamulet";
    public static final String ENCHANCE_RING = "enchancering";
    public static final String ENCHANCE_BRACELET = "enchancebracelet";
    public static final String BERA = " Ⓑ ";
    public static final String APE_KING = " Ⓐ ";
    public static final String DEATH = " Ⓓ ";
    public static final String NINE_TAILS = " Ⓝ ";
    public static final String RED_DRAGON = " Ⓡ ";
    public static final String SPIDER_QUEEN = " Ⓢ ";
    public static final String TIGRIS = " Ⓣ ";
    public static final String UP = ("w");
    public static final String DOWN = ("s");
    public static final String LEFT = ("a");
    public static final String RIGHT = ("d");
    public static final String WALL = "[/]";
    public static final String ROCK = " ⛰ ";
    public static final String LUCK = " ☘ ";
    public static final String SHOP_C = " S ";
    public static final String BLACKSMITH_C = " B ";
    public static final String CHEST = " ⛋ ";
    public static final String ANVIL = " ⇧ ";
    public static final String GOLD = " $ ";
    public static final String GOLD_2 = "$$$";
    public static final String NURSE = " H ";
    public static final String BIOLOGIST = "!☣ ";
    public static final String BIOLOGIST_2 = " ☣ ";
    public static final String PERSON = " ⛹";
    public static final String PERSON_2 = "!⛹";
    public static final String REMAINS = " ⛆ ";
    public static final String TELEPORT_C = " ↈ ";
    public static final String CORPSE = " ☠ ";
    public static final String STONE_2 = "!⌬ ";
    public static final String STONE = " ⌬ ";
    public static final String M_STONE = " ⍟ ";
    public static final String POTION_C = " ⚱ ";
    public static final String BARREL = " Ô ";
    public static final String OPENED_BARREL = " Ø ";
    public static final String BAG = " Û ";
    public static final String BUY_POTION = "buypotion";
    public static final String BUY_KEY = "buykey";
    public static final int CHEST_CHANCE = 10;
    public static final int POTION_CHANCE = 25;
    public static final int KEY_CHANCE = 50;
    public static final int ITEM_CHANCE = 75;
    public static final String SHOW_MOUNT = "showmount";
    public static final char CLEAR = '\u000c';
    public static final Shop SHOP = new Shop();
    public static final int LEVEL_1 = 1;
    public static final int LEVEL_5 = 5;
    public static final int LEVEL_10 = 10;
    public static final int LEVEL_15 = 15;
    public static final int LEVEL_20 = 20;
    public static final int LEVEL_25 = 25;
    public static final int LEVEL_30 = 30;
    public static final int LEVEL_35 = 35;
    public static final int LEVEL_40 = 40;
    public static final int LEVEL_45 = 45;
    public static final int LEVEL_50 = 50;
    public static final int LEVEL_55 = 55;
    public static final int LEVEL_9 = 9;
    public static final int LEVEL_14 = 14;
    public static final int LEVEL_19 = 19;
    public static final int LEVEL_34 = 34;
    public static final int LEVEL_49 = 49;
    public static final int LEVEL_60 = 60;
    public static final int LEVEL_70 = 70;
    
    public static final ArrayList <Monster> MONSTERS = new ArrayList<>();
    public static final ArrayList <String> MISK = new ArrayList<>(); 
    public static final Interactions INTERACTION = new Interactions();
    public static final Database DATABASE = new Database();
    public static final Display DISPLAY = new Display();
    public static final Storyline STORY = new Storyline();
    public static final Blacksmith BLACKSMITH = new Blacksmith();
    public static final World WORLD = new World();  
    public static final String [] MAP_LIST = new String[8];
    public static final Random RAND = new Random();
    public static final Input READER = new Input();
    
    private Player player;
    private Item weapon;
    private Item armour;
    private Item potion;
    private Item amulet;
    private Item ring;
    private Item bracelet;
    private int row = 24;
    private int col = 17;    
    private int pickUpGold = 0;
    private int numberOfInteractions = 9;
    private int bossGold = 1;
    private int procentValue = 10;
    private int totalNumberOfKills = 0;
    private int timelineNumberOfKills = 0;
    private int fixedProcentValue = 10;
    private int bonusDevider = 20;
    
    private boolean hasReceived = false;
    private int amountReceived = 0;
    private String objectReceived = null;
    private String message = null;
    private boolean isDisplayed = false;
    
    private boolean shopDescription =  false;
    private boolean blacksmithDescription =  false;
    private boolean guardDescription =  false;
    private boolean stableDescription =  false;
    private boolean teleporterDescription =  false;
    private boolean dessertDescription =  false;
    private boolean spiderCaveDescription =  false;
    private boolean firstDeathDescription =  false;
    private boolean stats = false;
    private boolean items = false;
    private boolean biologistInteraction = false;
    private boolean oldLadyInteraction = false;
    private boolean jewelerInteraction = false;
    private boolean farmerInteraction = false;
    private boolean drunkPersonInteraction = false;
    private boolean deathInteraction = false;
    private boolean redDragonInteraction = false;
    private boolean town = false;
    private boolean forest = false;
    private boolean mountain = false;
    private boolean dessert = false;
    private boolean spiderCave = false;
    private boolean tower = false;
    private boolean mythicalStone = false;
    private boolean isMounted = false;
    private boolean mountIsDisplayed = false;
    private boolean mountExists = false;
    
    /**
     * Initialise the game.
     * 
     * Create monsters and items.
     * Display the story.
     * 
     */
    public Game()
    {
        DISPLAY.runStory(STORY.getPartOne());
        
        System.out.println(CLEAR);
        
        System.out.println("\n\n\n\t\tPlease enter the player's name:");
        
        String playerName = READER.getString();
        player = new Player(playerName, 1);
        
        weapon = player.getWeapon();
        armour = player.getArmour();
        potion = player.getPotion();
        amulet = player.getAmulet();
        ring = player.getRing();
        bracelet = player.getBracelet();
                
        DISPLAY.runStory(STORY.getPartTwo(playerName, -1));
                        
        MISK.add(Characters.FLOWER_RED.getCharacter());
        MISK.add(Characters.FLOWER_BLUE.getCharacter());        
        MISK.add(Characters.FLOWER_YELLOW.getCharacter());
        MISK.add(Characters.FLOWER_PURPLE.getCharacter());
        MISK.add(Characters.FLOWER_WHITE.getCharacter());
        MISK.add(Characters.SNOW_FRAG.getCharacter());
        MISK.add(Characters.STAR_FRAG.getCharacter());
        MISK.add(Characters.SPIDER_KEY.getCharacter());
        MISK.add(Characters.TOWER_KEY.getCharacter());
        MISK.add(Characters.FOX_KEY.getCharacter());
        MISK.add(Characters.CHEST_KEY.getCharacter());
        
        MONSTERS.add(new Monster (Characters.BLACK_BEAR.getCharacter(), LEVEL_1, Characters.FLOWER_RED.getCharacter()));
        MONSTERS.add(new Monster (Characters.WHITE_TIGER.getCharacter(), LEVEL_5, Characters.FLOWER_RED.getCharacter()));
        MONSTERS.add(new Monster (Characters.APE_THROWER.getCharacter(), LEVEL_10, Characters.FLOWER_BLUE.getCharacter()));
        MONSTERS.add(new Monster (Characters.POISON_SPIDER.getCharacter(), LEVEL_15, Characters.FLOWER_YELLOW.getCharacter()));
        MONSTERS.add(new Monster (Characters.RED_SCORPION.getCharacter(),LEVEL_20, Characters.FLOWER_YELLOW.getCharacter()));
        MONSTERS.add(new Monster (Characters.ALBINO_SNAKE.getCharacter(),LEVEL_25, Characters.FLOWER_PURPLE.getCharacter()));
        MONSTERS.add(new Monster (Characters.POLAR_BEAR.getCharacter(),LEVEL_30, Characters.FLOWER_WHITE.getCharacter()));
        MONSTERS.add(new Monster (Characters.YETI.getCharacter(),LEVEL_35, Characters.SNOW_FRAG.getCharacter()));
        MONSTERS.add(new Monster (Characters.ABOMINABLE_SNOWMAN.getCharacter(),LEVEL_40, Characters.SNOW_FRAG.getCharacter()));
        MONSTERS.add(new Monster (Characters.DEMON.getCharacter(),LEVEL_45, Characters.STAR_FRAG.getCharacter()));
        MONSTERS.add(new Monster (Characters.CURSED_VAMPIRE.getCharacter(),LEVEL_50, Characters.STAR_FRAG.getCharacter()));
        MONSTERS.add(new Monster (Characters.WITCH.getCharacter(),LEVEL_55, Characters.STAR_FRAG.getCharacter()));
        MONSTERS.add(new Monster (Characters.BERA.getCharacter(),LEVEL_9, Characters.GOLD_2.getCharacter()));
        MONSTERS.add(new Monster (Characters.TIGRIS.getCharacter(),LEVEL_14, Characters.GOLD_2.getCharacter()));
        MONSTERS.add(new Monster (Characters.APE_KING.getCharacter(),LEVEL_19, Characters.GOLD_2.getCharacter()));
        MONSTERS.add(new Monster (Characters.SPIDER_QUEEN.getCharacter(),LEVEL_34, Characters.GOLD_2.getCharacter()));
        MONSTERS.add(new Monster (Characters.NINE_TAILS.getCharacter(),LEVEL_49, Characters.GOLD_2.getCharacter()));
        MONSTERS.add(new Monster (Characters.DEATH.getCharacter(),LEVEL_60, Characters.GOLD_2.getCharacter()));
        MONSTERS.add(new Monster (Characters.RED_DRAGON.getCharacter(),70, Characters.GOLD_2.getCharacter()));
        
        BLACKSMITH.addItems(weapon, armour, potion, amulet, ring, bracelet);
         
        run(); 
                  
    }
       
    /**
     * Main options.
     */
    public void run()
    {
        System.out.println(CLEAR);
        
        boolean finished = false;
        while(!finished)
        {
            System.out.println(CLEAR);
                
            changeImage();
            showInfo();
            updateVisualField();
            printMessages();
            
            String choiceRaw = READER.getAny();
            String choice = choiceRaw.toLowerCase().replaceAll("\\s+","");
            
            try
            {
                
                switch(choice)
                {
                    case TEST:
                        WORLD.setCurrentMap(TOWER);
                        setTowerCoord();
                        break;
                    
                    case SHOW_MOUNT:
                        displayMessage(displayMount());
                        
                        break;
                        
                    case QUIT:
                        finished = true;
                        break;
                    
                    case ADD_TELEPORT:
                        WORLD.addTeleport(player.getRowCoord() + 1, player.getColCoord());
                        break;
                        
                    case POTION:
                        message = player.drinkPotion();
                        isDisplayed = true;                       
                        break;
                        
                    case HELP:
                        DISPLAY.listOptions(STORY.getHelp());
                        pressAny();
                        break;
                        
                    case SEE_DATABASE:
                        DATABASE.printAll();
                        pressAny();
                        break;
                        
                    case SEE_MONSTERS:
                        DATABASE.getMonsterList(MONSTERS);
                        
                        pressAny();
                        break;
                    case SEE_LOCATION:
                        WORLD.printHelpMap(player.getRowCoord(), player.getColCoord());
                    
                        pressAny();
                        break;
                        
                    case TELEPORT:
                        runTeleport();
                        break;
                        
                    case SHOW_STATS:
                        stats=true;
                        break;
                        
                    case HIDE_STATS:
                        stats = false;
                        break;
                        
                    case SHOW_ITEMS:
                        items = true;
                        break;
                        
                    case HIDE_ITEMS:
                        items = false;
                        break;
                        
                    case INVENTORY:
                        System.out.println(CLEAR);
                    
                        player.printInventory(); 
                    
                        pressAny();
                        break;
                        
                    case QUEST:
                        System.out.println(CLEAR);
                    
                        player.printQuestList(); 
                    
                        pressAny();
                        break;
                        
                    case UP:
                        runMenu(choice);
                        break;
                        
                    case DOWN:
                        runMenu(choice);
                        break;
                        
                    case LEFT:
                        runMenu(choice);
                        break;
                        
                    case RIGHT:
                        runMenu(choice);
                        break;
                        
                    case MOUNT:
                        mount();
                        break;
                        
                    case DISMOUNT:
                        dismount();
                        break;

                    default:
                        displayMessage("Not an option");
                        
                } 
            
            }
            catch(Exception e)
            {
                displayMessage("Not a command");
                
            }
            
        }
    }
    
    /**
     * Display a message.
     */
    private void displayMessage(String message)
    {
        this.message = message;
        
        isDisplayed = true;
    }
    
    /**
     * Print messages if condition is true.
     */
    private void printMessages()
    {
        if(isDisplayed)
            System.out.println("\t\t" + message);
         
        else
            System.out.println(" ");
        
        isDisplayed = false;
        
        if(hasReceived)
            System.out.println("\tReceived: " + amountReceived + " " + objectReceived);
        
        else
            System.out.println(" ");
            
        hasReceived = false;
    }
    
    /**
     * Read any input from the user.
     */
    private void pressAny()
    {
        System.out.println("\n\n\n\t\tPress any to continue");
        
        READER.getAny();
    }
            
    /**
     * Move the player.
     */
    private void runMenu(String choice)
    {
        if(isMounted)
            moveTwice(choice);
            
        else
            moveOnce(choice);
            
    }
    
    /**
     * Update and print the player's visual field.
     */
    private void updateVisualField()
    {
        player.updateVisualField(WORLD.getMapAsArray());
        
    }
    
    /**
     * move twice.
     * if first move is correct, move again.
     */
    private void moveTwice(String direction)
    {
        if(moveOnce(direction))
            moveOnce(direction);
            
    }
    
    /**
     * Move player on the map.
     */
    private boolean moveOnce(String direction)
    {
        switch(direction)
        {
            case UP:
                if(checkNextSquare((player.getRowCoord() - 1), player.getColCoord())) 
                {
                    updateHelpMap(UP);
                    
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                    
                    player.setCoordinates((player.getRowCoord() - 1), player.getColCoord());
                        
                    updateScreen();
                        
                    return true;
                }
                else
                    return false; 
                                         
            
            case DOWN:
                if(checkNextSquare((player.getRowCoord() + 1), player.getColCoord()))
                {
                    updateHelpMap(DOWN);
                    
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                    
                    player.setCoordinates((player.getRowCoord() + 1), player.getColCoord());
                    
                    updateScreen();
                        
                    return true;
                }
                else    
                    return false;
                    
            case LEFT:
                if(checkNextSquare(player.getRowCoord(), (player.getColCoord() - 1)))
                {
                    updateHelpMap(LEFT);
                        
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                    
                    player.setCoordinates(player.getRowCoord(), (player.getColCoord() - 1));
                    
                    updateScreen();
                        
                    return true;
                }
                else
                    return false;
                   
                    
            case RIGHT:            
                if(checkNextSquare(player.getRowCoord(), (player.getColCoord() + 1)))
                {
                    updateHelpMap(RIGHT);
                    
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                    
                    player.setCoordinates(player.getRowCoord(), (player.getColCoord() + 1));
                        
                    updateScreen();
                    
                    return true;
                }
                else
                    return false;
                
            default:
                return false;
        }           
        
    }
    
    /**
     * update screen
     */
    private void updateScreen()
    {
        System.out.println(CLEAR);
        changeImage();
        showInfo();
        updateVisualField();
        checkFirstInteraction();
    }
        
    /**
     * Update the help map.
     */
    private void updateHelpMap(String direction)
    {
        switch(direction)
        {
            case UP:                
                //center
                WORLD.addToHelpMap((player.getRowCoord() - 1),player.getColCoord(), "   ");
                //left
                WORLD.addToHelpMap((player.getRowCoord() - 1), (player.getColCoord() - 1),
                                    WORLD.getSquareValue((player.getRowCoord() - 1), (player.getColCoord() - 1)));
                //right         
                WORLD.addToHelpMap((player.getRowCoord() - 1), (player.getColCoord() + 1),
                                    WORLD.getSquareValue((player.getRowCoord() - 1), (player.getColCoord() + 1)));
            
            
                break;
            
            case DOWN:
                //center
                WORLD.addToHelpMap((player.getRowCoord() + 1),player.getColCoord(), "   ");
                //left
                WORLD.addToHelpMap((player.getRowCoord() + 1), (player.getColCoord() - 1),
                                    WORLD.getSquareValue((player.getRowCoord() + 1), (player.getColCoord() - 1)));
                //right         
                WORLD.addToHelpMap((player.getRowCoord() + 1), (player.getColCoord() + 1),
                                    WORLD.getSquareValue((player.getRowCoord() + 1), (player.getColCoord() + 1)));
                   
               break;
            
            case LEFT:
                //center
                WORLD.addToHelpMap((player.getRowCoord()),player.getColCoord() - 1, "   ");
                //down
                WORLD.addToHelpMap((player.getRowCoord() - 1), (player.getColCoord() - 1),
                                    WORLD.getSquareValue((player.getRowCoord() - 1), (player.getColCoord() - 1)));
                //up         
                WORLD.addToHelpMap((player.getRowCoord() + 1), (player.getColCoord() - 1),
                                    WORLD.getSquareValue((player.getRowCoord() + 1), (player.getColCoord() - 1)));
        
                break;    
                                
            case RIGHT:
                //center
                WORLD.addToHelpMap((player.getRowCoord()),player.getColCoord() + 1, "   ");
                //down
                WORLD.addToHelpMap((player.getRowCoord() + 1), (player.getColCoord() + 1),
                                    WORLD.getSquareValue((player.getRowCoord() + 1), (player.getColCoord() + 1)));
                //up         
                WORLD.addToHelpMap((player.getRowCoord() - 1), (player.getColCoord() + 1),
                                    WORLD.getSquareValue((player.getRowCoord() - 1), (player.getColCoord() + 1)));
                                    
                break;
        }
        
    } 
    
    /**
     * Display information about the player and map.
     */
    private void showInfo()
    {
        String mapName = WORLD.getCurrentMapName().toLowerCase();        
         
        switch(mapName)
        {
            case TOWER:
                System.out.println("\tMap: " + mapName.toUpperCase() + " Level " + WORLD.getTowerLevel() + "\t" +
                                    "[" + player.getRowCoord() + ", " + player.getColCoord() + "]\n");
            
                break;
                
            default:
                System.out.println("\tMap: " + mapName.toUpperCase() + "\t" + "[" + player.getRowCoord() + 
                                    ", " + player.getColCoord() + "]\n");                
        }
        System .out.println();
        System.out.println("\tPlayer: " + player.getName() + "\tScore: " + 
                                    player.getScore() + "\n" + player.getHealthInfo());
                               
        if(stats)
        {
            System.out.println(player.getStats()); 
            getGold();
              
        }
                   
        if(items)
        {
            ((Weapon) weapon).print();
            ((Armour) armour).print();
            ((Potion) potion).print();
            ((Amulet) amulet).print();
            
            if(ring.checkVisibility())
                ((Ring) ring).print();
            
            if(bracelet.checkVisibility())
                ((Bracelet) bracelet).print();
            
            if(player.stoneExists())
                System.out.print("\nTELEPORT STONE - type 'teleport' to use\n\n");
                
        }   
        
    }
        
    /**
     * print the player's gold amount.
     */
    private void getGold()
    {
        System.out.println("\tGold: " + player.getGold() + "" + Characters.GOLD.getCharacter());
    }
    
    /**
     * the start of the fight with a monster.
     */
    private boolean fightMonster(String character, Actor monster)
    {
        if(fight(character, monster))
        {
            WORLD.addAnother(character);
            
            timelineNumberOfKills ++;
            totalNumberOfKills ++;
            
            procentValue = fixedProcentValue + (totalNumberOfKills % bonusDevider);
            
            if(checkMonster(character))
            {
                WORLD.addObjects(player.getColCoord() - 1, player.getColCoord() + 1,
                                player.getRowCoord() - 1, player.getRowCoord() + 1, Characters.GOLD_2.getCharacter());
            }
                                
            player.checkCharacter(character);    
            
            pickUpGold = dropGold(monster);
            player.addScore(pickUpGold);
            player.addScore(monster.getLevel());
            
            checkDrop(monster);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Check what monsters have been killed.
     */
    private boolean checkMonster(String string)
    {
        switch(string)
        {
            case BERA:
                setBossGold(BERA);
                
                return true;
            
            case APE_KING:
                setBossGold(APE_KING);
                
                return true;
            
            case SPIDER_QUEEN:
                setBossGold(SPIDER_QUEEN);
                player.addToInventory(Characters.SPIDER_KEY.getCharacter(), 1);
                hasRecieved(1, Characters.SPIDER_KEY.getCharacter());
                
                return true;
                
            case DEATH:
                setBossGold(DEATH);
                
                return true;
                
            case RED_DRAGON:
                if(!redDragonInteraction)
                {
                    DISPLAY.runStory(STORY.getPartTwo(player.getName(), 1));
                    
                    redDragonInteraction = true;
                }
                 
                setBossGold(RED_DRAGON);
                 
                return true; 
                    
            case TIGRIS:
                setBossGold(TIGRIS);
                
                return true;
                
            case NINE_TAILS:
                setBossGold(NINE_TAILS);
                player.addToInventory(Characters.FOX_KEY.getCharacter(), 1);
                hasRecieved(1, Characters.FOX_KEY.getCharacter());
                
                return true;
             
            default:
            
                return false;
        }
    }
    
    /**
     * set the amount of gold dropped by a boss.
     * 
     */
    private void setBossGold(String string)
    {
        int max = 3;
        int min = 1;
        Actor monster = findMonster(string);
        
        if(monster != null)
            min = monster.getLevel() * max; 
         
        bossGold = RAND.nextInt((max * min) - min) + min;
        
    }
        
    /**
     * Check the next square
     */
    private boolean checkNextSquare(int nextRow, int nextCol)
    {
        String squareValue = WORLD.getSquareValue(nextRow,nextCol);
        
        Actor monster = findMonster(squareValue);
        if(monster != null)
        {
            return fightMonster(squareValue, monster);
            
        }        
        else if(checkItem(squareValue))
        {
            player.addToInventory(squareValue, 1);
            
            hasRecieved(1, squareValue);
            
            return true;
        }
        else 
        {
            
            switch(squareValue)
            {
                case BARREL:
                    openBag();
                    WORLD.openBarels(nextRow, nextCol);
                    return false;
                
                case BAG:
                    openBag();
                    WORLD.openBags(nextRow, nextCol);
                    return true;
                    
                case OPENED_BARREL:
                    displayMessage("Barel has been destroyed");
                    
                    return true; 
                    
                case SQUARE:
                    return true;
                
                case WALL:
                    displayMessage("Cannot go through walls!");
                    
                    return false;
                
                case ROCK:
                    displayMessage("Cannot go through walls!");
                    
                    return false;
                
                case SHOP_C:
                    runShop();
                    
                    return false;
                
                case BLACKSMITH_C:
                    runBlacksmith();
                    
                    return false;
                
                case CHEST:                                            
                    return openChest();                   
                 
                case GOLD:
                    hasRecieved(pickUpGold, Characters.GOLD.getCharacter());
                    player.addGold(pickUpGold);
                    return true;
                
                case STABLE:
                    runStable();
                    return false;
                
                
                case NURSE:
                    player.setFullHealth();
                    displayMessage("Your healh has been restored!");
                    
                    return false;
                
                case BIOLOGIST:
                    runBiologist();
                    
                    return false;
                    
                case BIOLOGIST_2:
                    finishBiologistQuest();
                    
                    return false;
                    
                case PERSON_2:
                    checkPersonInteraction(nextRow,nextCol);
                    
                    return false;
                    
                case PERSON:
                    checkPersonQuest(nextRow,nextCol);
                    
                    return false;
                    
                case REMAINS:    
                    hasRecieved(1, Characters.REMAINS.getCharacter());
                    player.addToInventory(Characters.REMAINS.getCharacter(), 1);
                    
                    return true;
                    
                 case GOLD_2:    
                    hasRecieved(bossGold, Characters.GOLD.getCharacter());
                    player.addGold(bossGold);
                    
                    return true; 
                    
                case ANVIL: 
                    runBlacksmith();
                    
                    return false;
                    
                case LUCK:
                    playGame();
                    
                    return false;
                    
                case TELEPORT_C:
                    teleport();    
                    
                    return false;
                    
                case CORPSE:
                    System.out.println(CLEAR);                       
                    
                    INTERACTION.getInteraction(Characters.CORPSE.getCharacter());  
                    
                    pressAny();                   
                    
                    return false;
                    
                case STONE_2:
                    if(!player.checkInventory(Characters.MYTHICAL_STONE.getCharacter(), 1)) 
                    {
                        System.out.println(CLEAR);
                        
                        INTERACTION.getInteraction(Characters.STONE_SPOT.getCharacter());
                        
                        pressAny();
                        
                        return false;
                    }
                    else
                    {
                        System.out.println(CLEAR);
                        
                        DISPLAY.runStory(STORY.getPartTwo(player.getName(), 2));
                        
                        WORLD.setMythicalStone(Characters.STONE_SPOT.getCharacter());
                        
                        return false;
                    }
                    
                case STONE:
                    if(player.checkInventory(Characters.MYTHICAL_STONE.getCharacter(), 1)) 
                    {
                        System.out.println(CLEAR);
                        
                        INTERACTION.getInteraction(Characters.STONE_SPOT_2.getCharacter());
                        
                        pressAny();
                        
                        return false;
                    }
                    
                case M_STONE:
                    if(!mythicalStone)
                    {
                        System.out.println(CLEAR);
                        
                        INTERACTION.getInteraction(Characters.MYTHICAL_STONE.getCharacter()); 
                        
                        hasRecieved(1, Characters.MYTHICAL_STONE.getCharacter());
                        
                        player.addToInventory(Characters.MYTHICAL_STONE.getCharacter(), 1);
                        
                        pressAny();
                        
                        return true;
                    }
                    else
                    {
                        player.addToInventory(Characters.MYTHICAL_STONE.getCharacter(), 1);
                        
                        hasRecieved(1, Characters.MYTHICAL_STONE.getCharacter());
                        
                        return true;
                    }
                    
                
                case POTION_C:
                    int potionAmount = 5;
                    
                    hasRecieved(potionAmount, Characters.POTION.getCharacter());
                        
                    player.increasePotionAmount(potionAmount);
                            
                    return true;
                    
                default:    
                    return false;
                    
            }
            
        }
        
    }
    
    /**
     * Drop gold on the map.
     * @return an amount of gold equal to the monster's level.
     */
    private int dropGold(Actor monster)
    {
        if(((Monster)monster).dropGold() != 0)
        {
            WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
            ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, Characters.GOLD.getCharacter()) ;           
        }
        
        return monster.getLevel();
    }
        
    /**
     * drop an item on the map.
     */
    private void dropItem(String item, int number)
    {
        int value = RAND.nextInt(50 - 1) + 1;
        
        switch(number)
        {
            case 0:
                WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
                    ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, item) ;
                break;
                
            case 1:
                player.addGold(value);
                hasRecieved(value, GOLD);
                break;
                
            case -1:
                player.increasePotionAmount(1);
                hasRecieved(1, Characters.POTION.getCharacter());
                break;
                
            default: 
                player.addToInventory(item, 1);  
                hasRecieved(1, item);
        }
    }
    
    /**
     * Check if the monster has dropped any items.
     * 
     */
    private void checkDrop(Actor monster)
    {
        String item = ((Monster)monster).dropItem();
        String chest = ((Monster)monster).dropChest();
        String remains =((Monster)monster).dropRemains();
        String key =((Monster)monster).dropKey();
        String potion = ((Monster)monster).dropPotion();
        
        if(item != null)
            dropItem(item, 0);
            
        if(chest != null)
            dropItem(chest, 0);
            
        if(remains != null)
            dropItem(remains, 0);
            
        if(key != null)
            dropItem(key, 0);  
            
        if(potion != null)
            dropItem(potion, 0); 
    } 
    
    /**
     * Open bags and barrels.
     */
    private void openBag()
    {
        int key = 25;
        int potion = 10;
        int gold = 45;
        int max = 70;        
        int rand = RAND.nextInt(max - 1) + 1;
        
        if(rand > gold)
            dropItem(GOLD, 1);
            
        else if(rand > key)
            dropItem(Characters.CHEST_KEY.getCharacter(), key);
            
        else
            dropItem(Characters.POTION.getCharacter(), -1);
         
    }
        
    /**
     * Open a chest if the player has keys.
     * Display a message otherwise. 
     */
    private boolean openChest()
    {
        if (player.checkInventory(Characters.CHEST_KEY.getCharacter(), 1))   
        {
            openBag();
            
            return true;
        }
        else
        {
            displayMessage("Not enough " + Characters.CHEST_KEY.getCharacter());
            
            return false;       
        }
    }
    
    /**
     * Change variable values if player recieved items.
     */
    private void hasRecieved(int amount, String object)
    {
        hasReceived = true;
        
        amountReceived = amount;
         
        objectReceived = object;
    }
    
    /**
     * Check INTERACTION with people.
     */
    private void checkPersonInteraction(int row, int col)
    {
        if(row == Pointers.P13.getValue() && col == Pointers.P11.getValue() && !oldLadyInteraction)
        {
            oldLadyInteraction = INTERACTION.getInteraction(Characters.PERSON_3.getCharacter());
            
            pressAny();
            
            player.setQuestActive("oldlady");
            
            WORLD.setOldLady(Characters.PERSON.getCharacter());
        }
        else if(row == Pointers.P26.getValue() && col == Pointers.P10.getValue() && !jewelerInteraction)
        {
            jewelerInteraction = INTERACTION.getInteraction(Characters.PERSON_5.getCharacter());
            
            pressAny();
            
            player.setQuestActive("jeweler");
            
            WORLD.setJeweler(Characters.PERSON.getCharacter());
        }
        else if(row == Pointers.P31.getValue() && col == Pointers.P13.getValue() && !farmerInteraction)
        {
            farmerInteraction = INTERACTION.getInteraction(Characters.PERSON_7.getCharacter());
            
            pressAny();
            
            player.setQuestActive("farmer");
            
            WORLD.setFarmer(Characters.PERSON.getCharacter());
        }
        else if(row == Pointers.P29.getValue() && col == Pointers.P24.getValue() && !drunkPersonInteraction)
        {
            drunkPersonInteraction = INTERACTION.getInteraction(Characters.PERSON_9.getCharacter());
            
            pressAny();
            
            WORLD.setDrunkPerson(Characters.PERSON.getCharacter());
            
            player.setStone();
        }
        
    }
    
    /**
     * Check the quest.
     */
    private void checkPersonQuest(int row, int col)
    {
        if(row == Pointers.P13.getValue() && col == Pointers.P11.getValue())
        {
            
            if(player.checkInventory(Characters.REMAINS.getCharacter(), 1))
            {
                INTERACTION.getInteraction(Characters.PERSON_4.getCharacter());
                
                pressAny();
                
                player.setQuestInactive("oldlady");
                
                ring.setVisibility();
            }
            else
                pressAny();
            
        }
        else if(row == Pointers.P26.getValue() && col == Pointers.P10.getValue())
        {
            
            if(player.checkInventory(Characters.STAR_FRAG.getCharacter(), Pointers.P10.getValue()))
            {
                INTERACTION.getInteraction(Characters.PERSON_6.getCharacter());
                
                pressAny();
                
                player.setQuestInactive("jeweler");
                
                bracelet.setVisibility();
            }
            else
                pressAny();
            
        }
        else if(row == Pointers.P31.getValue() && col == Pointers.P13.getValue())
        {
            
            if((timelineNumberOfKills > 0))
            {
                INTERACTION.getInteraction(Characters.PERSON_8.getCharacter());
                
                pressAny();
                
                player.addGold(10 * timelineNumberOfKills);
                
                timelineNumberOfKills = 0;
                 
                WORLD.setFarmer(Characters.PERSON_2.getCharacter());
                
                player.setQuestInactive("farmer");
                
                farmerInteraction = false;
            }
            else
            {
                INTERACTION.getInteraction(Characters.PERSON_14.getCharacter());
                
                pressAny();
            }
            
        }
        else if(row == Pointers.P18.getValue() && col == Pointers.P19.getValue())
        {
            INTERACTION.getInteraction(Characters.PERSON_10.getCharacter());
            
            pressAny();
            
        }
        else if(row == Pointers.P24.getValue() && col == Pointers.P25.getValue())
        {
            INTERACTION.getInteraction(Characters.PERSON_11.getCharacter());
            
            pressAny();
            
        }
        else if(row == Pointers.P30.getValue() && col == Pointers.P19.getValue())
        {
            INTERACTION.getInteraction(Characters.PERSON_12.getCharacter());
            
            pressAny();
            
        }
        else
        {
            System.out.println("\t\tTips: " + getRandomMessage());
            
            pressAny();
            
        }
    }
    
    /**
     * get a random message.
     */
    private String getRandomMessage()
    {
        final String[] MESSAGES = new String[]
        {
            "\t\tYou can upgrade your items outside the city using anvils (Look for ⇧ ) ",                    
            "\t\tYou can purchase potions at the shop in cities(S)",
            "\t\tYou have a chance to multiply your gold \n\t\tby playing 'Guess the number' in the fortress(Look for ☘)",
            "\t\tChest keys can be purchased from shop or obtained by fighting monsters",
            "\t\tFighting bosses can be very rewarding",
            "\t\tCompleting quests will unlock more items",
            "\t\tTo use a potion, type 'potion'",
            "\t\tA teleport will help you travel to a different map",
            "\t\tYou can buy a mount from the stable outside the town. (Look for ♞) "
        };
        return MESSAGES[RAND.nextInt(MESSAGES.length - 0) + 0];
    }
    
    /**
     * Fight with a monster.
     */
    private boolean fight(String Characters, Actor monster)
    {
        if (monster != null)
        {
            return checkResult(action(monster), monster, Characters);
        }
        
        return false;
    }
    
    /**
     * Check if there is an item.
     */
    private boolean checkItem(String value)
    {
        for(String string : MISK)
        {
            if(string.equals(value))
                return true;
        }
        
        return false;
    }
        
    /**
     * Spawn another monster on the map if you won the fight.
     * If you die, you will be set back to the initial position.
     */
    private boolean checkResult(boolean result, Actor monster, String Characters)
    {
        if(result)
        {
            displayMessage("You Won!");
            
            return true;
        }
        else
        {
            isMounted = false;
            
            displayMessage("You Lost :(");
            
            checkFirstDeath();
            
            setCoordinates(); 
            
            player.setFullHealth();
           
        }
        
        return false;
    }
    
    private void setCoordinates()
    {
        String mapName = WORLD.getCurrentMapName().toLowerCase();
        
        switch(mapName)
        {
            case TOWN:        
                setTownCoord();
                break;
            
            case FORTRESS:
                setFortressCoord();
                break;
                
            case FOREST: 
                setForestCoord();
                break;
                
            case MOUNTAIN:
                setMountainCoord();
                break;
                
            case DESSERT:
                setDessertCoord();
                break;
                
            case SPIDER_CAVE:
                setSpiderCaveCoord();
                break;
                
            case TOWER:
                setTowerCoord();    
                break;            
        }
    }
    
    /**
     * Set the player coordinates to town entrance.
     */
    private void setTownCoord()
    {
        row = Pointers.P7.getValue();
        col = Pointers.P7.getValue();
        
        town = true;
        
        player.setCoordinates(row, col);
    }
    
    /**
     * 
     */
    private void setFortressCoord()
    {
        row = Pointers.P23.getValue();
        col = Pointers.P17.getValue();
        
        player.setCoordinates(row, col);
    }
    
    /**
     * 
     */
    private void setForestCoord()
    {
        row = Pointers.P21.getValue();
        col = Pointers.P30.getValue();
        
        forest = true;
        
        player.setCoordinates(row, col);
    }
    
    /**
     * 
     */
    private void setMountainCoord()
    {
        row = Pointers.P5.getValue();
        col = Pointers.P5.getValue();
        
        mountain = true;
        
        player.setCoordinates(row, col);
    }
    
    /**
     * 
     */
    private void setDessertCoord()
    {
        row = Pointers.P7.getValue();
        col = Pointers.P7.getValue();
        
        dessert = true;
        
        player.setCoordinates(row, col);
    }
    
    /**
     * 
     */
    private void setSpiderCaveCoord()
    {
        row = Pointers.P7.getValue();
        col = Pointers.P7.getValue();
        
        spiderCave = true;
        
        player.setCoordinates(row, col);
    }
    
    /**
     * 
     */
    private void setTowerCoord()
    {
        row = Pointers.P21.getValue();
        col = Pointers.P17.getValue();
        
        player.setCoordinates(row, col);
    }
    
    /**
     * Check the first player's death.
     * Tell the user what will hapen when he dies.
     */
    private void checkFirstDeath()
    {
        if(firstDeathDescription == false)
        {
            displayMessage("You died! When you die you will be sent back at the entrance\n\t\tand your health will be restored.");
            
            pressAny();
            
            firstDeathDescription = true;
        }
    }
    
    /**
     * Find which monster we are dealing with.
     */
    private Actor findMonster(String character)
    {
        for (Monster monster : MONSTERS)     
        {
            
            if (monster.getName().equals(character))
            {
                return monster;
                
            }
            
        }
        
        return null;
    }
    
    /**
     * Fast-forward fight
     */
    private boolean action(Actor monster)
    {
        do
        {
            monster.receiveDmg(player.attack());
            //System.out.println("Monster received " + monster.receiveDmg(player.attack()));
                        
            player.receiveDmg(monster.attack());
            //System.out.println("Player received " + player.receiveDmg(monster.attack()));    
            
        }
        while(player.checkHealth() && monster.checkHealth());
        
        return player.getHealthPoints();
    }
    
    /**
     * Change the player's icon.
     */
    private void changeImage()
    {
        if(isMounted)
            player.changeImage(Characters.STABLE.getCharacter());
            
        else
            player.changeImage(Characters.PLAYER.getCharacter()); 
            
        if(player.getCurrentHealth() <= player.getFullHealth() / 2)
            player.changeImage(Characters.PLAYER2.getCharacter()); 
                
    }
        
    /**
     * The first interaction with some of the game elements.
     */
    private boolean checkFirstInteraction()
    {
        if(numberOfInteractions == 0)
            return false;
        
        if(player.checkVisualField(Characters.SHOP.getCharacter()) && !shopDescription)
        {
            shopDescription = INTERACTION.getInteraction(Characters.SHOP.getCharacter()); 
            
            numberOfInteractions --;
            
            pressAny();
        }    
        else if(player.checkVisualField(Characters.BLACKSMITH.getCharacter()) && !blacksmithDescription)
        {
            blacksmithDescription = INTERACTION.getInteraction(Characters.BLACKSMITH.getCharacter()); 
            
            numberOfInteractions --;
            
            pressAny();
        }    
        else if(player.checkVisualField(Characters.STABLE.getCharacter()) && !stableDescription)
        {
            stableDescription = INTERACTION.getInteraction(Characters.STABLE_1.getCharacter());
            
            numberOfInteractions --;
            
            pressAny();
        }          
        else if(player.checkVisualField(Characters.GUARD.getCharacter()) && !guardDescription)
        {
            guardDescription = INTERACTION.getInteraction(Characters.GUARD.getCharacter());
            
            numberOfInteractions --;
            
            pressAny();
        }    
        else if(player.checkVisualField(Characters.TELEPORT.getCharacter()) && !teleporterDescription)
        {
            teleporterDescription = INTERACTION.getInteraction(Characters.TELEPORT.getCharacter());
            
            numberOfInteractions --;
            
            pressAny();
        }    
        else if(WORLD.getCurrentMapName().toLowerCase().equals(DESSERT) && !dessertDescription)
        {
            dessertDescription = INTERACTION.getInteraction(DESSERT);
            
            numberOfInteractions --;
            
            pressAny();
        }                
        else if(WORLD.getCurrentMapName().toLowerCase().equals(SPIDER_CAVE) && !spiderCaveDescription)
        {
            spiderCaveDescription = INTERACTION.getInteraction(SPIDER_CAVE);
            
            numberOfInteractions --;
            
            pressAny();
        }    
        else if(player.checkVisualField(Characters.DEATH.getCharacter()) && !deathInteraction)
        {
            deathInteraction = INTERACTION.getInteraction(Characters.DEATH.getCharacter());
            
            numberOfInteractions --;
            
            pressAny();
        } 
        else if(player.checkVisualField(Characters.RED_DRAGON.getCharacter()) && !redDragonInteraction)
        {
            DISPLAY.runStory(STORY.getPartTwo(player.getName(), 0));
            
            numberOfInteractions --;
            
        } 
        
        return true;
    }
    
    /**
     * Interact with biologist
     */
    private void runBiologist()
    {
        if(!biologistInteraction)
        {
            biologistInteraction = INTERACTION.getInteraction(Characters.BIOLOGIST.getCharacter());
            WORLD.setBiologist(Characters.BIOLOGIST_2.getCharacter());
            
            player.setQuestActive("biologist");
            
            pressAny();
        }
        
    }
    
    /**
     * Get rewards for colecting flowers.
     */
    private void finishBiologistQuest()
    {
        int amount = player.getReward();
        
        switch(amount)
        {
            case 0:
                INTERACTION.getInteraction(Characters.BIOLOGIST_3.getCharacter());                
                pressAny();
                
                break;
                
            default:
                INTERACTION.getInteraction(Characters.BIOLOGIST_2.getCharacter());                
                pressAny();
                rewardPlayer(amount);
                
                break;
            
        }
        
    }
    
    /**
     * Reward player for biologist quest
     */
    private void rewardPlayer(int amount)
    {
        hasRecieved(amount, Characters.GOLD.getCharacter()); 
                
        player.addGold(amount);               
                
    }
        
    /**
     * Interact with the blacksmith.
     */
    private void runBlacksmith()
    {
        boolean finished = false;
            
        while(!finished)
        {
            BLACKSMITH.createList(player.getGold());
            
            System.out.println("\n\t\tWhat can I do for you?\n\n");
                
            BLACKSMITH.openBlacksmithShop();
                
            String choiceRaw = READER.getString();
            String choice = choiceRaw.toLowerCase().replaceAll("\\s+","");
            
            switch(choice)
            {
                case QUIT:
                    finished = true;
                    break;
                    
                case ENCHANCE_WEAPON:
                    BLACKSMITH.setMessage(1);
                
                    if(BLACKSMITH.enchance(weapon, player.getGold()))
                        player.pay(weapon.getGoldRequired());
                        
                     break;   
                    
                case ENCHANCE_ARMOUR: 
                    BLACKSMITH.setMessage(1); 
                
                    if(BLACKSMITH.enchance(armour,player.getGold()))
                        player.pay(armour.getGoldRequired());
                    
                    break;   
                    
                case ENCHANCE_POTION: 
                    BLACKSMITH.setMessage(1);
                    
                    if(BLACKSMITH.enchance(potion, player.getGold()))
                        player.pay(potion.getGoldRequired());
                        
                    break;
                 
                case ENCHANCE_AMULET:  
                    BLACKSMITH.setMessage(1);
                    
                    if(BLACKSMITH.enchance(amulet, player.getGold()))
                        player.pay(amulet.getGoldRequired());
                        
                    break;
                    
                case ENCHANCE_RING:  
                    BLACKSMITH.setMessage(1);
                    
                    if(BLACKSMITH.enchance(ring, player.getGold()))
                        player.pay(ring.getGoldRequired());
                        
                    break;    
                 
                case ENCHANCE_BRACELET:    
                    BLACKSMITH.setMessage(1);
                    
                    if(BLACKSMITH.enchance(bracelet, player.getGold()))
                        player.pay(bracelet.getGoldRequired());
                        
                    break;
                    
                default:
                    BLACKSMITH.setMessage(0); 
            }
                
        }
        
    }
    
    /**
     * Interact with the shop.
     */
    private void runShop()
    {
        boolean finished = false;
            
        while(!finished)
        {           
            SHOP.openShop(player.getGold());
                
            String choiceRaw = READER.getString();
            String choice = choiceRaw.toLowerCase().replaceAll("\\s+","");
            
            switch(choice)
            {
                case QUIT:
                    finished = true;
                    break;
                
                case BUY_POTION:
                    SHOP.setMessage(1);
                    
                    System.out.println("\n\nHow many do you want to buy?\n\n");
                    
                    int amount = READER.getInteger();
                        
                    if (player.getGold() >= (SHOP.getPotionPrice() * amount))
                    {
                        player.pay(SHOP.getPotionPrice() * amount);
                        
                        player.increasePotionAmount(amount);
                        
                        System.out.println(Commands.SUCCESS.getCommand() + amount + " Health Potion(s)");
                    }
                    break;
                    
                case BUY_KEY:
                    SHOP.setMessage(1);
                
                    System.out.println("\n\nHow many do you want to buy?\n\n");
                    amount = READER.getInteger();
                        
                    if (player.getGold() >= (SHOP.getKeyPrice() * amount))
                    {
                        player.pay(SHOP.getKeyPrice() * amount);
                        
                        player.addToInventory(Characters.CHEST_KEY.getCharacter(),amount);
                        
                        System.out.println(Commands.SUCCESS.getCommand() + amount + " Keys");
                    }
                    break;
                    
                default:
                    SHOP.setMessage(0);
                    break;
            }
            
        }
        
    }
    
    /**
     * Teleport to a different map
     */
    private void teleport()
    {
        String mapName = WORLD.getCurrentMapName().toLowerCase();
        
        switch(mapName)
        {
            
            case FOREST:
                if(((Player)player).getColCoord() == Pointers.P3.getValue() || ((Player)player).getRowCoord() == Pointers.P12.getValue())
                {
                    WORLD.setCurrentMap(MOUNTAIN);
                    
                    setMountainCoord();
                }
                else 
                {
                    WORLD.setCurrentMap(DESSERT);
                    
                    setDessertCoord();
                }                
                break;
                
            case FORTRESS:
                WORLD.setCurrentMap(TOWN);                
                setTownCoord();                
                break;
            
            case MOUNTAIN:
                WORLD.setCurrentMap(DESSERT);
                setDessertCoord();
                break;
                
            case TOWN:
                WORLD.setCurrentMap(FOREST);                
                setForestCoord();
                break;
                
            case DESSERT:
                if(player.checkInventory(Characters.FOX_KEY.getCharacter(), 1))
                {
                    WORLD.setCurrentMap(SPIDER_CAVE);
                    
                    setSpiderCaveCoord();
                } 
                else
                {
                    displayMessage("You need to fox key to get in!");
                }
                   
                break;
                
            case SPIDER_CAVE:
                if(player.checkInventory(Characters.SPIDER_KEY.getCharacter(), 1))
                {
                    WORLD.setCurrentMap(TOWER);
                    
                    setTowerCoord();
                }
                else
                {
                    displayMessage("You need the Spider Queen key to get in");
                }
                break;
                
            case TOWER:
                //to be completed
                if(WORLD.getTowerLevel() == 6)
                {
                    //get interaction for red dragon kill.
                }    
                    
                if(WORLD.validateTowerLevel())
                {                    
                    WORLD.increaseTowerLevel();                
                    setTowerCoord();
                }
                else
                {
                    displayMessage("You need to kill all the monsters to unlock the teleport!" + " Remaining monsters: " +
                                WORLD.getAmount()); 
                    
                }
                
                break;
        }
    }
    
    /**
     * teleport stone options
     */
    private void runTeleport()
    {
        printDestinationList();
        
        String choiceRaw = READER.getString();
        String choice = choiceRaw.toLowerCase().replaceAll("\\s","");
        
        switch(choice)
        {
            case FORTRESS:
                WORLD.setCurrentMap(FORTRESS);            
                setFortressCoord();
                break;
                
            case TOWN:
                WORLD.setCurrentMap(TOWN);            
                setTownCoord();
                break;
                
            case FOREST:
                WORLD.setCurrentMap(FOREST);            
                setForestCoord();
                break;
                
            case DESSERT:
                WORLD.setCurrentMap(DESSERT);            
                setDessertCoord();
                break;
                
            case MOUNTAIN:
                WORLD.setCurrentMap(MOUNTAIN);            
                setMountainCoord();
                break;
                
            case SPIDER_CAVE:
                WORLD.setCurrentMap(SPIDER_CAVE);            
                setSpiderCaveCoord();
                break;
                
            default:
                displayMessage("Not a destination");  
                
        }
        
    }
    
    /**
     * Print the discovered maps.
     */
    private void printDestinationList()
    {
        MAP_LIST[0] = "\t\tSelect destination:\n\n";  
        
        MAP_LIST[2] = Commands.FORTRESS.getCommand();
        
        MAP_LIST[1] = Commands.QUIT.getCommand();
        
        if(town)
            MAP_LIST[3] = Commands.TOWN.getCommand();
            
        if(forest)
            MAP_LIST[4] = Commands.FOREST.getCommand();
        
        if(mountain)
            MAP_LIST[5] = Commands.MOUNTAIN.getCommand();
        
        if(spiderCave)
            MAP_LIST[7] = Commands.SPIDER_CAVE.getCommand();
        
        if(dessert)
            MAP_LIST[6] = Commands.DESSERT.getCommand();
        
        DISPLAY.listOptions(MAP_LIST);   
        
    }
    
    /**
     * Display the game rulles.
     */
    private void printRulles(int number)
    {
        
        switch(number)
        {
            case -1:
                final String RULLES [] = new String[] 
                {
                    "\t\tWelcome, adventurer!",
                    "\t\tHere you have a chance to multiply your gold!\n\t\tAll you have to do is to guess a number between 1 and 100.",
                    "\t\tYou have 5 tries and I will even give you some help!\n\n\t\tAre you ready?"  
                };
            
                DISPLAY.runStory(RULLES);
                
                break;
            
            case 0:
                final String WIN[] = new String[]
                {
                    "\n\n\t\tYou nailed it! Here is your reward!"
                };
                DISPLAY.runStory(WIN);
                
                break;
                
             case 1:
                final String LOST[] = new String[]
                {
                    "You run out of attempts! Try again later."
                };
                DISPLAY.runStory(LOST);
        }
        
    }
    
    /**
     * Guess the number game
     */
    private void playGame()
    {
        printRulles(-1);
        
        int multiplier = 5;
        int max = 100;
        int tries = 5;
        int number = RAND.nextInt(max -1) + 1; 
        int input = 0;
        int bet = 0;
        
        System.out.println(CLEAR + "\n\n\t\tHow much gold do you want to bet?\tYou have: " + 
                            player.getGold() + Characters.GOLD.getCharacter());
            
        bet = READER.getInteger();
            
        if(player.getGold() < bet)
        {
            System.out.println("\n\n\t\tCome back when you have enough gold");
            
            pressAny();
        }
        else
        {
            
            while(tries > 0)
            {
                System.out.println("\n\n\t\tEnter a number!\t Tries:" + tries);
                
                input = READER.getInteger();
                tries--;
                
                if(input > number)
                    System.out.println("\n\n\t\tGo Lower!");
                    
                else if(input < number)
                    System.out.println("\n\n\t\tGo Higher!");
                    
                else if(input == number)
                {
                    printRulles(0);
                    
                    player.addGold(bet * multiplier);
                    
                    hasRecieved(bet * multiplier, Characters.GOLD.getCharacter());
                    
                    break;
                }
                
                if(tries == 0)
                {
                    printRulles(1);             
                    player.pay(bet);
                }
                
            }
            
        }
        
    }
    
    /**
     * Mount the player.
     */
    private void mount()
    {
        int max = 100;
        String mapName = WORLD.getCurrentMapName().toLowerCase();
        
        switch(mapName)
        {
            case FORTRESS:
                displayMessage("You can not mount here");
                break;
             
            case TOWN:
                if(player.getColCoord() < Pointers.P13.getValue())
                {
                    displayMessage("You can not mount here");
                    
                }
                else
                    isMounted = true;
                    
                break;    
                
            default:
                isMounted = true;
        }
        player.increaseAttackForce((player.getAttackValue() / max) * procentValue);
        player.increaseShield((player.getDefenceValue() / max) * procentValue);
        player.increaseHealthPoints((player.getHealth() / max) * procentValue);
    }
    
    /**
     * dismount.
     */
    private void dismount()
    {
        isMounted = false;
        
    }
    
    /**
     * Display mount
     */
    private String displayMount()
    {
        int max = 100;
        if(mountExists)
            return "+" + (player.getAttackValue() / max) * procentValue + "Attack bonus\n"+
                "\t\t+" + (player.getDefenceValue() / max) * procentValue + "Defence bonus\n" +
                "\t\t+" +  (player.getHealth() / max) * procentValue + "Health bonus\n";
                
        else
            return "You do not have a mount";
            
    }
    
    /**
     * Display stable message.
     */
    private void runStable()
    {
        boolean finished = true;
        int mountPrice = 500;
        
        if(!mountExists)
        {
            
            do
            {
                System.out.println("\n\n\t\tI can give you a horse for a resonable price, warrior\n\n" +
                                    "\t\tHow does 500$ sound? Agree?");
                                    
                String choice = READER.getString();
                
                if(AGREE.contains(choice))
                {
                    System.out.println("\n\n\t\tGreat choice, warrior!\nJust type 'mount' to get on the horse "+
                                        "\t\tor 'dismount' to get off the horse!");
                                        
                    player.pay(mountPrice);
                    displayMessage("You paid 500£");
                    
                    finished = true;
                }
                else
                {
                    System.out.println("\n\n\t\tYou will not get a better price than this! \n\n\t\tTill next time!");
                    
                    finished = true;
                }
            }
            while(!finished);
            
        }
        else
        {
            INTERACTION.getInteraction(Characters.STABLE.getCharacter());
            
            pressAny();
        }
    }
}
