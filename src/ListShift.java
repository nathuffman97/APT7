
public class ListShift {
	public ListNode shift(ListNode start, int key) {
        ListNode junkFirst = new ListNode(0);
        ListNode shifted = junkFirst;
        ListNode list = start;
        
        while (list.next != null) {
        	if (list.next.info > key) {
        		ListNode toMove = list.next;
        		list.next = list.next.next;
        		shifted.next = toMove;
        		shifted = toMove;
        	}
        	else {
        		list = list.next;
        	}
        }
        
        if (start.info > key) {
        	shifted.next = start.next;
        	start.next = junkFirst.next;
        	return start;
        }
        else {
        	shifted.next = start;
            return junkFirst.next;
        }
    }
}
