import java.util.InputMismatchException;
import java.util.Scanner;
public class ConnectFourGame 
{
	private String[][] GameDesign;
	ConnectFourGame() 
	{//allocate the value to the row and column
		this.GameDesign = new String[6][7];
		for (int row = 0; row <=5; row++) 
		{			
			for (int col = 0; col <=6; col++) 
			{
				this.GameDesign[row][col] = " ";
			}
		}
	}

	public void GameDesignmaker() 
	{
		System.out.println("\n Column Number ");
		System.out.println("-0-1-2-3-4-5-6-");
		//System.out.println("\n Row Number ");
		
		for (int row = 0; row < 6; row++) 
		{
		//	int rownumber=0;
			//while(rownumber<6) {
			System.out.print("|");
			//}
			for (int col = 0; col < 7; col++) 
			{				
				System.out.print(this.GameDesign[row][col] + "|");
			}
			
			System.out.print('\n');
			
		}
		System.out.println("_______________");
	}
	
	
	public void inputvalidation(String disk) 
	{		
		int col = 0;
		Scanner sc = new Scanner(System.in);
		while (true) 
		{
			try
			{
				System.out.print("\nDrop a " + disk + " disk at column (0-6): ");
				col =  sc.nextInt();
				if(col >= 0 && col <= 7)
				{
					int row = this.ColCheker(col);
	
					if (row < 0) 
					{
						System.out.print("\nColoumn is Fully occupied, Please enter into another coloumns\n");
					} 
					else 
					{
						this.GameDesign[row][col - 0] = (disk.toUpperCase()).substring(0,1);
						break;
					}
				}
				else
				{
					System.out.print("\n*******Please enter the correct column it should be between (0 to 6):*******\n");
					sc.nextLine();
				}
				//sc.close();
			}
			catch(ArrayIndexOutOfBoundsException | InputMismatchException e)
			{
				System.out.println("\n*********Only Interger! Please enter the correct value for column:********");
				sc.nextLine();
			}
		}
		//sc.close();
		
	}
	
	/*To check the column is full or not before enter the value*/
	public int ColCheker(int col) 
	{
		int emptyRow = 5;

		for (int column = 5; column >= 0; column--) 
		{
			String c = this.GameDesign[column][col - 0];

			if ((c.equals(" "))) 
			{
				emptyRow = column;
				//System.out.println("Empty column");
				break;
			} 
			else 
			{
				//System.out.println("Full column");
				emptyRow = -1;
			}

		}

		return emptyRow;
	}


	public String winnerChecker() 
	{
		String RESULT = " ";
		//TO check combination horizontally 
		for (int row = 0; row <6; row++) 
		{
			for (int col = 0; col < 4; col++) 
			{
				if (GameDesign[row][col].equals("R") && GameDesign[row][col + 1].equals("R") && GameDesign[row][col + 2].equals("R") && GameDesign[row][col + 3].equals("R")) 
				{
					RESULT = "RED";
				}
				if (GameDesign[row][col].equals("Y") && GameDesign[row][col + 1].equals("Y") && GameDesign[row][col + 2].equals("Y") && GameDesign[row][col + 3].equals("Y")) 
				{
					RESULT = "YELLOW";
				}
			}
		}
		
		//TO check combination diagonal from bottom to top
    	for (int row = 5; row > 2; row--) 
		{
			for (int col = 0; col < 4; col++) 
			{
				if (GameDesign[row][col].equals("R") && GameDesign[row - 1][col + 1].equals("R") && GameDesign[row - 2][col + 2].equals("R") && GameDesign[row - 3][col + 3].equals("R")) 
				{
					RESULT =  "RED";
				}
				if (GameDesign[row][col].equals("Y") && GameDesign[row - 1][col + 1].equals("Y") && GameDesign[row - 2][col + 2].equals("Y") && GameDesign[row - 3][col + 3].equals("Y")) 
				{
					RESULT = "YELLOW";
				}
			}
		}
    	
    	//TO check combination diagonal from top to bottom
		for (int row = 0; row < 3; row++) 
		{
			for (int col = 0; col < 4; col++) 
			{
				if (GameDesign[row][col].equals("R") && GameDesign[row + 1][col + 1].equals("R") && GameDesign[row + 2][col + 2].equals("R") && GameDesign[row + 3][col + 3].equals("R")) 
				{
					RESULT = "RED";
				}
				if (GameDesign[row][col].equals("Y") && GameDesign[row + 1][col + 1].equals("Y") && GameDesign[row + 2][col + 2].equals("Y") && GameDesign[row + 3][col + 3].equals("Y")) 
				{
					RESULT = "YELLOW";
				}
			}
		}
		
		//TO check combination Vertically 
		for (int row = 0; row <3; row++) 
		{
			for (int col = 0; col < 7; col++) 
			{
				if (GameDesign[row][col].equals("R") && GameDesign[row+1][col].equals("R") && GameDesign[row+2][col].equals("R") && GameDesign[row+3][col].equals("R")) 
				{
					RESULT ="RED";
				}
				if (GameDesign[row][col].equals("Y") && GameDesign[row+1][col].equals("Y") && GameDesign[row+2][col].equals("Y") && GameDesign[row+3][col].equals("Y")) 
				{
					RESULT ="YELLOW";
				}
			}
		}
		
		return RESULT;
	}

	public static void main(String[] args) 
	{	
		String DSPRESULT = " ";
		String Playagain = " ";
		boolean flag = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("***************************");
		System.out.println("\nWelcome To ConnectFour-Game\n");
		System.out.println("***************************");
		
		while(flag == false)
		{
			DSPRESULT = " ";
			ConnectFourGame game = new ConnectFourGame();

			while (DSPRESULT == " ") 
			{
				// Red disk checker
				game.GameDesignmaker();
				game.inputvalidation("RED");
				DSPRESULT = game.winnerChecker();
				if(DSPRESULT!=" ") {
					break;
				}
				// Yellow disk checker
				game.GameDesignmaker();
				game.inputvalidation("YELLOW");
				DSPRESULT = game.winnerChecker();			
			}
			
			game.GameDesignmaker();
			
			
			if(DSPRESULT == " ")
			{
				System.out.println("\n*****The Game is Draw or Game is Over Please try Again.*****");
			}
			else
			{
				System.out.println("**************************************");
				System.out.println("\nThe " + DSPRESULT +" Player Won. \n" );
				System.out.println("**************************************");
			}
						
			boolean response = false;
			while (response == false) 
			{
				System.out.print("\nDo you want to Play again? Only (y) or (n)");
				Playagain = scan.next().toLowerCase().substring(0,1);
				response = true;
	
				if (!Playagain.equals("y")  && !Playagain.equals("n")) 
				{
					System.out.println("\nPlease enter Correct value:");
					scan.nextLine();
					response = false;
				}
				if (Playagain.equals("y")) 
				{
					flag = false;
				}
				if (Playagain.equals("n")) 
				{
					flag = true;
					System.out.println("\n*****Thank You Good Bye......*****");
					break;
				}
				//scan.close();
			}
		}
		scan.close();
		
		System.exit(0);
	}

}
