package provider.impl;

import model.Coordinates;
import model.Symbol;
import model.TicTacToeTable;
import provider.ICoordinateProvider;
import utils.Constants;
import utils.CoordinateProviderUtils;
import utils.Validator;

public class EasyAiCoordinateProvider implements ICoordinateProvider {
    private static EasyAiCoordinateProvider instance;

    private EasyAiCoordinateProvider() {
    }

    public static EasyAiCoordinateProvider getInstance() {
        if (instance == null) {
            instance = new EasyAiCoordinateProvider();
        }
        return instance;
    }

    @Override
    public void provideCoordinates(TicTacToeTable table, Symbol playingSymbol) {
        System.out.printf(Constants.AI_PROVIDER_MOVE_MESSAGE, "easy");
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