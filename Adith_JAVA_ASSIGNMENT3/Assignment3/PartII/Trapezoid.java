
public class Trapezoid {
	private static int nextId;
	private int id;
	private double base1;
	private double base2;
	private double height;
	
	public Trapezoid()
	{
		this.id=++nextId;
		this.base1=0;
		this.base2=0;
		this.height=0;
	}
	
	public Trapezoid(double base1,double base2,double height)
	{
		this.id=++nextId;
		this.base1=base1;
		this.base2=base2;
		this.height=height;
		
	}
	
	
	public double getBase1()
	{
		return this.base1;
	}
	
	
	
	public void setBase1(double base1)
	{
		this.base1=base1;
	}
	
	
	
	public double getBase2()
	{
		return this.base2;
		
	}
	
	
	
	public void setBase2(double base2)
	{
		this.base2=base2;
		
	}
	
	
	
	public double getHeight()
	{
		return this.height;
	}
	
	
	public void setHeight(double height)
	{
		this.height=height;
		
	}
	
	
	
	public double getArea()
	{
		double area=((this.base1+this.base2)/2)*this.height;
		
		return area;
		
		
	}
	
	
	
	public int getID()
	{
		return this.id;
	}
	
	
}
        
	

