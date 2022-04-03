public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result=new int[n];
        for(int i=0;i<bookings.length;i++)
        {
            int start=bookings[i][0]-1;
            int end=bookings[i][1]-1;
            int count=bookings[i][2];
            for(int j=start;j<=end;j++)
            {
                result[j]= result[j]+count;
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
        int[][] test1={{1,2,10},{2,3,20},{2,5,25}};
        int n1=5;
        int[] result1=(new Solution()).corpFlightBookings(test1,n1);
        for(int i=0;i<result1.length;i++)
        {
            System.out.print(result1[i]+" ");
        }
        System.out.println();
    }
}
