package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
        int output[]=new int[n];
        int prev=0;
        Stack<Integer> stack=new Stack<>();
        for(String log:logs) {
        	String str[]=log.split(":");
        	int index=Integer.parseInt(str[0]);
        	int time=Integer.parseInt(str[2]);
        	if(str[1].equals("start")) {
        		if(!stack.isEmpty()) {
        			output[stack.peek()]+=(time-prev);
        		}
        		stack.push(index);
        		prev=time;
        	}else {
        		stack.pop();
        		output[index]+=(time-prev+1);
        		prev=time+1;
        	}
        }
        
        return output;
    }
	
	public static void main(String[] args) {
		ExclusiveTimeOfFunctions obj=new ExclusiveTimeOfFunctions();
		String str[]=new String[]{
				"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"
			};
		List<String> logs=new ArrayList<>();
		for(String s:str)
			logs.add(s);
		int output[]=obj.exclusiveTime(2, logs);
		for(int i:output) {
			System.out.println(i);
		}
	}

}
