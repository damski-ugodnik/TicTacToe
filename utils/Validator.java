package utils;

import model.Coordinates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validateRegex(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static boolean turnPossible(Coordinates coordinates, char[][] table) {
        return inGameDeskBounds(coordinates, table) && cellIsEmpty(coordinates, table);
    }

    private static boolean inGameDeskBounds(Coordinates coordinates, char[][] table) {
        return coordinates.row() >= 0 && coordinates.row() < table.length &&
                coordinates.column() >= 0 && coordinates.column() < table.length;
    }

    private static boolean cellIsEmpty(Coordinates coordinates, char[][] table) {
        return table[coordinates.row()][coordinates.column()] == ' ';
    }
}
