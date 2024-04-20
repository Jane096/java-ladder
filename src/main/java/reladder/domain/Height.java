package reladder.domain;

public class Height {

    private final int input;

    private Height(int input) {
        validate(input);
        this.input = input;
    }

    public static Height of(int input) {
        return new Height(input);
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
