package me.vkku.queue;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output: 1
Example 2:

Input: grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
Output: 3
 */

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Islands_200 {
    public int numIslands(char[][] grid) {
        int row = grid[0].length - 1;
        int col = grid.length - 1;
        int islands = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1') {
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }
    return islands;
    }

    private void bfs(char[][] grid, int i, int j) {
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[] d : dir){
                int row = current[0] + d[0];
                int col = current[1] + d[1];
                if(row >= 0 &&
                        row < grid[0].length - 1 &&
                        col >= 0 &&
                        col < grid.length - 1 &&
                        grid[row][col] == '1'){
                    queue.add(new int[]{row, col});
                    grid[row][col] = '0';
                }
            }

        }

    }

    @Test
    public void driver(){
        Islands_200 islands200 = new Islands_200();
        System.out.println(islands200.numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}

