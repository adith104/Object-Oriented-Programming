package PartI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyQueue<E> implements Queue<E> {
	
	private ArrayList<E> ar;
	private int n;
	
	
	MyQueue()
	{  
		this.ar=new ArrayList<E>();
		this.n=0;
	}

	@Override
	public int size() {
		
	   return this.n;
	}

	@Override
	public boolean isEmpty() {
		
	
		if(this.n==0)
			return true;
		else
			return false;
		
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e) {
		
		ar.add(e);
		this.n++;
		
		return true;
	}

	@Override
	public E remove() {
		
		boolean t=isEmpty();
		
		if(!t)
		{
			this.n--;
			E a=ar.remove(0);
			
			return a;
		}
		else
		{
			try
			{
				throw new NoSuchElementException("Queue is empty");
			}
			catch(NoSuchElementException e)
			{
				System.out.println(e);
			}
		}
		
		return null;
	}

	@Override
	public E poll() {
		boolean t=isEmpty();
		
		if(!t)
		{
			this.n--;
			E a=ar.remove(0);
			
			return a;
		}
		
		return null;
	}

	@Override
	public E element() {
boolean t=isEmpty();
		
		if(!t)
		{
	
			E a=ar.get(0);
			
			return a;
		}
		else
		{
			try
			{
				throw new NoSuchElementException("Queue is empty");
			}
			catch(NoSuchElementException e)
			{
				System.out.println(e);
			}
		}
		return null;
	}

	@Override
	public E peek() {
      boolean t=isEmpty();
		
		if(!t)
		{
	
			E a=ar.get(0);
			
			return a;
		}
		
		return null;
	}
	
	
	public static void main(String[] args)
	{
		MyQueue <Integer> q=new MyQueue<>();
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		
		System.out.println("Size of the queue is: "+q.size());
		System.out.println("Is the queue empty ? "+q.isEmpty());
		System.out.println("Removed element is "+q.remove());
		System.out.println("Polling the queue head is "+q.poll());
		System.out.println("Head of the queue is "+q.element());
		System.out.println("Head of the queue by peeking is:"+q.peek());
		
		
	}
	

}
