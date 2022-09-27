package provider;

import model.Symbol;
import model.TicTacToeTable;

public interface ICoordinateProvider {
    void provideCoordinates(TicTacToeTable table, Symbol playingSymbol);
}
