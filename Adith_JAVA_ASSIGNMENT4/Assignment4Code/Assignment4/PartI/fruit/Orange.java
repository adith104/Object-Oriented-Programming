package fruit;

public class Orange extends Citris{
	
	private String type;
	
	public Orange()
	{
		this.type="default";
	}
	
	public Orange(String type,String taste,Boolean rotten)
	{
		super(taste,"orange",rotten);
		this.type=type;
		
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public String toString()
	{
		String g=super.toString()+"   Class name:Orange"+"  Type:"+type;
		return g;
		
	}
	
	public boolean equals(Object o)
	{
		if(super.equals(o))
		{
			if(o instanceof Orange)
			{
				Orange oj=(Orange)o;
				
				if(this.type.equals(oj.type))
						return true;
			}
			
		}
		
		
		return false;
	}


}
