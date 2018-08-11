package stack;

import java.util.Stack;

public class ScoreOfParentheses {
	public int scoreOfParentheses(String S) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        char str[]=S.toCharArray();
        char tmp;
        int a=0;
        for(int i=0;i<str.length;i++) {
        	switch(str[i]) {
        		case '(':
        			stack2.push(str[i]);
        			break;
        		case ')':
        			tmp=stack2.pop();
        			switch(tmp) {
        				case '(':
        					stack1.push(1);
        					stack2.push('x');
        					break;
        				case 'x':
        					a=stack1.pop();
        					while(!stack2.isEmpty() && stack2.peek()=='x') {
        						a+=stack1.pop();
        						stack2.pop();
        					}
        					if(!stack2.isEmpty()) {
        						stack1.push(2*a);
        						stack2.pop();
        						stack2.push('x');
        					}else {
        						stack1.push(a);
        					}
        			}
        	}
        }
        a=0;
        while(!stack1.empty()) {
        	a+=stack1.pop();
        }
        
        return a;
    }
	public static void main(String[] args) {
		ScoreOfParentheses obj=new ScoreOfParentheses();
		String S="(()()()())(()())";
		System.out.println(obj.scoreOfParentheses(S));

	}

}
