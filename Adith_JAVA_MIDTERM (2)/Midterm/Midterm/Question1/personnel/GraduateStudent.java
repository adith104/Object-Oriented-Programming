package personnel;

import java.util.Date;

public class GraduateStudent extends Student {
	
	private boolean phDStudent;
	
	public GraduateStudent(int Id,String name,Date birthdate,String department,boolean phDStudent)
	{
		super(Id,name,birthdate,department);
		this.phDStudent=phDStudent;
	}

	public boolean getphdstudent()
	{
		return this.phDStudent;
	}
	
	public void setphdstudent(boolean phdstudent)
	{
		this.phDStudent=phdstudent;
	}
	
	
	
	
	
	public String toString()
	{
		return super.toString()+"Class: GraduateStudent  "+" Is a phd student ?:"+this.phDStudent;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof GraduateStudent)
			{
				GraduateStudent gs=(GraduateStudent)o;
				
				if(this.phDStudent==gs.phDStudent)
					return true;
			}
		}
		
		return false;
		
	}
}
