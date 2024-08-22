package Medium;

public class M12_Rotate_Matrix_90_degree {

    //optimal solution
    //TC: O(N/2 * N/2)
    //SC: O(1)
        static void rotate(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            //transpose
            for (int i = 0; i < n; i++) {
                for (int j = i; j < m; j++) {
                    int temp;
                    //swapping
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            //reverse
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }
        }

        public static void main(String[] args) {
            int[][] arr =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            rotate(arr);
            System.out.println("Rotated Image");
            for(int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

        }
}
