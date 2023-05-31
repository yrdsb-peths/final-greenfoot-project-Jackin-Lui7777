import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{

    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        super(600, 400, 1); 
        addObject(new PlayButton(new GreenfootImage("Play", 30, Color.BLACK, Color.WHITE), 50, 50), 0, 0);
    }
}
