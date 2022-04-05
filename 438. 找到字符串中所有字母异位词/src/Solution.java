import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList=new ArrayList<>();
        int left=0;
        int right=0;
        int valid=0;
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        for(int i=0;i<p.length();i++)
        {
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }

        while(right<s.length())
        {
            char tempRchar=s.charAt(right);
            right++;
            if(need.containsKey(tempRchar))
            {
                window.put(tempRchar,window.getOrDefault(tempRchar,0)+1);
                if(need.get(tempRchar).equals(window.get(tempRchar)))
                {
                    valid++;
                }
            }

            while(right-left>=p.length())
            {
                if(valid==need.size())
                {
                    resultList.add(left);
                }
                char tempLchar=s.charAt(left);
                left++;
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
        return resultList;
    }

    public static void main(String[] args)
    {
        String s1="cbaebabacd";
        String p1="abc";
        List<Integer> result1=(new Solution()).findAnagrams(s1,p1);
        System.out.print(result1.toString());
        System.out.println();

        String s2="abab";
        String p2="ab";
        List<Integer> result2=(new Solution()).findAnagrams(s2,p2);
        System.out.print(result2.toString());
        System.out.println();
    }
}
