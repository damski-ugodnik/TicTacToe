package provider.impl;

import model.Coordinates;
import model.Symbol;
import model.TicTacToeTable;
import provider.ICoordinateProvider;
import utils.ConsoleReader;
import utils.Constants;
import utils.GameUtils;
import utils.Validator;

public class HumanCoordinateProvider implements ICoordinateProvider {
    private static HumanCoordinateProvider instance;

    private HumanCoordinateProvider() {
    }

    public static HumanCoordinateProvider getInstance() {
        if (instance == null) {
            instance = new HumanCoordinateProvider();
        }
        return instance;
    }

    @Override
    public void provideCoordinates(TicTacToeTable table, Symbol playingSymbol) {
        while (true) {
            String input = ConsoleReader.readString(Constants.COORDINATES_INPUT_MESSAGE,
                    Constants.COORDINATES_PATTERN);
            Coordinates coordinates = GameUtils.extractCoordinatesFromString(input);
            if (Validator.turnPossible(coordinates, table.getGameTable())) {
                table.setSymbol(coordinates, playingSymbol);
                return;
            }
        }
    }
}
