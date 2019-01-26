//Time Complexity = O(n+m)
//Space Complexity = O(n+m+1) // 1 for the special character we inserted in the new string
// n - length of the test
//m - length of the pattern to be found in the text

import java.util.*;

public class Zalgo{
    private static int[] createZarr(String s){
        int l = 0, r = 0;
        int[] z = new int[s.length()];
        z[0] = 0;
        for(int k = 1; k < s.length(); k++){
            if(k > r){
                l = r = k;
                while(r<s.length() && s.charAt(r)==s.charAt((r-l))){
                    r++;
                }
                z[k] = r-l;
                r--;
            }else{
                int k1 = k - l;
                if(z[k1] < r - k + 1){
                    z[k] = z[k1];
                }else{
                    l = k;
                    while(r<s.length() && s.charAt(r)==s.charAt(r-l)){
                        r++;
                    }
                    z[k] = r - l;
                    r--;
                }
            }
        }
        return z;
    }
    private static String createNewString(String s, String pat){
        String newString = pat + "$" + s;
        return newString;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String pat = sc.nextLine();
        String newString = createNewString(s,pat);
        int[] zArr = createZarr(newString);
        int patLen = pat.length();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : zArr){
            if(i == patLen){
                arr.add((i));
            }
        }
        // for(int i : arr){
        //     System.out.println( "Found pattern at : " + i );
        // }
        System.out.println(arr);
    }
}