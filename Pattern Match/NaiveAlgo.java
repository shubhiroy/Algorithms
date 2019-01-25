// Time Complexity : O(n(n-m+1)) 
// n - length of text 
// m - length of pattern to find
import java.util.*;

public class NaiveAlgo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String pat = sc.nextLine();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int j=0,m=i;
            if(s.charAt(i)==pat.charAt(j)){
                while(j<pat.length() && m<s.length() && s.charAt(m)==pat.charAt(j)){
                    j++;
                    m++;
                }
                if(j==pat.length()){
                    arr.add(i);
                }
            }
        }
        for(int i : arr){
            System.out.println("Pattern found at index : "+i);
        }
    }
}