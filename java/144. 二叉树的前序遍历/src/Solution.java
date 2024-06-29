import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
    public void traverse(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        result.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args)
    {
        TreeNode test1_node1=new TreeNode(1);
        TreeNode test1_node2=new TreeNode(2);
        TreeNode test1_node3=new TreeNode(3);
        test1_node1.right=test1_node2;
        test1_node2.left=test1_node3;
        List<Integer> result1=(new Solution()).preorderTraversal(test1_node1);
        System.out.print(result1);
        System.out.println();

    }
}
