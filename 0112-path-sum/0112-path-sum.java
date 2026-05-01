class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if tree is empty
        if (root == null) {
            return false;
        }

        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check left and right subtree
        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum) || 
               hasPathSum(root.right, remainingSum);
    }
}