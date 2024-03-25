
public class MyInitials {

	public static void main(String[] args) {
		
		int i,j;
		
		
		for(i=1;i<=7;i++)
		{
			for(j=1;j<=5;j++)
			{
				if(i==1 && j==3)
					System.out.print('A');
				else
				if(i==2 && (j==2||j==4))
					System.out.print('A');
				else
				
				if(i==3 && (j==1||j==5))
					System.out.print('A');
				else
				if(i==4)
					System.out.print('A');
				else
				if(i==5 && (j==1||j==5))
					System.out.print('A');
				else
				if(i==6 && (j==1||j==5))
					System.out.print('A');
				else
				if(i==7 && (j==1||j==5))
					System.out.print('A');
				else
					System.out.print(' ');
			}
			System.out.print("   ");
			for(j=9;j<=13;j++)
			{
				if(i==1)
					System.out.print('T');
				else
					if(i>1&&j==11)
						System.out.print('T');
					else
						System.out.print(' ');
				
						
				
				
			}
			
			System.out.println();
		}
		
		
		
		

	}
}
