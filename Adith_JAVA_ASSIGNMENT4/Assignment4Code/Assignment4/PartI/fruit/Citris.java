package fruit;

public class Citris extends Fruit{
	private String taste;
	
	public Citris()
	{
		this.taste="default";
		
	}
	
	public Citris(String taste,String color,Boolean rotten)
	{
		super(color,rotten);
		this.taste=taste;
	}
	
	public String getTaste()
	{
		return this.taste;
	}
	
	public void setTaste(String taste)
	{
		this.taste=taste;
		
	}
	
	public String toString()
	{
		String g=super.toString()+"   Class name:Citris "+"  Taste:"+taste;
		return g;
	}
	
	public boolean equals(Object o)
	{
		if(super.equals(o))
		{
			if(o instanceof Citris)
			{
				Citris ct=(Citris)o;
				
				if(this.taste.equals(ct.taste))
						return true;
			}
			
		}
		
		
		return false;
		
	}


}
