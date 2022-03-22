public class OfficialSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[0].length-1;
        boolean result=false;
        while(i<matrix.length&&j>=0)
        {
            if(matrix[i][j]==target)
            {
                result= true;
                break;
            }
            else if(matrix[i][j]>target)
            {
                j--;
                continue;
            }
            else if(matrix[i][j]<target)
            {
                i++;
                continue;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        OfficialSolution officialSolution=new OfficialSolution();
        int[][] matrix1 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target1=5;
        boolean result1=officialSolution.searchMatrix(matrix1,target1);
        System.out.println(result1);

        int[][] matrix2={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target2=20;
        boolean result2=officialSolution.searchMatrix(matrix2,target2);
        System.out.println(result2);

        int[][] matrix3={{-5}};
        int target3=-5;
        boolean result3=officialSolution.searchMatrix(matrix3,target3);
        System.out.println(result3);
    }
}
