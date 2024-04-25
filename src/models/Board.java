package models;
import java.util.List;
import java.util.ArrayList;
public class Board {
    private int size;
    private List<List<Cell>> board; //cell-> row, col, symbol
    public Board(int d){
        this.size=d;
        this.board = new ArrayList<>();
        for(int i=0; i<d; i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0; j<d; j++){
                row.add(new Cell(i, j));
            }
            this.board.add(row);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }
    public void printBoard(){
        for(List<Cell> row : board){
            for(Cell cell: row){
                if(cell.getCellState().equals(CellState.Empty)){
                    System.out.print("| - |");
                }
                else{
                    System.out.print("|"+cell.getPlayer().getSymbol().getChar());
                }
            }
        }
    }
}
