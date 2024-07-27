package JLL;

public class StackList<T> {
  
    int len;
    JLinkedList<T> top;
  
    public StackList(){
        top = new JLinkedList<>();
        len = 0;
    }
  
    public void push(T x){
        len++;
        top.insertFront(x);
    }
  
    public T pop(){
        if(len>0){
            return top.deleteFront();
        }
        return null;
    }
  
    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            top.display();
        }
    }
  
    public boolean isEmpty(){
        if(top==null)
            return true;
        return false;
    }
  
    public T peek(){
        if(!isEmpty()){
            T temp = top.deleteFront();
            top.insertFront(temp);
            return temp;
        }
        return null;
    }
}
