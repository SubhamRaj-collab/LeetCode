public class 95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {

        return solve(1, n);

    }

    public List<TreeNode> solve(int start, int end)
    {
        if(start > end)
        {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }

        List<TreeNode> bag = new ArrayList<>();

        for(int i = start; i <= end; i++)
        {
            List<TreeNode> leftTree = solve(start, i-1);
            List<TreeNode> rightTree = solve(i+1, end);

            for(TreeNode a: leftTree)
            {
                for(TreeNode b: rightTree)
                {
                    TreeNode node = new TreeNode(i);
                    node.left = a;
                    node.right = b;
                    bag.add(node);
                }
            }
        }

        // Have recursive leap of faith.
        // Worst Case time Complexity: O(n^3)

        return bag;

    }
    
}
