package code_practice;

import java.util.Arrays;

public class KMP {

	public void KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int[] lps = new int[M];
		computeLPSArray(pat, M, lps);
		int i = 0; //i is index of txt[]
		int j = 0; //j is index of pat[]
		while(i < N) {
			if(pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				System.out.println("found a match at index: " + (i-j));
				j = lps[j-1]; //reset pat index
			}
			else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				//do match lps[0...lps[j-1]] chars
				if(j !=0) {
					j = lps[j-1];
				}
				else {
					i = i+1;
				}
			}
		}
	}
	public void  computeLPSArray(String pattern, int M, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;
		while ( i < M) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len != 0) {
					len = lps[len -1];
				}
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "abababca";
		String pat = "abababca";
		int[] lps = new int[7];
		KMP kmp = new KMP();
		kmp.computeLPSArray(pat, 7, lps);
		System.out.println("lps: " + Arrays.toString(lps));
		
		kmp.KMPSearch(pat, test);
	}

}
