package models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType type;
    private static Scanner sc = new Scanner(System.in);
    public Player(String name, Symbol symbol, PlayerType type){
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
    public Move makeMove(Board board){
        //ask user for the position of their symbol
        System.out.println("Please enter row where you want to make your move: ");
        int row = sc.nextInt();
        System.out.println("Please enter col where you want to make your move: ");
        int col = sc.nextInt();

        return new Move(new Cell(row, col), this);
    }


}
