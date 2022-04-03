public class OfficialNumMatrix {
    private int[][] preSumMatrix;
    public OfficialNumMatrix(int[][] matrix) {
        preSumMatrix=new int[matrix.length+1][matrix[0].length+1];
        //1.前缀矩阵的的长宽均比原矩阵要多1，因此遍历的时候要加1
        for(int i=1;i<=matrix.length;i++)
        {
            for(int j=1;j<=matrix[0].length;j++)
            {
                //2.前缀矩阵的索引i,j，对应的是原矩阵的i-1,j-1,所以最后的matrix的索引分别要减一。前缀和矩阵和原矩阵混合运算要注意索引不要搞混。
                preSumMatrix[i][j]=preSumMatrix[i-1][j]+preSumMatrix[i][j-1]-preSumMatrix[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result=preSumMatrix[row2+1][col2+1]-preSumMatrix[row2+1][col1]-preSumMatrix[row1][col2+1]+preSumMatrix[row1][col1];
        return result;
    }

    public static void main(String[] args)
    {
        int[][] test1={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        int ressult1=(new OfficialNumMatrix(test1)).sumRegion(2,1,4,3);
        System.out.print(ressult1);
    }
}
