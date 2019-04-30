import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class addition {
	
	 public static void main(String[] args) {
	  int size = 2000;
	  
	  double[][] matrixone = new double[size][size];
	  double[][] matrixtwo = new double[size][size];
	  
	  double[][] parallelSum = new double[size][size];
	  double[][] seqSum = new double[size][size];
	  
	  for (int i = 0; i < matrixone.length; i++) 
	  {
	   for (int j = 0; j < matrixtwo[i].length; j++)
	   {
		   matrixone[i][j] = (int)(Math.random() * 10);
		   matrixtwo[i][j] = (int)(Math.random() * 10);
	   }
	  }
// NOt printing any matrix here because its big in size and takes more time to print
	  
//	  System.out.println("First Matrix");
//	  for(int i = 0; i < size; i++)
//	  {
//		  for(int j = 0 ; j<size; j++)
//		  {
//			 // System.out.print(matrixone[i][j] + "\t\t");
//		  }
//		  System.out.println();
//	  }
	  
//	  System.out.println("Second Matrix");
//	  for(int i = 0; i < size; i++)
//	  {
//		  for(int j = 0 ; j<size; j++)
//		  {
//			 // System.out.print(matrixtwo[i][j] + "\t\t");
//		  }
//		  System.out.println();
//	  }
	  
	  long time = System.currentTimeMillis();
	  parallelSum = parallelAddMatrix(matrixone, matrixtwo);
	 
	 // parallel programs take some time to create more threads or processes for the parallel computations and sometimes this overhead is not worth it.
	  System.out.println("The number of processors is " + Runtime.getRuntime().availableProcessors()); 
	  System.out.println("Parallel runtime is:" +(System.currentTimeMillis() - time) + " milliseconds for parallel-Addition");
	  // to print parallelsum
//	  for(int i = 0; i < size; i++)
//	  {
//		  for(int j = 0 ; j<size; j++)
//		  {
//			 // System.out.print(parallelSum[i][j] + "\t\t");
//		  }
//		  System.out.println();
//	  }
		  
	  /*sometimes parallel program is slower than a sequential one 2 reasons why.
		1: Because of communication overhead,i.e., the time for information exchange between processors
 		or threads or synchronization, and idle times(The time when a processor can not do anything useful but wait for a event to happen),
  		2: it can also depend on that the distribution of work to each processor is not equally divided.
     	if a part of the program cannot be parallelized then no matter of increasing processor numbers,
      	because the minimum execution time can not be less than the sequential fraction time of execution.*/
	  
	  long time1 = System.currentTimeMillis();
	  seqSum = addMatrix(matrixone, matrixtwo);
	  System.out.println("sequential runtime is:" +(System.currentTimeMillis() - time1) + " milliseconds for sequential-addition");
	  // to print seqsum
//	  for(int i = 0; i < size; i++)
//	  {
//		  for(int j = 0 ; j<size; j++)
//		  {
//			 // System.out.print(seqSum[i][j] + "\t\t");
//		  }
//		  System.out.println();
//	  }
	 }

	 public static double[][] parallelAddMatrix(double[][] one, double[][] two) {
	  double[][]  sum = new double[one.length][one.length];

	  //A recursive resultless ForkJoinTask. This class establishes conventions to parameterize resultless actions as Void ForkJoinTasks.
	  //Because null is the only valid value of type Void, methods such as join always return null upon completion. 
	 // RecursiveAction works recursively to compute a task parallelly in recursive action.
	  
	  RecursiveAction mainTask = new AddMatrix(one, two, sum, 0, one.length, 0, one.length);
	  
	//ForkJoinPool like ExecutorService automatically provide a pool of threads and API for assigning tasks to it.
	  
	  ForkJoinPool pool = new ForkJoinPool();
	  pool.invoke(mainTask);
	  return sum;
	 }
	 
	 public static double[][] addMatrix(double[][] a, double[][] b)
	 {
		 //sequential matrix addition
		  double[][] result = new double[a.length][a[0].length];
		  for (int i = 0; i < a.length; i++) 
		  {
			  for (int j = 0; j < a[i].length; j++)
			  {
				  result[i][j] = a[i][j] + b[i][j]; 
			  }
		 }
		  return result;
	 }
	 
	 private static class AddMatrix extends RecursiveAction 
	 {
	
	  private final static int THRESHOLD = 100;
	  private double[][] first;	  private double[][] second;	  private double[][] sumofmatix;
	  private int x1forzero;	  private int x2formatrixsize;
	  private int y1forzero;  	  private int y2formatrixsize;

	  public AddMatrix(double[][] a, double[][] b, double[][] c, int x1, int x2, int y1, int y2)
	  {
	   this.first = a;	   this.second = b;	   this.sumofmatix = c;
	   this.x1forzero = x1;  this.x2formatrixsize = x2;   this.y1forzero = y1;   
	   this.y2formatrixsize = y2;   
	  }
	  
	  
	  //override recursive compute method to implements addition of two matrix
	  @Override
	  protected void compute() {
		  //divide the matrix into four task and do calculation 
		  if (((x2formatrixsize - x1forzero) < THRESHOLD) || ((y2formatrixsize - y1forzero) < THRESHOLD)) 
		  {
		   //doing sum of arrays
			  for (int i = x1forzero; i < x2formatrixsize; i++)
			  {
				  for (int j = y1forzero; j < y2formatrixsize; j++) 
				  {
					  sumofmatix[i][j] = first[i][j] + second[i][j]; 
				  }
			  }
		  }
		  else
		  {
			  int midrangematrix1 = (x1forzero + x2formatrixsize) / 2;
			  int midrangematrix2 = (y1forzero + y2formatrixsize) / 2;
			  // The invokeAll() method invokes all of the Callable objects you pass to it in the collection passed as parameter. 
			  //The invokeAll() returns a list of Future objects via which you can obtain the results of the executions of each Callable.
			  invokeAll( new AddMatrix(first, second, sumofmatix, x1forzero, midrangematrix1, y1forzero, midrangematrix2), new AddMatrix(first, second, sumofmatix, midrangematrix1, x2formatrixsize, y1forzero, midrangematrix2),
	    		new AddMatrix(first, second, sumofmatix, x1forzero, midrangematrix1, midrangematrix2, y2formatrixsize),new AddMatrix(first, second, sumofmatix, midrangematrix1, x2formatrixsize, midrangematrix2, y2formatrixsize));
		  }
	  }
 }
	 
	
}

