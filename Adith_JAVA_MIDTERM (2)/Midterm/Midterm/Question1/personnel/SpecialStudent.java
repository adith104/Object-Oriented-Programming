package personnel;

import java.util.Date;

public class SpecialStudent extends Student {
	
	private boolean enrolled;
	
	public SpecialStudent(int Id,String name,Date birthdate,String department,boolean enrolled)
	{
		super(Id,name,birthdate,department);
		this.enrolled=enrolled;
	}


	public boolean getenrolled()
	{
		return this.enrolled;
	}
	
	public void setenrolled(boolean b)
	{
		this.enrolled=b;
	}
	
	
	public String toString()
	{
		return super.toString()+"Class: SpecialStudent  "+" Is enrolled ?"+this.enrolled;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof SpecialStudent)
			{
				SpecialStudent s=(SpecialStudent)o;
				
				if(this.enrolled=s.enrolled)
					return true;
			}
		}
		
		return false;
		
	}
}
