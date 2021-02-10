package algorithm.normal;

/**
 * 归并链表
 *
 * @author shanyb
 */
public class MergeLinkedList {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //初始化
        //类似归并排序的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
    
    
    class ListNode {
        int val;
        ListNode next;
        
        private ListNode() {
        }
        
        public ListNode(int val) {
            this.val = val;
        }
        
        private ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
    }
}
