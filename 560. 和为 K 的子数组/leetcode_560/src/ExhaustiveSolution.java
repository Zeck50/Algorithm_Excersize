public class ExhaustiveSolution {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        int tempSum=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                tempSum=tempSum+nums[j];
                if(tempSum==k)
                {
                    result++;
                }
            }
            tempSum=0;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] test1={1,1,1};
        int k1=2;
        int result1=(new ExhaustiveSolution()).subarraySum(test1,k1);
        System.out.println(result1);

        int[] test2={1,2,3};
        int k2=3;
        int result2=(new ExhaustiveSolution()).subarraySum(test2,k2);
        System.out.println(result2);

        int[] test3={1,-1,0};
        int k3=0;
        int result3=(new ExhaustiveSolution()).subarraySum(test3,k3);
        System.out.println(result3);
    }
}
