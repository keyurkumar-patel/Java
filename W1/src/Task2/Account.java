package Task2;
//import java.io.IOException;
import java.util.*;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.TimeZone;
public class Account{
		private int id=0;
		private double balance =0;
		private double annualInterestRate=0;
		private java.util.Date dateCreated;
		
public Account() {
    	//annualInterestRate = 0;
    	this.dateCreated = new Date();
    	/*this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;*/
	}

/*A constructor that creates an account with the specified id and initial balance.*/
public Account(int newId, double newBalance) {
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
		balance -= amount;
		//System.out.println("Sorry!!!! Insufficient fund.");
	}
	
/*A method named deposit that deposits a specified amount to the account.*/
public void deposit(double amount) {
		balance += amount;
		//System.out.println("Successfully Withdrawn."+amount);
		}

public static void main(String[] args){
	  Account Myaccount = new Account(1122, 20000); 
      Myaccount.setannualInterestRate(4.5);
      Myaccount.withdraw(2500);
      Myaccount.deposit(3000);
		
	  System.out.println("The balance of the account is : $" + Myaccount.getbalance());
      System.out.println("The Monthly interest is : " + Myaccount.getMonthlyInterest());
      System.out.println("The date when this account is created is : " + Myaccount.getdateCreated()); 
		
		}
		
}
