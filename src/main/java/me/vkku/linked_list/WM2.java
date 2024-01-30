package me.vkku.linked_list;

import org.junit.jupiter.api.Test;

public class WM2 {


  class Node {
    Integer data;
    Node next;
    Node(Integer data){
      this.data = data;
      next = null;
    }
  }
  static Node head;
  public void push(int data){
    Node node = new Node(data);
    node.next = head;
    head = node;
  }

  public boolean findLoop(Node root){
    Node comparisonPointer = root;
    Node current;
    if(root == null){
      return false;
    }
    current = root.next;
    while(root.data != null){
      if(current.data == comparisonPointer.data){
        return true;
      }
      current = current.next;
      Node temp = comparisonPointer.next;
      comparisonPointer =  temp.next;
    }
    return false;
  }



  @Test
  public void driver(){
      WM2 node = new WM2();
    node.push(1);
    node.push(2);
    node.push(3);
    node.push(4);
    //node.head.next.next.next = node.head;
    boolean loop = findLoop(head);
    System.out.println(loop);
  }


  //1 -> 2 -> 3
}


