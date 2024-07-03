package personnel;

import java.util.Date;

public abstract class Student extends Person {
	
	private String department;
	
	public Student(int Id,String name,Date birthdate,String department)
	{
		super(Id,name,birthdate);
		this.department=department;
	}

	
	
	public String getdepartment()
	{
		return this.department;
	}
	
	public void setdepartment(String d)
	{
		this.department=d;
	}
	
	
	
	public String toString()
	{
		return super.toString()+"Class: Student  "+" Department:"+this.department;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof Student)
			{
				Student s=(Student)o;
				
				if(this.department.equals(s.department))
					return true;
			}
		}
		
		return false;
		
	}
}
