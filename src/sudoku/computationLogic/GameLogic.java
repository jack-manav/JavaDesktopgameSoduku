package sudoku.computationLogic;

import sudoku.constants.GameState;
import sudoku.constants.Rows;
import sudoku.problemdomain.sudokuGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static sudoku.problemdomain.sudokuGame.GRID_BOUNDARY;

public class GameLogic {

    public static sudokuGame getNewGame(){
        return new sudokuGame(
                GameState.NEW,
                GameGenerator.getNewGameGrid()
        );
    }

    public static GameState checkForCompletion(int[][] grid){
        if(sudokuIsInvalid(grid)) return GameState.ACTIVE;
        if(tilesAreNotFilled(grid)) return GameState.ACTIVE;
         return GameState.COMPLETE;
    }

    public static boolean sudokuIsInvalid(int[][] grid) {
        if(rowsAreInvalid(grid)) return true;
        if(colAreInvalid(grid)) return true;
        if(squaresAreInvalid(grid)) return true;
        else return false;
    }

    private static boolean colAreInvalid(int[][] grid) {
        for(int xIndex=0; xIndex < GRID_BOUNDARY ; xIndex++){
            List<Integer> rows = new ArrayList<>();
            for(int yIndex=0; yIndex < GRID_BOUNDARY ; yIndex++){
                rows.add(grid[xIndex][yIndex]);
            }
            if(collectionHasRepeat(rows)) return true;
        }
       return false;
    }

    private static boolean squaresAreInvalid(int[][] grid) {
        if(rowOfSquaresIsInvalid(Rows.TOP,grid)) return true;

        if(rowOfSquaresIsInvalid(Rows.MIDDLE,grid)) return true;

        if(rowOfSquaresIsInvalid(Rows.BOTTOM,grid)) return true;

        return false;
    }

    private static boolean rowOfSquaresIsInvalid(Rows value, int[][] grid) {
        switch (value){
            case TOP:
                if(squareIsInvalid(0,0,grid)) return true;
                if(squareIsInvalid(0,3,grid)) return true;
                if(squareIsInvalid(0,6,grid)) return true;
                return false;
            case MIDDLE:
                if(squareIsInvalid(3,0,grid)) return true;
                if(squareIsInvalid(3,3,grid)) return true;
                if(squareIsInvalid(3,6,grid)) return true;
                return false;
            case BOTTOM:
                if(squareIsInvalid(6,0,grid)) return true;
                if(squareIsInvalid(6,3,grid)) return true;
                if(squareIsInvalid(6,6,grid)) return true;
                return false;
            default:
                return false;
        }

    }

    private static boolean squareIsInvalid(int xIndex, int yIndex, int[][] grid) {
        int yIndexEnd = yIndex +3;
        int xIndexEnd = xIndex + 3;

        List<Integer> square = new ArrayList<>();

        while (yIndexEnd > yIndex){
            while (xIndexEnd > xIndex){
                square.add(
                        grid[xIndex][yIndex]
                );
                xIndex++;
            }
            xIndex -= 3;

            yIndex++;
        }
        if(collectionHasRepeat(square)) return true;
        return false;

    }

    public static boolean collectionHasRepeat(List<Integer> collection) {

        for(int index = 1; index < GRID_BOUNDARY; index++){
            if(Collections.frequency(collection,index)>1) return true;
        }

        return false;
    }

    private static boolean rowsAreInvalid(int[][] grid) {
        for(int yIndex=0; yIndex < GRID_BOUNDARY ; yIndex++){
            List<Integer> rows = new ArrayList<>();
            for(int xIndex=0; xIndex < GRID_BOUNDARY ; xIndex++){
                rows.add(grid[xIndex][yIndex]);
            }
            if(collectionHasRepeat(rows)) return true;
        }
        return false;
    }

    public static boolean tilesAreNotFilled(int[][] grid) {
        for(int xIndex=0; xIndex<GRID_BOUNDARY;xIndex++){
            for(int yIndex=0 ; yIndex<GRID_BOUNDARY;yIndex++){
                if(grid[xIndex][yIndex]==0) return true;
            }
        }
        return false;
    }
}
