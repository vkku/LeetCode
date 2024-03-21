package me.vkku.queue.bfs;

import org.junit.jupiter.api.Test;

import java.util.*;
/*
Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
 */

public class NAryLOT_429 {
/*
  public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> result = new ArrayList<>();
        if(null == root){
            return new ArrayList<>();
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Node current = queue.poll();
                if(null != current){
                    level.add(current.val);
                    queue.addAll(current.children);
                }
            }
            result.add(level);
        }
        return result;
    }
*/
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root){
        if(null != root)
            bfs(root, 0);
        return result;
    }

    private void bfs(Node root, int level) {
        if(result.size() <= level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for(Node child : root.children){
            bfs(child, level + 1);
        }
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    @Test
    public void driver(){
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());
        Node node3 = new Node(3, Arrays.asList(node5, node6));
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        Node node = new Node(1, Arrays.asList(node3, node2, node4));
        System.out.println(levelOrder(node)); //[[1], [3, 2, 4], [5, 6]]
    }
}
