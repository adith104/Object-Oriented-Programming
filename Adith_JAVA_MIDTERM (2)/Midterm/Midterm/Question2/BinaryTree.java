import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import personnel.Person;
import personnel.Personnel;

public class BinaryTree<A>{
	private Node <A>root;
	private Comparator<A>cust;
	private String k;
	
	public BinaryTree() {
		this.root=null;
		this.cust=null;
	}
	
	public BinaryTree(Comparator<A>cust) {
		this.root=null;
		this.cust=cust;
	}
	
public void add(A value)
	{
		Node<A> g=find(value);
		if(g==null&&cust==null)
		{		
		root=cre(value,root);
		}
		else
		if(cust==null)	
		{
			System.out.println("Value already exists cannot add duplicate value");
		}
		else
		{
			root=cre(value,root);
		}
		
	
		
	}
	
	
	
	
public Node<A> find(A value)
{
		Node<A> g=root;
		g=findd(value,root);
		
		
		if(g==null)
		{
			
			return null;
		}
		else
		{
			
			return g;
			
			
		}
}
	
	
	
	
	
	
	
	
	
public Node<A> cre(A value,Node<A> root) 
{
		if(root==null)
		{
			root=new Node<A>(value);
			return root;
		}
		
		if(cust!=null)
		{
			if(cust.compare(value, root.data)<0)
			{
				root.lc=cre(value,root.lc);
				
			}
			else
			{
				root.rc=cre(value,root.rc);
			}
		}
		else
		if(value instanceof Comparable && cust==null)	
		{
			Comparable <A> compar=(Comparable<A>)value;
			if(compar.compareTo(root.data)<0)
			{
				root.lc=cre(value,root.lc);
				
			}
			else
			{
				root.rc=cre(value,root.rc);
			}
		}
		
		return root;
		
		
	}
	
public Node<A> findd(A value,Node<A>root) {
		
		if(root==null)
		{
			
			return null;
		}
		
		if(cust!=null)
		{
			if(cust.compare(value, root.data)==0)
			{
				return root;
			}
			else
			if(cust.compare(value, root.data)<0)
			{
				return findd(value,root.lc);
	
				
			}
			else
		    return findd(value,root.rc);
				
			
		}
		else
		{
			Comparable <A> compar=(Comparable<A>)value;
			if(compar.compareTo(root.data)==0)
			{
				return root;
				
			}
			else
			if(compar.compareTo(root.data)<0)
			{
				return findd(value,root.lc);
				
				
			}
			else
			return findd(value,root.rc);
				
			
		}
		
}

	
	
	
	
public void delete(A value) 
{
		Node<A> k=find(value);
		
		if(k!=null) {
		Node<A> g= del(value,root);
		root=g;}
		else
		{
			root=root;
			System.out.println("Such a value doesnt exist to be deleted");
		}
	
}







	
public Node<A> del(A value,Node<A> root)
{
		if(root==null)
			return root;
		
		
if(cust!=null)
{
	
	

	if(cust.compare(value,root.data)<0)
	{
	  root.lc=del(value,root.lc);
	  return root;
		
		
	}
	else
	if(cust.compare(value,root.data)>0)
	{
		 root.rc=del(value,root.rc);
		  return root;
			
		
	}
	
   if(root.rc==null)
	{
		Node<A> o=root.lc;
		return o;
	}
	else
	if(root.lc==null)
	{
		Node<A> o=root.rc;
		return o;
	}
	else
	{
		Node<A> a1=root;
		Node<A> a2=root.rc;
		
		while(a2.lc!=null)
		{
			a1=a2;
			a2=a2.lc;
		}
		
		
		if(a1!=root)
		{
			a1.lc=a2.rc;
			
		}
		else
		{
			a1.rc=a2.rc;
		}
		
		
		root.data=a2.data;
		
		return root;
		
	}
	
	
}
else
{	
		
		Comparable <A> compar=(Comparable<A>)value;

		if(compar.compareTo(root.data)<0)
		{
		  root.lc=del(value,root.lc);
		  return root;
			
			
		}
		else
		if(compar.compareTo(root.data)>0)
		{
			 root.rc=del(value,root.rc);
			  return root;
				
			
		}
		
	   if(root.rc==null)
		{
			Node<A> o=root.lc;
			return o;
		}
		else
		if(root.lc==null)
		{
			Node<A> o=root.rc;
			return o;
		}
		else
		{
			Node<A> a1=root;
			Node<A> a2=root.rc;
			
			while(a2.lc!=null)
			{
				a1=a2;
				a2=a2.lc;
			}
			
			
			if(a1!=root)
			{
				a1.lc=a2.rc;
				
			}
			else
			{
				a1.rc=a2.rc;
			}
			
			
			root.data=a2.data;
			
			return root;
			
		}
		
		
	
}	

	
	




}
	
public String toString(Node<A> root) 
{
		// toString should print out the contents of the 
		// binary tree in sorted order
	
	k="";
	
	
	
	inorder(root);
	System.out.println(k);
	return k;

	
}





public void inorder(Node<A> a)
{
		if(a==null)
			return;
					
	   inorder(a.lc);
	   
		
		
		k+=a.data+"\n";
		
		
		inorder(a.rc);
}
	
	
	
	
	
	public static void main(String[] args) {
		String f="C:\\Users\\santo\\OneDrive\\Desktop\\Midterm\\Midterm\\Question1\\personnel.csv";
		Personnel pp=new Personnel();
		ArrayList<Person> p=pp.readPersonnel(f);
		
		Comparator<Person> bday=new Comparator<Person>()
		{
			public int compare(Person a1,Person a2)
			{
				return a1.getdate().compareTo(a2.getdate());
				
			}
			
		};
		
		
		
		
		BinaryTree<Person> b = new BinaryTree<Person>(bday);
		
		int i;
		
		for(i=0;i<p.size();i++)
		{
			b.add(p.get(i));
		}
	
		b.toString(b.root);
		
		

	
		
		

	}
}
