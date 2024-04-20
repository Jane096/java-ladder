package reladder.testStrategy;

import reladder.strategy.RandomStrategy;

public class PointFalseStrategy implements RandomStrategy {

    @Override
    public boolean generate() {
        return false;
    }
}
