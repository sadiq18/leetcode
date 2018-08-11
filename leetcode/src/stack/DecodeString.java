package stack;

import java.util.Stack;

public class DecodeString {
	
	public String decodeStringUsingStack(String s) {
		Stack<Character> stack=new Stack<>();
		Stack<StringBuilder> stack2=new Stack<>();
		char[] ch=s.toCharArray();
		char c='.';
		int num=0,times=1;
		StringBuilder str=new StringBuilder();
		for(int i=0;i<ch.length;i++) {
			c=ch[i];
			if(c!=']') {
				stack.push(c);
			}else {
				while(!stack.isEmpty() && stack.peek()!='[') {
					c=stack.pop();
					if(c=='$') {
						str.append(stack2.pop());
					}else {
						str.append(c);
					}
				}
				stack.pop();
				times=1;
				num=0;
				while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
					num+=(stack.pop()-'0')*times;
					times = times * 10;
				}
				String tmp=str.toString();
				for(int j=0;j<num-1;j++) {
					str.append(tmp);
				}
				stack2.push(str);
				stack.push('$');
				str=new StringBuilder();
			}
		}
		while(!stack.isEmpty()) {
			c=stack.pop();
			if(c=='$') {
				str.append(stack2.pop());
			}else {
				str.append(c);
			}
		}
		return str.reverse().toString();
    }
	
	public String decodeString(String s) {
        StringBuilder decodedString = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            decodedString.append(Character.toString(s.charAt(i)));
            if (s.charAt(i) == ']') {
                decodedString = partialDecode(decodedString, decodedString.lastIndexOf("["), decodedString.length()-1);
            }
        }
        return decodedString.toString();
        
    }
    
    private StringBuilder partialDecode(StringBuilder decodedString, int startPos, int endPos) {
        int numStart = startPos - 1;
        while(numStart >= 0 && isNum(decodedString.charAt(numStart))){
            numStart--;
        }
        numStart++;

        int count = (numStart==startPos-1) ? Character.getNumericValue(decodedString.charAt(numStart)) : Integer.parseInt(decodedString.substring(numStart, startPos));
        
        String repeat = decodedString.substring(startPos + 1, endPos);
        decodedString.delete(numStart, endPos + 1);
        for (int i = 0; i < count; i++) {
            decodedString.append(repeat);
        }
        return decodedString;
    }
    
    private boolean isNum(char c) {
        return Character.getNumericValue(c) != -1 && Character.getNumericValue(c) < 10;
    }
    
    public String decodeStringRecursive(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int times = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int count = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count = count * 10 + s.charAt(i) - '0';
                    i++;
                }
                times = count;
            } else if (c == '[') {
                int count = 1;
                int start = ++i;
                while (i < s.length() && count > 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                String str = decodeStringRecursive(s.substring(start, i - 1));
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		DecodeString obj=new DecodeString();
		System.out.println(obj.decodeString("3[a]2[bc]"));
		System.out.println(obj.decodeString("3[a2[c]]"));
		System.out.println(obj.decodeString("2[abc]3[cd]ef"));
	}

}
