package personnel;

import java.util.Date;

public class Faculty extends Employee {
	
	private String title;
	private String department;
	private boolean tenured;
	
	public Faculty(int Id,String name,Date birthdate,double salary,String title,String department,boolean tenured)
	{
		super(Id,name,birthdate,salary);
		this.title=title;
		this.department=department;
		this.tenured=tenured;
	}
	
	
	public String gettitle()
	{
		return this.title;
	}
	
	public void settitle(String title)
	{
		this.title=title;
	}
	
	public String getdepartment()
	{
		return this.department;
	}
	
	public void setdepartment(String department)
	{
		this.department=department;
	}
	
	public boolean gettenured()
	{
		return this.tenured;
	}
	
	public void settenured(boolean tenured)
	{
		this.tenured=tenured;
	}
	
	
	
	
	public String toString()
	{
		return super.toString()+"Class: Faculty  "+" Title:"+this.title+" Department:"+this.department+" Tenured:"+this.tenured;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof Faculty)
			{
				Faculty f=(Faculty)o;
				
				if(this.department.equals(f.department)&&this.title.equals(f.title)&&this.tenured==f.tenured)
					return true;
			}
		}
		
		return false;
		
	}

}
