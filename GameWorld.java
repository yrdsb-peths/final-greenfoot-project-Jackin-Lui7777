import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        super(600, 400, 1);
        addObject(new Button(300, 300),0 ,0);
    }
    
    public void endGame() {
        ;
    }
    
    public void spawnObstacle() {
    }
}
