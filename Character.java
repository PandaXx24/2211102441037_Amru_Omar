import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Character extends Actor {
    private int score = 0;
    
    public Character() {
        setImage("1.png");
    }
    
    public void act() {
    checkKeyPress();
    checkGameOver();
    checkForCollision();
    }

    public void checkKeyPress() {
    if (Greenfoot.isKeyDown("left")) {
        move(-5);
    }
    if (Greenfoot.isKeyDown("right")) {
        move(5);
    }
    if (Greenfoot.isKeyDown("up")) {
        setLocation(getX(), getY() - 5);
    }
    if (Greenfoot.isKeyDown("down")) {
        setLocation(getX(), getY() + 5);
    }
    }
    
    public void checkForCollision() {
        Actor object = getOneIntersectingObject(ObjectSpecial.class);
        if (object != null) {
            increaseScore();
            getWorld().removeObject(object);
        }
    }
    
    public void increaseScore() {
        score += 10;
        getWorld().showText("Score: " + score, 50, 25);
    }
    
    public void checkGameOver(){
        if (score >= 100) { 
            getWorld().showText("Game Over You Win!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        } else if (getWorld().getObjects(Character.class).isEmpty()) {
            getWorld().showText("Game Over You Lose!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }        
    }
}

