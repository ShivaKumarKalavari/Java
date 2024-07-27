package JLL;

public class StackArray<T>{
  
    int top;
    int MAX;
    T ar[];
  
    public StackArray(T a[]){
        top = -1;
        ar = a;
        MAX = a.length;
    }
  
    public void push(T x) {
        if (top < MAX - 1) {
            top++;
            ar[top] = x;
        } else {
            System.out.println("Stack is overflowing....");
        }
    }
  
    public T pop(){
        T ans = null;
        if(top==-1){
            System.out.println("Stack is underflowing....");
        }
        else{
            ans = ar[top];
            top--;
        }
        return ans;
    }
  
    public void printStack(){
        if(this.isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
            for(int i = top;i>=0;i--){
                System.out.print(ar[i]+" ");
            }
            System.out.println();
        }
    }
  
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else {
            return false;
        }
    }
  
    public T peek(){
        if(top!=-1){
            return ar[top];
        }
        return null;
    }
}
