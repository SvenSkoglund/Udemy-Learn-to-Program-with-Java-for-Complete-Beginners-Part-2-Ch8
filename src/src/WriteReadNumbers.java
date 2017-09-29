//Using a text editor, create a file containing a list of floating point numbers, one number per line.
//Write a program to read the numbers into an array, and then compute and print their average.


package src;
import java.io.*;
import java.util.*;
public class WriteReadNumbers {

	public static void main(String[] args) throws IOException {
			Scanner scanner = new Scanner(System.in);
			FileWriter numWriter = new FileWriter("WriteReadNumbers.txt");
			PrintWriter numPrinter = new PrintWriter(numWriter);			
			FileReader numReader = new FileReader("WriteReadNumbers.txt");
			BufferedReader buffNum = new BufferedReader(numReader);
						
			float num [] = new float[10];
			float numSum = 0;
			int count = 10;

			int i;
			for( i = 0 ; i < count ; i++)
			{
				System.out.println("Enter number " + (i+1) + ": ");
				numPrinter.println(scanner.nextLine());								 			}
			scanner.close();
			numWriter.close();
			numPrinter.close();

			for ( i = 0 ; i < count ; i++) {
				num[i]=Float.parseFloat(buffNum.readLine());
//				System.out.println("DEBUG: Print number " + i + ": " + num[i]);
				numSum = numSum + num[i];
				
			}
			System.out.println("The average of the numbers entered is: " + (numSum/i));
				
			
			
			
			
			
			
			
			
			
	}

}
