/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class SolutionTraversal {
    public static int maxdepth;
    public static int currentDepth = 1;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxdepth;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            maxdepth = Math.max(currentDepth, maxdepth);
            return;
        }
        currentDepth++;
        traverse(node.left);
        traverse(node.right);
        currentDepth--;
    }

    public static void main(String[] args) {
        TreeNode test1_node_3 = new TreeNode(3);
        TreeNode test1_node_9 = new TreeNode(9);
        TreeNode test1_node_20 = new TreeNode(20);
        TreeNode test1_node_15 = new TreeNode(15);
        TreeNode test1_node_7 = new TreeNode(7);

        test1_node_3.left = test1_node_9;
        test1_node_3.right = test1_node_20;
        test1_node_20.left = test1_node_15;
        test1_node_20.right = test1_node_7;

        int result1 = (new SolutionTraversal()).maxDepth(test1_node_3);
        System.out.println(result1);


    }

}
