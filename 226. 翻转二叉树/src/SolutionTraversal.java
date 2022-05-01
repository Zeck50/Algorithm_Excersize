public class SolutionTraversal {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
    public static void traverse(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        TreeNode tempNode=node.left;
        node.left=node.right;
        node.right=tempNode;
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args)
    {
        TreeNode test1_node1=new TreeNode(1);
        TreeNode test1_node2=new TreeNode(2);
        TreeNode test1_node3=new TreeNode(3);
        TreeNode test1_node4=new TreeNode(4);
        TreeNode test1_node6=new TreeNode(6);
        TreeNode test1_node7=new TreeNode(7);
        TreeNode test1_node9=new TreeNode(9);

        test1_node4.left=test1_node2;
        test1_node4.right=test1_node7;
        test1_node2.left=test1_node1;
        test1_node2.right=test1_node3;
        test1_node7.left=test1_node6;
        test1_node7.right=test1_node9;
        (new SolutionTraversal()).printTree(test1_node4);
        TreeNode result1=(new SolutionTraversal()).invertTree(test1_node4);
        System.out.println();
        (new SolutionTraversal()).printTree(result1);
    }

    public void printTree(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        System.out.print(node.val);
        printTree(node.left);
        printTree(node.right);
    }


}
