import controllers.GameController;
import exceptions.InvalidMoveException;
import models.*;

import java.util.List;

import static models.PlayerType.Bot;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        GameController gameController = new GameController();
        int dimension = 3;
        List<Player> players = List.of(new Player("Paawan", new Symbol('X'), PlayerType.Human), new Bot("Bot", new Symbol('O'), PlayerType.Bot, BotDifficultyLevel.Easy));
        Game game = gameController.startGame(dimension, players);

        while(game.getStatus().equals(GameState.InProgress)){
            gameController.printBoard(game);
            gameController.makeMove(game);

        }
        if(!gameController.checkState(game).equals(GameState.Ended)){
            game.setStatus(GameState.Draw);
            System.out.println("Game Drawn");

        } else {
            gameController.printBoard(game);
            System.out.println("Player "+gameController.getWinner(game).getName()+" is the winner");
        }
    }
}