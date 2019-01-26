//Time Complexity = O(n+m)
//Space Complexity = O(n+m)
// n - length of the test
//m - length of the pattern to be found in the text

import java.util.*;

public class KMP{
    private static int[] lpsCreate(String pat){
        int[] lps = new int[pat.length()];
        int len = 0;
        lps[len] = 0;
        for(int i = 1; i < pat.length(); i++){
            if(pat.charAt(len)==pat.charAt(i)){
                len++;
                lps[i]=len;
            }else{
                int j = i-1;
                while(pat.charAt(len)!=pat.charAt(i) && len > 0){
                    len = lps[j];
                    j = len - 1;
                }
                if(pat.charAt(len)==pat.charAt(i)){
                    len++;
                    lps[i]=len;
                }else{
                    lps[i]=len;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String pat = sc.nextLine();
        int[] lps = new int[pat.length()];
        lps = lpsCreate(pat);
        ArrayList<Integer> arr = new ArrayList<>();
        int N = s.length();
        int M = pat.length();
        int j = 0;

        int i = 0; 
        while (i < N) { 
            if (pat.charAt(j) == s.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == M) { 
                System.out.println("Found pattern "
                                   + "at index " + (i - j)); 
                j = lps[j - 1]; 
            } 
            else if (i < N && pat.charAt(j) != s.charAt(i)) { 
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i = i + 1; 
            }
            for(int l : arr){
                System.out.println("Pattern found at : "+l);
            }
        }
    }
}