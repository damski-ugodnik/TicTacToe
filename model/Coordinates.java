package model;

public record Coordinates(int row, int column) {
    @Override
    public int row() {
        return row;
    }

    @Override
    public int column() {
        return column;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinates coordinates)) {
            return false;
        }
        return coordinates.row == this.row && coordinates.column == this.column;
    }
}
