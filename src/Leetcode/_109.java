package Leetcode;

public class _109 {
    public TreeNode sortedListToBST(ListNode head) {
    		if(head == null)  return null;
    		ListNode pre = new ListNode(0);
    		pre.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
        		pre = pre.next;
        		slow = slow.next;
        		fast = fast.next.next;
        }
        
        ListNode leftN = pre;
        ListNode rightN = slow.next;
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(leftN);
        root.right = sortedListToBST(rightN);
        return root;
    }
    
}
