package Utils;

import java.util.Random;

public class RandomSingleton {
    private static RandomSingleton instance;
    private Random rnd;
    private long seed = 12345;

    private RandomSingleton() {
        this.rnd = new Random(this.seed);
    }

    public final static RandomSingleton getInstance() {
        if(instance == null) {
            instance = new RandomSingleton();
        }
        return instance;
    }

    public Random getRandom() {
        return this.rnd;
    }

    public boolean nextBoolean() {
        return this.rnd.nextBoolean();
    }

    public int nextInt(int min, int max) {
        return this.rnd.nextInt(max - min) + 1 + min;
    }
    public int nextInt(int max) {
        return this.rnd.nextInt(max);
    }


}