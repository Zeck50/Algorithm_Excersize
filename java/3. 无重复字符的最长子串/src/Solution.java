import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result=0;
        int left=0;
        int right=0;
        List<Character> window=new ArrayList<>();
        while(right<s.length())
        {
            char tempRChar=s.charAt(right);
            boolean isWindowContains=window.contains(tempRChar);
            if(!isWindowContains)
            {
                result=Math.max(result,right-left+1);
                window.add(tempRChar);
                right++;
            }
            while(isWindowContains)
            {
                window.remove(window.indexOf(s.charAt(left)));
                isWindowContains=window.contains(tempRChar);
                left++;

            }
        }
        return result;
    }

    public static void main(String[] args)
    {

        String s1="abcabcbb";
        int result1=(new Solution()).lengthOfLongestSubstring(s1);
        System.out.println(result1);

        String s2="bbbbb";
        int result2=(new Solution()).lengthOfLongestSubstring(s2);
        System.out.println(result2);

        String s3="pwwkew";
        int result3=(new Solution()).lengthOfLongestSubstring(s3);
        System.out.println(result3);

        String s4="aab";
        int result4=(new Solution()).lengthOfLongestSubstring(s4);
        System.out.println(result4);


        String s5="";
        int result5=(new Solution()).lengthOfLongestSubstring(s5);
        System.out.println(result5);
    }
}
