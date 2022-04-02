public class TowPointSolution {

    public double[] sampleStats(int[] count) {
        int sum=0;
        for(int i=0;i<count.length;i++)
        {
            sum=sum+count[i];
        }

        double[] result=new double[5];

        double minimum=getMinimum(count);
        double maximum=getMaximum(count);
        double mean=getMean(count);
        double median= getMedian(count, sum);
        double mode=getMode(count);

        result[0]=minimum;
        result[1]=maximum;
        result[2]=mean;
        result[3]=median;
        result[4]=mode;
        return result;
    }
    private double getMode(int[] count)
    {
        double result=0;
        int temp=0;
        for(int i=0;i<count.length;i++)
        {
            if(count[i]>temp)
            {
                temp=count[i];
                result=i;
            }
        }
        return result;
    }

    private double getMean(int[] count)
    {
        double valueSum=0;
        double sum=0;
        for(int i=0;i<count.length;i++)
        {
            valueSum=valueSum+(double)i*count[i];
            sum=sum+count[i];
        }
        return valueSum/sum;
    }

    private double getMaximum(int[] count)
    {
        double result=0;
        for(int i=count.length-1;i>0;i--)
        {
            if(count[i]>0)
            {
                result=i;
                break;
            }
        }
        return result;
    }

    private double getMinimum(int[] count)
    {
        double result=0;
        for(int i=0;i<count.length;i++)
        {
            if(count[i]>0)
            {
                result=i;
                break;
            }
        }
        return result;
    }

    private double getMedian(int[] count, int sum) {
        double median=0;
        int left=0;
        int right=count.length-1;
        double countSumLeft=0;
        double countSumRight=0;
        int countTemp=0;
        while(left < right&&countTemp<count.length)
        {
            countTemp++;
            countSumLeft = countSumLeft + count[left];
            if(countSumLeft < sum /2.0)
            {
                left++;
            }
            countSumRight = countSumRight + count[right];
            if(countSumRight < sum /2.0)
            {
                right--;
            }
        }
       if(median==0&&left>0&&right>0)
       {
           median=(left+right)/2.0;
       }
        return median;
    }


    public static void main(String[] args)
    {
        TowPointSolution solution=new TowPointSolution();
        int[] count1 = {0,1,3,4,0};
        double[] result1=solution.sampleStats(count1);
        for(int i=0;i< result1.length;i++)
        {
            System.out.println(result1[i]);
        }


        System.out.println("****************************");

        int[] count2 = {0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        double[] result2 = solution.sampleStats(count2);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }
    }
}
