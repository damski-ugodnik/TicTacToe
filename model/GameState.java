package model;

public enum GameState {
    NOT_FINISHED("Game not finished") {
        @Override
        public boolean isThisState(char[][] gameTable) {
            return !isAllSymbolsInRow(gameTable, Symbol.O.getChar()) &&
                    !isAllSymbolsInRow(gameTable, Symbol.X.getChar()) &&
                    !isTableFull(gameTable);
        }
    },
    DRAW("Draw") {
        @Override
        public boolean isThisState(char[][] gameTable) {
            return !isAllSymbolsInRow(gameTable, Symbol.O.getChar()) &&
                    !isAllSymbolsInRow(gameTable, Symbol.X.getChar()) &&
                    isTableFull(gameTable);
        }
    },
    X_WINS("X wins") {
        @Override
        public boolean isThisState(char[][] gameTable) {
            return GameState.isAllSymbolsInRow(gameTable, Symbol.X.getChar());
        }
    },
    O_WINS("O wins") {
        @Override
        public boolean isThisState(char[][] gameTable) {
            return GameState.isAllSymbolsInRow(gameTable, Symbol.O.getChar());
        }
    };

    private final String stateMessage;

    GameState(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public static GameState fromTable(char[][] gameTable) {
        for (GameState state : values()) {
            if (state.isThisState(gameTable)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Error");
    }

    public static boolean isAllSymbolsInRow(char[][] gameTable, char symbol) {
        int size = gameTable.length;
        int charsInRowHorizontal = 0;
        int charsInRowVertical = 0;
        int charsInRowDiagonalDescending = 0;
        int charsInRowDiagonalAscending = 0;
        for (int i = 0; i < gameTable.length; i++) {
            for (int j = 0; j < gameTable[i].length; j++) {
                if (gameTable[i][j] == symbol) {
                    charsInRowHorizontal++;
                }
                if (gameTable[j][i] == symbol) {
                    charsInRowVertical++;
                }
                if (gameTable[j][j] == symbol) {
                    charsInRowDiagonalDescending++;
                }
                if (gameTable[size - 1 - j][j] == symbol) {
                    charsInRowDiagonalAscending++;
                }
                if (charsInRowHorizontal == size ||
                        charsInRowVertical == size ||
                        charsInRowDiagonalDescending == size ||
                        charsInRowDiagonalAscending == size) {
                    return true;
                }
            }
            charsInRowDiagonalDescending = 0;
            charsInRowDiagonalAscending = 0;
            charsInRowHorizontal = 0;
            charsInRowVertical = 0;
        }
        return false;
    }

    private static boolean isTableFull(char[][] gameTable) {
        for (char[] chars : gameTable) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public abstract boolean isThisState(char[][] gameTable);
}
