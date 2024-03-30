package sudoku.computationLogic;

import sudoku.problemdomain.sudokuGame;

public class SudokuUtilities {
    public static void copySudokuArrayValue(int[][] oldArray,int[][] newArray){
        for(int xIndex= 0;xIndex < sudokuGame.GRID_BOUNDARY;xIndex++){
            for(int yIndex= 0;yIndex < sudokuGame.GRID_BOUNDARY;yIndex++){
                newArray[xIndex][yIndex]= oldArray[xIndex][yIndex];
            }
        }
    }
    public static int[][] copyToNewArray(int[][] oldArray){
       int[][] newArray = new int[sudokuGame.GRID_BOUNDARY][sudokuGame.GRID_BOUNDARY];
        for(int xIndex= 0;xIndex < sudokuGame.GRID_BOUNDARY;xIndex++){
            for(int yIndex= 0;yIndex < sudokuGame.GRID_BOUNDARY;yIndex++){
                newArray[xIndex][yIndex]= oldArray[xIndex][yIndex];
            }
        }
        return newArray;
    }
}
