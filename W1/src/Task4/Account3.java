package Task4;
//import Task2.Account;
//import java.io.IOException;
//import java.util.*;
import java.util.Date;
public class Account3{
	
		private int id=0;
		private double balance =0;
		private double annualInterestRate=0;
		private java.util.Date dateCreated;
		
public Account3() {
		//annualInterestRate = 0;
		this.dateCreated = new Date();
		/*this.id = 0;
		this.balance = 0.0;
		this.annualInterestRate = 0.0;*/
	}

/*A constructor that creates an account with the specified id and initial balance.*/
public Account3(int newId, double newBalance) {
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
public void withdraw(double amount) {
		/*if(amount> balance){
			//System.out.println(" Sorry!!!! Insufficient fund." +amount);
			//return false;
		}else{*/
		balance = balance- amount;	
		 //System.out.println("Successfully withdrawn."+amount);
		//return true;
		}
		//balance -= amount;
		
	
/*A method named deposit that deposits a specified amount to the account.*/
public void deposit(double amount) {
		balance = balance+ amount;
		
		//System.out.println("Successfully Deposited."+amount);
		}
@Override
public String toString() {
			return  
					"\nAccount ID: " + getid() +
		            "\nBalance: $" + getbalance() +
		            "\nAccount Monthly Interest: $" + getMonthlyInterest() +
		            "\nAccount Annual Interest Rate: " + getannualIntrestRate() +
		            "\nDateCreated: " + getdateCreated() ;
		}
	
		/*System.out.println("The balance of the account is : $" + Myaccount.getbalance());
          System.out.println("The Monthly interest is : " + Myaccount.getMonthlyInterest());
          System.out.println("The date when this account is created is : " + Myaccount.getdateCreated()); 
		
		}*/


}

























