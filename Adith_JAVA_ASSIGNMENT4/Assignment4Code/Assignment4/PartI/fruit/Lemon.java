package fruit;

public class Lemon extends Citris {
	
	private int sourness;
	
	public Lemon()
	{
		this.sourness=-1;
	}
	
	public Lemon(int sourness,String taste,Boolean rotten)
	{
		super(taste,"yellow",rotten);
		this.sourness=sourness;
		
	}
	public int getSourness()
	{
		return this.sourness;
	}
	
	public void setSourness(int sourness)
	{
		this.sourness=sourness;
	}
	
	public String toString()
	{
		String g=super.toString()+"   Class name:Lemon  "+"  Sourness:"+sourness;
		return g;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof Lemon)
			{
				Lemon ll=(Lemon)o;
				
				if(this.sourness==ll.sourness)
						return true;
			}
			
		}
		
		
		return false;
	}


}
