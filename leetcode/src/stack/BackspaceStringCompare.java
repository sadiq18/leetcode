package stack;

//import java.util.Stack;

public class BackspaceStringCompare {
	/*private String backspaceCompareUtil(String str){
		Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++) {
        	char ch=str.charAt(i);
        	if(ch=='#') {
        		if(stack.isEmpty())
        			continue;
        		stack.pop();
        	}else {
        		stack.push(ch);
        	}
        }
        return String.valueOf(stack);
	}*/
	private String backspaceCompareUtilWithoutStack(String s) {
		StringBuilder sb=new StringBuilder();
		int backCount=0;
		char str[]=s.toCharArray();
		for(int i=str.length-1;i>=0;i--) {
			if(str[i]=='#')
				backCount++;
			else {
				if (backCount>0)
					backCount--;
				else
					sb.append(str[i]);
			}
		}
		return sb.toString();
	}
	public boolean backspaceCompare(String S, String T) {
		return backspaceCompareUtilWithoutStack(S).equals(backspaceCompareUtilWithoutStack(T));
    }
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		BackspaceStringCompare obj=new BackspaceStringCompare();
		System.out.println(obj.backspaceCompare("ab#c", "ad#c"));
		System.out.println(obj.backspaceCompare("ab##", "c#d#"));
		System.out.println(obj.backspaceCompare("a##c", "#a#c"));
		System.out.println(obj.backspaceCompare("a#c", "b"));
		
		long endTime = System.currentTimeMillis();
		System.out.println();
		System.out.println("********************");
		System.out.println("Took "+(endTime - startTime) + " ms"); 
	}

}
