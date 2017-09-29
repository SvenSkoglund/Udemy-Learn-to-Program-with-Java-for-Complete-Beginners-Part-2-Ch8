/*
 * Write a program that writes "Hello, world!" to a file. View the file with a text editor to see if your
program worked.
 */


package src;
import java.io.*;
public class HelloFile {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("HelloWorld.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.println("Hello, World!");
		fw.close();
		
	}

}
