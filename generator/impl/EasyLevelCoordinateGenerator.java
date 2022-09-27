package generator.impl;

import generator.ICoordinateGenerator;
import model.Coordinates;

import java.util.Random;

public class EasyLevelCoordinateGenerator implements ICoordinateGenerator {
    private static EasyLevelCoordinateGenerator instance;

    private final Random random = new Random();

    public static EasyLevelCoordinateGenerator getInstance() {
        if(instance == null) {
            instance = new EasyLevelCoordinateGenerator();
        }
        return instance;
    }

    @Override
    public Coordinates generateCoordinates(char[][] gameTable) {
        int row = random.nextInt(gameTable.length);
        int column = random.nextInt(gameTable.length);
        return new Coordinates(row, column);
    }
}
