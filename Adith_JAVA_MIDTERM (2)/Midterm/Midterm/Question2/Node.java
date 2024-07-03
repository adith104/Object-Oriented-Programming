
public class Node<A> {
	
	A data;
	
	Node<A>lc;
	Node<A>rc;
	
	Node(A data)
	{
		this.data=data;
		this.lc=null;
		this.rc=null;
	}

}
