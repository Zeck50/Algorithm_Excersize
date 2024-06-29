public class SolutionDecompose {
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int leftMaxDepth=maxDepth(root.left);
        int rightMaxDepth=maxDepth(root.right);
        int result=Math.max(leftMaxDepth,rightMaxDepth)+1;
        return result;
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

        int result1 = (new SolutionDecompose()).maxDepth(test1_node_3);
        System.out.println(result1);


    }

}
