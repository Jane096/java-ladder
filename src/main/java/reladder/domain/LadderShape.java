package reladder.domain;

public enum LadderShape {

    LINE_WITH_POINTS("-----|"),
    LINE_ONLY("     |");

    private final String shape;

    LadderShape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return this.shape;
    }
}
