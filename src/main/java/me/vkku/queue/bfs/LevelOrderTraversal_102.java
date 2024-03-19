package me.vkku.queue.bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size ; i++) {
                TreeNode current = queue.poll();
                if (null != current) {
                    level.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            if(!level.isEmpty())
                result.add(level);
        }
        return result;
    }

    public static class TreeNode {
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
    }

    @Test
    public void driver(){
        //[3,9,20,null,null,15,7]
        TreeNode tree = new TreeNode(3);
        TreeNode tree1 = new TreeNode(9) ;
        TreeNode tree2 = new TreeNode(20);
        TreeNode tree5 = new TreeNode(15);
        TreeNode tree6 = new TreeNode(7);
        tree.left = tree1;
        tree.right = tree2;
        tree1.left = null;
        tree1.right = null;
        tree2.left = tree5;
        tree2.right = tree6;
        LevelOrderTraversal_102 levelOrderTraversal = new LevelOrderTraversal_102();
        System.out.println(levelOrderTraversal.levelOrder(tree));
    }
}
