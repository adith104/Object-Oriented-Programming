 
public class Account {
	private static int account_count;
	private double balance;
	private int id;
	
	public Account()
	{
		this.id=++account_count;
		this.balance=0;
		
	}
	
	public Account(double startingBalance)
	{
		this.id=++account_count;
		this.balance=startingBalance;
		
	}
	
	public boolean withdraw(double amount)
	{
		if(amount<=this.balance)
		{
			this.balance=this.balance-amount;
			
			return true;
			
		}
		else
			return false;
		
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void deposit(double amount)
	{
		this.balance=this.balance+amount;
		
	}
	
	public int getId()
	{
		return this.id;
	}

}
