package me.vkku.linked_list;

import org.junit.jupiter.api.Test;

/*
    Easy
    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    Example 1:
    Input: head = [1,2,2,1]
    Output: true

    Example 2:
    Input: head = [1,2]
    Output: false
 */
public class PalindromeSinglyLL_234 {
    public boolean isPalindrome(ListNode head){
        //Journey to the centre of Earth
        ListNode slow = head;
        ListNode fast = head;
        while(null != fast && null != fast.next)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        //Reverse the links from middle till last
        ListNode previous = null;
        while(null != slow){
            ListNode temp = slow.next;
            slow.next = previous;
            previous = slow;
            slow = temp;
        }

        //Two pointer technique to find palindrome
        ListNode front = head;
        ListNode back = previous;
        while(null != back){
            if(front.val != back.val){
                return false;
            }
            else{
                front = front.next;
                back = back.next;
            }
        }
        return true;
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
        ListNode element3 = new ListNode(2);
        ListNode element4 = new ListNode(1);
        element.next = element2;
        element2.next = element3;
        element3.next = element4;
        System.out.println(isPalindrome(element)); //true
    }
}
