/******************
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author Bo
 *
 */

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode l3 = new ListNode(0);
        ListNode old = l3;
        while(l1 != null && l2 != null){
        	l3.val = (l1.val + l2.val + c)%10;
        	c = (l1.val + l2.val + c) / 10;
        	l1 = l1.next;
        	l2 = l2.next;
        	if(l1!= null && l2 != null){
	        	l3.next = new ListNode(0);
	        	l3 = l3.next;
        	}
        }

        if(l1 != null){
			l3.next = new ListNode(0);
			l3 = l3.next;
        	while(l1 != null){
        		l3.val = (l1.val + c)%10;
        		c = (l1.val + c)/10;
        		l1 = l1.next;
        		if(l1 != null){
        			l3.next = new ListNode(0);
        			l3 = l3.next;
        		}
        	}
        }
        
        if(l2 != null){
			l3.next = new ListNode(0);
			l3 = l3.next;
        	while(l2 != null){
        		l3.val = (l2.val+ c)%10;
        		c = (l2.val + c)/10;;
        		l2 = l2.next;
        		if(l2 != null){
        			l3.next = new ListNode(0);
        			l3 = l3.next;
        		}
        	}
        }
        
        if(c > 0){
			l3.next = new ListNode(c);
        }
        
        return old;
    }
    
    public static void main(String[] args){
    	int[] A = {5};
    	int[] B = {5};
    	ListNode test1 = ListNode.getListNode(A);
    	ListNode test2 = ListNode.getListNode(B);
    	test1 = AddTwoNumbers.addTwoNumbers(test1, test2);
    }
}
