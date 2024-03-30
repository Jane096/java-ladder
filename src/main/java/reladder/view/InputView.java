package reladder.view;

import reladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SERARATOR = ",";
    private static final String ALL = "all";

    public static Players inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();

        return Players.of(Arrays.asList(names.split(SERARATOR)));
    }

    public static Height inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int lineHeight = scanner.nextInt();
        return Height.of(lineHeight);
    }

    public static Prizes inputLadderPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String result = scanner.nextLine();

        return Prizes.of(Arrays.asList(result.split(SERARATOR)));
    }

    public static String inputLadderResultPlayer(LadderGame ladderGame) {
        scanner.nextLine();
        System.out.println("결과를 보고 싶은 사람은?");
        String name = scanner.nextLine();

        validateParticipantPlayer(ladderGame, name);
        return name;
    }

    private static void validateParticipantPlayer(LadderGame ladderGame, String name) {
        List<Player> players = ladderGame.getPlayers();
        if (!ALL.equals(name)){
            IntStream.range(0, players.size())
                    .filter(i -> Objects.equals(players.get(i).getName(), name))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("사다리 게임 참여자가 아닙니다."));
        }
    }
}
