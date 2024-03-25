
public class DumbPasswords {

	public static void printDumbPasswords(int m, int n) {
		
		int i,j,k,l,o;
		
		for(i=1;i<m;i++)
		{
			
			for(j=1;j<m;j++)
			{
				
				for(k=97;k<=98+n;k++)
				{
					
					char g=(char) k;
					
					
					for(l=97;l<=98+n;l++)
					{
						char ss=(char) l;
						
						for(o=1;o<m+1;o++)
						{
							if(o>i&&o>j)
							{   
								System.out.print(i);
								System.out.print(j);
								System.out.print(g);
								System.out.print(ss);
								System.out.print(o);
								System.out.print(' ');
								
							}
						}
						
						
					}
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		printDumbPasswords(3,1);
		
	}
}
