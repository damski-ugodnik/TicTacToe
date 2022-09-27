package model;

import provider.ICoordinateProvider;
import utils.GameUtils;

import java.util.Arrays;
import java.util.Map;

public class TicTacToeTable {
    private final int size;
    private char[][] gameTable;
    private final Map<Symbol, ICoordinateProvider> players;

    public TicTacToeTable(int size, Map<Symbol, ICoordinateProvider> players) {
        this.size = size;
        this.players = players;
        this.gameTable = new char[size][size];
        for (char[] chars : gameTable) {
            Arrays.fill(chars, ' ');
        }
    }

    public Map<Symbol, ICoordinateProvider> getPlayers() {
        return players;
    }

    public int getSize() {
        return size;
    }

    public char[][] getGameTable() {
        return GameUtils.copyArrayOfChars(gameTable);
    }

    public void setSymbol(Coordinates coordinates, Symbol symbol) {
        gameTable[coordinates.row()][coordinates.column()] = symbol.getChar();
    }

    @Override
    public String toString() {
        StringBuilder tableString = new StringBuilder();
        String horizontalLine = configHorizontalLine(gameTable[0].length);
        tableString.append(horizontalLine).append("\n");
        for (char[] row : gameTable) {
            tableString.append("| ");
            for (char column : row) {
                tableString.append(String.format("%c ", column));
            }
            tableString.append("|\n");
        }
        tableString.append(horizontalLine);
        return tableString.toString();
    }

    private String configHorizontalLine(int rowLength) {
        return "---" + "--".repeat(Math.max(0, rowLength));
    }

    @Override
    public TicTacToeTable clone() {
        TicTacToeTable ticTacToeTable = new TicTacToeTable(size, players);
        Coordinates coordinates;
        ticTacToeTable.gameTable = GameUtils.copyArrayOfChars(this.gameTable);
        return ticTacToeTable;
    }
}