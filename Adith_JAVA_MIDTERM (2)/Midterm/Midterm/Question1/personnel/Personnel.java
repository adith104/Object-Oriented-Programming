package personnel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Personnel {

	// the ArrayList should be parameterized here. This warning
	// should go away
	public static ArrayList<Person> readPersonnel(String filename) {
		FileReader ff=null;
		
		ArrayList<Person> personlist=new ArrayList<Person>();
		try
    	{
    			ff=new FileReader(filename);
    			BufferedReader i= new BufferedReader(ff);
    			
    			String inString = i.readLine();
    			
    			while(inString!=null)
    			{
    				
    				String[] g = inString.split(",");
    			    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
    			    Date tt=formatter.parse(g[3]);
        			
    			    
    			    if(g[0].equals("Administrator"))
    			    {
    			    	Person p=new Administrator(Integer.parseInt(g[1]),g[2],tt,Double.parseDouble(g[4]),g[5],Double.parseDouble(g[6]));
    			    	personlist.add(p);
    			    }
    			    else
    			    if(g[0].equals("Faculty"))
    			    {
    			    	Person p=new Faculty(Integer.parseInt(g[1]),g[2],tt,Double.parseDouble(g[4]),g[5],g[6],Boolean.parseBoolean(g[7]));
    			    	personlist.add(p);
    			    	
    			    }
    			    else
        			if(g[0].equals("GraduateStudent"))
        			{
        				Person p=new GraduateStudent(Integer.parseInt(g[1]),g[2],tt,g[4],Boolean.parseBoolean(g[5]));	
        				personlist.add(p);
        			}
        			else
            		if(g[0].equals("SpecialStudent"))
            		{
            			Person p=new SpecialStudent(Integer.parseInt(g[1]),g[2],tt,g[4],Boolean.parseBoolean(g[5])); 
            			personlist.add(p);
            		}
            		else
            		if(g[0].equals("Staff"))
            		{
            			Person p=new Staff(Integer.parseInt(g[1]),g[2],tt,Double.parseDouble(g[4]),Boolean.parseBoolean(g[5]),Boolean.parseBoolean(g[6])); 
            			personlist.add(p);
            		}
            		else
            		if(g[0].equals("UndergraduateStudent"))
            		{
            			Person p=new UndergraduateStudent(Integer.parseInt(g[1]),g[2],tt,g[4],Integer.parseInt(g[5]));  
            			personlist.add(p);
            		}
    			    
    			    
    			
    			
    				inString=i.readLine();
    				
    			}
    			i.close();
    			
    	}
		catch(ParseException e)
		{
			System.out.println("Parse exception");
			System.out.println(e);
		}
    	 catch(FileNotFoundException f)
        {
        	
        	System.out.println("File not found");
        	System.out.println(f);
        	
        }
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array index out of bounds");
        	System.out.println(e);
		}
        catch(IOException e)
        {
        	System.out.println("IO Exception");
        	System.out.println(e);
        	
        }
		catch(NumberFormatException e)
		{
			System.out.println("Number Format Exception");
        	System.out.println(e);
		}
    	finally
    	{
    		try {
    		
    		ff.close();
    		}
    		catch(IOException e)
            {
            	System.out.println("IO Exception");
            	System.out.println(e);
            	
            }
    	}
		return personlist;
	}
	
	public static void main(String[] args){
		
		String f="C:\\Users\\santo\\OneDrive\\Desktop\\Midterm\\Midterm\\Question1\\personnel.csv";
		ArrayList<Person> p=readPersonnel(f);
		
		int i;
		
		for(i=0;i<p.size();i++)
		{
			System.out.println(p.get(i));
		}
		
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Sorted by Name:");
		p.sort(Comparator.comparing(Person::getname));
		for(i=0;i<p.size();i++)
		{
			System.out.println(p.get(i));
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Sorted by birthdate");
		
		p.sort(Comparator.comparing(Person::getdate));
		for(i=0;i<p.size();i++)
		{
			System.out.println(p.get(i));
		}
		
		ArrayList<Faculty> fac=new ArrayList<Faculty>();
		
		for(i=0;i<p.size();i++)
		{
			if(p.get(i) instanceof Faculty)
			{
				Faculty fa=(Faculty)p.get(i);
				
				fac.add(fa);
			}
		}
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Faculty Sorted by salary");
		
		fac.sort(Comparator.comparing(Faculty::getsalary));
		
		for(i=0;i<fac.size();i++)
		{
			System.out.println(fac.get(i));
		}
		
		
		
	}
}
