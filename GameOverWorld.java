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
        super(600, 400, 1);
        GreenfootImage gameOverImage = new GreenfootImage("Game Over!", 30, Color.BLACK, Color.WHITE);
        addObject(new Button(gameOverImage, getWidth()/2 - gameOverImage.getWidth()/2, getHeight()/2 - gameOverImage.getHeight()/2), 0, 0);
        
        GreenfootImage playImage = new GreenfootImage(" Click to play again! ", 30, Color.BLACK, Color.WHITE);
        addObject(new PlayButton(playImage, getWidth()/2 - playImage.getWidth()/2, getHeight()/2 - playImage.getHeight()/2 + 50), 0, 0);
    }
}
