public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        boolean result=true;
        int[] diff=new int[1000];
        int[] statistics=new int[1000];
        //1.差分数组思想的应用
        for(int i=0;i<trips.length;i++)
        {
            int count=trips[i][0];
            int start=trips[i][1];
            //2.区间结束端点的处理，本题为左闭右开区间
            int end=trips[i][2]-1;
            diff[start]=diff[start]+count;
            //3.差分数组结束端点的处理
            if(end+1<1000)
            {
                diff[end+1]=diff[end+1]-count;
            }
        }
        //4.还原数组时首元素的处理
        statistics[0]=diff[0];
        if(statistics[0]>capacity)
        {
            result=false;
        }
        for(int i=1;i< statistics.length;i++)
        {
            statistics[i]=statistics[i-1]+ diff[i];
            if(statistics[i]>capacity)
            {
                result=false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {

        int[][] trips1={{2,1,5},{3,3,7}};
        int capacity1=4;
        boolean result1=(new Solution()).carPooling(trips1,capacity1);
        System.out.print(result1);

        System.out.println();

        int[][] trips2={{2,1,5},{3,3,7}};
        int capacity2=5;
        boolean result2=(new Solution()).carPooling(trips2,capacity2);
        System.out.print(result2);

        System.out.println();



        int[][] trips3={{2,1,5},{3,5,7}};
        int capacity3=3;
        boolean result3=(new Solution()).carPooling(trips3,capacity3);
        System.out.print(result3);

        System.out.println();


        int[][] trips4={{9,0,1},{3,3,7}};
        int capacity4=4;
        boolean result4=(new Solution()).carPooling(trips4,capacity4);
        System.out.print(result4);
    }
}
