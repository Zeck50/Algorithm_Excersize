import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        boolean[] used=new boolean[nums.length];
        backTrack(nums,track,used);
        return res;
    }
    public void backTrack(int[] nums,LinkedList<Integer> track,boolean[] used)
    {
        if(track.size()== nums.length)
        {
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i])
            {
                continue;
            }
            used[i]=true;
            track.add(nums[i]);
            backTrack(nums,track,used);
            used[i]=false;
            track.removeLast();
        }
    }
    public static void main(String[] args)
    {
        int[] test1={1,3,2};
        List<List<Integer>> result1=(new Solution()).permute(test1);
        System.out.print(result1);
        System.out.println();
    }

}
