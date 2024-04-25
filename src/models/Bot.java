package models;

import java.util.List;

public class Bot extends Player {
    public Bot(BotDifficultyLevel difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    private BotDifficultyLevel difficulty_level;
    public Bot(String name, Symbol symbol, PlayerType type, BotDifficultyLevel difficulty_level){
        super(name, symbol, type);
        this.difficulty_level = difficulty_level;
    }
    @Override
    public Move makeMove(Board board){
        //Find the first empty cell and make the move there
        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                if(cell.getCellState().equals(CellState.Empty)){
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
    
}
