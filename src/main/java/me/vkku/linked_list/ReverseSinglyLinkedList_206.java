package me.vkku.linked_list;

import org.junit.jupiter.api.Test;

/*
    Easy
    Given the head of a singly linked list, reverse the list, and return the reversed list.
    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Two pointer approach to reverse links
 */
public class ReverseSinglyLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode previous, current, next;
        previous = null;
        current = head;
        while(null != current){
            ListNode temp = new ListNode();
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

/*
         @Override
         public String toString() {
             return String.valueOf(val);
         }
*/
     }
    @Test
    public void driver(){
        ListNode element = new ListNode(1);
        ListNode element2 = new ListNode(2);
        ListNode element3 = new ListNode(3);
        ListNode element4 = new ListNode(4);
        ListNode element5 = new ListNode(5);
        element.next = element2;
        element2.next = element3;
        element3.next = element4;
        element4.next = element5;
        System.out.println(reverseList(element)); //5
    }
}