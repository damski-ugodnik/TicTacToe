package utils;

import model.Coordinates;

public class GameUtils {
    public static char[][] copyArrayOfChars(char[][] arr) {
        char[][] copy = new char[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);
        }
        return copy;
    }

    public static Coordinates extractCoordinatesFromString(String input) {
        int spaceIndex = input.indexOf(' ');
        int row = Integer.parseInt(input.substring(0, spaceIndex)) - 1;
        int column = Integer.parseInt(input.substring(spaceIndex + 1)) - 1;
        return new Coordinates(row, column);
    }
}
