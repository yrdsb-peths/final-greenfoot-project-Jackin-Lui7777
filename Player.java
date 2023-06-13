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
    public GreenfootImage[] sprites = new GreenfootImage[8];
    public int currentSprite = 0;
    public int spriteTimer;
    public int maxSpriteTimer = 5;
    
    public Player() {
        for(int i = 0; i < 8; i++) {
            GreenfootImage image = new GreenfootImage("images/tile00" + Integer.toString(i) + ".png");
            image.scale(100, 100);
            image.mirrorHorizontally();
            sprites[i] = image;
        }
        setImage(sprites[currentSprite]);
    }
    
    public void act() 
    {
        GameWorld world = (GameWorld) getWorld();
        this.ceilingHeight = world.getCeiling();
        this.floorHeight = world.getFloor();
        
        spriteTimer += 1;
        if (spriteTimer >= maxSpriteTimer) {
            changeSprite();
            spriteTimer = 0;
        }
      
        
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
    
    public void changeSprite() {
        if (getY() >= floorHeight) {
            setImage(sprites[currentSprite]);
            currentSprite += 1;
            if (currentSprite >= sprites.length) {
                currentSprite = 0;
            }
        }
    }
}
