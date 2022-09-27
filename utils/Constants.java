package utils;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern COORDINATES_PATTERN = Pattern.compile("\\d\s\\d");
    public static final String COORDINATES_INPUT_MESSAGE = "Enter the coordinates: ";
    public static final Pattern COMMANDS_PATTERN =
            Pattern.compile("^(start (user|easy|medium|hard) (user|easy|medium|hard)|exit)$");
    public static final String COMMANDS_INPUT_MESSAGE = "Input command: ";
    public static final String AI_PROVIDER_MOVE_MESSAGE = "Making move level \"%s\"\n";
}
