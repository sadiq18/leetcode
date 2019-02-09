package learning;

public class ZAlgorithm {
	
	private void getZarr(String str, int[] z) {
		int left=0,right=0;
		for(int i=1;i<str.length();i++) {
			// for suffix having prefix not present
			if(i>right) {
				left=right=i;
				while(right<str.length() && str.charAt(right-left)==str.charAt(right)) {
					right++;
				}
				z[i]=right-left;
				right--;
			}else { // utilize suffix having prefix
				int k=i-left;
				if(z[k]<right-i+1) {
					z[i]=z[k];
				}else {
					left=i;
					while(right<str.length() && str.charAt(right-left)==str.charAt(right)) {
						right++;
					}
					z[i]=right-left;
					right--;
				}
			}
		}
	}
	
	public void search(String text, String pat) {
		String concat=pat+'$'+text;
		int[] zarr=new int[concat.length()];
		getZarr(concat,zarr);
		int m=pat.length();
		for(int i=m+1;i<zarr.length;i++) {
			if(zarr[i]==m) {
				System.out.println(i-m-1);
			}
		}
	}
	

	public static void main(String[] args) {
		new ZAlgorithm().search("GEEKS FOR GEEKS", "GEEK");
		System.out.println("done");
	}

}
