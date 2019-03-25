import java.util.*;

class SelectionSort{
    public static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
   public static void selectionSort(int[] arr){
       int n = arr.length;
        for(int i=0;i<(n-1);i++){
            int min = i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(i,min,arr);
            }
        }
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the no. of values : ");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter all the values.");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        System.out.println("The sorted values are : ");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}