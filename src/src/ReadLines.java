//Using a text editor, create a file with several lines of text. Write a program to read the lines from the
//file (in a loop) and display them.


package src;
import java.io.*;

public class ReadLines {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("ReadLines.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line1 = "";		
		while (line1 != null)
		{
			line1 = br.readLine();

			if (line1 == null) {
				break;
			}
			System.out.println(line1);
		}
		fr.close();
		
		
		
			
	}

}
