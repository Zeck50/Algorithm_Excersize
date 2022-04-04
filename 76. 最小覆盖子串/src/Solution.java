import java.util.HashMap;

public class Solution {

    public String minWindow(String s, String t) {
        String result="";
        int left=0;
        int right=0;
        int start=0;
        int length=Integer.MAX_VALUE;

        //1.滑窗内满足要求的字符数量
        int valid=0;
        //2.满足最小长度子串所需要的所有字符及其个数映射的hashmap
        HashMap<Character,Integer> need=new HashMap<>();
        //3.滑窗定义及构造，只记录有效字符及当前滑窗内有效字符的个数
        HashMap<Character,Integer> window=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }

        while(right<s.length())
        {
            right++;
            char c=s.charAt(right);
            if(need.containsKey(c))
            {
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c)))
                {
                    valid++;
                }
            }

            while(valid==need.size())
            {
                left++;
                char d=s.charAt(left);
                if(need.containsKey(d))
                {
                    //4.最小子串的记录
                    if(right-left<length)
                    {
                        start=left;
                        length=right-left+1;
                    }
                    if(need.get(d).equals(window.get(d)))
                    {
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        result=length==Integer.MAX_VALUE?"":s.substring(start-1,start+length-1);
        return result;
    }


    public static void main(String[] args)
    {


        String s1="ADOBECODEBANC";
        String t1="ABC";
        String result1=(new Solution()).minWindow(s1,t1);
        System.out.println(result1);

        System.out.println("*****************************");


        String s2="a";
        String t2="a";
        String result2=(new Solution()).minWindow(s2,t2);
        System.out.println(result2);

        System.out.println("*****************************");

        String s3="a";
        String t3="aa";
        String result3=(new Solution()).minWindow(s3,t3);
        System.out.println(result3);
    }
}
