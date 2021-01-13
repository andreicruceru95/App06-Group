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
    public static final String UP = ("w");
    public static final String DOWN = ("s");
    public static final String LEFT = ("a");
    public static final String RIGHT = ("d");
    public static final String WALL = "[/]";
    public static final String ROCK = " ⛰ ";
    public static final String SHOP_C = " S ";
    public static final String BLACKSMITH_C = " B ";
    public static final String CHEST = " ⛋ ";
    public static final String GOLD = " $ ";
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
    public static final String BUY_POTION = "buypotion";
    public static final String BUY_KEY = "buykey";
    
    
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
    
    private Actor monster;
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
    private boolean ringExists = false;
    private boolean braceletExists = false;
    private boolean biologistInteraction = false;
    private boolean oldLadyInteraction = false;
    private boolean jewelerInteraction = false;
    private boolean farmerInteraction = false;
    private boolean drunkPersonInteraction = false;
    private boolean town = false;
    private boolean forest = false;
    private boolean mountain = false;
    private boolean dessert = false;
    private boolean spiderCave = false;
    private boolean tower = false;
    private boolean mythicalStone = false;
        
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
        
        DISPLAY.runStory(STORY.getPartTwo(playerName));
                        
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
        MONSTERS.add(new Monster (Characters.BERA.getCharacter(),LEVEL_9, Characters.SPIDER_KEY.getCharacter()));
        MONSTERS.add(new Monster (Characters.TIGRIS.getCharacter(),LEVEL_14, Characters.SPIDER_KEY.getCharacter()));
        MONSTERS.add(new Monster (Characters.APE_KING.getCharacter(),LEVEL_19, Characters.SPIDER_KEY.getCharacter()));
        MONSTERS.add(new Monster (Characters.SPIDER_QUEEN.getCharacter(),LEVEL_34, Characters.FOX_KEY.getCharacter()));
        MONSTERS.add(new Monster (Characters.NINE_TAILS.getCharacter(),LEVEL_49, Characters.TOWER_KEY.getCharacter()));
        MONSTERS.add(new Monster (Characters.DEATH.getCharacter(),LEVEL_60, Characters.CHEST_KEY.getCharacter()));
        MONSTERS.add(new Monster (Characters.RED_DRAGON.getCharacter(),70, Characters.MYTHICAL_STONE.getCharacter()));
         
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
            
            String choiceRaw = READER.getAny();
            String choice = choiceRaw.toLowerCase().replaceAll("\\s+","");
            
            try
            {
                
                switch(choice)
                {
                    case QUIT:
                        finished = true;
                        break;
                    
                    case ADD_TELEPORT:
                        WORLD.addTeleport(player.getRowCoord() + 1, player.getColCoord());
                        break;
                        
                    case POTION:
                        player.drinkPotion();
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
                    
                    default:
                        System.out.println("Not an option");
                } 
            
            }
            catch(Exception e)
            {
                System.out.println("Not a command");
            }
            
        }
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
        System.out.println("Chose direction");
        
          
        if(isDisplayed)
            System.out.println("\t" + message);
        
        isDisplayed = false;
        
        if(hasReceived)
            System.out.println("\tReceived: " + amountReceived + " " + objectReceived);
        
        hasReceived = false;
        
        movePlayer(choice);
    }
    
    /**
     * Update and print the player's visual field.
     */
    private void updateVisualField()
    {
        player.updateVisualField(WORLD.getMapAsArray());
        
    }
    
    /**
     * Move player on the map.
     */
    private void movePlayer(String direction)
    {
        
        switch(direction)
        {
            case UP:
                if(checkNextSquare((player.getRowCoord() - 1), player.getColCoord()))
                {
                    updateHelpMap(UP);
                
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                
                    player.setCoordinates((player.getRowCoord() - 1), player.getColCoord());
                      
                }
                break;                      
        
            case DOWN:
                if(checkNextSquare((player.getRowCoord() + 1), player.getColCoord()))
                {
                    updateHelpMap(DOWN);
                
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                
                    player.setCoordinates((player.getRowCoord() + 1), player.getColCoord());
                
                }
                break;
                
            case LEFT:
                if(checkNextSquare(player.getRowCoord(), (player.getColCoord() - 1)))
                {
                    updateHelpMap(LEFT);
                    
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                
                    player.setCoordinates(player.getRowCoord(), (player.getColCoord() - 1));
                
                }
                break;
            case RIGHT:            
                if(checkNextSquare(player.getRowCoord(), (player.getColCoord() + 1)))
                {
                    updateHelpMap(RIGHT);
                
                    WORLD.setObject(player.getRowCoord() ,player.getColCoord(),"   ");
                
                    player.setCoordinates(player.getRowCoord(), (player.getColCoord() + 1));
                
                }
            
        }
        
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
                System.out.println("\tMap: " + mapName.toUpperCase() + " Level " + WORLD.getTowerLevel() + "\n");
            
                break;
                
            default:
                System.out.println("\tMap: " + mapName.toUpperCase() + "\n");                
        }
        
        System.out.println("\tPlayer: " + player.getName() + "\tScore: " + 
                                    player.getScore() + "\n" + player.getHealthInfo());
                               
        if(stats)
        {
            System.out.println(player.getStats()); 
            getGold();
              
        }
        
        createRing();
        createBracelet();
            
        if(items)
        {
            ((Weapon) weapon).print();
            ((Armour) armour).print();
            ((Potion) potion).print();
            ((Amulet) amulet).print();
            
            if(ringExists)
                ((Ring) ring).print();
            
            if(braceletExists)
                ((Bracelet) bracelet).print();
            
            if(player.stoneExists())
                System.out.print("\nTELEPORT STONE - type 'teleport' to use\n\n");
                
        }   
         
    }
    
    /**
     * Create the player's ring.
     */
    private void createRing()
    {
        
        if(player.ringExists())
        {
            ring = player.getRing();
            
            ringExists = true;
        }
        
    }
    
    /**
     * Create the player's bracelet.
     */
    private void createBracelet()
    {
        
        if(((Player) player).braceletExists())   
        {
            bracelet = player.getBracelet();
            
            braceletExists = true;
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
                
            player.checkCharacter(character);
                
            pickUpGold = dropGold(monster);
            player.addScore(pickUpGold);
            player.addScore(monster.getLevel());
                
            dropItem(monster);
            dropChest(monster);
            dropKey(monster);
            dropPotion(monster);
            dropRemains(monster);
                
            return true;
        }
        
        return false;
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
            player.addToInventory(WORLD.getSquareValue(nextRow,nextCol), 1);
            
            return true;
        }
        else 
        {
            
            switch(squareValue)
            {
                case SQUARE:
                    return true;
                
                case WALL:
                    message = "Cannot go through walls!";
                    isDisplayed = true;
                    
                    return false;
                
                case ROCK:
                    message = "Cannot go through walls!";
                    isDisplayed = true;
                    
                    return false;
                
                case SHOP_C:
                    runShop();
                    
                    return false;
                
                case BLACKSMITH_C:
                    runBlacksmith();
                    
                    return false;
                
                case CHEST:
                    if(player.checkInventory(Characters.CHEST_KEY.getCharacter(), 1))
                    {
                        openChest();
                        
                        return true;
                    }
                    else
                    {
                        message = "Not enough keys!";
                        isDisplayed = true;
                        
                        return false;
                    }
                 
                case GOLD:
                    hasRecieved(pickUpGold, Characters.GOLD.getCharacter());
                    player.addGold(pickUpGold);
                    
                    return true;
                    
                case NURSE:
                    player.setFullHealth();
                    message = "Your healh has been restored!";
                    isDisplayed = true;
                    
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
                        
                        INTERACTION.getInteraction(Characters.STONE_SPOT_2.getCharacter());
                        
                        pressAny();
                        
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
                    
                
                case POTION:
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
     * Drop a chest on the map.
     */
    private void dropChest(Actor monster)
    {
        if(((Monster) monster).dropChest())
        {
            WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
            ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, Characters.CHEST.getCharacter()) ;  
        }
    }
    
    /**
     * Drop a potion on the map.
     */
    private void dropPotion(Actor monster)
    {
        if(((Monster) monster).dropPotion())
        {
            WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
            ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, Characters.POTION.getCharacter()) ;  
        }
    }
    
    /**
     * Drop a key on the map.
     */
    private void dropKey(Actor monster)
    {
        if(((Monster) monster).dropKey())
        {
            WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
            ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, Characters.CHEST_KEY.getCharacter()) ;  
        }
    }
    
    /**
     * Drop monster remains on the map.
     */
    private void dropRemains(Actor monster)
    {
        if(((Monster) monster).dropRemains())
        {
            WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
            ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, Characters.REMAINS.getCharacter()) ;  
        }
    }
    
    /**
     * 50% chance to obtain (1, 5) x monster level items or gold.
     */
    private void openChest()
    {
        if((RAND.nextInt(1 - 0) +0) == 0)
        {
            player.addToInventory(((Monster) monster).getDrop(), ((Monster) monster).getDropAmount());
            
            hasRecieved(((Monster) monster).getDropAmount(), ((Monster) monster).getDrop());
        }
        else
        {
            player.addGold(((Monster) monster).getDropAmount() * monster.getLevel());
            
            hasRecieved(((Monster) monster).getDropAmount() * monster.getLevel(), Characters.GOLD.getCharacter());
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
                
                player.setRing();
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
                
                player.setBracelet();
            }
            else
                pressAny();
            
        }
        else if(row == Pointers.P31.getValue() && col == Pointers.P13.getValue())
        {
            
            if((player.getKilled() >= 50))
            {
                INTERACTION.getInteraction(Characters.PERSON_8.getCharacter());
                
                pressAny();
                
                player.addGold(500);
                
                player.decreaseKilled(50);
                
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
            INTERACTION.getInteraction(Characters.PERSON_13.getCharacter());
            
            pressAny();
            
        }
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
     * Drop gold on the map.
     * @return an amount of gold equal to the monster's level.
     */
    private int dropGold(Actor monster)
    {
        if(((Monster) monster).dropGold() != 0)
        {
            WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
            ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, Characters.GOLD.getCharacter()) ;           
        }
        
        return monster.getLevel();
    }
    
    /**
     * Drop an item on the map.
     */
    private void dropItem(Actor monster)
    {
        if(((Monster) monster).dropItem())
        {
            WORLD.addObjects(((Player) player).getColCoord() - 1 , ((Player) player).getColCoord() + 1,
            ((Player) player).getRowCoord() - 1, ((Player) player).getRowCoord() + 1, ((Monster) monster).getDrop()) ;           
        }
           
    }
    
    /**
     * Spawn another monster on the map if you won the fight.
     * If you die, you will be set back to the initial position.
     */
    private boolean checkResult(boolean result, Actor monster, String Characters)
    {
        if(result)
        {
            message = "You Won!";
            isDisplayed = true;
            
            return true;
        }
        else
        {
            message = "You Lost :(";
            isDisplayed = true;
            
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
            message = "You died! You will be sent back in town where someone will take care of you.";
            isDisplayed = true;
            
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
     * Change the player's icon when it's health is lower than 50%.
     */
    private void changeImage()
    {
        if(player.getCurrentHealth() <= player.getFullHealth() / 2)
            player.changeImage(Characters.PLAYER2.getCharacter());
            
        else
            player.changeImage(Characters.PLAYER.getCharacter()); 
            
    }
        
    /**
     * The first interaction with some of the game elements.
     */
    private void checkFirstInteraction()
    {
        
        if(player.checkVisualField(Characters.SHOP.getCharacter()) && !shopDescription)
        {
            shopDescription = INTERACTION.getInteraction(Characters.SHOP.getCharacter());    
            pressAny();
        }    
        else if(player.checkVisualField(Characters.BLACKSMITH.getCharacter()) && !blacksmithDescription)
        {
            blacksmithDescription = INTERACTION.getInteraction(Characters.BLACKSMITH.getCharacter()); 
            pressAny();
        }    
        else if(player.checkVisualField(Characters.STABLE.getCharacter()) && !stableDescription)
        {
            stableDescription = INTERACTION.getInteraction(Characters.STABLE.getCharacter());
            pressAny();
        }          
        else if(player.checkVisualField(Characters.GUARD.getCharacter()) && !guardDescription)
        {
            guardDescription = INTERACTION.getInteraction(Characters.GUARD.getCharacter());
            pressAny();
        }    
        else if(player.checkVisualField(Characters.TELEPORT.getCharacter()) && !teleporterDescription)
        {
            teleporterDescription = INTERACTION.getInteraction(Characters.TELEPORT.getCharacter());
            pressAny();
        }    
        else if(WORLD.getCurrentMapName().toLowerCase().equals(DESSERT) && !dessertDescription)
        {
            dessertDescription = INTERACTION.getInteraction(DESSERT);
            pressAny();
        }                
        else if(WORLD.getCurrentMapName().toLowerCase().equals(SPIDER_CAVE) && !spiderCaveDescription)
        {
            spiderCaveDescription = INTERACTION.getInteraction(SPIDER_CAVE);
            pressAny();
        }    
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
                player.addGold(player.getReward());
                
                hasRecieved(player.getReward(), Characters.GOLD.getCharacter());
                
                break;
            
        }
        
    }
        
    /**
     * Interact with the blacksmith.
     */
    private void runBlacksmith()
    {
        boolean finished = false;
            
        while(!finished)
        {
            BLACKSMITH.createList(ringExists, braceletExists);
            
            message = "\n\n\t\tWhat can I do for you?\n\n";
            isDisplayed = true;
                
            BLACKSMITH.openBlacksmithShop();
                
            String choiceRaw = READER.getString();
            String choice = choiceRaw.toLowerCase().replaceAll("\\s+","");
            
            switch(choice)
            {
                case QUIT:
                    finished = true;
                    break;
                case ENCHANCE_WEAPON:
                    if(BLACKSMITH.enchance(weapon, player.getGold()))
                        player.pay(BLACKSMITH.getCost(weapon));
                        
                     break;   
                    
                case ENCHANCE_ARMOUR:               
                    if(BLACKSMITH.enchance(armour,player.getGold()))
                        player.pay(BLACKSMITH.getCost(armour));
                    
                    break;   
                    
                case ENCHANCE_POTION:                
                    if(BLACKSMITH.enchance(potion, player.getGold()))
                        player.pay(BLACKSMITH.getCost(potion));
                        
                    break;
                 
                case ENCHANCE_AMULET:                
                    if(BLACKSMITH.enchance(amulet, player.getGold()))
                        player.pay(BLACKSMITH.getCost(amulet));
                        
                    break;
                    
                case ENCHANCE_RING:                
                    if(BLACKSMITH.enchance(ring, player.getGold()))
                        player.pay(BLACKSMITH.getCost(ring));
                        
                    break;    
                 
                case ENCHANCE_BRACELET:                
                    if(BLACKSMITH.enchance(bracelet, player.getGold()))
                        player.pay(BLACKSMITH.getCost(bracelet));
                        
                    break;
                    
                default:
                    message = "Not an option";
                    isDisplayed = true;
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
            System.out.println("\t\tHave a look at what I got!\n\n\n");
               
            SHOP.openShop();
                
            String choiceRaw = READER.getString();
            String choice = choiceRaw.toLowerCase().replaceAll("\\s+","");
            
            switch(choice)
            {
                case QUIT:
                    finished = true;
                
                case BUY_POTION:
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
                    message = "Not an option";
                    isDisplayed = true;
                    
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
                if(WORLD.checkTeleport(player.getColCoord()))
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
                
            case TOWN:
                WORLD.setCurrentMap(FOREST);                
                setForestCoord();
                break;
                
            case DESSERT:
                if(player.getMonsterStatus("fox"))
                {
                    WORLD.setCurrentMap(SPIDER_CAVE);
                    
                    setSpiderCaveCoord();
                }                
                break;
                
            case SPIDER_CAVE:
                if(player.getMonsterStatus("queen"))
                {
                    WORLD.setCurrentMap(TOWER);
                    
                    setTowerCoord();
                }
                break;
                
            case TOWER:
                WORLD.increaseTowerLevel();                
                setTowerCoord();
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
                message = "Not a destination";   
                isDisplayed = true;
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
}
