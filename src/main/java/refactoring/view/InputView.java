package refactoring.view;

import refactoring.model.Height;
import refactoring.model.Player;
import refactoring.model.Players;
import refactoring.model.Prize;

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
        String players = scanner.nextLine();

        return new Players(Arrays.stream(players.split(SERARATOR))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public static Height inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int lineHeight = scanner.nextInt();
        return new Height(lineHeight);
    }

    public static List<Prize> inputLadderPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String result = scanner.nextLine();

        return Arrays.stream(result.split(SERARATOR))
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public static Player inputLadderResultPlayer(Players players) {
        scanner.nextLine();
        System.out.println("결과를 보고 싶은 사람은?");
        Player resultPlayer = new Player(scanner.nextLine());
        validateParticipantPlayer(resultPlayer, players);
        return resultPlayer;
    }

    private static void validateParticipantPlayer(Player player, Players players) {
        if (!ALL.equals(player.getName())){
            IntStream.range(0, players.getCount())
                    .filter(i -> Objects.equals(players.getPlayers().get(i).getName(), player.getName()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("사다리 게임 참여자가 아닙니다."));
        }
    }
}
