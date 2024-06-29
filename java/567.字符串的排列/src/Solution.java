import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean result=false;

        int left=0;
        int right=left;
        int valid=0;
        HashMap<Character,Integer> window=new HashMap<>();
        HashMap<Character,Integer> need=new HashMap<>();

        for(int i=0;i<s1.length();i++)
        {
            need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);
        }

        while(right< s2.length())
        {
            char tempRchar=s2.charAt(right);
            right++;
            if(need.containsKey(tempRchar))
            {
                window.put(tempRchar,window.getOrDefault(tempRchar,0)+1);
                if(need.get(tempRchar).equals(window.get(tempRchar)))
                {
                    valid++;
                }
            }

            //System.out.println(window+" "+left+" "+right);
            while(right-left>=s1.length())
            {
                char tempLchar=s2.charAt(left);
                left++;
                if(valid==need.size())
                {
                    System.out.println(window+" "+left+" "+right+" "+valid);
                    result=true;
                }
                if(need.containsKey(tempLchar))
                {
                    if(need.get(tempLchar).equals(window.get(tempLchar)))
                    {
                        valid--;
                    }
                    window.put(tempLchar,window.getOrDefault(tempLchar,0)-1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        String test1_s1="ab";
        String test1_s2="eidbaooo";
        boolean result1=(new Solution()).checkInclusion(test1_s1,test1_s2);
        System.out.println(result1);


        String test2_s1="ab";
        String test2_s2="eidboaoo";
        boolean result2=(new Solution()).checkInclusion(test2_s1,test2_s2);
        System.out.println(result2);


    }
}
