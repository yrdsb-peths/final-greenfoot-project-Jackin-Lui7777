import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PlayButton(GreenfootImage image, int x1, int y1) {
        super(image, x1, y1);
    }
    
    public void onClick() {
        Greenfoot.setWorld(new GameWorld());
    }
}
