class Permutations {
	
	static int[][] permutations = new int[120][5]; //obviously your array will have more members
	
	public static int[][] getPermutations(int[] array,int k) {
		
		if(array.length==k)
		{
			int ll;
			for(ll=0;ll<array.length;ll++)
				{
				   permutations[currentIndex][ll]=array[ll];
				 
				}
			
			currentIndex++;
			
			return permutations;
		}
		int i,j,temp;
		
		
		for(i=k;i<array.length;i++)
		{
			temp=array[k];
			array[k]=array[i];
			array[i]=temp;
			getPermutations(array,k+1);
			temp=array[k];
			array[k]=array[i];
			array[i]=temp;
			
		
		}
		
		return permutations;
		
	}
	
	private static int currentIndex = 0;
	
	
    
    public static void main(String[] args) {
    	int[] startingArray =   {1,2,3,4,5};
    	int[][] result = getPermutations(startingArray,0);
    	
    	int i,j;
    	
    	for(i=0;i<result.length;i++)
    	{
    		for(j=0;j<result[i].length;j++)
    		{
    			System.out.print(result[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    }
}
