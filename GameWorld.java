import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public int score;
    public int addScore = 1;
    public int speed = 5;
    public int scoreDelay = 0;
    public int scoreDelayMax = 6;
    
    public int ceilingHeight = 100;
    public int floorHeight = 300;
    
    int obstacleDelayMax = 100;
    int obstacleDelay = 0;
    
    public GameWorld()
    {    
        super(600, 400, 1);
        addObject(new Player(), 50, floorHeight);
        spawnObstacle();
    }
    // Fix this 
    public void act() {
        scoreDelay += 1;
        if (scoreDelay >= scoreDelayMax) {
            score += addScore;
            scoreDelay = 0;
        }
        
        obstacleDelay += 1;
        if (obstacleDelay >= obstacleDelayMax) {
            spawnObstacle();
            obstacleDelay = 0;
        }
        
        
        showText("Score: " + score, (int) (getWidth() * 0.8), (int) (getHeight() * 0.125));
    }
    
    public void endGame() {
        ;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void spawnObstacle() {
        Obstacle obstacle = new Obstacle();
        addObject(obstacle, getWidth(), floorHeight);
    }
    
    public int getCeiling() {
        return ceilingHeight;
    }
    
    public int getFloor() {
        return floorHeight;
    }
}
