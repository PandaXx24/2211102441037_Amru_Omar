import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class ObjectSpecial extends Actor {
    private GreenfootSound collectSound = new GreenfootSound("coinsounds.wav");
    
    public ObjectSpecial() {
        setImage("coin.png");
    }
    
    public void act() {
        moveDown();
        checkForCollision();
    }
    
    public void moveDown() {
    
        setLocation(getX(), getY() + 1);

      
        if (getY() >= getWorld().getHeight() - 1) {
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
    
    public void checkForCollision() {
        Character player = (Character) getOneIntersectingObject(Character.class);
        if (player != null) {
            player.increaseScore();
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
            playCollectSound();
        }
    }

    public void playCollectSound() {
        collectSound.play();
    }
}
