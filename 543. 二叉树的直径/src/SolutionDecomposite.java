public class SolutionDecomposite {
    public int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return diameter;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        int maxLeftDepth = getMaxDepth(node.left);
        int maxRightDepth = getMaxDepth(node.right);
        diameter = Math.max(maxLeftDepth + maxRightDepth, diameter);
        traverse(node.left);
        traverse(node.right);
    }

    public int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(node.left);
        int rightDepth = getMaxDepth(node.right);
        int result = Math.max(leftDepth, rightDepth) + 1;
        return result;
    }

    public static void main(String[] args) {
        TreeNode test1_node1 = new TreeNode(1);
        TreeNode test1_node2 = new TreeNode(2);
        TreeNode test1_node3 = new TreeNode(3);
        TreeNode test1_node4 = new TreeNode(4);
        TreeNode test1_node5 = new TreeNode(5);

        test1_node1.left = test1_node2;
        test1_node1.right = test1_node3;
        test1_node2.left = test1_node4;
        test1_node2.right = test1_node5;

        int result1 = (new SolutionDecomposite()).diameterOfBinaryTree(test1_node1);
        System.out.println(result1);

    }

}
