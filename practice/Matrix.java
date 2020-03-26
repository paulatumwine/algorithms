import org.junit.Assert;

public class Matrix {

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        int x,i,j;
        for(x=0; x<A.length; x++) { // row in A
            for (j=0; j<B[0].length; j++) { // col in B
                for(i=0; i<B.length; i++) { // row in B & col in A
                    result[x][j] += A[x][i] * B[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,0,0},{-1,0,3}};
        int[][] B = new int[][]{{7,0,0},{0,0,0},{0,0,1}};
        int[][] C = multiply(A, B);
        Assert.assertArrayEquals(new int[][]{{7,0,0},{-7,0,3}}, C);

        A = new int[][]{{1,-5}};
        B = new int[][]{{12},{-1}};
        C = new int[][]{{17}};
        C = multiply(A, B);
        Assert.assertArrayEquals(new int[][]{{17}}, C);
    }
}
