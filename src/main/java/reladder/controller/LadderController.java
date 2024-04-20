package reladder.controller;

import reladder.domain.*;
import reladder.view.InputView;
import reladder.view.OutputView;

import java.util.Map;

public class LadderController {

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        Prizes prizes = InputView.inputLadderPrizes();
        Height height = InputView.inputLadderHeight();

        Ladder ladder = new LadderCreator().run(height, players);
        LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        OutputView.viewLadder(ladder, players, prizes);

        GameResult gameResult = new GameResult(ladderGame);
        Map<String, String> ladderResult = gameResult.generateResults();
        String name = InputView.inputLadderResultPlayer(ladderGame);

        OutputView.findLadderGameResult(name, ladderResult);
    }
}
