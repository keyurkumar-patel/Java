package Task4;

//import Task2.Account;
class SavingAccount extends Account3{
	public SavingAccount()
	   {
		 
	       super();
	       
	   }
	   
	   public SavingAccount(int id, double balance) 
	   {
	         super(id,balance);
	   }
	   
	   public void withdraw(double amount)
	   {       
		   double balance = this.getbalance();
	       if(amount > balance)
	       {
	    	   System.out.println("\n----------:SAVINGS ALEART MESSAGE:-------");
	    	   System.out.println("Not Enough fund to Withdraw $"+ amount +" From the SAVINGS ACCOUNT Because savings account cannot be overdrawn.");
	        	   
	       }	       
	       else
	       {
	    	   balance -= amount;
	    	   this.setbalance(balance);
	    	   System.out.println("\n----------:SAVINGS ALEART MESSAGE:-------");
	    	   System.out.println("The amount of $" + amount + " was withdrawn from Savings Account ");
	    	   
	       }	  
	       
	     }
}

class CheckingAccount extends Account3 {
	private final double limit = -100.00;
	
	   public CheckingAccount()
	   {
	        super();
	   }
	   
	   public CheckingAccount(int id, double balance) 
	   {
	         super(id,balance);
	   }
	   @Override   
	   public void withdraw(double amount)
	   {	
		   double balance = this.getbalance();
	    	   if((balance -amount) < limit)
	    	   {
	    		   System.out.println("\n\n\n----------:CHECKING ALEART MESSAGE:-------");
		   		   System.out.println("Sorry!!! Your balance cannot goes below $" + limit+ " because it has $" +limit+ "Overdraft limit");
	    		
		       }
	    	   else
	    	   {
	    		   balance-= amount;
	    		   this.setbalance(balance);
	    		   System.out.println("\n\n\n----------:CHECKING ALEART MESSAGE:-------");
			       System.out.println("$"+amount+ " Withdrawn From Checking Account and it has $" +limit+ " Overdraft limit." ); 
	    		   //this.setbalance(balance);
	    	   }
	   }
	    	  
}
