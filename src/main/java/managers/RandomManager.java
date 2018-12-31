package managers;

import java.util.Random;

public class RandomManager {

    public Random random;

    public RandomManager(){
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }
}
