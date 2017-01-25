/*
 * Given a sorted linked list, delete all duplicates
 * such that each element appear only once.
 * 
 * For example, 
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author Arpan Ghosh
 */
public class RemoveDuplicatesSortedList {
	

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
		public static class ListNode {
			int val;
			ListNode next;
			ListNode(int x) {
				val = x;
			}
		}
			
	
	    public static ListNode deleteDuplicates(ListNode head) {
	    	
	    	ListNode curr = head;

			StringBuilder s = new StringBuilder("");
		
			int x = 0;
			
			while (curr != null) {
				x = curr.val;
				s = s.append(x);
				System.out.println(x);
				while (x == curr.next.val ) {
					x = curr.val;
					curr = curr.next;
				}		
				System.out.print(s);
				curr = curr.next;
			}
	    	
	        return head;
	    }
	
	    public static void main (String[] args) {
	    	
	    	ListNode list = new ListNode(1);
	    	ListNode list2 = new ListNode(1);
	    	ListNode list3 = new ListNode(2);
	    	ListNode list4 = new ListNode(4);

	    	list.next = list2;
	    	list.next.next = list3;
	    	list.next.next.next = list4;
	    	list.next.next.next.next = null;

	    	
	    	deleteDuplicates(list);

	    }
	    
}
