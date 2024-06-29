public class PreSumExhaustiveSolution {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        int[] preSum=new int[nums.length+1];
        for(int i=1;i<nums.length+1;i++)
        {
            preSum[i]=preSum[i-1]+nums[i-1];
        }
        for(int i=0;i<preSum.length;i++)
        {
            for(int j=i+1;j<preSum.length;j++)
            {
                if(preSum[j]-preSum[i]==k)
                {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] test1={1,1,1};
        int k1=2;
        int result1=(new PreSumExhaustiveSolution()).subarraySum(test1,k1);
        System.out.println(result1);

        int[] test2={1,2,3};
        int k2=3;
        int result2=(new PreSumExhaustiveSolution()).subarraySum(test2,k2);
        System.out.println(result2);

        int[] test3={1,-1,0};
        int k3=0;
        int result3=(new PreSumExhaustiveSolution()).subarraySum(test3,k3);
        System.out.println(result3);
    }
}
