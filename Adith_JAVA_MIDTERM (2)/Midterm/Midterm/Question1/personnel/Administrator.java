package personnel;

import java.util.Date;

public class Administrator extends Employee {
	
	private String title;
	private double budget;
	
	public Administrator(int Id,String name,Date birthdate,double salary,String title,double budget)
	{
		super(Id,name,birthdate,salary);
		this.title=title;
		this.budget=budget;
		
	}
	
	public String gettitle()
	{
		return this.title;
	}
	
	public double getbudget()
	{
		return this.budget;
		
	}
	
	public void settitle(String title)
	{
		this.title=title;
		
	}
	
	public void setbudget(double budget)
	{
		this.budget=budget;
	}
	
	public String toString()
	{
		return super.toString()+"Class: Administrator  "+" Title:"+this.title+" Budget:"+this.budget;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof Administrator)
			{
				Administrator a=(Administrator)o;
				
				if(this.title.equals(a.title)&&this.budget==a.budget)
					return true;
			}
		}
		
		return false;
		
	}

}
