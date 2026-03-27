class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If tree is empty
        if (root == null) return false;

        // If leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Reduce targetSum
        int remaining = targetSum - root.val;

        // Check left or right
        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
    }
}