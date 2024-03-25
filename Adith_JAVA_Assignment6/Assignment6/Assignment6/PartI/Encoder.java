import javax.swing.JFrame;

public class Encoder {


	public static String encodeNumeric(String s) {
		
		char ch;
		int i;
		String kk="";
		
		for(i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			
			if(ch==32)
			{
				kk+=" ";
			}
			else
			if(ch>='a'&&ch<='z')	
			{
				kk+=(ch-'a'+1);
				kk+=".";
			}
			else
			if(ch=='\n')
			{
					kk+=ch;
			}
			
			
		}
		return kk;
	}
	
	public static String encodeROT13(String s) {
		

		char ch;
		int i;
		String kk="";
		
		for(i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			
			if(ch==32)
			{
				kk+=" ";
			}
			else
			if(ch>='a'&&ch<='z')			
			{
				int y=ch-'a'+1;
				
				y=(y+13)%26;
				
				if(y==0)
					y=26;
				
				
				
				ch=(char)(y+'a'-1);
				
				kk+=ch;
			}
			else
			if(ch=='\n')
			{
				kk+=ch;
			}
			
			
		}
		return kk;
	}
	
	
	
	
}
