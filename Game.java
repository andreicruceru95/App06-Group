import java.util.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, console based game.  
 *  It's a world of monsters, where a young warior must fight to grow 
 *  so he can defeat tougher and tougher evils.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Your name
 */

public class Game 
{
    public static final char CLEAR = '\u000c';
    public static final String HELP = "help";
    public static final String QUIT = "quit";
    public static final String POTION = "potion";
    public static final String SEE_DATABASE = "database";
    public static final String SEE_STATS = "seestats";
    public static final String SEE_LOCATION = "seelocation";
    public static final String SUCCESS = "\t\tYou have successfully purchased: ";    
    
    public static final Shop SHOP = new Shop();
    public static final int PLAYER_INITIAL_ROW = 7;
    public static final int PLAYER_INITIAL_COL = 7;
    public static final int PLAYER_VISUAL = 3;
    public static final String TOWN = "town";
    public static final String DESSERT = "dessert";
    public static final String SPIDER_CAVE = "spidercave";
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
    public static final String UP = "w";
    public static final String DOWN = "s";
    public static final String LEFT = "a";
    public static final String RIGHT = "d";
        
    private String square = "   ";
    private int monsterLevel = 1;
    
    //A list of monsters name, level
    private HashMap <String, Integer> monsters = new HashMap<>();
    
    //interactions with game objects
    private Interactions interaction = new Interactions();
    
    private Database database = new Database();
    private Display display = new Display();
    private Storyline story = new Storyline();
    private Blacksmith blacksmith = new Blacksmith();
    
    private Characters character;
    private Commands command;
    
    private Player player;
    private Item weapon;
    private Item armour;
    private Item potion;
    private Item amulet;
    
    private World world = new World("World of Zull");
    
    private boolean shopDescription =  false;
    private boolean blacksmithDescription =  false;
    private boolean guardDescription =  false;
    private boolean stableDescription =  false;
    private boolean teleporterDescription =  false;
    private boolean dessertDescription =  false;
    private boolean spiderCaveDescription =  false;
    private boolean firstDeathDescription =  false;
    
    private Random rand = new Random();
    private Input reader = new Input();
    
    private int playerRowCoord = 6;
    private int playerColCoord = 6;
    
    public Game()
    {
                                
        display.runStory(story.getPartOne());
        
        System.out.println(CLEAR);
        
        System.out.println("\n\n\n\t\tPlease enter the player's name:");
        
        String playerName = reader.getString();
        player = new Player(playerName, 1);
        
        weapon = player.getWeapon();
        armour = player.getArmour();
        potion = player.getPotion();
        amulet = player.getAmulet();
        
        display.runStory(story.getPartTwo(playerName));
                        
        // create monsters
        monsters.put(character.BLACK_BEAR.getCharacter(), LEVEL_1);
        monsters.put(character.WHITE_TIGER.getCharacter(), LEVEL_5);
        monsters.put(character.APE_THROWER.getCharacter(), LEVEL_10);
        monsters.put(character.POISON_SPIDER.getCharacter(), LEVEL_15);
        monsters.put(character.RED_SCORPION.getCharacter(),LEVEL_20);
        monsters.put(character.ALBINO_SNAKE.getCharacter(),LEVEL_25);
        monsters.put(character.POLAR_BEAR.getCharacter(),LEVEL_30);
        monsters.put(character.YETI.getCharacter(),LEVEL_35);
        monsters.put(character.ABOMINABLE_SNOWMAN.getCharacter(),LEVEL_40);
        monsters.put(character.DEMON.getCharacter(),LEVEL_45);
        monsters.put(character.CURSED_VAMPIRE.getCharacter(),LEVEL_50);
        monsters.put(character.WITCH.getCharacter(),LEVEL_55);
        monsters.put(character.BERA.getCharacter(),LEVEL_9);
        monsters.put(character.TIGRIS.getCharacter(),LEVEL_14);
        monsters.put(character.APE_KING.getCharacter(),LEVEL_19);
        monsters.put(character.SPIDER_QUEEN.getCharacter(),LEVEL_34);
        monsters.put(character.NINE_TAILS.getCharacter(),LEVEL_49);
        monsters.put(character.DEATH.getCharacter(),LEVEL_60);
        monsters.put(character.RED_DRAGON.getCharacter(),70);
         
        run();
                
    }
    
