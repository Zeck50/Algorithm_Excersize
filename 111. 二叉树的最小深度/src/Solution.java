import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minDepth(TreeNode root) {
        //1.root非空时，root本身就是一层，因此初始化为1
        int result=1;
        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        //2.BFS框架，及二叉树的层序遍历框架
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode cur= queue.poll();
                if(cur.right==null&&cur.left==null)
                {
                    return result;
                }
                if(cur.right!=null)
                {
                    queue.offer(cur.right);
                }
                if(cur.left!=null)
                {
                    queue.offer(cur.left);
                }
            }
            //3.步长叠加
            result++;
        }
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode node_9=new TreeNode(9,null,null);
        TreeNode node_15=new TreeNode(15,null,null);
        TreeNode node_17=new TreeNode(17,null,null);
        TreeNode node_20=new TreeNode(20,node_15,node_17);
        TreeNode node_3=new TreeNode(3,node_9,node_20);

        int result1=(new Solution()).minDepth(node_3);
        System.out.println(result1);

    }
}
