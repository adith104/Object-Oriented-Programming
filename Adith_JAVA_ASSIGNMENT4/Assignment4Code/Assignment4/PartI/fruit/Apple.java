package fruit;

public class Apple extends Fruit{
	private String taste;
	private String texture;
	
	public Apple()
	{
		
		this.taste="default";
		this.texture="default";
	}
	
	public Apple(String taste,String texture,String color,Boolean rotten)
	{
		super(color,rotten);
		
		this.taste=taste;
		this.texture=texture;
		
	}
	
	public String getTaste()
	{
		return this.taste;
	}
	
	public void setTaste(String taste)
	{
		this.taste=taste;
		
	}
	
	public String getTexture()
	{
		return this.texture;
	}
	
	
	public void setTexture(String texture)
	{
		this.texture=texture;
	}
	
	public String toString()
	{
		String g=super.toString()+"   Class name:Apple"+"   Taste:"+taste+"   Texture:"+texture;
		return g;
	}
	
	public boolean equals(Object o)
	{
		if(super.equals(o))
		{
			if(o instanceof Apple)
			{
				Apple a=(Apple)o;
				
				if(this.taste.equals(a.taste)&&this.texture.equals(a.texture))
						return true;
			}
			
		}
		
		
		return false;
		
	}


}
