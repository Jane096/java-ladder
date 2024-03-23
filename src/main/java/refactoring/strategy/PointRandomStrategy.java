package refactoring.strategy;

import java.util.Random;

public class PointRandomStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return new Random().nextBoolean();
    }
}
