package managers;

import java.util.Random;


/**
 * Wrapper for the Java Util Random class
 */
public class RandomManager {

    private Random random;

    public RandomManager(){
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }
    public int nextInt(int integer){
        return random.nextInt(integer);
    }
}
