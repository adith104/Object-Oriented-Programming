
public class WordReverser {

	public static String reverseSentence(String sentence) {
		
		String s[]=sentence.split(" ");
		String g="";
		int i,j,k;
		char ch;
		
		for(i=0;i<s.length;i++)
		{
			for(j=s[i].length()-1,k=0;j>=0&&k<s[i].length();j--,k++)
			{
				ch=Character.toLowerCase(s[i].charAt(j));
				
				if(Character.isUpperCase(s[i].charAt(k)))
				{
					ch=Character.toUpperCase(ch);
				}
				
				g+=ch;

			}
			
			if(i<s.length-1)
			g+=' ';
			
		}
		
		return g;
	}
	
	public static void main(String[] args) {
		String result = reverseSentence("The quick brown fox jumps over the lazy dog");
		System.out.println(result);
		


	}

}
