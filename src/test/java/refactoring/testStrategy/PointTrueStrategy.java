package refactoring.testStrategy;

import refactoring.strategy.RandomStrategy;

public class PointTrueStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return true;
    }
}
