/*Design a class named Location for locating a maximal value and its location in a two-dimensional array.
The class contains public data fields row, column, 
and maxValue that store the maximal value and its indices in a two-dimensional array with row and column as int types and maxValue as a double type.
Write the following method that returns the location of the largest element in a two-dimensional array:
public static Location locateLargest(double[][] a)
The return value is an instance of Location. 
Write a test program that prompts the user to enter a two-dimensional array and displays the location of the largest element in the array. 
*/
package Task1;
import java.util.Scanner;
public class Location1 {
	   public int row;
       public int column;
       public double maxValue;
       
       
public static Location1 locateLargest(double[][] a)
{

        
	Location1 loc = new Location1();//daynamic-runtime memory allocation
       /*public int row = 0;
       public int column = 0;
       public double maxValue= a[0][0];// = a[0][0];*/
			loc.row = 0;
			loc.column = 0;
			loc.maxValue= a[0][0];
        for (int i = 0; i < a.length; i++)
        {
                for (int j = 0; j < a[i].length; j++)
                {
                        if (a[i][j] >loc.maxValue)
                        {
                                loc.row = i;
                                loc.column = j;
                                loc.maxValue = a[i][j];
                        }
                }
        }

        return loc;
}
public static void main(String[] args)
 {
                //Create Scanner
                Scanner input = new Scanner(System.in);
				
				
				/*if(choice == Math.floor(choice)){
					int choiceInt = (int) choice;
				}*/
				
				int numberOfRows = 0;
                int numberOfColumns =0;

					
					boolean isNumber;
					do{
						System.out.println("Enter the number of rows and columns in the array: ");
						/*if (numberOfRows < 1 || numberOfColumns < 1)
						{
							numberOfRows = incorrectRow(numberOfRows);
						    numberOfColumns = incorrectColumn(numberOfColumns);
						}*/
						if (input.hasNextInt()){
                                     numberOfRows = input.nextInt();
                                     if(input.hasNextInt()){
                                           numberOfColumns = input.nextInt();
                                           isNumber=true;
                                       }
                                       else
                                       {
                                           System.out.println("Please enter Only Decimal Input.");
                                           isNumber=false;
                                           System.out.println();
                                           input.nextLine();
                                       }
						}
                        else
                        {
							System.out.println("Please enter Only Decimal Input.");
							isNumber=false;
                            System.out.println();
							input.nextLine();					
                        }
					}
					while(!(isNumber));
			     //User input data in array
                System.out.println("Enter numbers into array: ");
         		//Create array
                double[][] a = new double[numberOfRows][numberOfColumns];
                for (int i = 0; i <numberOfRows ; i++){
                        for (int j = 0; j < numberOfColumns; j++) {
                            a[i][j] = input.nextDouble();
                            }
                        }      
				Location1 location = Location1.locateLargest(a);
				//int[] loc = locateLargest(a);
                System.out.println("The location of the largest element is " + location.maxValue + " at (" + location.row + ", " +location.column +")");
                input.close();
          }
 }


