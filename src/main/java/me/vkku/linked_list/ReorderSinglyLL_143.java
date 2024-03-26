package me.vkku.linked_list;

import org.junit.jupiter.api.Test;

public class ReorderSinglyLL_143 {
    public void reorderList(ListNode head) {
     ListNode fast = head;
     ListNode slow = head;
     //Journey to the centre of Earth
     while(null != fast && null != fast.next)
     {
         fast = fast.next.next;
         slow = slow.next;
     }
     //Reverse LL from middle
     ListNode previous = null;
     while(null != slow)
     {
         ListNode temp = slow.next;
         slow.next = previous;
         previous = slow;
         slow = temp;
     }
     ListNode front = head;
     ListNode back = previous;
     ListNode tempFront = new ListNode();
     ListNode tempBack = new ListNode();
     while(null != back){
         tempFront = front.next;
         tempBack = back.next;
         front.next = back;
         back.next = tempFront;
         front = tempFront;
         back = tempBack;
     }
     front.next = null;
     front = head;
     while(null != front){
         System.out.println(front.val);
         front = front.next;
     }

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    @Test
    public void driver(){
        ListNode element = new ListNode(1);
        ListNode element2 = new ListNode(2);
        ListNode element3 = new ListNode(3);
        ListNode element4 = new ListNode(4);
        element.next = element2;
        element2.next = element3;
        element3.next = element4;
        reorderList(element);
    }
}
