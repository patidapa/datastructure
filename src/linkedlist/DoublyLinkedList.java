package linkedlist;
class DoublyList {
    ListNode head;
    ListNode tail;

    static class ListNode {
        private int data;
        ListNode next;
        ListNode prev;

        ListNode(int data) {
            this.data = data;
        }
    }
    public void insertNode(int data) {
        ListNode newNode=new ListNode(data);
        if(head==null){
            tail=newNode;
        }else{
            head.prev=newNode;
        }
        newNode.next=head;
        head=newNode;
    }
    public void insertAtLast(int data) {
        ListNode newNode=new ListNode(data);
        if (head == null) {
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail=newNode;
    }
    public void insertAt(int position, int data) {
        if (position == 1) {
            ListNode newNode=new ListNode(data);
            if(head==null){
                tail=newNode;
            }else{
                head.prev=newNode;
            }
            newNode.next=head;
            head=newNode;
        } else {
            ListNode node = head;
            int n = 1;
            while (n < position - 1) {
                node = node.next;
                n++;
            }
            ListNode mid = node.next;
            ListNode newNode = new ListNode(data);
            if(mid.next!=null) {
                node.next = newNode;
                newNode.next=mid;
                mid.prev=newNode;
                newNode.prev=node;
            }else{
                mid.next=newNode;
                newNode.prev=mid;
                tail=newNode;
            }
        }
    }
    public void deleteAt(int position) {
        if (position == 1) {
            head = head.next;
            head.prev=null;
        } else {
            ListNode node = head;
            int n = 1;
            while (n < position - 1) {
                node = node.next;
                n++;
            }
            ListNode node1 = node.next;
            if(node1.next!=null){
                node.next = node1.next;
                node1.next.prev=node.next;
            }else{
               tail=tail.prev;
               tail.next=null;
            }
        }
    }
    public void printList() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }
    public void printReverse() {
        ListNode node = tail;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.prev;
        }
    }
}
public class DoublyLinkedList {
    public static void main(String args[]){
        DoublyList list=new DoublyList();
        list.insertNode(20);
        list.insertNode(8);
        list.insertNode(3);
        list.insertAtLast(5);
        list.insertAt(1,6);
      // list.insertAt(4,4);
        list.deleteAt(5);


        list.printList();
        System.out.println();
        list.printReverse();
    }
}