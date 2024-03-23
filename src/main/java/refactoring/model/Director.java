package refactoring.model;

import java.util.List;

public class Director {

    private final List<Line> lines;

    public Director(List<Line> lines) {
        this.lines = lines;
    }

    public int move(int playerLocation) {
        int currentLocation = playerLocation;

        for (Line line : this.lines) {
            currentLocation = line.move(new Direction(currentLocation));
        }

        return currentLocation;
    }
}
