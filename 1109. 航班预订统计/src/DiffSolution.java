public class DiffSolution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result=new int[n];
        int[] diffArr=new int[n];
        //1.差分数组的应用
        for(int i=0;i<bookings.length;i++)
        {
            int start=bookings[i][0]-1;
            int end=bookings[i][1]-1;
            int count=bookings[i][2];
            diffArr[start]=diffArr[start]+count;
            //2.差分数组结束边界条件的处理
            if(end+1<n)
            {
                diffArr[end+1]=diffArr[end+1]-count;
            }
        }
        result[0]=diffArr[0];
        //3.差分数组的还原
        for(int i=1;i<result.length;i++)
        {
            result[i]=result[i-1]+diffArr[i];
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] test1={{1,2,10},{2,3,20},{2,5,25}};
        int n1=5;
        int[] result1=(new DiffSolution()).corpFlightBookings(test1,n1);
        for(int i=0;i<result1.length;i++)
        {
            System.out.print(result1[i]+" ");
        }
        System.out.println();
    }
}