    /**
     * Main options.
     */
    public void run()
    {
        System.out.println(CLEAR);
        
        updateVisualField();
        
        boolean finished = false;
        while(!finished)
        {
            System.out.println(CLEAR);
        
            changeImage();
            showInfo();
            updateVisualField();
            
            String choice = reader.getString();
            
            if (choice.toLowerCase().replaceAll("\\s+","").equals(QUIT))
                finished = true;
            
            else if(choice.toLowerCase().replaceAll("\\s+","").equals(POTION))
                player.drinkPotion();
                
            else if(choice.toLowerCase().replaceAll("\\s","").contains(HELP))
                display.listOptions(story.getHelp());
                
            else if(choice.toLowerCase().replaceAll("\\s","").contains(SEE_DATABASE))
                database.printAll();
                
            else if(choice.toLowerCase().replaceAll("\\s","").contains(SEE_STATS))
                database.getMonsterList(monsters);
            
            else if(choice.toLowerCase().replaceAll("\\s","").contains(SEE_LOCATION))
                world.printHelpMap(player.getRowCoord(), player.getColCoord());
                
            else
                runMenu(choice);
        }
    }
            
    /**
     * Move the player.
     */
    public void runMenu(String choice)
    {
        System.out.println("Chose direction");
        movePlayer(choice);
    }
    
    /**
     * Update and print the player's visual field.
     */
    private void updateVisualField()
    {
        player.updateVisualField(world.getMapAsArray());
        
    }
    
    /**
     * Move player on the map.
     */
    public void movePlayer(String direction)
    {
              
        playerRowCoord = player.getRowCoord();
        playerColCoord = player.getColCoord();
                
        if(direction.replaceAll("\\s+","").equals(UP))
        {
            int nextRowUp = playerRowCoord - 1;
            int check = checkNextSquare(nextRowUp, playerColCoord);
            
            if(check == 1)
            {
                world.setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(nextRowUp, playerColCoord);
                
            }
                       
        }
        else if(direction.replaceAll("\\s+","").equals(DOWN))
        {
            int nextRowDown = playerRowCoord + 1;
            int check = checkNextSquare(nextRowDown, playerColCoord);
            
            if(check == 1)
            {
                world.setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(nextRowDown, playerColCoord);
                
            }
               
        }
        else if(direction.replaceAll("\\s+","").equals(LEFT))
        {
            int nextColLeft = playerColCoord - 1;
            int check = checkNextSquare(playerRowCoord, nextColLeft);
            
            if(check == 1)
            {
                world.setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(playerRowCoord, nextColLeft);
                
            }
               
        }
        else if(direction.replaceAll("\\s+","").equals(RIGHT))
        {
            int nextColRight = playerColCoord + 1;
            int check = checkNextSquare(playerRowCoord, nextColRight);
            
            if(check == 1)
            {
                world.setObject(playerRowCoord ,playerColCoord,"   ");
                
                player.setCoordinates(playerRowCoord, nextColRight);
                
            }
            
        }
        
        //updateVisualField();
        
        //checkFirstInteraction();       
    }
    
    /**
     * Display information about the player and map.
     */
    public void showInfo()
    {
        System.out.println("\tMap: " + world.getCurrentMapName().toUpperCase() + "\n");
        System.out.println(player.getStats()); 
        System.out.println("\tGold: " + player.getGold() + "" + character.GOLD.getCharacter());
        ((Weapon) weapon).print();
        ((Armour) armour).print();
        ((Potion) potion).print();
        ((Amulet) amulet).print();
    }
    
    /**
     * Check the next square
     */
    public int checkNextSquare(int nextRow, int nextCol)
    { 
        if (world.getSquareValue(nextRow,nextCol).equals(square))
        {
            return 1;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(character.WALL.getCharacter()) || world.getSquareValue(nextRow,nextCol).equals(character.ROCK.getCharacter()))
        {
            System.out.println("Cannot go through walls");
            
            return 0;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(character.SHOP.getCharacter()))
        {
            runShop();
            
            return 0;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(character.BLACKSMITH.getCharacter()))
        {
            runBlacksmith();
            
            return 0;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(character.CHEST.getCharacter()))
        {
            //SEE CHEST
            return 1;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(character.GOLD.getCharacter()))
        {
            //take gold
            return 1;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(character.ITEM.getCharacter()))
        {
            //take random item
            return 1;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(character.TELEPORT.getCharacter()))
        {
            teleport();
            return 0;
        }
        else 
        {
            String character = (world.getSquareValue(nextRow,nextCol));
            
            Actor monster = findMonster(character);
            
            if (monster != null)
            {
                int result = action(monster);
                
                int check = checkResult(result, character);
                
                return check;
            }
            
        }
        return 0;
    }
    
