import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //1.路径的构造
        LinkedList<String> track=new LinkedList<>();
        backTrack(track,n);
        return result;
    }

    public void backTrack(LinkedList<String> track, int n)
    {
        //2.结束条件的选取
        if(track.size()==n)
        {
            result.add(new LinkedList<>(track));
            System.out.println(track);
            return;
        }
        //3.选择的遍历
        for(int i=0;i<n;i++)
        {
            //4.选择是否有效的判断
            if(!isValid(i,track,n))
            {
                continue;
            }
            String currentRow="";
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    currentRow=currentRow+'Q';
                }
                else
                {
                    currentRow=currentRow+'.';
                }
            }
            //5.进行选择
            track.add(currentRow);
            //6.回溯
            backTrack(track,n);
            //7.撤销选择
            track.removeLast();
        }
    }

    public boolean isValid(int i,LinkedList<String> track,int n)
    {
        if(!track.isEmpty())
        {
            for(int row=0;row<track.size();row++)
            {
                if(track.get(row).charAt(i)=='Q')
                {
                    return false;
                }
                for(int col=0;col<n;col++)
                {
                    //8.对角线是否有元素的判断
                    double colDistance=i-col;
                    double rowDistance=track.size()-row;
                    double rate=Math.abs(colDistance/rowDistance);
                    if((Math.abs(rate-1)<10e-5)&&track.get(row).charAt(col)=='Q')
                    {
                       // System.out.println(track);
                       // System.out.println(colDistance+" "+rowDistance+" "+rate);
                        //System.out.println(row+" "+col+" "+track.size()+" "+i);
                        return false;
                    }

                }

            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int test1=5;
        List<List<String>> result=(new Solution()).solveNQueens(test1);
        //System.out.println(result);
        System.out.println();
    }
}
