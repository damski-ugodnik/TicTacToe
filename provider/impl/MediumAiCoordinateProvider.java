package provider.impl;

import model.Coordinates;
import model.Symbol;
import model.TicTacToeTable;
import provider.ICoordinateProvider;
import utils.Constants;
import utils.CoordinateProviderUtils;
import utils.Validator;

import java.util.function.Function;

public class MediumAiCoordinateProvider implements ICoordinateProvider {
    private static MediumAiCoordinateProvider instance;
    private static final String TITLE = "medium";

    private MediumAiCoordinateProvider() {
    }

    public static MediumAiCoordinateProvider getInstance() {
        if (instance == null) {
            instance = new MediumAiCoordinateProvider();
        }
        return instance;
    }

    @Override
    public void provideCoordinates(TicTacToeTable table, Symbol playingSymbol) {
        System.out.printf(Constants.AI_PROVIDER_MOVE_MESSAGE, TITLE);
        Symbol opponentSymbol = playingSymbol.getNext();
        if (CoordinateProviderUtils.canWinInOneFurtherMove(table, playingSymbol, Function.identity())) {
            return;
        }
        if (CoordinateProviderUtils.canWinInOneFurtherMove(table, opponentSymbol, Symbol::getNext)) {
            return;
        }
        Coordinates coordinates;
        while (true) {
            coordinates = CoordinateProviderUtils.randomCoordinates(table.getGameTable());
            if (Validator.turnPossible(coordinates, table.getGameTable())) {
                table.setSymbol(coordinates, playingSymbol);
                return;
            }
        }
    }
}
