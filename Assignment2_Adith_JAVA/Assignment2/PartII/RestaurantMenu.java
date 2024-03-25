import java.util.Scanner;

public class RestaurantMenu {

	public static double itemCost(char item) {
		if(item=='H')
			return 5.25;
		else
	    
		if(item=='F')
			return 2.50;
		else
		
		if(item=='C')
			return 7.00;
		else
		
		if(item=='M')
			return 3.75;
		else
		
		if(item=='B')
			return 6.25;
		else
		
		if(item=='S')
			return 1.25;
		else
			return 0;
		
		
		
	}
	
	public static void main(String[] args) {
		
		
		double cost=0.00,sum=0.00;
		
		
		while(true) {
			
			
			
	    System.out.println("Item              Cost");
	    System.out.println("Hamburger         $5.25");
	    System.out.println("French Fries      $2.50");
	    System.out.println("Cheeseburger      $7.00");
	    System.out.println("Milkshake         $3.75");
	    System.out.println("Buffalo Wings     $6.25");
	    System.out.println("Soda              $1.25");
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter menu item: ");
		char item = in.next().charAt(0);
		int i=100;
		
		if(item=='H')
			i=0;
		else
	    
		if(item=='F')
			i=1;
		else
		
		if(item=='C')
			i=2;
		else
		
		if(item=='M')
			i=3;
		else
		
		if(item=='B')
			i=4;
		else
		
		if(item=='S')
			i=5;
		else
			if(item=='X')
			break;
		
				
		
		
		
		switch(i)
		{
		
		case 0:cost=itemCost(item);
		       sum+=cost;
		       System.out.println("Total =$"+sum);
		       break;
		       
		case 1:cost=itemCost(item);
	       sum+=cost;
	       System.out.println("Total =$"+sum);
	       break;
	       
		case 2:cost=itemCost(item);
	       sum+=cost;
	       System.out.println("Total =$"+sum);
	       break;
	       
		case 3:cost=itemCost(item);
	       sum+=cost;
	       System.out.println("Total =$"+sum);
	       break;
	       
		case 4:cost=itemCost(item);
	       sum+=cost;
	       System.out.println("Total =$"+sum);
	       break;
	       
		case 5:cost=itemCost(item);
	       sum+=cost;
	       System.out.println("Total =$"+sum);
	       break; 
	       
	    default:System.out.println("Invalid menu item");
	            break;
		
		}
		
		
		
		
		
		
		
		}
		
		System.out.println("Order complete.Total is $"+sum);
		
		
	}
}
