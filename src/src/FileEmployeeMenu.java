/*Starting here we introduce a program that you build a piece at a time, adding capabilities to the
program after each chapter as you learn more techniques of computer programming. You may not
have time to work on the project this week, in which case you can use it as a post-class project to
practice what you've learned after this class is over.

Write a program that displays a menu on the screen:

Read the option number, then display a message:

Put your employee program into an infinite loop. Make sure the exit option works so the user can
end the program.

Change the program such that for each option on the menu (except the exit option), your program
will call a method to do the work. Write the methods and, for now, just move the
System.out.print( ) that prints which option you chose into the corresponding method.
Have the method print the message and

Add a class declaration which describes an employee. Include a first name, a last name, a phone
number, a department code, and a salary. Use an array of employee classes as your employee file
— add, delete, view, and list the employees from this array. Finally, have each of your methods
now perform their intended task:
The "new employee" option will prompt and add a new employee to the array.
The "view employee" option will view an entry in the array by prompting for and searching on the
last name (Hint: use equals()).
The "delete employee" option will prompt and delete an employee from the array (put a null value in
the department code to "mark" the employee as deleted).
The "list employees" option will list all non-deleted employees in the array. */
 
package src;
import java.util.*;
import java.io.*;

public class FileEmployeeMenu
{
	public static void main (String [] Args) throws IOException, NullPointerException
	{ 
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		int count = 0;
		int op = 0;
		employee [] employeeFile = new employee[50];
		count = loadFile(employeeFile);

		//System.out.println("DEBUG: " + employeeFile[0].firstName);
		while (true)
		{
			
			int i = 0;
			System.out.println();
			System.out.println("      Employee File           ");
			System.out.println("      _____________            ");
			System.out.println("Option   Description           ");
			System.out.println("______   ___________           ");
			System.out.println("0        Exit                  ");
			System.out.println("1        Enter a new employee  ");
			System.out.println("2        View existing employee");
			System.out.println("3        Delete an employee    ");
			System.out.println("4        List all employees    ");
			System.out.println();
			System.out.print("Please choose an Option: ");
			

			System.out.println();
			op = scanner.nextInt();	
			switch (op)
			{
	
				case 0 :
				saveFile(employeeFile);
				scanner.close();
				return;
				
				case 1:
				employeeFile[count] = newEmployee(count, scanner);
				count = count + 1;
				break;
				
				case 2:
				existingEmployee( employeeFile, count, scanner);
				break;
				
				case 3:
				employeeFile = deleteEmployee( employeeFile, count , scanner);
				break;
	
				case 4:
				listEmployees( employeeFile, count);
				break;
				
				default:
				System.out.println("!! Invalid Entry !! \u0007");
				break;
			}


		}

		
		
	}
			
