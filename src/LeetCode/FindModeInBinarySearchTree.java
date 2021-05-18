package LeetCode;


import java.util.*;

public class FindModeInBinarySearchTree {
    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    } // end of TreeNode.

    private static TreeNode root; // Object of type TreeNode.

    public static void main (String[] args) {
        root = new TreeNode(1,null , new TreeNode(2,new TreeNode(2),null));
        int[] modes = findMode(root);
        for (var mode : modes){
            System.out.print(mode + " ");
        }
    }
    private static void solve(TreeNode root, Map<Integer,Integer> freq){
        if ( root == null)
            return;
        solve(root.left , freq);
        freq.put(root.val , freq.getOrDefault(root.val,0) + 1);
        solve(root.right , freq);
    }
    public static int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList();
        Map<Integer , Integer> freq = new HashMap<>();
        solve(root , freq);
        int max_freq = Collections.max(freq.values());
        if (max_freq <= 1)
            throw new NoSuchElementException("There's no mode.");
        for (int key : freq.keySet()){
            if (freq.get(key) == max_freq)
                result.add(key);
        }
        return result.stream().mapToInt(n -> n).toArray();
    }
}
