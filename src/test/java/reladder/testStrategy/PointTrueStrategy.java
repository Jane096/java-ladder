package reladder.testStrategy;

import reladder.strategy.RandomStrategy;

public class PointTrueStrategy implements RandomStrategy {

    @Override
    public boolean generate() {
        return true;
    }
}
