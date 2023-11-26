package step2.teststrategy;

import step2.model.RandomStrategy;

public class PointFalseStrategy implements RandomStrategy {

    @Override
    public boolean hasPoint() {
        return false;
    }
}
