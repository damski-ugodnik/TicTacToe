package model;

public enum Symbol {
    X('X') {
        @Override
        public Symbol getNext() {
            return O;
        }
    },
    O('O') {
        @Override
        public Symbol getNext() {
            return X;
        }
    },
    EMPTY(' ');

    private final char actualSymbol;

    Symbol(char symbol) {
        this.actualSymbol = symbol;
    }

    public Symbol getNext() {
        throw new UnsupportedOperationException("Operation not supported by this Symbol");
    }

    public char getChar() {
        return actualSymbol;
    }
}
