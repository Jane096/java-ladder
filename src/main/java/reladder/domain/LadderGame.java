package reladder.domain;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        validate(players.getCount(), prizes.getPrizes().size());
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public String getPrizeValueByName(String name) {
        int currentPlayerPosition = getPositionByName(name);
        return getPrizeByCurrentPosition(ladder.move(currentPlayerPosition)).getValue();
    }

    public Prize getPrizeByCurrentPosition(int currentPosition) {
        return this.prizes.getPrizeByCurrentPosition(currentPosition);
    }

    public int getPositionByName(String name) {
        return this.players.getPlayerPosition(name);
    }

    public List<Player> getPlayers() {
        return this.players.getPlayers();
    }

    private void validate(int playersSize, int prizesSize) {
        if (playersSize != prizesSize) {
            throw new IllegalArgumentException("플레이어 수와 상품 수가 일치하지 않습니다.");
        }
    }
}
