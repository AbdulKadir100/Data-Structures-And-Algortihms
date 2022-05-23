package StringsAndArray;

import java.util.Arrays;

public class MatrixRotate {
    public static void main(String[] args) {
        char[] Carr = new char[]{'a','b','d','u','l'};
        isRotated(Carr);
    }

    /* Zero matrix */
    public static void setZeros(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        //Check if first row has a zero
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        //Check if first col has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[j][0] == 0) {
                colHasZero = true;
                break;
            }
        }
        //Check the zeros in the rest of array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //Nullify rows based on values in first column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) nullifyRow(matrix, i);
        }

        //Nullify colmns based on values in first row
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) nullifyCol(matrix, i);
        }
        //Nullify first and column as necessary
        if (rowHasZero) nullifyRow(matrix, 0);
        if (colHasZero) nullifyCol(matrix, 0);
    }


    public static void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void nullifyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][col] = 0;
        }
    }

    static boolean Rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];   //Save top
                //Left top
                matrix[first][i] = matrix[last][last - offset];
                //bottom left
                matrix[last - offset][first] = matrix[last][last - offset];
                //right bottom
                matrix[last][last - offset] = matrix[i][last];
                //top left
                matrix[i][last] = top;
            }
        }
        return true;
    }


    static void isRotated(char[] s1){
        for (int i=0;i<s1.length;i++){
            s1[i] = s1[s1.length-1-i];
        }
        System.out.println(Arrays.toString(s1));
    }
}
