package strategies;

import models.Board;
import models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    // row number -> hashmap for that row
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    HashMap<Character, Integer> leftDiagonalMaps = new HashMap<>();
    HashMap<Character, Integer> rightDiagonalMaps = new HashMap<>();

    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getSym();
        if(!rowMaps.containsKey(row)){
            rowMaps.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRowMap = rowMaps.get(row);
        if(currRowMap.containsKey(character)){
            currRowMap.put(character, currRowMap.get(character)+1);
        }
        else{
            currRowMap.put(character, 1);
        }
        if(currRowMap.get(character) == board.getSize()){
            return true;
        }
        //column:
        if(!colMaps.containsKey(col)){
            colMaps.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currColMap = colMaps.get(col);
        if(!currColMap.containsKey(character)){
            currColMap.put(character, 1);
        }
        else{
            currColMap.put(character, currColMap.get(character)+1);

        }
        if(currColMap.get(character) == board.getSize()){
            return true;
        }
        if (row == col) {
            if(!leftDiagonalMaps.containsKey(character)){
                leftDiagonalMaps.put(character, 1);

            } else{
                leftDiagonalMaps.put(character, leftDiagonalMaps.get(character)+1);
            }
            if(leftDiagonalMaps.get(character) == board.getSize()){
                return true;
            }
        }
        if(row+col == board.getSize()-1){
            if(!rightDiagonalMaps.containsKey(character)){
                rightDiagonalMaps.put(character, 1);

            } else{
                rightDiagonalMaps.put(character, rightDiagonalMaps.get(character)+1);
            }
            if(rightDiagonalMaps.get(character) == board.getSize()){
                return true;
            }
        }
        return false;
    }
}
