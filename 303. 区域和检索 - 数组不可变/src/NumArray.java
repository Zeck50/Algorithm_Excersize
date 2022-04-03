public class NumArray {
    private int[] temp;
    public NumArray(int[] nums) {
        temp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            temp[i]=nums[i];
        }

    }
    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left;i<right;i++)
        {
            sum=sum+temp[i];
        }
        return sum;

    }
}
