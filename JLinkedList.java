package JLL;

public class JLinkedList<T>{
    Node head;
  
    class Node{    
        T data;
        Node next;
      
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
  
    JLinkedList(){
        head = null;
    }
  
    public void insertFront(T ele){
        Node newNode = new Node(ele);
        newNode.next = head;
        head = newNode;
    }
  
    public void insertEnd(T ele){
        Node newNode = new Node(ele);
        if(head==null)
            head = newNode;
        else{
            Node temp =head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
  
    public void insertKey(T ele,T key){
        Node newNode = new Node(ele);
        Node temp = head;
        while(temp!=null){
            if(temp.data == key)
                break;
            temp = temp.next;
        }
        if(temp!= null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
  
    public void mergeList(JLinkedList<T> l2){
        if(head==null)
            head = l2.head;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = l2.head;
        }
    }
  
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
  
    public T deleteFront(){
        if(head!=null){
            Node temp = head;
            head = temp.next;
            return temp.data;
        }
        return null;
    }
  
    public T deleteEnd(){
        if(head!=null){
            Node temp =head,prev = null;
            while(temp.next!=null){
                prev=temp;
                temp = temp.next;
            }
            if(prev!=null){
                prev.next = null;
                return temp.data;
            }
            else{
                head = null;
                return temp.data;
            }
        }
        return null;
    }
  
    public T deleteKey(T key){
        if(head!=null){
            Node temp = head,prev=null;
            while(temp!=null){
                if(temp.data==key){
                    if(temp==head)
                        head = head.next;
                    else{
                        prev.next = temp.next;
                    }
                    break;
                }
                else{
                    prev = temp;
                    temp = temp.next;
                }
            }
            return temp.data;
        }
        return null;
    }
  
    public void reverseList(){
        if(head!=null){
            Node curr = head, next, prev =null;
            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
    }
}

