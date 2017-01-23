/*
 * You are given two non-empty linked lists representing two
 * non-negative integers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two
 * numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, 
 * except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 807
 * 
 * Revised: returning as the integer itself, not as a linked list
 */
public class AddTwoNumbers {
	
	 //Definition for singly-linked list.
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { 
	    	  val = x; 
	    	  }
	  }
	 
	 public static int addTwoNumbers(ListNode l1, ListNode l2) {
		 
		 return decode(l1) + decode(l2);
		 				   
	 }
	 
	public static int decode(ListNode l1) {
		
		ListNode prev = null;
		ListNode curr = l1;

		StringBuilder s = new StringBuilder("");
	
		int x = 0;
		
		while (curr != null) {
			x = curr.val;
			s = s.append(x);
			prev = curr;
			curr = curr.next;
		}
		
		s = s.reverse();
		String num = s.toString();
		x = Integer.parseInt(num);
			
		return x;
	}
	
	
	public static void main (String[] args) {
		
		ListNode list = new ListNode(2);
		ListNode numSecond = new ListNode(4);
		ListNode numThird = new ListNode(3);
		list.next = numSecond;
		list.next.next = numThird;
		list.next.next.next = null;
		
		ListNode list2 = new ListNode(5);
		ListNode numSecond2 = new ListNode(6);
		ListNode numThird2 = new ListNode(4);
		list2.next = numSecond2;
		list2.next.next = numThird2;
		list2.next.next.next = null;
		
		System.out.print(addTwoNumbers(list,list2));
		
	}

}