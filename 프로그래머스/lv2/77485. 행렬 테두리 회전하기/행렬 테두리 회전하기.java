import java.util.*;

class Solution {
    static int[][] matrix;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows + 1][columns + 1];
        int num = 1;
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int[] cmd : queries) {
            list.add(rotate(cmd));
        }
        
        return list.stream().mapToInt(x->x).toArray();
    }
    
    public int rotate(int[] cmd) {
        int minR = cmd[0],
            minC = cmd[1],
            maxR = cmd[2],
            maxC = cmd[3];
        
        int temp = matrix[minR][minC];
        int min = temp;
        
        for(int i = minR; i < maxR; i++) {
            matrix[i][minC] = matrix[i+1][minC];
            min = Math.min(min, matrix[i][minC]);
        }
        for(int i = minC; i < maxC; i++) {
            matrix[maxR][i] = matrix[maxR][i+1];
            min = Math.min(min, matrix[maxR][i]);
        }
        for(int i = maxR; i > minR; i--) {
            matrix[i][maxC] = matrix[i-1][maxC];
            min = Math.min(min, matrix[i][maxC]);
        }
        for(int i = maxC; i > minC; i--) {
            matrix[minR][i] = matrix[minR][i-1];
            min = Math.min(min, matrix[minR][i]);
        }
        matrix[minR][minC+1] = temp;
        
        return min;
    }
}