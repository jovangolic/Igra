package model;

public class Game {

    private Grid grid;
    private int currentPlayer;
    private int maxTurns;
    private int turnCount;

    public Game(Grid grid, int maxTurns) {
        this.grid = grid;
        this.maxTurns = maxTurns;
        this.turnCount = 0;
        this.currentPlayer = 1; // Player 1 starts
    }

    public String makeMove(int column) {
        if (turnCount >= maxTurns) {
            return "Game Over";
        }

        // Implement the move logic (insert a disc into the column)
        boolean success = grid.dropDisc(column, currentPlayer);
        if (!success) {
            return "Invalid move";
        }

        turnCount++;
        currentPlayer = (currentPlayer == 1) ? 2 : 1; // Switch players

        return "Move successful";
    }

    /*
     * public String getGameState() {
     * return grid.toString(); // Returns the current state of the grid
     * }
     */

    public int[][] getGameState() {
        return grid.getMatrix(); // Vraća matricu, umesto toString()
    }
}
