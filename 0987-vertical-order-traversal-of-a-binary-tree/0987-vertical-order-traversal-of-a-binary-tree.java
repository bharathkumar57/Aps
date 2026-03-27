import java.util.*;

class Solution {

    class Node {
        int col, row, val;

        Node(int c, int r, int v) {
            col = c;
            row = r;
            val = v;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> list = new ArrayList<>();
        
        // Step 1: DFS traversal
        dfs(root, 0, 0, list);

        // Step 2: Sort
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        // Step 3: Group by column
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (Node node : list) {
            if (node.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node.col;
            }
            result.get(result.size() - 1).add(node.val);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<Node> list) {
        if (node == null) return;

        list.add(new Node(col, row, node.val));

        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}