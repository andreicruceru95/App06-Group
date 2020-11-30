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
    private static final char CLEAR = '\u000c';
    private static final Shop OBJECT_SHOP = new Shop();
    
    private static final int PLAYER_INITIAL_ROW = 7;
    private static final int PLAYER_INITIAL_COL = 7;
    private static final int FULL_L = 34;
    private static final int FULL_H = 46;
    private static final int PLAYER_VISUAL = 3;
    private static final int SHOP_ROW = 10;
    private static final int SHOP_COL = 3;
    private static final String TELEPORT = "  ↈ ";
    private static final String PERSON_1 = " ⛹";
    private static final String PERSON_2 = " ⛹";
    private static final String PERSON_3 = " ⛹";
    private static final String PERSON_4 = " ⛹";
    private static final String PERSON_5 = " ⛹";
    private static final String GUARD = " ⏳ ";
    private static final String STABLE = " ♞";
    private static final String BLACK_BEAR = " ① ";
    private static final String WHITE_TIGER = " ② ";
    private static final String APE_THROWER = " ③ ";
    private static final String POISON_SPIDER = " ④ ";
    private static final String RED_SCORPION = " ⑤ ";
    private static final String ALBINO_SNAKE = " ⑥ ";
    private static final String POLAR_BEAR = " ⑦ ";
    private static final String YETI = " ⑧ ";
    private static final String ABOMINABLE_SNOWMAN = " ⑨ ";
    private static final String DEMON = " ⑩ ";
    private static final String CURSED_VAMPIRE = " ⑪ ";
    private static final String WITCH = " ⑫ ";
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_5 = 5;
    private static final int LEVEL_10 = 10;
    private static final int LEVEL_15 = 15;
    private static final int LEVEL_20 = 20;
    private static final int LEVEL_25 = 25;
    private static final int LEVEL_30 = 30;
    private static final int LEVEL_35 = 35;
    private static final int LEVEL_40 = 40;
    private static final int LEVEL_45 = 45;
    private static final int LEVEL_50 = 50;
    private static final int LEVEL_55 = 55;
    
    //bosses    
    private static final String BERA = " Ⓑ ";
    private static final String TIGRIS = " Ⓣ ";
    private static final String APE_KING = " Ⓐ ";
    private static final String SPIDER_QUEEN = " Ⓢ ";
    private static final String NINE_TAILS = " Ⓝ ";
    private static final String DEATH = " Ⓓ ";
    private static final String RED_DRAGON = " Ⓡ ";
    private static final int LEVEL_9 = 9;
    private static final int LEVEL_14 = 14;
    private static final int LEVEL_19 = 19;
    private static final int LEVEL_34 = 34;
    private static final int LEVEL_49 = 49;
    private static final int LEVEL_60 = 60;
    private static final int LEVEL_70 = 70;
    
    private static final String MAIN_QUEST = "!";
    private static final String QUEST_HUSBAND = "Q1";
    private static final String QUEST_FARM = "Q2";
    private static final String QUEST_WOLF = "Q3";
    private static final String MISSING_HUSBAND = "??";
    private static final String PLAYER = "☧";
    
    private static final String ROCK = " ⛰ ";
    private static final String WALL = "[/]";
    private static final String BLACKSMITH = " B ";
    private static final String SHOP = " S ";
    private static final String CHEST = "!?";
    private static final String GOLD = "$";
    private static final String ITEM = "!^";
    private static final String TREE = " ¥";
    private static final String UP = "w";
    private static final String DOWN = "s";
    private static final String LEFT = "a";
    private static final String RIGHT = "d";
    private String square = "   ";
    private int monsterLevel = 1;;
    //A list of monsters name, level
    private HashMap <String, Integer> monsters = new HashMap<String, Integer>();
    private Player player;
    private World world = new World("World of Zull");
    
    private boolean shopDescription =  false;
    private boolean blacksmithDescription =  false;
    private boolean guardDescription =  false;
    private boolean stableDescription =  false;
    private boolean teleporterDescription =  false;
    private boolean dessertDescription =  false;
    private boolean spiderCaveDescription =  false;
    private boolean firstDeathDescription =  false;
    
    private Blacksmith blacksmith;
    private Random rand = new Random();
    private Input reader = new Input();
    private int playerRowCoord = 6;
    private int playerColCoord = 6;
    
    public Game()
    {
        String [] partOne = new String[] 
        {
            "\t\tOnce upon a time the world was once a beautiful and peaceful place,\n" + 
            "\tbut one day things changed when evil creatures start appearing everywhere..",
            "\t\tPeople of the lands known as gladiators,\n\tthe best of the human race had to offer " + 
            "were ready for such a day to come \n\tbut when their people needed them most...they vanished....",
            "\t\tNow people talk about the next \"gladiators\" known as reborns ",
            "\t\tAlthough they are of unknown origin, they have the power\n\tto take on the darkness looming over our world...",
            "\t\tBut I believe they will save the world....."
            
        };
                        
        runStory(partOne);
        
        System.out.println(CLEAR);
        System.out.println("\n\n\n\t\tPlease enter the player's name:");
        String playerName = reader.getString();
        player = new Player(playerName);
        blacksmith = new Blacksmith(player, player.getWeapon(), player.getArmour(), player.getPotion());
        
        String [] partTwo = new String[] 
        {
            "\t\tOne day, a young warrior stepped in our town.\n\tThe only safe place left for humans..",
            "\t\tPeople loved this warrior.\n\tThey called him " + player.getName() + "..",
            "\t\tHe promised that he will travel the world \n\tand find the root of this evil",
            "\t\tBut will he be able to do it..?\n\tOr is he just another scared cat..?"
            
        };
        
        runStory(partTwo);
                        
        // create monsters
        monsters.put(BLACK_BEAR,LEVEL_1);
        monsters.put(WHITE_TIGER, LEVEL_5);
        monsters.put(APE_THROWER, LEVEL_10);
        monsters.put(POISON_SPIDER, LEVEL_15);
        monsters.put(RED_SCORPION,LEVEL_20);
        monsters.put(ALBINO_SNAKE,LEVEL_25);
        monsters.put(POLAR_BEAR,LEVEL_30);
        monsters.put(YETI,LEVEL_35);
        monsters.put(ABOMINABLE_SNOWMAN,LEVEL_40);
        monsters.put(DEMON,LEVEL_45);
        monsters.put(CURSED_VAMPIRE,LEVEL_50);
        monsters.put(WITCH,LEVEL_55);
        monsters.put(BERA,LEVEL_9);
        monsters.put(TIGRIS,LEVEL_14);
        monsters.put(APE_KING,LEVEL_19);
        monsters.put(SPIDER_QUEEN,LEVEL_34);
        monsters.put(NINE_TAILS,LEVEL_49);
        monsters.put(DEATH,LEVEL_60);
        monsters.put(RED_DRAGON,70);
        run();
                
    }
    
    public void runStory(String[] part)
    {
        for(int i = 0; i < part.length; i ++)
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            
            System.out.println(CLEAR);
            System.out.println(part[i]);
        }
    }
    
        
    /**
     * Main options.
     */
    public void run()
    {
        world.printVisualField(playerRowCoord, playerColCoord);
        
        System.out.println("\t\tEnter \'w\' to move forward");  
        System.out.println("\t\tEnter \'s\' to move back");  
        System.out.println("\t\tEnter \'a\' to move left");  
        System.out.println("\t\tEnter \'d\' to move right");  
        
        boolean finished = false;
        while(!finished)
        {
            String choice = reader.getString();
            if (choice.toLowerCase().replaceAll("\\s+","").equals("quit"))
            {
                finished = true;
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("potion"))
            {
                player.drinkPotion();
            }
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
     * Move player on the map.
     */
    public void movePlayer(String direction)
    {
        System.out.println(CLEAR);
              
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
        // else
            // System.out.println("\n\tNot a direction");
        
        playerRowCoord = player.getRowCoord();
        playerColCoord = player.getColCoord();
        
        System.out.println("\tMap: " + world.getCurrentMapName().toUpperCase() + "\n");
        System.out.println(player.getPlayerAttributes()); 
        System.out.println(player.getItemsAttributes());
        
        world.printVisualField(playerRowCoord,playerColCoord);
        
        checkFirstInteraction();       
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
        else if(world.getSquareValue(nextRow,nextCol).equals(WALL) || world.getSquareValue(nextRow,nextCol).equals(ROCK))
        {
            System.out.println("Cannot go through walls");
            return 0;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(SHOP))
        {
            runShop();
            
            return 0;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(BLACKSMITH))
        {
            runBlacksmith();
            
            return 0;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(CHEST))
        {
            //SEE CHEST
            return 1;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(GOLD))
        {
            //take gold
            return 1;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(ITEM))
        {
            //take random item
            return 1;
        }
        else if(world.getSquareValue(nextRow,nextCol).equals(TELEPORT))
        {
            teleport();
            return 0;
        }
        else 
        {
            String character = (world.getSquareValue(nextRow,nextCol));
            
            Monster monster = findMonster(character);
            
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
                    
            world.addAnotherMonster(character);
            int gold = dropGold();
                    
            player.addScore(1);
            player.addGold(gold);
                    
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
    private Monster findMonster(String character)
    {
        for (String monsterName : monsters.keySet())     
        {
            if (monsterName.equals(character))
            {
                monsterLevel = monsters.get(monsterName);
                
                Monster monster = new Monster(monsterName,monsterLevel);
                
                return monster;
            }
        }
        return null;
    }
    
    /**
     * Fast-forward fight
     */
    public int action(Monster monster)
    {
        do
        {
            int playerAttack = player.attack();
            int monsterAttack = monster.attack();
        
            monster.receiveDmg(playerAttack);
            
            player.receiveDmg(monsterAttack);
                
        }
        while(player.checkHealth() == true && monster.checkHealth() == true);
        
        return player.getHitPoints();
    }
    
    /**
     * 30% chance to recieve a 2x monster's level amount of gold.
     */
    private int dropGold()
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
        if(world.checkVisualField(SHOP) == true && shopDescription == false)
        {
            System.out.println("There is a shop there, you can buy health potions from there");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            shopDescription = true;
        }
        
        if(world.checkVisualField(BLACKSMITH) == true && blacksmithDescription == false)
        {
            System.out.println("There is a blacksmith there, you can ask him to improve your items for a price.\n" +
                                "Ask him \"enchance armour\" or \"enchance weapon\" or \"enchance potion\"." );
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            blacksmithDescription = true;
        }
        
        if(world.checkVisualField(STABLE) == true && stableDescription == false)
        {
            System.out.println("There is a stable there, you soon be able to buy a horse from there");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            stableDescription = true;
        }
        
        if(world.checkVisualField(GUARD) == true && guardDescription == false)
        {
            System.out.println("Town guard: \t\tHey, You! \n\t\tCome here. \n\tAre you that warrior " + 
                                "everyone is talking about?\n\tIf you are that brave, why don't you go" + 
                                "and kill some wolves for us?\n\tThey have been killing our people for a while.\n" +
                                "\tActually I'll pay you if for each monster you kill.\n\t\tDeal?");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            guardDescription = true;
        }
        
        if(world.checkVisualField(TELEPORT) == true && teleporterDescription == false)
        {
            System.out.println("There is a teleporter there, you can go to a different map.");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            teleporterDescription = true;
        }
        
        if(world.getCurrentMapName().toLowerCase().equals("dessert") && dessertDescription == false)
        {
            System.out.println("This was once a beautifull forrest. Now it's a dangerous death field. Be aware!");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            dessertDescription = true;
        }
        
        if(world.getCurrentMapName().toLowerCase().equals("spidercave") && spiderCaveDescription == false)
        {
            System.out.println("A cave? You should be carefull.. Who knows what monsters lives in here.");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\t\tPress any to continue..");
            reader.getAny();
            spiderCaveDescription = true;
        }
    }
    
    /**
     * Enchance an item.
     */
    private void runBlacksmith()
    {
        boolean finished = false;
            
        while(!finished)
        {
            System.out.println("What can I do for you?");
                
            blacksmith.openBlacksmithShop();
                
            String choice = reader.getString();
                
            if(choice.toLowerCase().replaceAll("\\s+","").equals("quit"))
            {
                finished = true;
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("enchanceweapon"))
            {
                int weaponCost = blacksmith.getWeaponCost();
                   
                if (blacksmith.enchanceWeapon(player.getGold()) == true)
                {
                    player.pay(weaponCost);
                }
                
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("enchancearmour"))
            {
                int armourCost = blacksmith.getArmourCost();
                    
                if (blacksmith.enchanceArmour(player.getGold()) == true)
                    player.pay(armourCost);
                    
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("enchancepotion"))
            {
                int potionCost = blacksmith.getPotionCost();
                   
                if (blacksmith.enchancePotion(player.getGold()) == true)
                    player.pay(potionCost);
                    
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
            System.out.println("Have a look at what I got!");
               
            OBJECT_SHOP.openShop();
                
            String choice = reader.getString();
            
            if(choice.toLowerCase().replaceAll("\\s+","").equals("quit"))
            {
                finished = true;
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buypotion"))
            {
                System.out.println("How many do you want to buy?");
                int amount = reader.getInteger();
                    
                if (player.getGold() >= (OBJECT_SHOP.getPotionPrice() * amount))
                {
                    player.pay(OBJECT_SHOP.getPotionPrice() * amount);
                    
                    player.increasePotionAmount(amount);
                }
                
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buyattack"))
            {
                
                if (player.getGold() >= (OBJECT_SHOP.getAttackPrice()))
                {
                    player.pay(OBJECT_SHOP.getAttackPrice());
                    
                    player.increaseAttackForce(OBJECT_SHOP.getAtackValue());
                }
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buyshield"))
            {
                
                if (player.getGold() >= (OBJECT_SHOP.getShieldPrice()))
                {
                    player.pay(OBJECT_SHOP.getShieldPrice());
                    
                    player.increaseShield(OBJECT_SHOP.getShieldValue());
                }
                    
            }
            else if(choice.toLowerCase().replaceAll("\\s+","").equals("buyhealth"))
            {
                
                if (player.getGold() >= (OBJECT_SHOP.getHealthPrice()))
                {
                    player.pay(OBJECT_SHOP.getHealthPrice());
                    
                    player.increaseHitPoints(OBJECT_SHOP.getHealthValue());
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
        if(world.getCurrentMapName().toLowerCase().equals("town"))
        {
            player.setCoordinates(PLAYER_INITIAL_ROW,PLAYER_INITIAL_COL);
            
            world.setCurrentMap("dessert");
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
