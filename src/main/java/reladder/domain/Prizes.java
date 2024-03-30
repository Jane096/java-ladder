package reladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeNames) {
        List<Prize> results = new ArrayList<>();
        IntStream.range(0, prizeNames.size())
                .forEach(index -> results.add(new Prize(prizeNames.get(index), index)));

        return new Prizes(results);
    }

    public Prize getPrizeByCurrentPosition(int currentPosition) {
        return prizes.stream()
                .filter(prize -> prize.isCurrentPositionMatched(currentPosition))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("매칭되는 상품이 없습니다."));
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(this.prizes);
    }
}
