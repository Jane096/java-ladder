package reladder.domain;

public class Player {

    private final String name;
    private final int position;
    private static final int MAX_NAME_LENGTH = 5;

    public Player(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    public boolean isPlayerNameExist(String name) {
        return this.name.equals(name);
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 넘길 수 없습니다.");
        }
    }
}
