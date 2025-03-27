package model;

public class Grid {

    private int rows;
    private int columns;
    private int[][] matrix;

    public Grid() {

    }

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public boolean dropDisc(int column, int player) {
        for (int row = rows - 1; row >= 0; row--) {
            if (this.matrix[row][column] == 0) { // Empty cell
                this.matrix[row][column] = player;
                return true;
            }
        }
        return false; // Column is full
    }

    public int getColumns() {
        return this.columns;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : this.matrix) {
            for (int cell : row) {
                sb.append(cell == 0 ? "." : (cell == 1 ? "X" : "O"));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
