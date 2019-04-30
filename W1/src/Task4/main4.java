/*In Programming Exercise Task 2, the Account class was defined to model a bank account. 
An account has the properties account number, balance, annual interest rate, and date created, and methods to deposit and withdraw funds. 
Create two subclasses for checking and saving accounts. A checking account has an overdraft limit, but a savings account cannot be overdrawn.
Write a test program that creates objects of Account, SavingsAccount, and CheckingAccount and invokes their toString() methods.*/
package Task4;
public class main4 {
	public static void main(String args[])
	{
		Account3 Myaccount = new Account3(1, 200);
		SavingAccount savings= new SavingAccount(2,100);
		CheckingAccount checking= new CheckingAccount(3,300);

		Myaccount.setannualInterestRate(4.5);
		savings.setannualInterestRate(4.5);
		checking.setannualInterestRate(4.5);
		
	
		Myaccount.withdraw(120);
		savings.withdraw(150);
		checking.withdraw(500);
		
		System.out.println("\n----------:TASK2 MAIN ACCOUNT DETAILS:-------");
		System.out.println(Myaccount.toString());
		System.out.println("\n----------:SAVINGS ACCOUNT DETAILS:-------");
		System.out.println("\nSAVINGS ACCOUNT cannot be overdrawn.");
		System.out.println(savings.toString());
		System.out.println("\n----------:CHECKING ACCOUNT DETAILS:-------");
		System.out.println("\nCHECKING ACCOUNT has Overdraft limit.");
		System.out.println(checking.toString());
		
		
}

}
