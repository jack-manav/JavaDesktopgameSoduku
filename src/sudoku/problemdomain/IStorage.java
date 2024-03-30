package sudoku.problemdomain;

import java.io.IOException;

public interface IStorage {
    void updateGameData(sudokuGame game) throws IOException;
    sudokuGame getGameData() throws IOException;
}
