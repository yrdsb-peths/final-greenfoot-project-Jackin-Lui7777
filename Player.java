import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int jumpSpeed;
    public int velocity;
    public int ceilingHeight;
    public int floorHeight;
    public boolean canJump = true;
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("space")) {
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
        setLocation(getX(), getY() + velocity);
        if(getY() <= ceilingHeight) {
            setLocation(getX(), ceilingHeight);
            velocity = -velocity;
        }
        if(getY() >= floorHeight) {
            setLocation(getX(), floorHeight);
            velocity = 0;
        }
        
    } 
}