package sudoku.problemdomain;

import sudoku.computationLogic.SudokuUtilities;
import sudoku.constants.GameState;

import java.io.Serializable;

public class sudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;

    public static final int GRID_BOUNDARY=9;

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState); // protects game object from change
    }

    public sudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }
}
