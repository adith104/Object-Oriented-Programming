import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private ArrayList<RDFTriple<Integer,Integer,Integer>> rdfTripleList;
    private String fileName;
 
    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
    	rdfTripleList=new ArrayList<RDFTriple<Integer,Integer,Integer>>();
    }
    
    public ArrayList<RDFTriple<Integer,Integer,Integer>> getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects
    		// of three numbers.
    		
    		RDFTriple<Integer,Integer,Integer> t=new RDFTriple<Integer,Integer,Integer>(number1,number2,number3);
    		rdfTripleList.add(t);
    	}
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;	
    }
    
    public void readList() {
    	rdfTripleList=new ArrayList<RDFTriple<Integer,Integer,Integer>>();
    	FileReader ff=null;
		
    	try
    	{
    			ff=new FileReader("numberfile.txt");
    			BufferedReader i= new BufferedReader(ff);
    			
    			String inString = i.readLine();
    			
    			while(inString!=null)
    			{
    				
    				String[] nums = inString.split(" ");
    				int a=Integer.parseInt(nums[0]),b=Integer.parseInt(nums[1]),c=Integer.parseInt(nums[2]);
    				
    				RDFTriple<Integer,Integer,Integer> t=new RDFTriple<Integer,Integer,Integer>(a,b,c);
    				rdfTripleList.add(t);
    				inString=i.readLine();
    				
    			}
    			i.close();
    			
    	}		
    	 catch(FileNotFoundException f)
        {
        	
        	System.out.println("File not found");
        	System.out.println(f);
        	
        }
        catch(IOException e)
        {
        	System.out.println("IO Exception");
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
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred()+ " " + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }
        catch(FileNotFoundException f)
        {
        	
        	System.out.println("File not found");
        	System.out.println(f);
        	
        }
        catch(IOException e)
        {
        	System.out.println("IO Exception");
        	System.out.println(e);
        	
        }
        catch(NullPointerException e)
        {
        	System.out.println("NULL Pointer Exception");
        	System.out.println(e);
        }
        finally {
        	
        	try {
            if (input != null) {
                input.close();
            }
            
        	}
        	  catch(IOException e)
            {
            	System.out.println("IO Exception");
            	System.out.println(e);
            	
            }
        }
      
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.createList();
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    	
    	
    }

}
