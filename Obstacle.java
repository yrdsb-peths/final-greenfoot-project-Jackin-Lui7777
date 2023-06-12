import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    public void act() 
    {
        GameWorld world = (GameWorld) getWorld();
        
        int speed = world.getSpeed();
        setLocation(getX() - speed, getY());
        
        if (isTouching(Player.class)) {
            //world.endGame();
            //Greenfoot.setWorld(new GameOverWorld());
        }
        if (getX() <= 0) {
            world.removeObject(this);
        }
    }    
}
