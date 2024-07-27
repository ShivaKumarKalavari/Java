package JLL;

public class Sorting {
  
    public static void insertionSort(int a[]){
        int n = a.length;
        int j,temp;
        for(int i=1;i<n;i++){
            j = i;
            temp = a[j];
            while(j>0 && temp<a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }
  
    public static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
  
    public static void selectionSort(int a[]){
        int pos,n=a.length;
        for(int i=0;i<n-1;i++){
            pos = i;
            for(int j=i+1;j<n;j++){
                if(a[pos]>a[j])
                    pos = j;
            }
            swap(a,i,pos);
        }
    }
  
    public static void maxHeapify(int a[],int x, int n){
        int left = (2*x)+1, right = (2*x)+2, Max = x;
        if(left<n && a[Max]<a[left])
            Max = left;
        if(right<n && a[Max]<a[right])
            Max = right;
        if(Max!=x){
            swap(a,Max,x);
            maxHeapify(a,Max,n);
        }
    }
  
    public static void maxHeapIt(int a[], int n){
        for(int i =(n/2 -1);i>-1;i--){
            maxHeapify(a,i,n);
        }
    }
  
    public static void maxHeapSort(int a[],int n){
        for(int i=n-1;i>0;i--){
            swap(a,0,i);
            maxHeapify(a,0,i);
        }
    }
  
    public static void minHeapify(int a[],int x, int n){
        int left = (2*x)+1, right = (2*x)+2, Min = x;
        if(left<n && a[Min]>a[left])
            Min = left;
        if(right<n && a[Min]>a[right])
            Min = right;
        if(Min!=x){
            swap(a,Min,x);
            minHeapify(a,Min,n);
        }
    }
  
    public static void minHeapIt(int a[], int n){
        for(int i =(n/2 -1);i>-1;i--){
            minHeapify(a,i,n);
        }
    }
  
    public static int[] minHeapSort(int a[],int n){
        int ans[] = new int[n];
        for(int i=n-1;i>-1;i--){
            swap(a,0,i);
            ans[(n-1)-i] = a[i];
            minHeapify(a,0,i);
        }
        return ans;
    }
  
    public static void quickSort(int a[], int lb, int ub){
        if(lb<ub){
            int i = lb, j = ub, pivot = i;
            while(i<j) {
                while (i < ub && a[pivot] >= a[i])
                    i++;
                while (a[pivot] < a[j])
                    j--;
                if(i<j)
                    swap(a,i,j);
            }
            swap(a,pivot,j);
            quickSort(a,lb,j-1);
            quickSort(a,j+1,ub);
        }
    }
  
    public static void mergeSort(int a[],int lb,int ub){
        if(lb<ub){
            int mid = (lb+ub)/2;
            mergeSort(a,lb,mid);
            mergeSort(a,mid+1,ub);
            merge(a,lb,mid,ub);
        }
    }
  
    public static void merge(int a[], int lb, int mid, int ub){
        int n1 = (mid - lb) + 1, n2 = ub - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i=0;i<n1;i++){
            left[i] = a[lb+i];
        }
        for(int i=0;i<n2;i++){
            right[i] = a[mid+1+i];
        }
        int i=0,j=0,k=lb;
        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                a[k] = left[i];
                i++;
            }
            else{
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            a[k] = right[j];
            j++;
            k++;
        }
    }
}
