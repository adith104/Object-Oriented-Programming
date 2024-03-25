package fruit;

public class Fruit {
	private String color;
	private Boolean rotten;
	private static int next_id;
	private int id=++next_id;
	
	public Fruit()
	{
		this.color="default";
		this.rotten=true;
		
	}
	
	public Fruit(String color,Boolean rotten)
	{
		this.color=color;
		this.rotten=rotten;
		
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public void setColor(String color)
	{
		this.color=color;
	}
	
	public boolean isRotten()
	{
		return this.rotten;
		
	}
	public void setRotten(Boolean rotten)
	{
		
		this.rotten=rotten;
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public String toString()
	{
		String g="Class name:Fruit"+"  Color:"+color+"   Rotten status:"+rotten+"  Id:"+id;
		return g;
	}
	
	public boolean equals(Object o)
	{
		if(this==o)
			return true;
		
		if(o instanceof Fruit)
		{
			Fruit f=(Fruit)o;
			
			if(this.rotten==f.rotten&&this.color.equals(f.color))//id not compared in equals method
				return true;
			
		}
		
		return false;
	}

}
