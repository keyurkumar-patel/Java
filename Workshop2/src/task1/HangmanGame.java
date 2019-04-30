package task1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
public class HangmanGame {
	 	String[] gameInput;
	    char[] userInput;
	    int length,noOfTries;

	    HangmanGame()
	    {
	    	gameInput[0] = "";
	    	userInput[0] = '\0';
	        length = 0;
	        noOfTries = 0;
	    }

	    HangmanGame(String[] word) 
	    {
	    	noOfTries = 0;
	        Random rand = new Random();
	        int RandomNumber = rand.nextInt(word.length);
	        gameInput = new String[1];
	        
	        gameInput[0] = word[RandomNumber];
	        length = gameInput[0].length();
	        userInput = new char[length];
	        
	        int i = 0;
	        while(i < length) {
	        	userInput[i] = '*';
	        	i++;
	        }
	    }

	    public void userGuessWord()
	    {
	    	System.out.print("(Guess) Enter a letter in word ");
	        int n = 0;
	        while( n < length) {
	            char lw= Character.toUpperCase (userInput[n]); 
	            System.out.print(lw +"> " );
	            n++;
	        }
	       
	    }

	    

	    public void getString(char temp) 
	    {
	        int i = gameInput[0].indexOf(temp);
	        if (i < 0)
	        {
	            System.out.println("               " + temp + " is not in the word ");
	            noOfTries++;
	        }
	        else if (userInput[i] != '*')
	            System.out.println("               " + temp + " is already in the word");
	        else 
	        {
	        	int k = 0;
	            while(k < length) {
	                if (gameInput[0].charAt(k) == temp) 
	                	userInput[k] = temp;
	            
	                k++;
	            }
	        }
	    }
	   
	    
	    public boolean check() 
	    {
	        boolean value = false;
	        int i = 0;
	        while ( i < length) 
	        {
	            if (userInput[i] != '*')
	            	value = true;
	            else 
	            {
	            	value = false;
	                break;
	            }
	            i++;
	        }
	        return value;
	    }
	    
	    public static void main(String[] args) throws FileNotFoundException 
	    {
	        char choice;
	        String[] wordList = { "seneca", "college", "student", "service" };
	        Scanner in = new Scanner(System.in);
	      
	        
	        System.out.println("----------:Welcome to Hangman Game:--------\n");
	        do 
	        {
	            System.out.println("Press 1 to run game with randomly generated wordlist.");
	            
	            System.out.println("Press 2 to run game by reading the wordlist from the text file.");
	            
	            System.out.println("Press 3 to Exit.");
	            
	            System.out.println("Enter a choice ");
	            choice = in.next().charAt(0);
	            switch (choice) 
	            {
	            case '1':
	                char temp;
	                
	                
	                do 
	                {
	                	HangmanGame game = new HangmanGame(wordList);
	                    while (game.check() != true)
	                    {
	                    	game.userGuessWord();
	                        temp = in.next().charAt(0);
	                        game.getString(temp);
	                    }
	                    if (game.check())
	                    {
	                        System.out.println("\nThe wordlist is " + game.gameInput[0] + ". You missed " + game.noOfTries + " times\n");
	                    }
	                    do
	                    {
	                    System.out.print("Do you want to guess another word? Enter Y (Yes) or N (NO)\n > ");
	                    choice = in.next().charAt(0);
	                    switch(choice)
	                    {
	                        case 'Y':
	                        choice='1';
	                        break;
	                        case 'y':
	                        choice='1';
	                        break;
	                        case 'N':
	                        choice='2';
	                        break;
	                        case 'n':
	                        choice='2';
	                        break;
	                        default:
	                        System.out.println("Please Enter an Valid option : Only Y (Yes) or N (NO) \n>");
	                        choice = 'r' ;
	                        break;
	                    }
	                }
	                    while(choice == 'r');
	                } 
	                while (choice == '1');

	                break;

	            case '2':
	            	Scanner reader = null;
	            	String[] word = null;
	    			File textFile = new File("hangman.txt").getAbsoluteFile(); //Put your file location.
	    			if(!textFile.exists())
	    			{
	    				System.out.println("Sorry..!Provided Source file Does not Exist.");
	    				System.exit(0);
	    			}
	    			try
	    			{
	    				reader =  new Scanner(textFile);
	    				while(reader.hasNextLine()) 
	    				{
	    					word = reader.nextLine().split(",");
	    				}	
	    			}
	    			catch(FileNotFoundException ex)
	    			{
	    				ex.printStackTrace();
	    			}
	                do 
	                {
	                	HangmanGame game = new HangmanGame(word);
	                    while (game.check() != true) 
	                    {
	                    	game.userGuessWord();
	                        temp = in.next().charAt(0);
	                        game.getString(temp);
	                    }
	                    if (game.check())
	                    {
	                        System.out.println(
	                                "\nThe wordlist is " + game.gameInput[0] + ". You missed " + game.noOfTries + " times\n");
	                    }
	                    do
	                    {
	                    System.out.print("Do you want to guess another word? Enter Y (Yes) or N (NO) \n> ");
	                    choice = in.next().charAt(0);
	                    switch(choice){
	                        case 'Y':
	                        choice='1';
	                        break;
	                        case 'y':
	                        choice='1';
	                        break;
	                        case 'N':
	                        choice='2';
	                        break;
	                        case 'n':
	                        choice='2';
	                        break;
	                        default:
	                        System.out.println("Please Enter an Valid option : Only Y (Yes) or N (NO)\n >");
	                        choice = 'r' ;
	                        break;
	                    }
	                }
	                  while(choice == 'r');
	                } 
	                while (choice == '1');

	                break;

	            case '3':
	            	System.out.println("Thank You for Using Good Bye... \n");
	            	System.exit(0);
	            	
	                break;

	            default:

	                System.out.println("Please enter valid option \n");

	                break;

	            }

	        } while (choice != 3);

	        in.close();

	    }
	    
}
