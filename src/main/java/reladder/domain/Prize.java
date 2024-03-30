package reladder.domain;

public class Prize {

    private final String value;
    private final int position;

    public Prize(String value, int position) {
        validate(value);
        this.value = value;
        this.position = position;
    }

    private void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("사다리 게임 결과를 입력해주세요");
        }
    }

    boolean isCurrentPositionMatched(int currentPosition) {
        return this.position == currentPosition;
    }


    public String getValue() {
        return this.value;
    }
}
