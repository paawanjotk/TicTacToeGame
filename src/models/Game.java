package models;
import exceptions.InvalidMoveException;
import strategies.WinningAlgorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Board board;
    private int nextPlayerMoveIndex;
    private GameState status;
    private List<Move> moves;
    private Player Winner;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players){
        this.players = players;
        this.board = new Board(dimension);
        this.nextPlayerMoveIndex = 0;
        this.status = GameState.InProgress;
        this.moves = new ArrayList<>();
        this.Winner = null;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }
    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public GameState getStatus() {
        return status;
    }

    public void setStatus(GameState status) {
        this.status = status;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return Winner;
    }

    public void setWinner(Player winner) {
        Winner = winner;
    }

    public void printBoard(){
        this.board.printBoard();
    }
    private boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row<0 || row>=board.getSize() || col<0 || col>=board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.Empty);
    }
    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        Move move = currentPlayer.makeMove(this.board);
        //game will validate the move
        if(!validateMove(move)){
            //throw an exception
            throw new InvalidMoveException("Invalid Move made by " + currentPlayer.getName());
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.Filled);

        Move finalMove = new Move(cellToChange, currentPlayer);
        moves.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex+1) % players.size();

        if(winningAlgorithm.checkWinner(board, finalMove)){
            status = GameState.Ended;
            Winner = currentPlayer;
        } else if (moves.size()==board.getSize()*board.getSize()){
            status = GameState.Draw;
        }
    }
}