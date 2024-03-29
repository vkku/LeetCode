//package me.vkku.queue;
//
//import java.util.Queue;
//
//public class BFS {
//
//    public static class Node{
//        int value;
//        Node next;
//    }
//
//    public Node findElementBFS(Node root, Node target)
//    Queue<Node> queue;  // store all nodes which are waiting to be processed
//    int step = 0;       // number of steps needed from root to current node
//    // initialize
//    add root to queue;
//    // BFS
//    while (queue is not empty) {
//        // iterate the nodes which are already in the queue
//        int size = queue.size();
//        for (int i = 0; i < size; ++i) {
//            Node cur = the first node in queue;
//            return step if cur is target;
//            for (Node next : the neighbors of cur) {
//                add next to queue;
//            }
//            remove the first node from queue;
//        }
//        step = step + 1;
//    }
//    return -1;          // there is no path from root to target
//
//}
