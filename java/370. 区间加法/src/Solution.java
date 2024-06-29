public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result=new int[length];
        for(int i=0;i<updates.length;i++)
        {
            int start=updates[i][0];
            int end=updates[i][1];
            int inc=updates[i][2];
            for(int j=start;j<=end;j++)
            {
                result[j]= result[j]+inc;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int length1=5;
        int[][] update1={{1,3,2},{2,4,3},{0,2,-2}};
        int[] result1=(new Solution()).getModifiedArray(length1,update1);
        for(int i=0;i<result1.length;i++)
        {
            System.out.print(result1[i]+" ");
        }
        System.out.println();
    }
}
