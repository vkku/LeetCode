package me.vkku.linked_list;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class LinkedList_707 {
  Node node, current, head, tail;
  int size;
  @Getter
  @Setter
  public class Node{
    int val;
    Node next;
  }

  public LinkedList_707(){
    node = new Node();
  }

  void addAtHead(int val){
    if(head.getVal() != 0){
      node.setVal(val);
      node.setNext(null);
    }else{
      Node headNode = new Node();
      headNode.setNext(head);
      headNode.setVal(val);
      head = headNode;
    }
  }


}
