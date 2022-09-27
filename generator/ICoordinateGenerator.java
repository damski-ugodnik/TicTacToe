package generator;

import model.Coordinates;

public interface ICoordinateGenerator {
    Coordinates generateCoordinates(char[][] gameTable);
}
