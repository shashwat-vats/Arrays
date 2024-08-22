package Medium;

public class M10_setMatrixZeroes {

    public static void setZeros(int[][] a, int n, int m) {

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i =0 ; i<n ; i++) {
            for(int j=0; j<m ; j++) {
                if(a[i][j]==0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i =0 ; i<n ; i++) {
            for(int j=0; j<m ; j++) {
                if(row[i] == 1 || col[j] == 1) {
                   a[i][j] = 0;
                }
            }
        }

        for(int i =0 ; i<n ; i++) {
            for(int j=0; j<m ; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }

    }







    public static void main(String[] args) {
    int[][] a = {{1,1,1,1},{1,0,1,1},{1,1,0,1},{0,1,1,1}};
    int n = a.length;
    int m= a[0].length;
    setZeros(a,n,m);

    }

}
