import greenfoot.*;  
import java.util.Random;

public class world extends World
{
    private int specialObjectDelay = 100;
    private int specialObjectCounter = 0;

    public world()
    {    
        super(600, 400, 1); 
        prepare();
    }

    public void act() {
        

      
        if (specialObjectCounter >= specialObjectDelay) {
            spawnSpecialObject();
            specialObjectCounter = 0; 
        } else {
            specialObjectCounter++;
        }
    }
    
    private void prepare()
    {
        Character player = new Character();
        addObject(player,66,199);
        Character player2 = new Character();
        addObject(player2,560,203);
        removeObject(player2);
        Enemy enemy = new Enemy();
        addObject(enemy,543,196);
    }
    
    private void spawnSpecialObject() {
        Random random = new Random();
        int x = random.nextInt(getWidth()); 
        int y = 0;
        ObjectSpecial specialObject = new ObjectSpecial();
        addObject(specialObject, x, y);
    }
}