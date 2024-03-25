package bruteforceattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class BruteForceAttack {

	static final char startLower = 'a';
	static final char startUpper = 'A';
	static final char startNumber = '0';
	static final char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w','x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
	public static char getChar(int i) {
		return letters[i];
		
	}
	
	public static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public static int getInt(char c) {
		if ((c >= 'a') && (c <= 'z')) {
			return c - 'a';
		} else if ((c >= 'A') && (c <= 'Z')) {
			return 26 + (c - 'A');
		} else if ((c >= '0') && (c <= '9')) {
			return 52 + (c - '0');
		} else {
			return 0;
		}
	}
	
	public static Set<String> hashedpasswords(String filename) {
		Set<String> hashSet = new HashSet<String>();
		try {
			FileReader fr = new FileReader("hashedpassword.txt");
			BufferedReader br = new BufferedReader(fr);
			String inline = br.readLine();
			while (inline != null) {
				hashSet.add(inline);
				inline = br.readLine();
			}
		} catch (Exception e) {
			
		}
		return hashSet;
		
	}
	public static void main(String[] args) throws NoSuchAlgorithmException,InterruptedException{
		
		final long s1=System.currentTimeMillis();
		System.out.println("The kind of computer this program is running on:");
		System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
		System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));
		System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));

		
		Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		AtomicInteger numfound = new AtomicInteger(0);
		int len = 5;
		
		double max = Math.pow(26, len);
		
		
		int i;
		int nth=16;
		Thread[] ts=new Thread[nth];
		long r=(long)max/nth;
		long l=0;
		double m=0;
		
			for(i=0;i<nth;i++) {
			l=i*r;
			m=(1+i)*r;
		ts[i]=new Thread(new bth(passwordSet,m,l,numfound,len));
		
		
		ts[i].start();
		
			}
		
		
		for(i=0;i<nth;i++)
		{ts[i].join();}
		
		final long d1=System.currentTimeMillis()-s1;
		
		System.out.println("Found " + numfound.get()+ " passwords of length:"+len+" out of " + passwordSet.size()+" using "+nth+" threads and the time taken is :"+(double)d1/1000);
}


static class bth implements Runnable{
	
	private MessageDigest digest;
	private Set<String> passwordSet;
	private AtomicInteger numfound;
	private double max;
	private long l;
	private int len;
	
	public bth(Set<String>passwordSet,double max,long l,AtomicInteger n,int len)
	{
		try {
			this.digest= MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.passwordSet=passwordSet;
		this.numfound=n;
		this.max=max;
		this.l=l;
		this.len=len;
		
	}
	
	@Override
	public void run()
	{
		byte[] pass = new byte[this.len];
		for (int k = 0;k<pass.length ;k++) {
			pass[k] = (byte)letters[(int) ((l/(Math.pow(26, k))))%26];
		}
		
		
		
		for (long j=l ; j <max ;j++) { 
			int v = (int)(j % 26L);
			if ((v == 0) && (j!=0)) {
				
				pass[0] = startLower;
				for (int k = 1;k<pass.length ;k++) {
					if (pass[k] == 'z') {
						if (k != pass.length-1) {
							pass[k] = startLower;
							continue;
						} else {
							break;
						}
					} else {
						int val = getInt((char)pass[k]);
						val++;
						pass[k] = (byte)letters[val];
						break;
					}
				}
			} else {
				pass[0] = (byte)letters[v];
			}
			
			byte[] encodedhash = digest.digest(pass);
					
			String hashpass = BruteForceAttack.bytesToHex(encodedhash);
			
			
			if (passwordSet.contains(hashpass)) {
				String passString = new String(pass);
				System.out.println("found password " + passString);
				numfound.getAndIncrement();
			}
			//System.out.println(new String(pass));
		}
		
	
	}
	
	
	}

}
