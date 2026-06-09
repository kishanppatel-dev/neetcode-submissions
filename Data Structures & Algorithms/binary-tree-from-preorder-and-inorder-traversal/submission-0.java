/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return rec(map, preorder, inorder, 0, n-1);
    }

    TreeNode rec(HashMap<Integer, Integer> map, int[] preorder, int[] inorder, int left, int right) {
        if (left > right || index == preorder.length) return null;
        TreeNode root = new TreeNode(preorder[index]);
        int mid = map.get(preorder[index++]);

        root.left = rec(map, preorder, inorder, left, mid-1);
        root.right = rec(map, preorder, inorder, mid+1, right);
        return root;
    }
}
