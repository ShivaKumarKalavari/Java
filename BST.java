// My implimentation of BST saying to make all methods to non static methods.
package JLL;

public class BST<T extends Comparable<T>>{
  
    T data;
    BST<T> left;
    BST<T> right;
  
    public BST(){
        data = null;
        left = null;
        right = null;
    }
  
    public BST(T x){
        data = x;
        left = null;
        right = null;
    }
  
    public void insert(T x) {
        if (data == null) {
            data = x;
        } else if (data.compareTo(x) > 0) {
            if (left == null) {
                left = new BST<T>(x);
            } else {
                left.insert(x);
            }
        } else if (data.compareTo(x) < 0) {
            if (right == null) {
                right = new BST<T>(x);
            } else {
                right.insert(x);
            }
        }
    }
  
    public static void preorder(BST root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
  
    public static void postorder(BST root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }
  
    public static void inorder(BST root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
  
    public BST<T> delete(BST<T> root, T key){
        if(root==null)
            return null;
        else if(root.data.compareTo(key)<0)
            root.right = delete(root.right,key);
        else if(root.data.compareTo(key)>0)
            root.left = delete(root.left,key);
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else{
                root.data = root.inSucc(root.right);
                root.right = delete(root.right,root.data);
            }
        }
        return root;
    }
  
    public T inSucc(BST<T> root){
        if(root.left!=null)
            root = root.left;
        return root.data;
    }
}
