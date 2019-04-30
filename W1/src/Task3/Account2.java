package Task3;
//import java.io.IOException;
import java.util.*;
//import java.util.Date;
public class Account2{
			private int id=0;
			private double balance =0;
			private double annualInterestRate=0;
			private java.util.Date dateCreated;
			
public Account2() {
	    //annualInterestRate = 0;
	    this.dateCreated = new Date();
	    /*/*id = 0;
		balance = 0;
		annualInterestRate = 0;*/
	  }

/*A constructor that creates an account with the specified id and initial balance.*/
Account2(int newId, double newBalance) {
			this();
			id = newId;
			balance = newBalance;
		}

/*The accessor methods for id, balance, and annualInterestRate*/
public int getid(){
			return id;
		}

public double getbalance(){
			return balance;
		}

public double getannualIntrestRate(){
			return annualInterestRate;
		}

/*The mutator methods for id, balance, and annualInterestRate*/
public void setid(int newId) {
			this.id = newId;
		}

public void setbalance(double newBalance) {
			this.balance = newBalance;
		}

public void setannualInterestRate(double newAnnualInterestRate) {
			this.annualInterestRate = newAnnualInterestRate;
		}

//The accessor method for dateCreated.
	  public Date getdateCreated() {
	      return dateCreated; //= newDateCreated;
	  }
	  
/*	A method named getMonthlyInterestRate() that returns the monthly interest rate.*/
		public double getMonthlyInterestRate() {
			return getannualIntrestRate() / 1200;
			}
		
/*A method named getMonthlyInterest() that returns the monthly interest.*/
public double getMonthlyInterest() {
	return getbalance() * getMonthlyInterestRate();
			}

/*A method named withdraw that withdraws a specified amount from the account.*/
public boolean withdraw(double amount) {
			if(amount> balance){
					System.out.println("Sorry!!!! Insufficient fund.");
					return false;
			}
			else
			{
					balance -= amount;	
					System.out.println("Successfully Withdrawn."+amount);
					return true;
			}
		}

/*A method named deposit that deposits a specified amount to the account.*/
public void deposit(double amount) {
			balance += amount;
			System.out.println("Successfully Deposited."+amount);
			}
}
	

	
		


