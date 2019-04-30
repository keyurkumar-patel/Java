/*Use the Account class created in Task 2 (above) to simulate an ATM machine.
 Create ten accounts in an array with id 0, 1, . . . , 9, and initial balance $100.
 The system prompts the user to enter an id. If the id is entered incorrectly, ask the user to enter a correct id. 
 Once an id is accepted, the main menu is displayed as shown in the sample run.
 You can enter a choice 1 for viewing the current balance,2 for withdrawing money,3 for depositing money, and 4 for exiting the main menu. 
 Once you exit, the system will prompt for an id again. Thus, once the system starts, it will not stop.*/
package Task3;
import java.util.Scanner;
public class main {
public static void main(String[] args){
	
		Account2[] Myaccount = new Account2[10]; 
		
		for(int i=0; i <10; i++)
		{
			Myaccount[i] = new Account2();
			Myaccount[i].setbalance(100);
		}
		
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Enter an id: ");
			int id =0;
			//id = input.nextInt();
			if(!input.hasNextInt()) {
				
				System.out.println("Incorrect ID, Enter Correct ID: ");
				input.nextLine();
				
			}
			else {
				id = input.nextInt();
				while (id < 0 || id > 9)
				{
					System.out.print("ID is incorrect, try again: ");
					//if(input.hasNextInt()) {
					id = input.nextInt();
					
				}
				int choice = 0;
				while(choice!=4) {
					MenuList();
					choice =input.nextInt();
					if( choice < 0 || choice >4) {
						System.out.println("Incorrect Choice, Enter the correct choice\n");
					}
					
					switch(choice) {
						case 1 : System.out.println("The balance is: " + Myaccount[id].getbalance());
						break;
						
						case 2 : System.out.println("Enter an amount to withdraw: ");
						//double WithdrawAmount = (input.nextInt());
						Myaccount[id].withdraw(input.nextInt());
						System.out.println("\n");
						//return true;
						break;
						
						case 3 : System.out.println("Enter an amount to deposit: ");
						//double depositamount = (input.nextInt());
						Myaccount[id].deposit(input.nextInt());
						System.out.println("\n");
						break;
						
						case 4 : break;
						
					}
				}
			}input.close();	
		}
		
	}
public static void MenuList(){
		System.out.print("Main menu "
				+ "\n1: Check balance"
				+ "\n2: Withdraw"
				+ "\n3: Deposit"
				+ "\n4: Exit"
				+ "\nEnter a choice: ");
	}

}
