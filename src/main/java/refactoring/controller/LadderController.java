package refactoring.controller;

import refactoring.model.*;
import refactoring.strategy.PointRandomStrategy;
import refactoring.view.InputView;
import refactoring.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        List<Prize> prizes = InputView.inputLadderPrizes();
        Height height = InputView.inputLadderHeight();

        LadderGenerator ladderGenerator = LadderGenerator.of(height, players, new PointRandomStrategy());
        OutputView.viewLadder(ladderGenerator, players, prizes);

        LadderResult ladderResult = LadderResult.of(players, prizes, ladderGenerator.getLines());
        Player player = InputView.inputLadderResultPlayer(players);

        OutputView.getLadderResult(player, ladderResult);
    }
}
