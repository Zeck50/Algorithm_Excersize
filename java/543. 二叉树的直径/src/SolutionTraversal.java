public class SolutionTraversal {
    public int diameter;
    public int currentDepth;
    public int maxDepth;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return diameter;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        int leftMaxDepth = getMaxDepth(node.left);
        maxDepth = 0;
        int rightMaxDepth = getMaxDepth(node.right);
        maxDepth = 0;
        diameter = Math.max(leftMaxDepth + rightMaxDepth, diameter);
        traverse(node.left);
        traverse(node.right);
    }

    public int getMaxDepth(TreeNode node) {
        traverseForNode(node);
        return maxDepth;
    }

    public void traverseForNode(TreeNode node) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, currentDepth);
            return;
        }
        currentDepth++;
        traverseForNode(node.left);
        traverseForNode(node.right);
        currentDepth--;
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

        int result1 = (new SolutionTraversal()).diameterOfBinaryTree(test1_node1);
        System.out.println(result1);
    }
}
