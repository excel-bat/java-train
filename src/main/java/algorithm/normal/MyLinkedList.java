package algorithm.normal;

/**
 * 链表
 * linkedlist 仿制链表 所以方法应该跟linkedlist 类似
 *
 * @author shanyb
 */
public class MyLinkedList {
    
    private Node head;
    
    private Node current;
    
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.init();
        myLinkedList.print(myLinkedList.head);
        
        Node temp = myLinkedList.reverse(3, 7, myLinkedList.head);
        myLinkedList.print(temp);
    }
    
    /**
     * 增加方法
     *
     * @return
     */
    private void add(int data) {
        //如果头节点为空
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }
    
    /**
     * 打印
     *
     * @param node
     */
    private void print(Node node) {
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
    
    /**
     * init
     *
     * @param
     */
    private Node init() {
        for (int i = 0; i < 10; i++) {
            this.add(i);
        }
        return head;
    }
    
    private int length() {
        if (head == null) {
            return -1;
        }
        
        int length = 0;
        current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    /**
     * 从m 到 n 进行链表反转
     *
     * @param m
     * @param n
     */
    private Node reverse(int m, int n, Node haad) {
        //虚拟头节点
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        
        Node p = dummyHead;
        Node q = dummyHead.next;
        
        //移动数据到指定m
        int step = 0;
        while (step < m - 1) {
            p = p.next;
            q = q.next;
            step++;
        }
        
        //头插法
        for (int i = 0; i < n - m; i++) {
            Node temp = q.next;
            q.next = q.next.next;
            
            temp.next = p.next;
            p.next = temp;
        }
        return dummyHead;
    }
    
    /**
     * 节点
     */
    class Node {
        int val;
        Node next;
        
        private Node(int val) {
            this.val = val;
        }
    }
}
