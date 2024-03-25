package PartI;
import java.util.ArrayList;


public class MyStack<E> {

	private ArrayList<E> ar;
	private int top;
	
	
	MyStack()
	{
		this.ar=new ArrayList<E>();
		this.top=-1;
	}
	
	
	public boolean empty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	
	
	public E peek()
	{
		
		if(top==-1)
		{
			System.out.println("Stack empty");
			return null;
		}
		else
			return ar.get(top);
			
	}
	
	public E pop()
	{
		if(top==-1)
		{
			System.out.println("Stack empty");
			return null;
		}
		else
		{
			E a=ar.get(top);
			top--;
			return a;
		}
	}
	
	public E push(E a)
	{
		top++;
		ar.add(a);
		
		return a;
	}
	public int search(Object o)
	{
		
		int t=top;
		int flag=0;
		while(t!=-1)
		{
			if(ar.get(t)==o)
			{
				flag=1;
				break;
			}
			
			t--;
		}
		
		if(flag==0)
			return -1;
		
		
		return t+1;
		
	}
	
	
	public static void main(String[] args)
	{
		MyStack<Integer> st=new MyStack<>();
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		
		System.out.println("The top of the stack is:"+st.peek());
		System.out.println("Is the stack empty ?"+st.empty());
		System.out.println("The popped element is:"+st.pop());
		System.out.println("The current top of the stack is:"+st.peek());
		System.out.println("The position of element 3 is:"+st.search(3));
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
