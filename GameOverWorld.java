import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{

    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage playImage = new GreenfootImage("Game Over!", 30, Color.BLACK, Color.WHITE);
        addObject(new PlayButton(playImage, getWidth()/2 - playImage.getWidth()/2, getHeight()/2 - playImage.getHeight()/2), 0, 0);
    }
}
