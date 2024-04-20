package refactoring.model;

public class Height {

    private final int input;

    public Height(int input) {
        validate(input);
        this.input = input;
    }

    private void validate(int input) {
        if (input == 0 || input < 0) {
            throw new IllegalArgumentException("사다리 높이가 0이거나 음수일 수 없습니다.");
        }
    }

    public int getHeight() {
        return this.input;
    }
}
