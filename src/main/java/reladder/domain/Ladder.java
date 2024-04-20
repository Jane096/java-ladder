package reladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int move(int playerPosition) {
        int currentPosition = playerPosition;

        for (Line line : lines) {
            currentPosition = line.move(currentPosition);
        }

        return currentPosition;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
