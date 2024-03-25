import java.io.*;
import java.util.ArrayList;

import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shape)throws ShapeException {
		
		/* if vehicleName is "Circle" return Circle();
		 * if vehicleName is "Rectangle" return Rectangle();
		 * if vehicleName is "Square" return Square();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
		
		if(shape.equals("Circle"))
		{
			Circle c=new Circle();
			return c;
		}
		else
			if(shape.equals("Rectangle"))
			{
				Rectangle r=new Rectangle();
				return r;
				
			}
		else
			if(shape.equals("Square"))
			{
				Square s=new Square();
				return s;
			}
		else
			{
			
				throw new ShapeException(shape);
			}	
				
			
				
		
	}
	
	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		
		
		
		
		
		FileReader ff=null;
		
try
{
		ff=new FileReader(f);
		BufferedReader i= new BufferedReader(ff);
		
		String inString = i.readLine();
		
		while(inString!=null)
		{
		
		/* create a loop to read the file line-by-line */
		
		try {
			
			GeometricObject shape = createShape(inString);
			shapeList.add(shape);
		} 
		catch (ShapeException e) {
			System.err.println("Cannot create Shape: " + inString);
		}
		
		inString=i.readLine();
		
		}
		
		
	i.close();	
}
catch(Exception e)
{
	System.err.println(e);
}
int i,c=0;

       for(i=0;i<shapeList.size();i++)
       {
		c++;
	   }
       
       System.out.println(c);
       System.out.println(shapeList);
	
	}

}
