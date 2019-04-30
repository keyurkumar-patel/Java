import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class game {
	
	  public static void main(String[] args) {

	        Scanner input = new Scanner(System.in);
	        int numberOfBalls=0;
	        int numberOfSlots=0;
	        String[] Pathforball;
	        int[] slots;
	    	boolean ballisNumber;
	    	boolean SlotisNumber;
	    	// take input from the user and validate the input before proceed it.
	    	do {
	    		 System.out.println("Enter the number of balls to drop  : ");
	    		try
	    		{
	    			numberOfBalls = input.nextInt();
	    			if(numberOfBalls > 0) {
	    				ballisNumber=true;
	    				
	    			}else {
	    				System.out.println("\n***Please Enter Value Gratet than Zero\n");
	    				ballisNumber=false;
	    			}
	    				
	    			
	    		}
	    		catch(InputMismatchException e)
	    		{
	    			System.out.println("\n***Please enter Only Decimal Input.");
	        		ballisNumber=false;
                    System.out.println();
					input.nextLine();
	    		}
	    	 
	    	}while(!(ballisNumber));
	    	
	    	
	    	do {
	    		System.out.println("Enter the number of slots in the bean machine: ");
	    		try
	    		{
	    				numberOfSlots = input.nextInt();
	    				if(numberOfSlots > 0) {
	    					SlotisNumber=true;
		    				
		    			}else {
		    				System.out.println("\n***Please Enter Value Gratet than Zero\n");
		    				SlotisNumber=false;
		    			}
	    		}
	    		catch(InputMismatchException e)
	    		{
	    			System.out.println("\n***Please enter Only Decimal Input.");
		      		SlotisNumber=false;
		      		System.out.println();
		      		
		      		input.nextLine();
	    		}
	      	      		
	      	}while(!(SlotisNumber));
	    	
	    	
	    	//Take number of balls into string to display the ball path.
	   	Pathforball = new String[numberOfBalls];

	      		
	 	       
	    slots = new int[numberOfSlots];

		        // this will display the path of the balls falling of each ball by printing its path.
		        for (int i = 0; i < numberOfBalls; i++) {
		        	Pathforball[i] = dropBall(slots);
		            System.out.printf("BAllS:- %10s\n", Pathforball[i]);
		        }

		        // display game
		        System.out.println("");
		        System.out.println("Final Board After the Balls drop into the Machine\n");
		    	System.out.println("");
		    	/*int m;
		    	for(m=0;m<=slots.length;m++) {
		    		System.out.println(slots[m]);
		    	}*/
		    	System.out.println("|0|1|2|3|4|5|6|7|8|9|10|");
		            while (!isEmpty(slots)) {
	//if whole slot gets L then remove the whole slot with L
		                if (isRowEmpty(slots, numberOfBalls)) {
		                    numberOfBalls--;
		                    continue;
		                }
		                
		                for (int i = 0; i < slots.length; i++) {

		                    if (slots[i] >= numberOfBalls) {
		                    	
		                        System.out.printf("%2c", 'O');
		                        slots[i]--;
		                    }
		                    else System.out.printf("%2c", '-');

		                }
		                numberOfBalls--;
		                System.out.println("");

		            }
		            System.out.println("|0|1|2|3|4|5|6|7|8|9|10|");
	    	
	       
	    	
	        input.close();
	    }
	  public static boolean isEmpty(int[] slots) {
//check whether the slot is empty or not
	        for (int slot : slots) {
	            if (slot != 0) {
	                return false;
	            }
	        }

	        return true;
	    }
	  
	  
	    public static String dropBall(int[] slot) {

	        StringBuilder ballPath = new StringBuilder();

	       
	        for (int i = 0; i < slot.length - 1; i++) {
	        	//// 50% chance of falling to the left or to the right.
	            int random = (int)(Math.random() * 10) % 2;
	            
	            if (random > 0) ballPath.append("R ");
	            else ballPath.append("L ");
	            
	        }
	        // pass string to getballpostion to count R and increment slot position
	        int position = getBallPosition(ballPath.toString(), 'R');
	        slot[position]++;
	        return ballPath.toString();
	    }

	    public static int getBallPosition(String str, char a) {
//get the postion of balls
	        int count = 0;
	        for (int i = 0; i < str.length(); i++) {

	            if (str.charAt(i) == a) count++;

	        }

	        return count;
	    }


	  //if whole slot gets L then remove the whole slot with L
	    public static boolean isRowEmpty(int[] slots, int rowNum) {

	        for (int slot : slots) {
	            if (slot == rowNum) {
	                return false;
	            }
	        }

	        return true;
	    }
	
}	
