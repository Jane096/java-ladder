package refactoring.testStrategy;

import refactoring.strategy.RandomStrategy;

public class PointFalseStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return false;
    }
}
