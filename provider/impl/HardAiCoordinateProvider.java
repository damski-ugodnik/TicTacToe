package provider.impl;

import model.Symbol;
import model.TicTacToeTable;
import provider.ICoordinateProvider;
import utils.Constants;
import utils.CoordinateProviderUtils;

public class HardAiCoordinateProvider implements ICoordinateProvider {
    private static HardAiCoordinateProvider instance;

    private HardAiCoordinateProvider() {
    }

    public static HardAiCoordinateProvider getInstance() {
        if (instance == null) {
            instance = new HardAiCoordinateProvider();
        }
        return instance;
    }

    @Override
    public void provideCoordinates(TicTacToeTable table, Symbol playingSymbol) {
        System.out.printf(Constants.AI_PROVIDER_MOVE_MESSAGE, "hard");
        CoordinateProviderUtils.findBestMove(table, playingSymbol);
    }
}
