package fruit;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
		Fruit f=new Fruit("Red",false);
		Fruit f1=new Fruit("Red",false);
		System.out.println(f);
        
		Citris c=new Citris("sour","yellow",false);
		 
		Citris c2=new Citris("sour","yellow",false);
		System.out.println(c);
		
		Orange oj=new Orange("Valencia","Sweet",false);
		Orange oj2=new Orange("Valencia","Sweet",false);
		System.out.println(oj);
		
		Apple aa=new Apple("Sweet","Smooth","Dark Red",false);
		System.out.println(aa);
		
		Lemon ll=new Lemon(10,"Very sour",false);
		Lemon ll2=new Lemon(10,"Very sour",false);
		System.out.println(ll);
		
		Apple aa1=new Apple("Tart","Soft","Green",true);
		Apple aa2=new Apple("Tart","Soft","Green",true);
		
		System.out.println(f.equals(f1));
		System.out.println(aa1.equals(aa2));
		System.out.println(c.equals(c2));
		System.out.println(ll.equals(ll2));
		System.out.println(oj.equals(oj2));
		
	}

}
