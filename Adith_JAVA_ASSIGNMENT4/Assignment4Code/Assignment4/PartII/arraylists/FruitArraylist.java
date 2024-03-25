package arraylists;
import java.util.ArrayList;
import java.util.Random;

import fruit.*;

public class FruitArraylist {

	public static void main(String[] args) {
		
		Random r=new Random();
		// this ArrayList MUST be parameterized
		ArrayList<Fruit> fruitArrayList=new ArrayList<Fruit>();
		
		Fruit fr1=new Apple("Sweet","Crisp","Red",false);
		Fruit fr2=new Apple("Tart","Soft","Green",true);	
		Fruit fr3=new Apple("Tart","Soft","Green",true);	
		Fruit fr4=new Lemon(r.nextInt(101),"Sour",false);	
		Fruit fr5=new Lemon(r.nextInt(101),"Sour",false);	
		Fruit fr6=new Lemon(r.nextInt(101),"Sour",false);	
		Fruit fr7=new Orange("Mandarin","Sweet",true);	
		Fruit fr8=new Orange("Mandarin","Sweet",true);
		
		fruitArrayList.add(fr1);
		fruitArrayList.add(fr2);
		fruitArrayList.add(fr3);
		fruitArrayList.add(fr4);
		fruitArrayList.add(fr5);
		fruitArrayList.add(fr6);
		fruitArrayList.add(fr7);
		fruitArrayList.add(fr8);
		
		
		
		
	int i,c=0;
	double g=0.0;
	
	for(i=0;i<fruitArrayList.size();i++)
	{
		if(fruitArrayList.get(i) instanceof Lemon)
		{c++;
		
		Lemon ll=(Lemon)fruitArrayList.get(i);
		
		g+=ll.getSourness();
		
		
			
		}
	}
	
	System.out.println("The average sourness of all the lemon objects is: "+g/c);
		
		
		
	System.out.println("The original list is:");
	for(i=0;i<fruitArrayList.size();i++)
	{
		System.out.println(fruitArrayList.get(i));
	}
	
		
		
		
		
		
		
		
		
		
		
		//fruitArrayList.add(new Object());  gives compilation error
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
	System.out.println("   ");
	System.out.println("   ");
	System.out.println("   ");
		Apple rottenGreenApple1=(Apple)fr2;
		
		for(i=fruitArrayList.size()-1;i>=0;i--)//starting in reverse order so the first retained rotten apple is not deleted
		{
			if(fruitArrayList.get(i) instanceof Apple)
			{
				Apple a=(Apple)fruitArrayList.get(i);
				
				if(a.equals(rottenGreenApple1))
				{
					System.out.println("Equal in value apple");
					
					System.out.println(a.toString());
					
				}
				
				if(a==rottenGreenApple1)
				{
                   System.out.println("Same object apple");
					
					System.out.println(a.toString());
					
				}
				
				
				if(a.equals(rottenGreenApple1))
				{
					fruitArrayList.remove(i);
					
				}
			}
		}
		
		System.out.println("The edited list is:");
		
		for(i=0;i<fruitArrayList.size();i++)
		{
			 System.out.println(fruitArrayList.get(i).toString());
						
			
		}
		
		
		
		
		
		
		
		
		
	}
}
