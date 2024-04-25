package controllers;

import exceptions.InvalidMoveException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.WinningAlgorithm;
import java.util.List;

public class GameController {
    public Game startGame(int boardSize, List<Player> players){
        return new Game(boardSize, players);
    }
    public void makeMove (Game game) throws InvalidMoveException{
        game.makeMove();
    }
    public GameState checkState(Game game){
        return game.getStatus();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void printBoard(Game game){
        game.printBoard();
    }

}
