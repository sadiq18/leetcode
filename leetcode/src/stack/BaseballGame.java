package stack;

import java.util.Stack;

public class BaseballGame {
	public int calPoints(String[] ops) {
        int sum=0,points=0,a=0,b=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<ops.length;i++) {
        	String option=ops[i];
        	switch(option) {
        		case "+":
        			a=stack.pop();
        			b=stack.peek();
        			points=a+b;
        			sum+=points;
        			stack.push(a);
        			stack.push(points);
        			break;
        		case "D":
        			points=stack.peek()*2;
        			sum+=points;
        			stack.push(points);
        			break;
        		case "C":
        			a=stack.pop();
        			sum-=a;
        			break;
        		default:
        			a=Integer.parseInt(option);
        			stack.push(a);
        			sum+=a;
        		
        	}	
        }
        return sum;
    }
	public static void main(String[] args) {
		BaseballGame obj=new BaseballGame();
		String[] input=new String[] {"5","-2","4","C","D","9","+","+"};
		System.out.println(obj.calPoints(input));
	}

}
