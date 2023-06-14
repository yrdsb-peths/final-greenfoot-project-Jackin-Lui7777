import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    public int delay = 0;
    public int maxDelay = 6;
    
    public Obstacle() {
        setImage(new GreenfootImage("images/spikes.png"));
        getImage().scale(50, 20);
    }
    
    public void act() 
    {
        GameWorld world = (GameWorld) getWorld();
        int speed = world.getSpeed();
        setLocation(getX() - speed, getY());
        
        if (isTouching(Player.class)) {
            delay += 1;
            if (delay >= maxDelay){
                world.endGame();
            }
        }
        if (getX() <= 0) {
            world.removeObject(this);
        }
    }    
}
