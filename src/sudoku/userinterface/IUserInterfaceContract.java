package sudoku.userinterface;

import sudoku.problemdomain.sudokuGame;

public interface IUserInterfaceContract {
    interface EventListener{
        void onSudokuInput(int x,int y,int input);
        void onDialogClick();
    }
    interface View{
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(sudokuGame game);    // i have put sudokuGame but it is SudokuGame
        void showDialog(String message);
        void showError(String message);
    }
}
