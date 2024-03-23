package refactoring.model;

public class Direction {

    private int position;

    public Direction(int position) {
        this.position = position;
    }

    public int stay() {
        return this.position;
    }

    public int goLeft() {
        return --this.position;
    }

    public int getPrevious() {
        return this.position - 1;
    }

    public int goRight() {
        return ++this.position;
    }

    public int getPosition() {
        return this.position;
    }
}
