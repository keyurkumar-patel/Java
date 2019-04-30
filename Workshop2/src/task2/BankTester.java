package task2;
import java.util.*;
public class BankTester {
	static final int UniqueID = 0;
    static final int loan = 1;
    static double[][][] Banks;
    
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
       // BankTester tester = new BankTester(); 
        boolean Exit = false;
       
        int n=0;
        do
        {
        	try
        	{
        		System.out.print("Enter the number of banks: "); //print the message to the console.
        		n= input.nextInt();
        		Exit = true;
        	}
        	catch (InputMismatchException ex)// print the exception to the console
        	{
        		System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                input.nextLine();
                Exit = false;
        	}
        	
        }while(Exit == false);
        
        int limit=0; 
        do
        {
        	try 
        	{
        		 System.out.print("Enter minimum limit: "); //print the message to the console.
        		 limit= input.nextInt();
        		 Exit = true;
        	}
        	catch (InputMismatchException ex)//Exception to the console
        	{
        		System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                input.nextLine();
                Exit = false;
        	}
        	
        }while(Exit == false);
       
       
        
        Banks = new double[n][][]; // initialization 3 dimension array.
        
        System.out.println("Bank #  -> Balance -> Number of banks Loaned -> 1st Bank ID -> Amount -> 2nd Bank ID -> Amount -> ...");  //print the message to the console.
        
        
            double balance=0;
           
            int numBanks =0; //take input from reader.
            
            do 
            {
            	try 
            	{
				int i=0;
            		while( i < Banks.length)// takes input base on bank length
            		{   
            			System.out.print("Bank #" + i + " > "); 
            			balance= input.nextDouble();
            			numBanks = input.nextInt(); 
            			Exit = true;
            			Banks[i] = new double[++numBanks][2];  
            			Banks[i][0][0] = balance; 
            			for (int bank = 1; bank < Banks[i].length; bank++) 
            			{  
                         Banks[i][bank][UniqueID] = input.nextInt(); 
                         Banks[i][bank][loan] = input.nextDouble(); 
            			}
					 i++;
					 
                 }
            		
            	}
            	catch (InputMismatchException ex)
            	{
            		System.out.println("Try again. (" + "Incorrect input:*****Only integer/double Required "+
            	"\nAll VALUES should be in Decimal format otherwise needs to do it all Again***)");
                    input.nextLine();
                    Exit = false;
            	}
            	/*finally{
            		System.out.println("this is test method");
            	}*/
            	
            }while(Exit == false);
         
        boolean[] unsafeIndex = checkBanks(Banks, limit); //call the function checkBanks.
        List<Integer> unsafeArr = new ArrayList<Integer>();
        
        int i=0;
        while(i < unsafeIndex.length)
        {	
        	if (unsafeIndex[i] == true) 
        		unsafeArr.add(i); 
        
				i++;
        }
        
        if (unsafeArr.size() == 0)
        { 
        	System.out.println("All banks are safe");
        }
        else if (unsafeArr.size() == 1)
        { 
        	System.out.print("The only unsafe bank is Bank " + unsafeArr.get(0));
        }
        else
        {
            System.out.print("** Unsafe banks are"); 
            for (int j = 0; j < unsafeArr.size(); j++)
            {
            	System.out.print(" Bank " + unsafeArr.get(j));
            	if (j < unsafeArr.size()-1)
            	{
            		System.out.print(" and");
            	}
            }
            System.out.print(" *****");
        }
        
        input.close();
    }

   
    
    public static boolean[] checkBanks(double[][][] m, int limit) {

        boolean[] indexUnsafeBanks = new boolean[m.length];
        double total;
        boolean isSafe = false; 
        while (!isSafe)
        { 
            isSafe = true;
            
            for (int banks = 0; banks < m.length; banks++)
            {
                total = m[banks][0][0]; 
                
                for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++)
                {
                    int index = (int)m[banks][LoanedBanks][UniqueID];
                    if (!indexUnsafeBanks[index])
                        total += m[banks][LoanedBanks][loan]; // total the loanedbanks money and save it into total variable.
                }
                if (total < limit && !indexUnsafeBanks[banks])
                { // check it total is less than limit.
                    indexUnsafeBanks[banks] = true; //  return true if total is less than limit.
                    isSafe = false; 
                }
            }
        }
        return indexUnsafeBanks; //unsafe bank index.
    }
}
	
