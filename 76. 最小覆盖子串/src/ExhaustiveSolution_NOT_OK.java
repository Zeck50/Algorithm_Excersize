import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSolution_NOT_OK {
    public String minWindow(String s, String t) {
        String result="";
        String tempResultString=s;
        List<String> subStringList=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                String tempString=s.substring(i,j+1);
                if(isContainAllChar(tempString,t))
                {
                    subStringList.add(tempString);
                }
            }
        }
        int length=Integer.MAX_VALUE;
        for(String temp:subStringList)
        {
            if(temp.length()<length)
            {
                length=temp.length();
                result=temp;
            }
        }
        return result;
    }

    public boolean isContainAllChar(String s, String t)
    {
        boolean result=true;
        boolean[] resultArr=new boolean[t.length()];
        String temp=s;
        for(int i=0;i<t.length();i++)
        {
            for(int j=0;j<temp.length();j++)
            {
                if(temp.charAt(j)==t.charAt(i))
                {
                    resultArr[i]=true;
                    temp=temp.substring(0,j)+temp.substring(j+2,temp.length());
                }
            }
        }
        for(int i=0;i<resultArr.length;i++)
        {
            if(resultArr[i]==false)
            {
                result=false;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {

        /*
        String s1="ADOBECODEBANC";
        String t1="ABC";
        String result1=(new ExhaustiveSolution()).minWindow(s1,t1);
        System.out.println(result1);


        String s2="a";
        String t2="a";
        String result2=(new ExhaustiveSolution()).minWindow(s2,t2);
        System.out.println(result2);

         */

        String s3="a";
        String t3="aa";
        String result3=(new ExhaustiveSolution_NOT_OK()).minWindow(s3,t3);
        System.out.println(result3);
    }
}
