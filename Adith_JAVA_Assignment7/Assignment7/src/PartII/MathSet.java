package PartII;
import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {
		
		MathSet<E> in=new MathSet<E>();
		
		Object[] s2a=s2.toArray();
		
		int i;
		
		for(i=0;i<s2a.length;i++)
		{
			E a=(E)s2a[i];
			if(this.contains(a))
				in.add(a);
		}
		
		
		
		
      return in;
		
	}
	
	public Set<E> union(Set<E> s2) {
		
MathSet<E> un=new MathSet<E>();
		
		Object[] s2a=s2.toArray();
		
		Object[] ta=this.toArray();
		
		int i;
		
		for(i=0;i<ta.length;i++)
		{
			E a=(E)ta[i];
			un.add(a);
			
			
		}
		
		
		for(i=0;i<s2a.length;i++)
		{
			E a=(E)s2a[i];
			un.add(a);
		}
		
		
		return un;
		
		

	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		
		MathSet<Pair<E,T>> cp=new MathSet<Pair<E,T>>();
		
        Object[] s2a=s2.toArray();
		
		Object[] ta=this.toArray();
		
		int i;
		
		int j;
		
		for(i=0;i<ta.length;i++)
		{
			E a=(E)ta[i];
			for(j=0;j<s2a.length;j++)
			{
				T b=(T)s2a[j];
				
				cp.add(new Pair<E,T>(a,b));
			}
		}
		
		
		
		return cp;

	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		
		
		
		
		MathSet<Integer> s1=new MathSet<Integer>();
		MathSet<Integer> s2=new MathSet<Integer>();
		
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		
		s2.add(3);
		s2.add(4);
		s2.add(5);
		s2.add(6);
		s2.add(7);
		
		
		
		System.out.println("The Intersection is:"+s1.intersection(s2));
		System.out.println("The Union is:"+s1.union(s2));
		
		
		MathSet<String> s3=new MathSet<String>();
		
		s3.add("A");
		s3.add("D");
		s3.add("I");
		
		System.out.println("The Cartesian Product is:"+s1.cartesianProduct(s3));
		
		
		
		
		
	}
}
