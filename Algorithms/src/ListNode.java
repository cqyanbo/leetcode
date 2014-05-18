
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static ListNode getListNode(int[] list){
		ListNode result = new ListNode(list[0]);
		ListNode old = result;
		for(int i = 1; i < list.length; i++){
			result.next = new ListNode(list[i]);
		}
		
		return old;
	}
}
