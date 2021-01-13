import java.util.*;

/**
 * This class will make the conection between maps.
 *
 * @authors Andrei Cruceru
 * @version 1.0.12
 */
public class World
{
    private static final int MAP_EDGE = 3;
    private static final int FULL_L = 34;
    private static final int FULL_H = 46;
    private static final String SQUARE = "   ";
    
    private Map currentMap;
    private Map town;
    private Map dessert;
    private Map spiderCave;
    private Map fortress;
    private Map forest;
    private Map tower;
    private Map mountain;
    private Map userHelp;
    private Map test;
    
    private String biologist;
    private String oldLady;
    private String jeweler;
    private String farmer;
    private String drunkPerson;
    private String mythicalStone;
           
    private int row = 3;
    private int col = 3;
    private int towerLevel = 1;
    /**
     * initialising the World.
     * create and initialise the maps.
     */
    public World()
    {
        town = new Map("Town");
        town.createMap(Characters.WALL.getCharacter(),MAP_EDGE);
        addObjectsToTown();
        
        dessert = new Map("Dessert");
        dessert.createMap(Characters.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToDessert();
        
        spiderCave = new Map("SpiderCave");
        spiderCave.createMap(Characters.ROCK.getCharacter(),MAP_EDGE);
        addObjectsToSpiderCave();
        
        fortress = new Map("Fortress");
        fortress.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
        addObjectsToFortress();
        
        forest = new Map("Forest");
        forest.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
        addObjectsToForest();
        
        tower = new Map("Tower");
        tower.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
        addObjectToTower(Characters.WHITE_TIGER.getCharacter());
        
        mountain = new Map("Mountain");
        mountain.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
        addObjectsToMountain();
        
        userHelp = new Map("Location");
        userHelp.createMap(Characters.WALL.getCharacter(),MAP_EDGE);
        
        setCurrentMap("fortress");
    } 
    
    /**
     * Add objects on the map.
     */
    public void addObjects(int columnMin, int columnMax, int rowMin, int rowMax, String object)
    {
        currentMap.addObjects(columnMin, columnMax, rowMin, rowMax, object, 1);
    }
     
    /**
     * @return the used map name.
     */
    public String getCurrentMapName()
    {
        return currentMap.getName();
    }
           
    /**
     * set the curent map to a given map name
     */
    public void setCurrentMap(String name)
    {
        if (name.toLowerCase().equals("town"))
        {
            currentMap = town;
        }
        else if(name.toLowerCase().equals("dessert"))
        {
            currentMap = dessert;
        }
        else if(name.toLowerCase().equals("spidercave"))
        {
            currentMap = spiderCave;
        }
        else if(name.toLowerCase().equals("fortress"))
        {
            currentMap = fortress;
        }
        else if(name.toLowerCase().equals("forest"))
        {
            currentMap = forest;
        }
        else if(name.toLowerCase().equals("dessert"))
        {
            currentMap = dessert;
        }
        else if(name.toLowerCase().equals("spiderCave"))
        {
            currentMap = spiderCave;
        }
        else if(name.toLowerCase().equals("tower"))
        {
            currentMap = tower;
        }
        else if(name.toLowerCase().equals("mountain"))
        {
            currentMap = mountain;
        }
        else
             System.out.println("error");
        
    }
    
    /**
     * check tower Level
     */
    public void increaseTowerLevel()
    {
        if(getTowerLevel() == 1)
        {
            tower.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
            
            addObjectToTower(Characters.POISON_SPIDER.getCharacter());
            
            towerLevel++;
            
        }
        else if(getTowerLevel() == 2)
        {
            tower.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
            
            addObjectToTower(Characters.DEMON.getCharacter());
            
            towerLevel++;
            
        }
        else if(getTowerLevel() == 3)
        {
            tower.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
            
            addObjectToTower(Characters.CURSED_VAMPIRE.getCharacter());
            
            towerLevel++;
            
        }
        else if(getTowerLevel() == 4)
        {
            tower.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
            
            addObjectToTower(Characters.WITCH.getCharacter());
            
            currentMap.addObjects(Pointers.P16.getValue(),Pointers.P17.getValue(), 
                                       Pointers.P20.getValue(),Pointers.P21.getValue(), Characters.DEATH.getCharacter(), 1);
            
            towerLevel++;
            
        }
        else if(getTowerLevel() == 5)
        {
            tower.createMap(Characters.WALL.getCharacter(), MAP_EDGE);
            
            currentMap.addObjects(Pointers.P16.getValue(),Pointers.P17.getValue(), 
                                       Pointers.P20.getValue(),Pointers.P21.getValue(), Characters.RED_DRAGON.getCharacter(), 1);
            
            towerLevel++;
            
        }
        else if(getTowerLevel() == 6)
            currentMap = spiderCave;
    }
    
    /**
     * add object to the town map
     */
    private void addObjectsToTown()
    {
        //add wall
        for (int i = 0; i < FULL_H; i++)
        {
            for(int j = Pointers.P10.getValue(); j < Pointers.P13.getValue(); j++)
            {
                town.setOne(i, j, Characters.WALL.getCharacter());
                
            }
        }
        //add forest entrance
        for (int i = Pointers.P31.getValue(); i < Pointers.P36.getValue(); i++)
        {
            for(int j = Pointers.P10.getValue(); j < Pointers.P13.getValue(); j++)
            {
                town.setOne(i, j, SQUARE);
                
            }
        }
                  
        for(int i = 0; i < FULL_H; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town.setOne(i, j, Characters.TREE.getCharacter());
                
            }
        }
        //add instances in town
        town.setOne(Pointers.P10.getValue(), Pointers.P4.getValue(), Characters.SHOP.getCharacter());
        town.setOne(Pointers.P13.getValue(), Pointers.P9.getValue(), Characters.BLACKSMITH.getCharacter());
                
        town.setOne(Pointers.P17.getValue(),Pointers.P4.getValue(),Characters.PERSON.getCharacter());
        town.setOne(Pointers.P21.getValue(),Pointers.P7.getValue(),Characters.PERSON.getCharacter());
        town.setOne(Pointers.P24.getValue(),Pointers.P5.getValue(),Characters.PERSON.getCharacter());
        town.setOne(Pointers.P28.getValue(),Pointers.P9.getValue(),Characters.PERSON.getCharacter());
        town.setOne(Pointers.P32.getValue(),Pointers.P8.getValue(),Characters.PERSON.getCharacter());
        town.setOne(Pointers.P33.getValue(),Pointers.P11.getValue(),Characters.GUARD.getCharacter());
        town.setOne(Pointers.P35.getValue(),Pointers.P4.getValue(),Characters.STABLE.getCharacter());
        
        //add monsters, trees, etc       
        town.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.TREE.getCharacter(), 50);
        town.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.BLACK_BEAR.getCharacter(), 30);
        town.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.WHITE_TIGER.getCharacter(), 25);
        town.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.APE_THROWER.getCharacter(), 20);
        town.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.BERA.getCharacter(), 1);
        town.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.TIGRIS.getCharacter(), 1);
        town.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.APE_KING.getCharacter(), 1);
            
        //add trees to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                town.setOne(i ,j , Characters.TREE.getCharacter());
            }
        }
        
        town.setOne(Pointers.P4.getValue(), Pointers.P25.getValue(), Characters.TELEPORT.getCharacter());
    }
    
    private void addObjectsToFortress()
    {
        //left wall
        for (int i = 0; i < Pointers.P45.getValue(); i++)
        {
            fortress.setOne(i, Pointers.P7.getValue(), Characters.WALL.getCharacter());
        }
        fortress.setOne(Pointers.P6.getValue(), Pointers.P7.getValue(),  SQUARE);
        fortress.setOne(Pointers.P10.getValue(), Pointers.P7.getValue(), SQUARE);
        fortress.setOne(Pointers.P18.getValue(), Pointers.P7.getValue(), SQUARE);
        fortress.setOne(Pointers.P23.getValue(), Pointers.P7.getValue(), SQUARE);
        fortress.setOne(Pointers.P30.getValue(), Pointers.P7.getValue(), SQUARE);
        fortress.setOne(Pointers.P31.getValue(), Pointers.P7.getValue(), SQUARE);
        fortress.setOne(Pointers.P39.getValue(), Pointers.P7.getValue(), SQUARE);
        fortress.setOne(Pointers.P40.getValue(), Pointers.P7.getValue(), SQUARE);
        
        //right wall
        for (int i = 0; i < Pointers.P45.getValue(); i++)
        {
            fortress.setOne(i, Pointers.P29.getValue(), Characters.WALL.getCharacter());
        }
        fortress.setOne(Pointers.P23.getValue(), Pointers.P29.getValue(), SQUARE);
        fortress.setOne(Pointers.P24.getValue(), Pointers.P29.getValue(), SQUARE);
        fortress.setOne(Pointers.P25.getValue(), Pointers.P29.getValue(), SQUARE);
        
        //house/school wall
        for (int i = 0 ; i < Pointers.P9.getValue(); i++)
        {
            fortress.setOne(i, Pointers.P10.getValue(), Characters.WALL.getCharacter());
            fortress.setOne(i, Pointers.P14.getValue(), Characters.WALL.getCharacter());
        }
        
        //Barraks wall
        for (int i = 0 ; i < Pointers.P14.getValue(); i++)
        {
            fortress.setOne(i, Pointers.P19.getValue(), Characters.WALL.getCharacter());
        }
        
        //Shop/B-smith wall
        for (int i = Pointers.P35.getValue() ; i < Pointers.P45.getValue(); i++)
        {
            fortress.setOne(i, Pointers.P10.getValue(), Characters.WALL.getCharacter());
            fortress.setOne(i, Pointers.P14.getValue(), Characters.WALL.getCharacter());
        }
        
        //Hospital wall
        for (int i = Pointers.P33.getValue() ; i < Pointers.P45.getValue(); i++)
        {
            fortress.setOne(i, Pointers.P21.getValue(), Characters.WALL.getCharacter());
        }
        
        //Church wall
        for (int i = Pointers.P20.getValue() ; i < Pointers.P29.getValue(); i++)
        {
            fortress.setOne(i, Pointers.P13.getValue(), Characters.WALL.getCharacter());
            fortress.setOne(i, Pointers.P19.getValue(), Characters.WALL.getCharacter());
        }
        fortress.setOne(Pointers.P23.getValue(), Pointers.P19.getValue(), SQUARE);
        fortress.setOne(Pointers.P24.getValue(), Pointers.P19.getValue(), SQUARE);
        fortress.setOne(Pointers.P25.getValue(), Pointers.P19.getValue(), SQUARE);
        
        for (int j = 0 ; j < Pointers.P7.getValue(); j++)
        {
            fortress.setOne(Pointers.P8.getValue(),j, Characters.WALL.getCharacter());
            fortress.setOne(Pointers.P14.getValue(),j, Characters.WALL.getCharacter());
            fortress.setOne(Pointers.P20.getValue(),j, Characters.WALL.getCharacter());
            fortress.setOne(Pointers.P26.getValue(),j, Characters.WALL.getCharacter());
            fortress.setOne(Pointers.P35.getValue(),j, Characters.WALL.getCharacter());
        }
        
        for (int j = Pointers.P10.getValue() ; j < Pointers.P21.getValue(); j++)
        {
            fortress.setOne(Pointers.P35.getValue(),j, Characters.WALL.getCharacter());
        }
        fortress.setOne(Pointers.P35.getValue(),Pointers.P12.getValue(), SQUARE);
        fortress.setOne(Pointers.P35.getValue(),Pointers.P18.getValue(), SQUARE);
        
        for (int j = Pointers.P21.getValue() ; j < Pointers.P29.getValue(); j++)
        {
            fortress.setOne(Pointers.P33.getValue(),j, Characters.WALL.getCharacter());
        }
        fortress.setOne(Pointers.P33.getValue(),Pointers.P24.getValue(), SQUARE);
        fortress.setOne(Pointers.P33.getValue(),Pointers.P25.getValue(), SQUARE);
        
        for (int j = Pointers.P13.getValue() ; j < Pointers.P19.getValue(); j++)
        {
            fortress.setOne(Pointers.P20.getValue(),j, Characters.WALL.getCharacter());
            fortress.setOne(Pointers.P28.getValue(),j, Characters.WALL.getCharacter());
        }
        
        for (int j = Pointers.P19.getValue() ; j < Pointers.P29.getValue(); j++)
        {
            fortress.setOne(Pointers.P14.getValue(),j, Characters.WALL.getCharacter());
        }
        fortress.setOne(Pointers.P14.getValue(),Pointers.P25.getValue(), SQUARE);
        fortress.setOne(Pointers.P14.getValue(),Pointers.P26.getValue(), SQUARE);
        
        for (int j = Pointers.P10.getValue() ; j < Pointers.P19.getValue(); j++)
        {
            fortress.setOne(Pointers.P9.getValue(),j, Characters.WALL.getCharacter());
        }
        fortress.setOne(Pointers.P9.getValue(),Pointers.P13.getValue(), SQUARE);
        fortress.setOne(Pointers.P9.getValue(),Pointers.P16.getValue(), SQUARE);
        fortress.setOne(Pointers.P9.getValue(),Pointers.P17.getValue(), SQUARE);
        
        for (int j = Pointers.P29.getValue() ; j < Pointers.P32.getValue(); j++)
        {
            fortress.setOne(Pointers.P22.getValue(),j, Characters.WALL.getCharacter());
            fortress.setOne(Pointers.P26.getValue(),j, Characters.WALL.getCharacter());
        }
        
        fortress.setOne(Pointers.P24.getValue(),Pointers.P32.getValue(), Characters.TELEPORT.getCharacter());
        fortress.setOne(Pointers.P36.getValue(),Pointers.P12.getValue(), Characters.SHOP.getCharacter());
        fortress.setOne(Pointers.P36.getValue(),Pointers.P18.getValue(), Characters.BLACKSMITH.getCharacter());
        fortress.setOne(Pointers.P34.getValue(),Pointers.P25.getValue(), Characters.NURSE.getCharacter());
        fortress.setOne(Pointers.P36.getValue(),Pointers.P24.getValue(), Characters.POTION.getCharacter());
        fortress.setOne(Pointers.P40.getValue(),Pointers.P25.getValue(), Characters.POTION.getCharacter());
        fortress.setOne(Pointers.P40.getValue(),Pointers.P25.getValue(), Characters.POTION.getCharacter());
        
        fortress.setOne(Pointers.P18.getValue(),Pointers.P11.getValue(), Characters.PERSON.getCharacter());
        fortress.setOne(Pointers.P13.getValue(),Pointers.P15.getValue(), Characters.PERSON.getCharacter());
        fortress.setOne(Pointers.P16.getValue(),Pointers.P15.getValue(), Characters.PERSON.getCharacter());
        fortress.setOne(Pointers.P18.getValue(),Pointers.P19.getValue(), Characters.PERSON.getCharacter());
        fortress.setOne(Pointers.P18.getValue(),Pointers.P23.getValue(), Characters.PERSON.getCharacter());
        fortress.setOne(Pointers.P21.getValue(),Pointers.P23.getValue(), Characters.PERSON.getCharacter());
        fortress.setOne(Pointers.P18.getValue(),Pointers.P11.getValue(), Characters.PERSON.getCharacter());
        fortress.setOne(Pointers.P24.getValue(),Pointers.P25.getValue(), Characters.PERSON.getCharacter());        
        fortress.setOne(Pointers.P30.getValue(),Pointers.P19.getValue(), Characters.PERSON.getCharacter());
        
        setBiologist(Characters.BIOLOGIST.getCharacter());
        setOldLady(Characters.PERSON_2.getCharacter());
        setFarmer(Characters.PERSON_2.getCharacter());
        setJeweler(Characters.PERSON_2.getCharacter());
        setDrunkPerson(Characters.PERSON_2.getCharacter());
        setMythicalStone(Characters.STONE_SPOT_2.getCharacter());
    }
    
    /**
     * Set mythical stone image
     */
    public void setMythicalStone(String image)
    {
        mythicalStone = image;
        
        fortress.setOne(Pointers.P24.getValue(),Pointers.P16.getValue(), mythicalStone);
    }
    
    /**
     * Set biologist image.
     */
    public void setBiologist(String image)
    {
        biologist = image;
        
        fortress.setOne(Pointers.P39.getValue(),Pointers.P7.getValue(), biologist);
    }
    
    /**
     * Set drunk guy image.
     */
    public void setDrunkPerson(String image)
    {
        drunkPerson = image;
        
        fortress.setOne(Pointers.P29.getValue(),Pointers.P24.getValue(), image);
    }
    
    /**
     * Set old lady image.
     */
    public void setOldLady(String image)
    {
        oldLady = image;
        
        fortress.setOne(Pointers.P13.getValue(),Pointers.P11.getValue(), oldLady);
    }
    
    /**
     * Set farmer image.
     */
    public void setFarmer(String image)
    {
        farmer = image;
        
        fortress.setOne(Pointers.P31.getValue(),Pointers.P13.getValue(), farmer);
    }
    
    /**
     * Set jeweler image.
     */
    public void setJeweler(String image)
    {
        jeweler = image;
        
        fortress.setOne(Pointers.P26.getValue(),Pointers.P10.getValue(), jeweler);
    }
        
    /**
     * Initialise forest map.
     */
    private void addObjectsToForest()
    {
        for(int i = Pointers.P14.getValue(); i < Pointers.P26.getValue(); i++)
        {
            forest.setOne(i, Pointers.P8.getValue(), Characters.TREE.getCharacter());
            forest.setOne(i, Pointers.P13.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P26.getValue(); i < Pointers.P44.getValue(); i++)
        {
            forest.setOne(i, Pointers.P6.getValue(), Characters.TREE.getCharacter());
        }
        forest.setOne(Pointers.P26.getValue(), Pointers.P7.getValue(), Characters.TREE.getCharacter());
        
        for(int i = Pointers.P6.getValue(); i < Pointers.P14.getValue(); i++)
        {
            forest.setOne(i, Pointers.P13.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P3.getValue(); i < Pointers.P12.getValue(); i++)
        {
            forest.setOne(i, Pointers.P25.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P6.getValue(); i < Pointers.P16.getValue(); i++)
        {
            forest.setOne(i, Pointers.P29.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P16.getValue(); i < Pointers.P28.getValue(); i++)
        {
            forest.setOne(i, Pointers.P21.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P22.getValue(); i < Pointers.P33.getValue(); i++)
        {
            forest.setOne(i, Pointers.P17.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P20.getValue(); i < Pointers.P28.getValue(); i++)
        {
            forest.setOne(i, Pointers.P25.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P29.getValue(); i < Pointers.P41.getValue(); i++)
        {
            forest.setOne(i, Pointers.P29.getValue(), Characters.TREE.getCharacter());
            forest.setOne(i, Pointers.P10.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P33.getValue(); i < Pointers.P41.getValue(); i++)
        {
            forest.setOne(i, Pointers.P14.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int i = Pointers.P42.getValue(); i < Pointers.P42.getValue(); i++)
        {
            forest.setOne(i, Pointers.P15.getValue(), Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P6.getValue(); j < Pointers.P21.getValue(); j++)
        {
            forest.setOne(Pointers.P6.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P3.getValue(); j < Pointers.P8.getValue(); j++)
        {
            forest.setOne(Pointers.P10.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P21.getValue(); j < Pointers.P24.getValue(); j++)
        {
            forest.setOne(Pointers.P12.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P13.getValue(); j < Pointers.P21.getValue(); j++)
        {
            forest.setOne(Pointers.P18.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P21.getValue(); j < Pointers.P28.getValue(); j++)
        {
            forest.setOne(Pointers.P16.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P29.getValue(); j < Pointers.P32.getValue(); j++)
        {
            forest.setOne(Pointers.P20.getValue(), j, Characters.TREE.getCharacter());
            forest.setOne(Pointers.P24.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P25.getValue(); j < Pointers.P29.getValue(); j++)
        {
            forest.setOne(Pointers.P28.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P21.getValue(); j < Pointers.P28.getValue(); j++)
        {
            forest.setOne(Pointers.P33.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P18.getValue(); j < Pointers.P28.getValue(); j++)
        {
            forest.setOne(Pointers.P37.getValue(), j, Characters.TREE.getCharacter());
        }
        
        for(int j = Pointers.P10.getValue(); j < Pointers.P28.getValue(); j++)
        {
            forest.setOne(Pointers.P41.getValue(), j, Characters.TREE.getCharacter());
        }
        
        forest.setOne(Pointers.P15.getValue(), Pointers.P3.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P15.getValue(), Pointers.P4.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P23.getValue(), Pointers.P3.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P23.getValue(), Pointers.P4.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P19.getValue(), Pointers.P6.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P19.getValue(), Pointers.P7.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P29.getValue(), Pointers.P11.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P29.getValue(), Pointers.P12.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P29.getValue(), Pointers.P13.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P27.getValue(), Pointers.P13.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P28.getValue(), Pointers.P13.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P33.getValue(), Pointers.P15.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P33.getValue(), Pointers.P16.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P10.getValue(), Pointers.P14.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P10.getValue(), Pointers.P15.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P10.getValue(), Pointers.P19.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P10.getValue(), Pointers.P20.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P10.getValue(), Pointers.P21.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P11.getValue(), Pointers.P21.getValue(), Characters.TREE.getCharacter());
        
        forest.setOne(Pointers.P12.getValue(), Pointers.P24.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P12.getValue(), Pointers.P25.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P16.getValue(), Pointers.P28.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P16.getValue(), Pointers.P29.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P26.getValue(), Pointers.P8.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P26.getValue(), Pointers.P13.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P28.getValue(), Pointers.P29.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P33.getValue(), Pointers.P17.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P33.getValue(), Pointers.P28.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P37.getValue(), Pointers.P28.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P11.getValue(), Pointers.P21.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P41.getValue(), Pointers.P28.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P41.getValue(), Pointers.P29.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P42.getValue(), Pointers.P15.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P43.getValue(), Pointers.P15.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P44.getValue(), Pointers.P15.getValue(), Characters.TREE.getCharacter());
        forest.setOne(Pointers.P43.getValue(), Pointers.P14.getValue(), Characters.TELEPORT.getCharacter());
        forest.setOne(Pointers.P12.getValue(), Pointers.P3.getValue(), Characters.TELEPORT.getCharacter());
        
        forest.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.BLACK_BEAR.getCharacter(), 10);
        forest.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.WHITE_TIGER.getCharacter(), 10);
        forest.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.APE_THROWER.getCharacter(), 10);
        forest.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.POISON_SPIDER.getCharacter(), 10);
        forest.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.BERA.getCharacter(), 2);
        forest.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.TIGRIS.getCharacter(), 2);
        forest.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.APE_KING.getCharacter(), 2);
        
        for (int j = FULL_L - (MAP_EDGE - 1); j <= FULL_L; j++)
        {
            for (int i = 0; i < FULL_H; i++)
            {
                forest.setOne(i, j, Characters.TREE.getCharacter());
                
            }
            
        }
        
    }
    
    /**
     * initialise the mountain map
     */
    private void addObjectsToMountain()
    {
        for (int j = 0; j < Pointers.P19.getValue(); j++)
        {
            mountain.setOne(Pointers.P7.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P8.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P19.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P20.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P31.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P32.getValue(), j, Characters.TREE.getCharacter());
            
        }
        
        for (int j = Pointers.P13.getValue(); j < FULL_L; j++)
        {
            mountain.setOne(Pointers.P13.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P14.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P25.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P26.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P37.getValue(), j, Characters.TREE.getCharacter());
            mountain.setOne(Pointers.P38.getValue(), j, Characters.TREE.getCharacter());
            
        }
        
        for (int i = 0; i < FULL_H; i++)
        {
            
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                
                mountain.setOne(i, j, Characters.TREE.getCharacter());
                
            }
            
        }
        
        mountain.setOne(Pointers.P41.getValue(), Pointers.P30.getValue(), Characters.TELEPORT.getCharacter());
        mountain.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.YETI.getCharacter(), 20);
        mountain.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.ABOMINABLE_SNOWMAN.getCharacter(), 20);
        mountain.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.POLAR_BEAR.getCharacter(), 20);
        mountain.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, Characters.NINE_TAILS.getCharacter(), 2);
        
    }
    
    /**
     * Initialise tower map
     */
    private void addObjectToTower(String monster)
    {
        for (int i = 0; i <= Pointers.P12.getValue(); i ++)
        {
            for (int j = 0; j < FULL_L; j++)
            {
                tower.setOne(i, j, Characters.WALL.getCharacter());
            }
            
        }
        
        for (int i = Pointers.P30.getValue(); i < FULL_H; i ++)
        {
            for (int j = 0; j < FULL_L; j++)
            {
                tower.setOne(i, j, Characters.WALL.getCharacter());
            }
            
        }
        
        for (int i = 0; i < FULL_H; i ++)
        {
            for (int j = 0; j <= Pointers.P8.getValue(); j++)
            {
                tower.setOne(i, j, Characters.WALL.getCharacter());
            }
            
        }
        
        for (int i = 0; i < FULL_H; i ++)
        {
            for (int j = Pointers.P26.getValue(); j < FULL_L; j++)
            {
                tower.setOne(i, j, Characters.WALL.getCharacter());
            }
            
        }
        
        tower.setOne(Pointers.P13.getValue(), Pointers.P9.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P13.getValue(), Pointers.P10.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P13.getValue(), Pointers.P11.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P14.getValue(), Pointers.P9.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P14.getValue(), Pointers.P10.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P15.getValue(), Pointers.P9.getValue(), Characters.WALL.getCharacter());
        
        tower.setOne(Pointers.P13.getValue(), Pointers.P23.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P13.getValue(), Pointers.P24.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P13.getValue(), Pointers.P25.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P14.getValue(), Pointers.P24.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P14.getValue(), Pointers.P25.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P15.getValue(), Pointers.P25.getValue(), Characters.WALL.getCharacter());
        
        tower.setOne(Pointers.P27.getValue(), Pointers.P9.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P28.getValue(), Pointers.P9.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P28.getValue(), Pointers.P10.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P29.getValue(), Pointers.P9.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P29.getValue(), Pointers.P10.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P29.getValue(), Pointers.P11.getValue(), Characters.WALL.getCharacter());
        
        tower.setOne(Pointers.P27.getValue(), Pointers.P25.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P28.getValue(), Pointers.P24.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P28.getValue(), Pointers.P25.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P29.getValue(), Pointers.P23.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P29.getValue(), Pointers.P24.getValue(), Characters.WALL.getCharacter());
        tower.setOne(Pointers.P29.getValue(), Pointers.P25.getValue(), Characters.WALL.getCharacter());
        
        tower.addObjects(Pointers.P8.getValue(), Pointers.P25.getValue(), Pointers.P12.getValue(), Pointers.P29.getValue(),
                       monster, 20);
    }
    
    public void addTeleport(int row, int col)
    {
        currentMap.setOne(row, col, Characters.TELEPORT.getCharacter());
    }
    
    /**
     * initialise DESSERT map
     */
    private void addObjectsToDessert()
    {
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.CACTUS.getCharacter(), 50);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.POISON_SPIDER.getCharacter(), 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.RED_SCORPION.getCharacter(), 30);
        dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.ALBINO_SNAKE.getCharacter(), 30);
        
        //add rocks to the right of the map
        for(int i = MAP_EDGE; i < FULL_H - MAP_EDGE; i++)
        {
            for (int j = FULL_L - MAP_EDGE; j < FULL_L; j++)
            {
                dessert.setOne(i, j,Characters.ROCK.getCharacter());
            }
        }
        
        dessert.setOne(Pointers.P27.getValue(), Pointers.P15.getValue(), Characters.TELEPORT.getCharacter());
        dessert.setOne(Pointers.P8.getValue(), Pointers.P8.getValue(), Characters.CORPSE.getCharacter());
        dessert.setOne(Pointers.P16.getValue(), Pointers.P6.getValue(), Characters.POTION.getCharacter());
    }
    
    /**
     * Initialise Spider dungeon map
     */
    private void addObjectsToSpiderCave()
    {
        int thickness = 3;
        int opening = 5;
        
        //add a wall going down in the cave
        for (int i = 0; i < FULL_H - MAP_EDGE - opening; i++)
        {
            for(int j = MAP_EDGE + opening; j < MAP_EDGE + opening + thickness; j++)
            {
                spiderCave.setOne(i, j, Characters.ROCK.getCharacter());
            }
        }
        //add a wall to the right
        for (int i = FULL_H - opening - thickness; i < FULL_H - opening; i++)
        {
            for(int j = MAP_EDGE + opening; j < FULL_L - MAP_EDGE - opening - thickness; j++)
            {
                spiderCave.setOne(i, j, Characters.ROCK.getCharacter());
            }
        }
        //add wall going up
        for (int i = MAP_EDGE + opening; i < FULL_H - MAP_EDGE - opening; i++)
        {
            for(int j = FULL_L - MAP_EDGE - opening - thickness; j < FULL_L - MAP_EDGE - opening; j++)
            {
                spiderCave.setOne(i, j, Characters.ROCK.getCharacter());
            }
        }
        //add wall right to left
        for (int i = MAP_EDGE + opening; i < MAP_EDGE + opening + thickness; i++)
        {
            for(int j = MAP_EDGE + opening + thickness + opening; j < FULL_L - MAP_EDGE - opening - thickness; j++)
            {
                spiderCave.setOne(i, j,Characters.ROCK.getCharacter());
            }
        }
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.POISON_SPIDER.getCharacter(), 40);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.RED_SCORPION.getCharacter(), 40);
        spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, Characters.ALBINO_SNAKE.getCharacter(), 40);
        
        spiderCave.addObjects(Pointers.P15.getValue() - 1, Pointers.P15.getValue() + 1,Pointers.P26.getValue() - 1,
                                Pointers.P26.getValue() + 1, Characters.SPIDER_QUEEN.getCharacter(), 1);
        spiderCave.addObjects(Pointers.P15.getValue() - 1, Pointers.P15.getValue() + 1,Pointers.P26.getValue() - 1,
                                Pointers.P26.getValue() + 1, Characters.TELEPORT.getCharacter(), 1);
        
    }
    
    /**
     * return the value of a square in the map
     */
    public String getSquareValue(int row, int col)
    {
        String value = currentMap.getSquareValue(row, col);
        
        return value;
    }
    
    /**
     * Set an object at a given location
     */
    public void setObject(int playerRowCoord, int playerColCoord, String value)
    {
        currentMap.setOne(playerRowCoord, playerColCoord, value);
    }
    
    /**
     * @return the current map as a 2d array.
     */
    public String[][] getMapAsArray()
    {
        return currentMap.getmap();
    }
    
    /**
     * Add a monster on the map in an empty square
     */
    public void addAnother(String character)
    {
        if (currentMap.getName().toLowerCase().equals("town"))
        {
            currentMap.addObjects(Pointers.P13.getValue() + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
        }
        else if (currentMap.getName().toLowerCase().equals("dessert"))
        {
            dessert.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
        }
        else if (currentMap.getName().toLowerCase().equals("spidercave"))
        {
            spiderCave.addObjects(MAP_EDGE + 1, FULL_L - MAP_EDGE - 1, MAP_EDGE, FULL_H - MAP_EDGE - 1, character, 1);
        }
        else if (currentMap.getName().toLowerCase().equals("forest"))
        {
            currentMap.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, character, 1);
        }
        else if (currentMap.getName().toLowerCase().equals("mountain"))
        {
            currentMap.addObjects(MAP_EDGE, FULL_L - MAP_EDGE, MAP_EDGE, FULL_H - MAP_EDGE, character, 1);
        }
        else if (currentMap.getName().toLowerCase().equals("tower"))
        {
            
            if(!currentMap.checkForMonsters())
                currentMap.addObjects(Pointers.P14.getValue(),Pointers.P15.getValue(), 
                                       Pointers.P16.getValue(),Pointers.P17.getValue(), Characters.TELEPORT.getCharacter(), 1);
                                       
        }
    }
    
    /**
     * print the maps.
     */
    private void printMaps()
    {
        town.printMap();
        dessert.printMap();
        spiderCave.printMap();
        fortress.printMap();
        forest.printMap();
        tower.printMap();
        mountain.printMap();
    }
    
    /**
     * Open barels
     */
    public void openBarels(int row, int col)
    { 
        currentMap.setOne(row, col, Characters.OPENED_BARREL.getCharacter());
        
    }
    
    /**
     * Increase the tower level
     */
    public void increaseLevel()
    {
        towerLevel++;
    }
    
    /**
     * @return tower level
     */
    public int getTowerLevel()
    {
        return towerLevel;
    }
    
    /**
     * Print a empty map for the user with the player's location.
     */
    public void printHelpMap(int pRow, int pCol)
    {
        userHelp.setOne(row, col, SQUARE);
        userHelp.setOne(pRow, pCol, Characters.PLAYER.getCharacter());
        
        row = pRow;
        col = pCol;
        
        userHelp.printMap();
    }
    
    /**
     * Set values in the help map.
     */
    public void addToHelpMap(int row, int col, String object)
    {
        userHelp.setOne(row, col, object);
        
    }
        
    /**
     * 
     */
    public boolean checkTeleport(int col)
    {
        if(col == Pointers.P14.getValue())
            return true;
        else
            return false;
    }
}