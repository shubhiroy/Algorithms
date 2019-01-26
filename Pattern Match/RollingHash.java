import java.util.*;
import java.lang.*;
public class RollingHash{

    static int mult = 3;

    private static boolean checkMatch(String a, String b){
        for(int i = 0; i < a.length(); i++){
            if(b.charAt(i) != a.charAt((a.length()-i-1))){
                return false;
            }
        }
        return true;
    }

    private static int calcHash(String s,int j){
        int sum = 0;
        if(j==0){
            int k = 0;
            for(int i = s.length()-1; i >= 0; i--){
                sum = sum + (int)s.charAt(i) * (int)Math.pow(mult,k);
                k++;
            }
        }else{
            int k = 0;
            for(int i = 0; i < s.length(); i++){
                sum = sum + (int)s.charAt(i) * (int)Math.pow(mult,k);
                k++;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Start entering character. Enter 0 when want to exit !!!");
        String s = "";
        Character ch = sc.next().charAt(0);
        s = Character.toString(ch) + s; 
        int firstHash = 0;
        String first = "";
        while(ch!='0'){
            if(s.length()==1){
                System.out.println( s + " is a pallindrome.");
            }else{
                int len = s.length();
                int half = len/2;
                if(len%2==0){
                    first = s.substring(half,len);
                    firstHash = calcHash(first,1);
                    String second = s.substring(0,half);
                    int secondHash = calcHash(second,0);
                    if( firstHash == secondHash ){
                        if(checkMatch(first,second)){
                            System.out.println(s + " is a pallindrome.");
                        }else{
                            System.out.println(s + " is not a pallindrome.");
                        }
                    }else{
                        System.out.println(s + " is not a pallindrome.");
                    }
                }else{
                    String second = s.substring(0,half);
                    int secondHash = calcHash(second,0);
                    if( firstHash == secondHash ){
                        if(checkMatch(first,second)){
                            System.out.println(s + " is a pallindrome.");
                        }else{
                            System.out.println(s + " is not a pallindrome.");
                        }
                    }else{
                        System.out.println(s + " is not a pallindrome.");
                    }
                }
            }
            ch = sc.next().charAt(0);
            s = Character.toString(ch) + s;
        }
    }
}