package JLL;

public class QueueList<T> {
  
    JLinkedList<T> front,rear;
  
    public QueueList(){
        front = new JLinkedList<T>();
        rear = front;
    }
  
    public void enqueue(T x){
        rear.insertEnd(x);
    }
  
    public T dequeue(){
        return front.deleteFront();
    }
  
    public void printQueue(){
        front.display();
    }
  
    public boolean isEmpty(){
        if(front==null){
            return true;
        }
        else
            return false;
    }
}
