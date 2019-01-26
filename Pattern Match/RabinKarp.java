// TIme Complexity = O(n*m)
// n - length of the string
//m-length of the pattern to be matched
//Used to detect plagarism in multiple documents

import java.util.*;
import java.lang.*;

public class RabinKarp{
	
	static int mult = 3;
	
	private static int calcHash(String s, int i,int len){
		int sum = 0,k=0;
		for(int j = i; j<i+len;j++){
			sum = sum + (int)s.charAt(j) *(int) Math.pow(mult,k);
			k++;
		}
		return sum;
	}
	
	private static boolean checkMatch(String s, String pat, int i){
		for(int j = 0; j<pat.length();j++){
			if(s.charAt((i+j))!=pat.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
	private static int traverseHashList(String s, int i, int len, int lastHash){
		lastHash = lastHash - (int)s.charAt(i-1);
		lastHash = lastHash/mult;
		lastHash = lastHash + (int)s.charAt((i+len-1))*(int)Math.pow(mult,(len-1));
		return lastHash;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String pat = sc.nextLine();
		int len = pat.length();
		int patHash = calcHash(pat,0,len);
		int[] sHash = new int[(s.length()-len+1)];
		ArrayList<Integer> arr = new ArrayList<>();
		sHash[0]=calcHash(s,0,len);
		for(int i = 1 ; i < sHash.length; i++){
			sHash[i] = traverseHashList(s,i,len,sHash[i-1]);
		}
		for(int i = 0; i < sHash.length; i++){
			if(sHash[i]==patHash){
				if(checkMatch(s,pat,i)){
					arr.add(i);
				}
			}
		}
		for(int i : arr){
			System.out.println( "Found pattern at : " + i );
		}
	}
}