public class DiffSolutioin {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result=new int[length];
        int[] diffArr=new int[length];
        //1.差分数组的应用
        for(int i=0;i<updates.length;i++)
        {
            int start=updates[i][0];
            int end=updates[i][1];
            int inc=updates[i][2];
            diffArr[start]=diffArr[start]+inc;
            //2.差分数组结束点及长度的判断
            if(end+1<diffArr.length)
            {
                diffArr[end+1]=diffArr[end+1]-inc;
            }
        }
        result[0]=diffArr[0];
        //3.差分数组的还原算法
        for(int i=1;i<diffArr.length;i++)
        {
            result[i]=result[i-1]+diffArr[i];
        }
        return result;
    }

    public static void main(String[] args)
    {
        int length1=5;
        int[][] update1={{1,3,2},{2,4,3},{0,2,-2}};
        int[] result1=(new DiffSolutioin()).getModifiedArray(length1,update1);
        for(int i=0;i<result1.length;i++)
        {
            System.out.print(result1[i]+" ");
        }
        System.out.println();
    }
}
