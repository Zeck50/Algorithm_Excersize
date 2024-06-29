public class Solution {

    /*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]
 

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109
     */
    public int[] searchRange(int[] nums, int target) {
        int leftbound=getLeftBound(nums,target);
        int rightbound= getRightBound(nums,target);
        if (leftbound <= rightbound && rightbound < nums.length && nums[leftbound] == target && nums[rightbound] == target) {
            return new int[]{leftbound, rightbound};
        }
        return new int[]{-1, -1};
    }

    public int getLeftBound(int[] nums, int target)
    {
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                right=mid-1;
            }
            else if(nums[mid]<target)
            {
                left=mid+1;
            }
            else if(nums[mid]>target)
            {
                right=mid-1;
            }
        }
       return left;

    }

    public int getRightBound(int[] nums,int target)
    {
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                left=mid+1;
            }
            else if(nums[mid]<target)
            {
                left=mid+1;
            }
            else if(nums[mid]>target)
            {
                right=mid-1;
            }
        }
       return right;
    }

    public static void main(String[] args)
    {
        Solution solution=new Solution();
        int i=1+3/2;
        //System.out.println(i);
        int [] test1={5,7,7,8,8,10};
        int target1=8;
        int[] result1=solution.searchRange(test1,target1);
        System.out.println(result1[0]+" "+result1[1]);

        int [] test2={5,7,7,8,8,10};
        int target2=6;
        int[] result2=solution.searchRange(test2,target2);
        System.out.println(result2[0]+" "+result2[1]);

        int [] test3={};
        int target3=0;
        int[] result3=solution.searchRange(test3,target3);
        System.out.println(result3[0]+" "+result3[1]);
    }
}
