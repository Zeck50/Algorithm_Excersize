import java.util.HashMap;

public class PreSumHashMapSolution {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum0_i=0;
        int sum0_j=0;
        for(int i=0;i<nums.length;i++)
        {
            //1.前缀和数组思想的应用
            sum0_i=sum0_i+nums[i];
            sum0_j=sum0_i-k;
            //2.HashMap优化的应用
            if(map.containsKey(sum0_j))
            {
                result=result+map.get(sum0_j);
            }
            map.put(sum0_i,map.getOrDefault(sum0_i,0)+1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] test1={1,1,1};
        int k1=2;
        int result1=(new PreSumHashMapSolution()).subarraySum(test1,k1);
        System.out.println(result1);

        int[] test2={1,2,3};
        int k2=3;
        int result2=(new PreSumHashMapSolution()).subarraySum(test2,k2);
        System.out.println(result2);

        int[] test3={1,-1,0};
        int k3=0;
        int result3=(new PreSumHashMapSolution()).subarraySum(test3,k3);
        System.out.println(result3);
    }
}
