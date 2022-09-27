package tictactoe;

import model.GameState;
import model.PlayerType;
import model.Symbol;
import model.TicTacToeTable;
import provider.ICoordinateProvider;
import utils.ConsoleReader;
import utils.Constants;

import java.util.Map;

public class Application {

    public void run() {
        String input;
        String[] args;
        while (true) {
            input = ConsoleReader.readString(Constants.COMMANDS_INPUT_MESSAGE, Constants.COMMANDS_PATTERN);
            args = input.split(" ");
            if (args[0].equalsIgnoreCase("exit")) {
                return;
            }
            Symbol symbol = Symbol.X;
            Map<Symbol, ICoordinateProvider> players = Map.of(symbol, PlayerType.getProviderByTitle(args[1]),
                    symbol.getNext(), PlayerType.getProviderByTitle(args[2]));
            TicTacToeTable table = new TicTacToeTable(3, players);
            do {
                System.out.println(table);
                table.getPlayers().get(symbol).provideCoordinates(table, symbol);
                symbol = symbol.getNext();
            } while (GameState.NOT_FINISHED.isThisState(table.getGameTable()));
            System.out.println(table);
            System.out.println(GameState.fromTable(table.getGameTable()).getStateMessage());
        }
    }
}
