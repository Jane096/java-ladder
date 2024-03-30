package reladder.strategy;

import java.util.Random;

public class PointRandomStrategy implements RandomStrategy {

    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }
}
