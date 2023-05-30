import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class button extends Actor
{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public boolean isHovered = false;
    public boolean canClick = true;
    
    public button(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void act() 
    {
        if (isHovering()) {
            if(!isHovered) {
                beginHover();
            }
            if (isClicked() && canClick) {
                onClick();
            }
            if (!isClicked()) {
                canClick = true;
            }
            isHovered = true;
        }
        else {
            if(isHovered) {
                endHover();
            }
            isHovered = false;
        }
    }
    
    public boolean isHovering() {
        MouseInfo cursor = Greenfoot.getMouseInfo();
        try {
            if(x1 <= cursor.getX() && cursor.getX() <= x2) {
                if(y1 <= cursor.getY() && cursor.getY() <= y2) {
                    return true;
                }
            }
        }
        catch(Exception e) {
            ;
        }
        return false;
    }
    
    public boolean isClicked() {
        MouseInfo cursor = Greenfoot.getMouseInfo();
        try {
            if (cursor.getButton() == 1) {
                return true;
            }
        }
        catch(Exception e) {
            ;
        }
        return false;
    }
    
    public void onClick() {
        System.out.println("Clicking");
    }
    
    public void beginHover() {
        MouseInfo cursor = Greenfoot.getMouseInfo();
        if (cursor.getButton() == 1) {
            canClick = false;
        }
        else {
            canClick = true;
        }
        System.out.println("Begin hover");
    }
    
    public void endHover() {
        System.out.println("End hover");
    }
}
