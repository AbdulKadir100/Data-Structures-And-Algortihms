package GFGSelfPaced;

import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;

import static CodeChef.CodeChefProblems.swap;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2},
                {3,4}
        };

        matrixReshape(matrix,1,4);
    }
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }
    static int recInMatrix(int[][] mat){
        int r = mat.length;
        int c = mat[0].length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j]==0){
                    stack.clear();
                    break;
                }else {
                    stack.push(mat[i][j]);
                }
            }
            if (stack.size()>0)
                res=stack.size();
           // res = stack.size();
        }
        return res;
    }
    static int[][] sortMat(int[][] mat){
        int n = mat.length;
        int[] temp = new int[n*n];
        int k=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[k++] = mat[i][j];
            }
        }
        Arrays.sort(temp);
        k=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = temp[k++];
            }
        }
       return mat;
    }

    static int maxRowOne(int[][] mat) {
        int r = mat[0].length;
        int c = mat.length;
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1)
                    count++;
                res = Math.max(res, count);
            }

        }
        return res;
    }

    static int median(int[][] matrix, int r, int c) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            //finding min
            if (matrix[i][0] < min)
                min = matrix[i][0];
            //finding max
            if (matrix[i][c - 1] > max)
                max = matrix[i][c - 1];
        }
        int desired = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int get = 0, place = 0;
            for (int i = 0; i < r; i++) {
                get = Arrays.binarySearch(matrix[i], mid);

                if (get < 0)
                    get = Math.abs(get) - 1;
                else {
                    while (get < matrix[i].length && matrix[i][get] == mid) {
                        get += 1;
                    }

                }
                place = place + get;

            }
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isTrue = true;
        int i = 0, j = c - 1;
        while (i < r && j >= 0) {
            if (matrix[i][j] == target) {
                return isTrue;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return isTrue;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isTrue = true;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == target) {
                    return isTrue;
                } else {
                    isTrue = false;
                }
            }
        }
        return isTrue;
    }

    public static void spiralOfMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int right = c - 1;
        int bottom = r - 1;
        int top = 0, left = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {   // Top Row
                System.out.print(mat[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {   // Right Column
                System.out.print(mat[i][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {    // Bottom Row (Reverse Order)
                    System.out.print(mat[bottom][i] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {      // Left Column (Reverse Order)
                    System.out.print(mat[i][left] + " ");
                }
                left++;
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int right = c - 1;
        int bottom = r - 1;
        int top = 0, left = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {   // Top Row
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {   // Right Column
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {    // Bottom Row (Reverse Order)
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {      // Left Column (Reverse Order)
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

    public static void rotate90(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] t = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                t[j][r - i - 1] = mat[i][j];//clock wise
                // t[r-j-1][i] = mat[i][j];//anti clock wise
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = t[i][j];
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void transPose(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                swap(mat[i][j], mat[j][i]);
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }


    }

    private static void swap(int i, int i1) {
        int temp = i;
        i = i1;
        i1 = temp;
    }

    public static void boundTraversal(int[][] mat) {
        /*
          1 -> 2 -> 3 -> 4
                         |
         5               8
         |               |
         9               11
         |               |
        12 - 13 -  14 <- 15
         */
        int row = mat.length;
        int col = mat[0].length;
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                System.out.print(mat[i][0] + " ");
            }
        } else {
            for (int i = 0; i < col; i++) {
                System.out.print(mat[0][i] + " ");
            }
            for (int i = 1; i < row; i++) {
                System.out.print(mat[i][col - 1] + " ");
            }
            for (int i = col - 2; i >= 0; i--) {
                System.out.print(mat[row - 1][i] + " ");
            }
            for (int i = row - 2; i >= 1; i--) {
                System.out.print(mat[i][0] + " ");
            }
        }
    }

    public static void printSnake(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < col; j++) {
                    System.out.print(mat[i][j] + " ");
                }
            } else {
                for (int j = col - 1; j >= 0; j--) {
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
    }

}
