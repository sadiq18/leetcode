package stack;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] stack=new int[nums2.length];
        int top=0,next=0,curr=0;
        stack[top]=nums2[0];
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=1;i<nums2.length;i++) {
        	next=nums2[i];
        	if(top>=0)
        		curr=stack[top--];
        	while(curr<next) {
        		map.put(curr, next);
        		if(top<0)
        			break;
        		curr=stack[top--];
        	}
        	if(curr>=next)
        		stack[++top]=curr;
        	stack[++top]=next;
        }
        while(top>=0) {
        	map.put(stack[top--], -1);
        }
        int[] result=new int[nums1.length];
        for(int j=0;j<nums1.length;j++) {
        	result[j]=map.get(nums1[j]);
        }
        return result;
    }
	
	public static void main(String[] args) {
		NextGreaterElementI obj=new NextGreaterElementI();
		int[] nums1=new int[] {2,4};
		int[] nums2=new int[] {1,2,3,4};
		int[] result=obj.nextGreaterElement(nums1, nums2);
		for(int a:result) {
			System.out.print(a+" ");
		}
		System.out.println();
	}

}
