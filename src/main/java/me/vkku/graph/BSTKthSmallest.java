package me.vkku.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BSTKthSmallest {

  class Node{
    int data;
    Node left;
    Node right;

    Node(int k){
      data = k;
      left = right = null;
    }
  }

  static int count = 0;
  Node insert(Node root, int value){
    if(root == null){
      return new Node(value);
    }
    if(value < root.data){
      root.left = insert(root.left, value);
    }
    else if(value > root.data){
      root.right = insert(root.right, value);
    }
    return root;
  }

  Node findKthSmallest(Node root, int k){
    if(root == null){
      return root;
    }

    Node kthSmallest = findKthSmallest(root.left, k);
    if(null != kthSmallest){
      return kthSmallest;
    }
    count++;
    if(count == k){
      return root;
    }

    return findKthSmallest(root.right, k);
  }

  static void preorder(Node root, List<Integer> v){
    if(null == root){
      return;
    }
    v.add(root.data);
    preorder(root.left, v);
    preorder(root.right, v);
  }

  @Test
  public void driver(){
    Node root = null;
    int[] keys = { 20, 8, 22, 4, 12, 10, 14 };
    for(int x: keys){
      root = insert(root, x);
    }
    int k = 3;
    Node kthSmallest = findKthSmallest(root, k);
    System.out.println("kth smallest element : " + kthSmallest.data);
  }

}
