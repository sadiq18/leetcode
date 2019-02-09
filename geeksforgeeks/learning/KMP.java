package learning;

public class KMP {
	
	void createLSPArray(String pat,int lsp[]) {
		lsp[0]=0;
		int len=0;
		int i=1;
		while(i<pat.length()) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len++;
				lsp[i]=len;
				i++;
			}else {
				if(len!=0) {
					len=lsp[len-1];
				}else {
					lsp[i]=len;
					i++;
				}
			}
		}
	}
	
	void KMPSearch(String text,String pat) {
		int lsp[]=new int[pat.length()];
		createLSPArray(pat,lsp);
		//System.out.println(123);
		for(int i=0,j=0;i<text.length();) {
			if(text.charAt(i)==pat.charAt(j)) {
				i++;j++;
			}
			if(j==pat.length()) {
				System.out.println(i-j);
				j=lsp[j-1];
			}
			else if(i<text.length() && text.charAt(i)!=pat.charAt(j)) {
				if(j!=0) {
					j=lsp[j-1];
				}else {
					i=i+1;
				}
			}
		}
	}

	public static void main(String[] args) {
		KMP kmp=new KMP();
		System.out.println("Start");
		kmp.KMPSearch("ABABDABACDABABCABAB", "ABABCABAB");
		System.out.println("Done");
	}

}
