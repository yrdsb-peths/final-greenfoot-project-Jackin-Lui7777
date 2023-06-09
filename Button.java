import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write Button description of class button here.
 * 
 * @author (your name) 
 * @version (Button version number or Button date)
 */
public class Button extends Actor
{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public boolean isHovered = false;
    public boolean isMouseDown = false;
    public int lastMouseX;
    public int lastMouseY;
    
    public Button(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public Button(GreenfootImage image, int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + image.getWidth();
        this.y2 = y1 + image.getHeight();
        setImage(image);
    }
    
    public Button(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + getImage().getWidth();
        this.y2 = y1 + getImage().getHeight();
    } 
    
    public void fixLocation() {
        setLocation(x1 + (x2 - x1)/2, y1 + (y2 - y1)/2);
    }
    
    public void changeLocation(int newX, int newY) {
        x2 = newX + (x2 - x1);
        y2 = newY + (y2 - y1);
        x1 = newX;
        y1 = newY;
        fixLocation();
    }
    
    public void act() 
    {
        fixLocation();
        if (isHovering()) {
            if(!isHovered) {
                beginHover();
                initialHoverCheck();
            }
            if (isClicked()) {
                onClick();
            }
            if (isMouseDown) {
                whileClicked();
            }
            isHovered = true;
        }
        else {
            if(isHovered) {
                endHover();
            }
            isMouseDown = false;
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
        boolean toReturn = false;
        try {
            if (cursor.getButton() == 1) {
                if (!isMouseDown) {
                    isMouseDown = true;
                    toReturn = true;
                }
                else {
                    toReturn = false;
                    if (cursor.getX() == lastMouseX && cursor.getY() == lastMouseY) {
                        isMouseDown = false;
                    }
                    else {
                        isMouseDown = true;
                    }
                }
            }
            else {
                toReturn = false;
            }
        }
        catch(Exception e) {
            toReturn = false;
        }
        lastMouseX = cursor.getX();
        lastMouseY = cursor.getY();
        return toReturn;
    }
    
    public void whileClicked() {
        ;
    }
    
    public void onClick() {
        ;
    }
    
    public void beginHover() {
        ;
    }
    
    public void endHover() {
        ;
    }
    
    public void initialHoverCheck() {
        MouseInfo cursor = Greenfoot.getMouseInfo();
        if (cursor.getButton() == 1) {
            isMouseDown = true;
        }
    }
}
