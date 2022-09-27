package utils;

import model.Coordinates;
import model.GameState;
import model.Symbol;
import model.TicTacToeTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CoordinateProviderUtils {
    public static Coordinates randomCoordinates(char[][] table) {
        Random random = new Random();
        int row = random.nextInt(table.length);
        int column = random.nextInt(table.length);
        return new Coordinates(row, column);
    }

    public static boolean canWinInOneFurtherMove(TicTacToeTable table, Symbol playingSymbol, Function<Symbol, Symbol> symbolFunction) {
        List<Coordinates> freeCells = getFreeCells(table.getGameTable());
        if (freeCells.size() > table.getSize() * table.getSize() - table.getSize()) {
            return false;
        }
        char[][] tableClone;
        for (Coordinates freeCell : freeCells) {
            tableClone = GameUtils.copyArrayOfChars(table.getGameTable());
            tableClone[freeCell.row()][freeCell.column()] = playingSymbol.getChar();
            if (GameState.isAllSymbolsInRow(tableClone, playingSymbol.getChar())) {
                table.setSymbol(freeCell, symbolFunction.apply(playingSymbol));
                return true;
            }
        }
        return false;
    }

    private static List<Coordinates> getFreeCells(char[][] table) {
        List<Coordinates> freeCells = new ArrayList<>();
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                if (table[row][column] == ' ') {
                    freeCells.add(new Coordinates(row, column));
                }
            }
        }
        return freeCells;
    }

    public static void findBestMove(TicTacToeTable table, Symbol playingSymbol) {
        int bestVal = -1000;
        Coordinates coordinates = new Coordinates(-1, -1);
        List<Coordinates> freeCells = getFreeCells(table.getGameTable());
        TicTacToeTable tableClone = table.clone();
        int moveVal;

        for (Coordinates freeCell : freeCells) {
            tableClone.setSymbol(freeCell, playingSymbol);
            moveVal = minimax(tableClone.getGameTable(), 0, false, playingSymbol);
            if (moveVal > bestVal) {
                bestVal = moveVal;
                coordinates = freeCell;
            }
            tableClone.setSymbol(freeCell, Symbol.EMPTY);
        }
        table.setSymbol(coordinates, playingSymbol);
    }

    private static int minimax(char[][] board, int depth, Boolean isMaximizer, Symbol playingSymbol) {
        char currentChar = isMaximizer ? playingSymbol.getChar() : playingSymbol.getNext().getChar();
        BiFunction<Integer, Integer, Integer> minMax = isMaximizer ? Math::max : Math::min;
        int best = isMaximizer ? -1000 : 1000;
        int minimaxValue;

        if (GameState.isAllSymbolsInRow(board, playingSymbol.getChar()))
            return 10;
        if (GameState.isAllSymbolsInRow(board, playingSymbol.getNext().getChar()))
            return -10;
        if (getFreeCells(board).size() == 0)
            return 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Symbol.EMPTY.getChar()) {
                    board[i][j] = currentChar;
                    minimaxValue = minimax(board, depth + 1, !isMaximizer, playingSymbol);
                    best = minMax.apply(best, minimaxValue);
                    board[i][j] = Symbol.EMPTY.getChar();
                }
            }
        }

        return best;
    }
}