    /**
     * Spawn another monster on the map if you won the fight.
     * If you die, you will be set back to the initial position.
     */
    private int checkResult(int result, String character)
    {
        if(result > 0)
        {
            System.err.println("\t\t\t\tYou Win!");
                    
            world.addAnother(character);
            
            checkLuck();
                    
            player.addScore(1);
            
            player.addGold(goldChance());
                    
            return 1;
        }
                
        else
        {
            if(firstDeathDescription == false)
            {
                System.out.println("You died! You will be sent back in town where someone will take care of you.");
                System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
                reader.getAny();
                firstDeathDescription = true;
            }
            System.err.println("\t\t\t\tYou Lost!");
                    
            player.setCoordinates(PLAYER_INITIAL_ROW, PLAYER_INITIAL_COL);
            player.setFullHealth();
                    
            guardQuest();
        }
        return 0;
    }
    
    /**
     * Find which monster we are dealing with.
     */
    private Actor findMonster(String character)
    {
        for (String monsterName : monsters.keySet())     
        {
            if (monsterName.equals(character))
            {
                monsterLevel = monsters.get(monsterName);
                
                Actor monster = new Monster(monsterName,monsterLevel);
                
                return monster;
            }
        }
        return null;
    }
    
    private void checkLuck()
    {
        
    }
    
    /**
     * Fast-forward fight
     */
    public int action(Actor monster)
    {
        do
        {
            monster.receiveDmg(player.attack());
            System.out.println("Monster received " + monster.receiveDmg(player.attack()));
                        
            player.receiveDmg(monster.attack());
            System.out.println("Player received " + player.receiveDmg(monster.attack()));    
            
        }
        while(player.checkHealth() == true && monster.checkHealth() == true);
        
        return player.getHitPoints();
    }
    
    /**
     * 
     */
    public void changeImage()
    {
        if(player.getCurrentHealth() <= player.getFullHealth() / 2)
            player.changeImage(character.PLAYER2.getCharacter());
            
        else
            player.changeImage(character.PLAYER.getCharacter()); 
    }
     
    
    /**
     * 30% chance to recieve a 2x monster's level amount of gold.
     */
    private int goldChance()
    {
        int min = 5;
        int max = 15;
                
        int dropChance = rand.nextInt(max - min) + min;
        int multiplier = rand.nextInt(max - (min + 1)) + min;
        
        if(dropChance == min || dropChance == 1 || dropChance == max)
        {
            return monsterLevel * multiplier;
        }
        
        return 0;
    }
    
    /**
     * The first interaction with some of the most important game elements.
     */
    public void checkFirstInteraction()
    {
        if(player.checkVisualField(character.SHOP.getCharacter()) == true && shopDescription == false)
            shopDescription = interaction.getInteraction(character.SHOP.getCharacter());            
            
        else if(player.checkVisualField(character.BLACKSMITH.getCharacter()) == true && blacksmithDescription == false)
            blacksmithDescription = interaction.getInteraction(character.BLACKSMITH.getCharacter()); 
            
        else if(player.checkVisualField(character.STABLE.getCharacter()) == true && stableDescription == false)
            stableDescription = interaction.getInteraction(character.STABLE.getCharacter());
                  
        else if(player.checkVisualField(character.GUARD.getCharacter()) == true && guardDescription == false)
            guardDescription = interaction.getInteraction(character.GUARD.getCharacter());
            
        else if(player.checkVisualField(character.TELEPORT.getCharacter()) == true && teleporterDescription == false)
            teleporterDescription = interaction.getInteraction(character.TELEPORT.getCharacter());
            
        else if(world.getCurrentMapName().toLowerCase().equals(DESSERT) && dessertDescription == false)
            dessertDescription = interaction.getInteraction(DESSERT);
                        
        else if(world.getCurrentMapName().toLowerCase().equals(SPIDER_CAVE) && spiderCaveDescription == false)
            spiderCaveDescription = interaction.getInteraction(SPIDER_CAVE);
            
    }
    
