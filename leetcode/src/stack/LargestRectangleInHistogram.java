package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	public int largestRectangleArea(int[] heights) {
		if(heights.length==0)
			return 0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int top=0,index=0,area=0,maxArea=-1;
        for(index=1;index<heights.length;index++) {
        	if(stack.isEmpty() || heights[index]>heights[stack.peek()]) {
        		stack.push(index);
        	}else {
        		while(!stack.isEmpty() && heights[index]<=heights[stack.peek()]) {
                	top=stack.pop();
            		if(stack.isEmpty())
            			area=heights[top]*index;
            		else
            			area=heights[top]*(index-stack.peek()-1);
            		maxArea=maxArea>=area?maxArea:area;
                }
        		stack.push(index);
        	}
        }
        while(!stack.isEmpty()) {
        	top=stack.pop();
    		if(stack.isEmpty())
    			area=heights[top]*index;
    		else
    			area=heights[top]*(index-stack.peek()-1);
    		maxArea=maxArea>=area?maxArea:area;
        }
        return maxArea;
    }
	public static void main(String[] args) {
		int[] heights=new int[] {2,1,5,6,2,3};
		LargestRectangleInHistogram obj=new LargestRectangleInHistogram();
		System.out.println(obj.largestRectangleArea(heights));
	}

}
