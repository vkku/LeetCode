package me.vkku.queue.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryLOT_429 {
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
    static class Node {
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
    };
}
