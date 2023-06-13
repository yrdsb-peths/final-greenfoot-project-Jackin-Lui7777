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
    
    public int ceilingHeight = 150;
    public int floorHeight = 300;
    
    int obstacleDelayMax = 50;
    int obstacleDelay = 0;
    
    
    public GameWorld()
    {    
        super(600, 400, 1);
        addObject(new Player(), 50, floorHeight);
    }
    // Fix this 
    public void act() {
        scoreDelay += 1;
        if (scoreDelay >= scoreDelayMax) {
            score += addScore;
            scoreDelay = 0;
        }
        
        if (score % 250 == 0 && score > 0) {
            increaseDifficulty();
        }
        
        obstacleDelay += 1;
        if (obstacleDelay >= obstacleDelayMax) {
            if(Greenfoot.getRandomNumber(30) == 0) {
                spawnObstacle();
                obstacleDelay = 0;
            }
        }
        
        
        showText("Score: " + score, (int) (getWidth() * 0.8), (int) (getHeight() * 0.125));
    }
    
    public void endGame() {
        GameOverWorld gameOver = new GameOverWorld();
        Greenfoot.setWorld(gameOver);
        gameOver.showText("Score: " + score, (int) (getWidth() * 0.8), (int) (getHeight() * 0.125));
        
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void spawnObstacle() {
        Obstacle obstacle = new Obstacle();
        addObject(obstacle, getWidth(), floorHeight + 40);
    }
    
    public int getCeiling() {
        return ceilingHeight;
    }
    
    public int getFloor() {
        return floorHeight;
    }
    
    public int getScore() {
        return score;
    }
    
    public void increaseDifficulty() {
        speed += 1;
        obstacleDelayMax -= 2;
    }
}