	public static employee newEmployee(/*employee [] newE,*/ int count, java.util.Scanner scanner)
	{	
		System.out.println("You chose option 1 - Enter a new employee");
		
		System.out.println("Enter Employee First Name: ");
		String newFirst = scanner.next();
		
		System.out.println("Enter Employee Last Name: ");
		String newLast = scanner.next();

		System.out.println("Enter Employee Phone Number: ");
		String newPhone = scanner.next();
		
		System.out.println("Enter Employee Department Code: ");
		int newDeptCode = scanner.nextInt();

		System.out.println("Enter Employee Salary");
		int newSalary = scanner.nextInt();
		
		employee newEmployee = new employee();
		newEmployee.firstName = newFirst;
		newEmployee.lastName = newLast;
		newEmployee.phoneNumber = newPhone;
		newEmployee.deptCode = newDeptCode;
		newEmployee.salary = newSalary;
		
        System.out.println("Employee " + newFirst + " " + newLast
                + " added.");


		return newEmployee;
		


		
		
	}
	public static void existingEmployee (employee [] employeeFile, int count , java.util.Scanner scanner)
	{

		System.out.println("You chose option 2 - View an existing employee");
		System.out.print("Enter the last name of the employee you wish to view: ");
		String searchLast = scanner.next();
		for (int i = 0 ; i < count ; i++)
		{
			if (employeeFile[i].lastName.equals(searchLast))
			{
				System.out.println("First Name:\t" + employeeFile[i].firstName);
				System.out.println("Last Name:\t" + employeeFile[i].lastName);
				System.out.println("Phone:\t\t" + employeeFile[i].phoneNumber);
				System.out.println("Department:\t"+ employeeFile[i].deptCode);
				System.out.println("Salary:\t\t" + employeeFile[i].salary);
				
			}

		}
		
		
	}
	public static employee[] deleteEmployee (employee [] employeeFile, int count , java.util.Scanner scanner)
	{
		employee [] deleteEmployee = new employee [50];
		System.out.println("You chose option 3 - Delete an employee");
		System.out.print("Enter the first name of the employee you wish to delete: ");
		String deleteFirst = scanner.next();
		System.out.print("Enter the last name of the employee you wish to delete");
		String deleteLast = scanner.next();
		
		for (int i = 0 ; i < count ; i++)
		{
			if (employeeFile[i].lastName.equals(deleteLast) && employeeFile[i].firstName.equals(deleteFirst))
			{
				employeeFile[i].deptCode = 0;
				System.out.println("You have deleted " + employeeFile[i].firstName + " " + employeeFile[i].lastName);
			}
		deleteEmployee = employeeFile;

		}
		return deleteEmployee;
	
		
	}
	public static void listEmployees ( employee [] employeeFile, int count)
	{

		System.out.println("You chose option 4 - List all employees");
		//System.out.println("First\tLast\tPhone\tDept\tSalary");
		for (int i = 0 ;  i < count ; i++)
		{
			if (employeeFile[i].deptCode != 0)
			{
				System.out.println(employeeFile[i].firstName +"\t" + employeeFile[i].lastName +"\t" + employeeFile[i].phoneNumber +"\t" + employeeFile[i].deptCode +"\t" + employeeFile[i].salary);
			}
		}
	}
public static int loadFile(employee[] ees) {
    int count = 0;
    try {
        FileInputStream fis = new FileInputStream("EmployeeMenu.dat");
        DataInputStream in = new DataInputStream(fis);

        for (; count < ees.length && in.available() > 0; count++) {
            String fName = in.readUTF();
            String lName = in.readUTF();
            String phone = in.readUTF();
            int dept = in.readInt();
            int salary = in.readInt();

            employee ee = new employee();
            ee.firstName = fName;
            ee.lastName = lName;
            ee.phoneNumber = phone;
            ee.deptCode = dept;
            ee.salary = salary;
            ees[count] = ee;
        }
        in.close();
    } 
    catch (FileNotFoundException fnfe) {
        // Don't do anything if file doesn't exist
    } 
    catch (IOException ioe) {
        System.err.println("Error reading file");
        System.exit(1);
    }
    return count;
}


	public static void saveFile(employee [] employeeFile) throws IOException , NullPointerException
	{
		try
		{
			FileOutputStream outputFile = new FileOutputStream("EmployeeMenu.dat");
			DataOutputStream dataSave = new DataOutputStream(outputFile);
		
		
		for ( int i = 0 ; i < 50 ; i++)
		{
			employee saveFile = employeeFile [ i ] ;
			if (saveFile != null) {
			dataSave.writeUTF(saveFile.firstName);
			dataSave.writeUTF(saveFile.lastName);
			dataSave.writeUTF(saveFile.phoneNumber);
			dataSave.writeInt(saveFile.deptCode);
			dataSave.writeInt(saveFile.salary);
		}
		}
		outputFile.close();

		}
		catch (IOException ioe)
		{
			System.err.println("Error Writing File");
			System.exit(1);
		}
	}
}
	
