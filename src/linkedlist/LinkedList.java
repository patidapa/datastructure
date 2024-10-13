package linkedlist;

class SinglyLinkedList {
    ListNode head;

    static class ListNode {
        private int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertNode(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    public void insertAtLast(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(data);
    }

    public void insertAt(int position, int data) {
        if (position == 1) {
            ListNode node = new ListNode(data);
            node.next = head;
            head = node;
        } else {
            ListNode node = head;
            int n = 1;
            while (n < position - 1) {
                node = node.next;
                n++;
            }
            ListNode mid = node.next;
            ListNode newNode = new ListNode(data);
            node.next = newNode;
            newNode.next = mid;
        }
    }

    public void deleteAt(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            ListNode node = head;
            int n = 1;
            while (n < position - 1) {
                node = node.next;
                n++;
            }
            ListNode node1 = node.next;
            node.next = node1.next;

        }
    }

    public void delete(int data) {
        ListNode node = head;
        ListNode nodeD = null;
        while (node.data != data) {
            nodeD = node;
            node = node.next;
        }
        nodeD.next = node.next;
    }

    public void reversList() {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void findMiddleNode() {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Node: " + slow.data);
    }

    public void findNthNodeFromLast(int n) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (count < n) {
            fast = fast.next;
            count++;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("Nth node from llast : " + slow.data);
    }

    public void removeDuplicate() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void detectLoop() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                System.out.println("loop detected in list");
            }
        }
    }
    public void mergeList(ListNode a ,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                a=a.next;
            }else{
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
        if(a==null){
            tail.next=b;
        }else{
            tail.next=a;
        }
        head=dummy.next;
    }


    public void printList() {
    SinglyLinkedList.ListNode node = head;
    while (node != null) {
        System.out.print(node.data + "->");
        node = node.next;
    }
}
}

public class LinkedList {
    public static void main(String args[]) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertNode(20);
        list.insertNode(8);
        list.insertNode(8);
        list.insertAtLast(4);
        list.insertAt(2, 5);
        list.insertAt(1, 6);
        list.insertAt(2, 9);
        list.insertAt(2, 9);
        //list.delete(4);
        // list.reversList();
        list.printList();
        System.out.println();
//        list.removeDuplicate();
//        list.printList();
//        list.findMiddleNode();
//        list.findNthNodeFromLast(2);
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.insertNode(2);
        list1.insertNode(10);
        list1.insertNode(3);
        list1.insertAtLast(1);
        list1.printList();
        System.out.println();
        list1.mergeList(list.head,list1.head);
        list1.printList();

    }
}
