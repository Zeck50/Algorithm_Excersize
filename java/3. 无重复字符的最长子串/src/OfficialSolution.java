import java.util.HashMap;

public class OfficialSolution {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        int left=0;
        int right=0;
        HashMap<Character,Integer> window=new HashMap<>();
        //1.滑动窗口思想的应用
        while(right<s.length())
        {
            char tempRchar=s.charAt(right);
            right++;
            //2.窗口更新的判断
            window.put(tempRchar,window.getOrDefault(tempRchar,0)+1);
            while(window.getOrDefault(tempRchar,0)>1)
            {
                char tempLchar=s.charAt(left);
                left++;
                window.put(tempLchar,window.getOrDefault(tempLchar,0)-1);
            }
            //3.求最大值函数的应用
            result=Math.max(result,right-left);
        }
        return result;
    }
    public static void main(String[] args)
    {
        String s1="abcabcbb";
        int result1=(new OfficialSolution()).lengthOfLongestSubstring(s1);
        System.out.println(result1);

        String s2="bbbbb";
        int result2=(new OfficialSolution()).lengthOfLongestSubstring(s2);
        System.out.println(result2);

        String s3="pwwkew";
        int result3=(new OfficialSolution()).lengthOfLongestSubstring(s3);
        System.out.println(result3);

        String s4="aab";
        int result4=(new OfficialSolution()).lengthOfLongestSubstring(s4);
        System.out.println(result4);

        String s5="";
        int result5=(new OfficialSolution()).lengthOfLongestSubstring(s5);
        System.out.println(result5);
    }
}
