package personnel;

import java.util.Date;

public abstract class Person {
	
	private int Id;
	private String name;
	private Date birthdate;
	
	public Person(int Id,String name,Date birthdate)
	{
		this.Id=Id;
		this.name=name;
		this.birthdate=birthdate;
	}
	
	
	public int getid()
	{
		return this.Id;
	}
	
	public String getname()
	{
		return this.name;
	}
	
	public Date getdate()
	{
		return this.birthdate;
	}
	
	public void setid(int id)
	{
		this.Id=id;
	}
	
	public void setname(String name)
	{
		this.name=name;
	}
	
	public void setdate(Date d)
	{
		this.birthdate=d;
	}
	
	
	
	public String toString()
	{
		return "Class: Person  "+" Id:"+this.Id+" Name:"+this.name+" Birthdate:"+this.birthdate;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(this==o)
			return true;
		
		
			if(o instanceof Person)
			{
				Person p=(Person)o;
				
				if(this.Id==p.Id&&this.name.equals(p.name)&&this.birthdate.equals(p.birthdate))
					return true;
			}
		
		
		return false;
		
	}

}
