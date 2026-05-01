import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, 
                     List<Integer> path, 
                     List<List<Integer>> result) {
        
        if (node == null) return;

        // Add current node to path
        path.add(node.val);

        // Check if it's a leaf node and sum matches
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(path)); // store copy
        } else {
            // Continue DFS
            dfs(node.left, targetSum - node.val, path, result);
            dfs(node.right, targetSum - node.val, path, result);
        }

        // Backtrack (remove last element)
        path.remove(path.size() - 1);
    }
}