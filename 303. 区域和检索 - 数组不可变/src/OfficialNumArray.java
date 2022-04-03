public class OfficialNumArray {
    private int[] preSum;
    public OfficialNumArray(int[] nums) {
        preSum=new int[nums.length+1];
        for(int i=1;i<nums.length+1;i++)
        {
            //1.考察前缀数组在求和中的应用
            preSum[i]=preSum[i-1]+nums[i-1];
        }

    }
    public int sumRange(int left, int right) {
         return preSum[right+1]-preSum[left];
    }

}
