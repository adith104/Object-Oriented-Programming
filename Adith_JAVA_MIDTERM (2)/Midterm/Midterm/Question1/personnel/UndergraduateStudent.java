package personnel;

import java.util.Date;

public class UndergraduateStudent extends Student {
	
	private int year;
	
	public UndergraduateStudent(int Id,String name,Date birthdate,String department,int year)
	{
		super(Id,name,birthdate,department);
		this.year=year;
	}

	public int getyear()
	{
		return this.year;
	}
	
	public void setyear(int year)
	{
		this.year=year;
	}
	
	
	public String toString()
	{
		return super.toString()+"Class: UndergraduateStudent  "+" Year:"+this.year;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof UndergraduateStudent)
			{
				UndergraduateStudent u=(UndergraduateStudent)o;
				
				if(this.year==u.year)
					return true;
			}
		}
		
		return false;
		
	}
}
