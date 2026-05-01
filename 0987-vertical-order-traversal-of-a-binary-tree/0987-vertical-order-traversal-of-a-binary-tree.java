import java.util.*;

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // column -> list of [row, value]
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        
        dfs(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            // sort by row, then value
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });

            List<Integer> colList = new ArrayList<>();
            for (int[] arr : list) {
                colList.add(arr[1]);
            }

            result.add(colList);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, 
                     TreeMap<Integer, List<int[]>> map) {
        if (node == null) return;

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, node.val});

        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}