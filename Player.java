import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int jumpSpeed = 10;
    public int velocity;
    public int ceilingHeight;
    public int floorHeight;
    public boolean canJump = true;
    
    public Player() {
        GameWorld world = (GameWorld) getWorld();
    }
    
    public void act() 
    {
        GameWorld world = (GameWorld) getWorld();
        this.ceilingHeight = world.getCeiling();
        this.floorHeight = world.getFloor();
        
        if(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            if (canJump) {
                velocity = jumpSpeed;
                canJump = false;
            }
        }
        else {
            if (getY() >= floorHeight) {
                canJump = true;
            }
        }
        setLocation(getX(), getY() - velocity);
        if(getY() <= ceilingHeight) {
            setLocation(getX(), ceilingHeight);
            velocity = -velocity;
        }
        else if(getY() >= floorHeight) {
            setLocation(getX(), floorHeight);
            velocity = 0;
        }
        
        else {
            if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
                if (velocity > 0) {
                    velocity = -velocity;
                }
            }
        }
        
    } 
}
