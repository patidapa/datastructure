package linkedlist;
class CircularList{
    private ListNode last;

    static class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data=data;
        }
    }
    public void insertNode(int data){
        ListNode node=new ListNode(data);
       if(last==null){
           last=node;
       } else{
           node.next=last.next;
       }
       last.next=node;
    }
    public void insertAtLast(int data){
        ListNode newNode=new ListNode(data);
        if(last==null){
            last=newNode;
            last.next=last;
        }else{
            newNode.next=last.next;
            last.next=newNode;
            last=newNode;
        }
    }
    public void deleteFirst(){
        ListNode first=last.next;
        if(last.next==last){
            last=null;
        }else{
            last.next=first.next;
        }
    }
    public void insertAt(int position, int data){
        if(position==1){
            ListNode node=new ListNode(data);
            if(last==null){
                last=node;
            } else{
                node.next=last.next;
            }
            last.next=node;
        }else{
           ListNode temp=last.next;
           int n=1;
           while(n<position-1){
               temp=temp.next;
               n++;
           }
           ListNode node=temp.next;
           ListNode newNode=new ListNode(data);
           temp.next=newNode;
           newNode.next=node;
        }
    }
    public void deleteAt(int position){
        if(position==1){
            ListNode first=last.next;
            if(last.next==last){
                last=null;
            }else{
                last.next=first.next;
            }
        }else {
            ListNode temp = last.next;
            int n = 1;
            while (n < position - 1) {
                temp = temp.next;
                n++;
            }
            ListNode node = temp.next;
            temp.next = node.next;
        }
    }
    public void printList(){
        if(last==null){
            return;
        }
        ListNode first=last.next;
        while(first!=last){
            System.out.print(first.data+"->");
            first=first.next;
        }
        System.out.print(first.data);
    }
}

public class CircularLinkedList {
    public static void main(String args[]){
        CircularList list=new CircularList();
        list.insertNode(20);
       list.insertNode(10);
        list.insertNode(4);
        list.insertAtLast(5);
        list.insertAt(4 ,6);
        list.deleteAt(1);
       // list.deleteFirst();
        list.printList();
    }


}
