package PartIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortFrequency {

	public static void sortByFrequency(ArrayList<Integer> ar) {
		
		Map<Integer,Integer>f=new HashMap<>();
		
		int i;
		Integer g;
		for(i=0;i<ar.size();i++)
		{
			g=ar.get(i);
			f.put(g, f.getOrDefault(g,0)+1);
		}
		
		
		Collections.sort(ar,(x,y)->
		{
			
			int xf=f.get(x);
			int yf=f.get(y);
			if(xf!=yf)
				return xf-yf;
			else
				return x-y;
			
		});
		
		
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i=0;i<100;i++) {
			ar.add((int)(Math.random()*10));			
		}
		System.out.println(ar.toString());
		sortByFrequency(ar);
		System.out.println(ar.toString());
	}
}
