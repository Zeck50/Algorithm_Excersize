public class NumMatrix {
    private int[][] tempMatrix;
    public NumMatrix(int[][] matrix) {
        tempMatrix=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                tempMatrix[i][j]=matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result=0;
        for(int i=0;i<tempMatrix.length;i++)
            for(int j=0;j<tempMatrix[0].length;j++)
            {
                if(i>=row1&&i<=row2&&j>=col1&&j<=col2)
                {
                    result=result+tempMatrix[i][j];
                }
            }
        return result;
    }
}
