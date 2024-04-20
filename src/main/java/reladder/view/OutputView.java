package reladder.view;

import reladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String WIDTH = "%6s";
    private static final String ALL = "all";

    public static void viewLadder(Ladder ladder, Players players, Prizes prizes) {
        viewPlayers(players);

        ladder.getLines().forEach(line -> {
            System.out.print(line);
            System.out.println();
        });

        viewPrizes(prizes);
    }

    public static void viewPlayers(Players players) {
        System.out.println(players.getPlayers().stream()
                .map(player -> nameFormat(player.getName()))
                .collect(Collectors.joining()));
    }

    public static void particularPlayerPrize(Map<String, String> results, String name) {
        System.out.println(results.get(name));
    }

    public static void findLadderGameResult(String name, Map<String, String> gameResult) {
        System.out.println("실행 결과");

        if (ALL.equals(name)) {
            allLadderResult(gameResult);
            return;
        }

        particularPlayerPrize(gameResult, name);
    }

    public static void allLadderResult(Map<String, String> results) {
        results.forEach((playerName, prize) -> System.out.println(playerName + " : " + prize));
    }

    public static void viewPrizes(Prizes prizes) {
        System.out.println(prizes.getPrizes().stream()
                .map(prize -> nameFormat(prize.getValue()))
                .collect(Collectors.joining()));
    }

    private static StringBuilder nameFormat(String name) {
        return new StringBuilder().append(String.format(WIDTH, name));
    }
}