    /**
     * Enchance an item.
     */
    private void runBlacksmith()
    {
        boolean finished = false;
            
        while(!finished)
        {
            System.out.println("\n\n\t\tWhat can I do for you?\n\n");
                
            blacksmith.openBlacksmithShop();
                
            String choice = reader.getString();
                
            if(choice.toLowerCase().replaceAll("\\s+","").equals("quit"))
            {
                finished = true;
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("enchanceweapon"))
            {
                                 
                if(blacksmith.enchance(weapon, player.getGold()))
                    player.pay(blacksmith.getCost(weapon));
                
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("enchancearmour"))
            {
                
                if(blacksmith.enchance(armour,player.getGold()))
                    player.pay(blacksmith.getCost(armour));
                    
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("enchancepotion"))
            {
                
                if(blacksmith.enchance(potion, player.getGold()))
                    player.pay(blacksmith.getCost(potion));
                    
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("enchanceamulet"))
            {
                
                if(blacksmith.enchance(amulet, player.getGold()))
                    player.pay(blacksmith.getCost(amulet));
                
            }
            else
                System.out.println("Not an option");
                
        }
        
    }
    
    /**
     * Buy from shop.
     */
    private void runShop()
    {
        boolean finished = false;
            
        while(!finished)
        {
            System.out.println("\t\tHave a look at what I got!\n\n\n");
               
            SHOP.openShop();
                
            String choice = reader.getString();
            
            if(choice.toLowerCase().replaceAll("\\s+","").equals("quit"))
            {
                finished = true;
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buypotion"))
            {
                System.out.println("\n\nHow many do you want to buy?\n\n");
                int amount = reader.getInteger();
                    
                if (player.getGold() >= (SHOP.getPotionPrice() * amount))
                {
                    player.pay(SHOP.getPotionPrice() * amount);
                    
                    player.increasePotionAmount(amount);
                    
                    System.out.println(SUCCESS + amount + " Health Potion(s)");
                }
                
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buyattack"))
            {
                
                if (player.getGold() >= (SHOP.getAttackPrice()))
                {
                    player.pay(SHOP.getAttackPrice());
                    
                    player.increaseAttackForce(SHOP.getAtackValue());
                    
                    System.out.println(SUCCESS + " Attack value");
                }
                
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buyshield"))
            {
                
                if (player.getGold() >= (SHOP.getShieldPrice()))
                {
                    player.pay(SHOP.getShieldPrice());
                    
                    player.increaseShield(SHOP.getShieldValue());
                    
                    System.out.println(SUCCESS + " Deffence value");
                }
                    
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buyhealth"))
            {
                
                if (player.getGold() >= (SHOP.getHealthPrice()))
                {
                    player.pay(SHOP.getHealthPrice());
                    
                    player.increaseHealthPoints(SHOP.getHealthValue());
                    
                    System.out.println(SUCCESS + " Extra health points");
                }
                
            }
            else
                System.out.println("Not an option");
        }
        
    }
    
    /**
     * Guardian Quest
     */
    public void guardQuest()
    {
        int min = 1;
        int max = player.getScore() + 10;
        
        int guardGold = rand.nextInt(max - min) + min;
        
        player.addGold(guardGold);
        
        System.out.println("You have recieved " + guardGold + " Gold from the guard");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
        reader.getAny();
    }
    
    /**
     * Teleport to a different map
     */
    private void teleport()
    {
        if(world.getCurrentMapName().toLowerCase().equals("town") && world.goTest())
        {
            player.setCoordinates(PLAYER_INITIAL_ROW,PLAYER_INITIAL_COL);
            
            world.setCurrentMap("test");
        }
        else if(world.getCurrentMapName().toLowerCase().equals("town"))
        {
            player.setCoordinates(PLAYER_INITIAL_ROW,PLAYER_INITIAL_COL);
            
            world.setCurrentMap("dessert");
        }
        else if(world.getCurrentMapName().toLowerCase().equals("test"))
        {
            player.setCoordinates(PLAYER_INITIAL_ROW,PLAYER_INITIAL_COL);
            
            world.setCurrentMap("town");
        }
        else if(world.getCurrentMapName().toLowerCase().equals("dessert"))
        {
            player.setCoordinates(PLAYER_INITIAL_ROW,PLAYER_INITIAL_COL);
            
            world.setCurrentMap("spidercave");
        }
        else if(world.getCurrentMapName().toLowerCase().equals("spidercave"))
        {
            player.setCoordinates(PLAYER_INITIAL_ROW,PLAYER_INITIAL_COL);
            
            world.setCurrentMap("town");
        }
    }
}
