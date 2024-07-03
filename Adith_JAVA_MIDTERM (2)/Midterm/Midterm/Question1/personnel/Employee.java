package personnel;

import java.util.Date;

public abstract class Employee extends Person {
	
	private double salary;
	
	public Employee(int Id,String name,Date birthdate,double salary)
	{
		super(Id,name,birthdate);
		this.salary=salary;
	}
	
	public double getsalary()
	{
		return this.salary;
	}
	
	public void setsalary(double salary)
	{
		this.salary=salary;
	}
	
	public String toString()
	{
		return super.toString()+"Class: Employee  "+" Salary:"+this.salary;
		
	}
	
	public boolean equals(Object o)
	{
		
		if(super.equals(o))
		{
			if(o instanceof Employee)
			{
				Employee e=(Employee)o;
				
				if(this.salary==e.salary)
					return true;
			}
		}
		
		return false;
		
	}

}
