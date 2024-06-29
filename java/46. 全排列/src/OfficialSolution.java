import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OfficialSolution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        boolean used[]=new boolean[nums.length];
        backTrack(nums,track,used);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used)
    {
        //1.结束条件的选取
        if(track.size()== nums.length)
        {
            //注意要new一个linkedList，否则track会被当作Object而不是List
            res.add(new LinkedList<>(track));
            return;
        }
        //2.选择的遍历
        for(int i=0;i<nums.length;i++)
        {
            //3.判断选择范围
            if(used[i])
            {
                continue;
            }
            //4.做选择
            track.add(nums[i]);
            used[i]=true;
            backTrack(nums,track,used);
            //5.撤销选择
            track.removeLast();
            used[i]=false;
        }
    }

    public static void main(String[] args)
    {
        int[] test1={1,2,3};
        List<List<Integer>> result1=(new OfficialSolution()).permute(test1);
        System.out.println(result1);
        System.out.println();
    }
}
