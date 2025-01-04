package me.vkku.binarySearch;

import org.junit.jupiter.api.Test;

public class Search2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix[0].length;
        int cols = matrix.length;
        int lo = 0;
        int hi = cols - 1;
        int savePos = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(matrix[mid][rows - 1] == target){
                return true;
            } else if (matrix[mid][rows - 1] < target) {
                lo = mid + 1;
                savePos = lo;
            } else {
                hi = mid - 1;
            }
        }
        if(savePos >= cols){
            return false;
        }
        return binarySearch(matrix, savePos, rows, target);
    }

    public int findIndex(int[][] matrix, int target){
        int cols = matrix.length;
        int saveIndex = -1;
        for(int i = 0 ; i < cols ; i++){
            if(matrix[i][matrix[0].length - 1] > target){
                saveIndex = i;
                break;
            }
        }
        return saveIndex;
    }

    public boolean binarySearch(int[][] matrix, int row, int cols, int target){
        int lo = 0;
        int hi = cols - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(matrix[row][mid] == target){
                return true;
            } else if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }


    @Test
    public void driver(){
        Search2DMatrix_74 search2DMatrix = new Search2DMatrix_74();
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
//        int[][] arr = {
//                {1}
//        };

//        System.out.println(search2DMatrix.searchMatrix(arr, 2));
        System.out.println(search2DMatrix.findIndex(arr, 2));
    }

}
