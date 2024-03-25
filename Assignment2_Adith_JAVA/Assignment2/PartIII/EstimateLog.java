
public class EstimateLog {

	static int n;
	public static double estimateLog(double x) {
		double result = 0,k,l,j,m;
		int a1;
		int a2;
		int e;
		double g=Math.log(1+x);
	
		g=g*10000;//To get first 4 significant digits of decimal
		
		
		for(n=1;n<1000;n++)
		{
			k=Math.pow(-1, n+1);
			l=Math.pow(x, n)/n;
			j=k*l;
			result+=j;
			
			m=result*10000;//To get first 4 significant digits of decimal
			
			a1=(int)m;
			a2=(int)g;
			
			
			if(a1==a2)//Checking wether the first 4 significant digits of inbuilt log
			{                     //same as that of the taylor series summation
				break;
			}
		
			
			
		}
		
		

		return result;
		
	}
	
	public static void main(String[] args) {
		
		double x=0,result;
		int i=0;
		for(i=0;i<10;i++)
		{
			result=estimateLog(x);
			System.out.println("ln(1."+i+") is "+result);
			System.out.println("it requires "+n+" iterations to estimate ln(1."+i+") within .0001");
			x=x+0.1;
			
		}
		
		
		
		
	}
	
}
