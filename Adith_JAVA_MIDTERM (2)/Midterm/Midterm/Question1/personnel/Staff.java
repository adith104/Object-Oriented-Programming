package personnel;

import java.util.Date;

public class Staff extends Employee {
	
	private boolean contractor;
	private boolean fulltime;
	
	public Staff(int Id,String name,Date birthdate,double salary,boolean contractor,boolean fulltime)
	{
		super(Id,name,birthdate,salary);
		this.contractor=contractor;
		this.fulltime=fulltime;
	}


	public boolean getcontractor()
	{
		return this.contractor;
	}
	
	public void setcontractor(boolean b)
	{
		this.contractor=b;
	}

	public boolean getfulltime()
	{
		return this.fulltime;
	}
	
	public void setfulltime(boolean b)
	{
		this.fulltime=b;
	}
	
	
	
	
	
	
	public String toString()
	{
		return super.toString()+"Class: Staff  "+" Is contractor ?"+this.contractor+"Is fulltime?"+this.fulltime;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof Staff)
			{
				Staff s=(Staff)o;
				
				if(this.contractor==s.contractor&&this.fulltime==s.fulltime)
					return true;
			}
		}
		
		return false;
		
	}
}
