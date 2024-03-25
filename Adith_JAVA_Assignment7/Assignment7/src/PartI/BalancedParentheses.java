package PartI;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		
		char ch;
		MyStack<Character> cst=new MyStack<>();
		
		int i;
		
		for(i=0;i<inString.length();i++)
		{
			ch=inString.charAt(i);
			
			if(ch=='(')
			{
				cst.push(ch);
				
			}
			
			if(ch==')')
			{
				cst.pop();
			}
			
		}
		
		
		
		boolean b=cst.empty();
		
		return b;
	}
	
	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())");
		
		
		System.out.println(result);
		
		
		result = isBalanced("(((())))");
		
		System.out.println(result);
		
		
		result = isBalanced("((((((())");
		
		System.out.println(result);
	}
}
