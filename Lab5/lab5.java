// Importing the required packages
import java.util.*;

// Defining a Student class with the required fields and methods
class Student {
String RegNo;
String Name;
String Email;
String Phone;
String Class;
String Department;
// Defining a constructor to initialize the fields of the class
public Student(String RegNo, String Name, String Email, String Phone, String Class, String Department) {
    this.RegNo = RegNo;
    this.Name = Name;
    this.Email = Email;           
    this.Phone = Phone;
    this.Class = Class;
    this.Department = Department;
}

// Method to print the details of a student
public void printDetails() {                        
    System.out.println("Register No.: " + RegNo);
    System.out.println("Name: " + Name);
    System.out.println("Email: " + Email);
    System.out.println("Phone: " + Phone);
    System.out.println("Class: " + Class);
    System.out.println("Department: " + Department);
}

// Method to get the Registration Number of a student
public String getRegNo() {
    return RegNo;             
}

// Method to get the Name of a student
public String getName() {
    return Name;                
}
// Importing the required packages
import java.util.*;

// Defining a Student class with the required fields and methods
class Student {
String RegNo;
String Name;
String Email;
String Phone;
String Class;
String Department;

csharp
Copy code
// Defining a constructor to initialize the fields of the class
public Student(String RegNo, String Name, String Email, String Phone, String Class, String Department) {
    this.RegNo = RegNo;
    this.Name = Name;
    this.Email = Email;           
    this.Phone = Phone;
    this.Class = Class;
    this.Department = Department;
}

// Method to print the details of a student
public void printDetails() {                        
    System.out.println("Register No.: " + RegNo);
    System.out.println("Name: " + Name);
    System.out.println("Email: " + Email);
    System.out.println("Phone: " + Phone);
    System.out.println("Class: " + Class);
    System.out.println("Department: " + Department);
}

// Method to get the Registration Number of a student
public String getRegNo() {
    return RegNo;             
}

// Method to get the Name of a student
public String getName() {
    return Name;                
}
}

// Main class to implement the functionality of the program
public class lab5 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Student[] students = new Student[100]; // Creating an array to store the student objects
int count = 0; // Initializing the counter variable
int choice; // Initializing the variable to store user choice
    do {

        System.out.println();

        // Displaying the menu options
        System.out.println("1. Add a student");
        System.out.println("2. Search for a student");
        System.out.println("3. Display all students");
        
        
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt(); // Reading user choice
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                // Adding a new student
                System.out.print("Enter the Registration no: ");
                String RegNo = scanner.nextLine();
                System.out.print("Enter the Name of student: ");
                String Name = scanner.nextLine();
                System.out.print("Enter the Email: ");
                String Email = scanner.nextLine();
                System.out.print("Enter the Phone: ");
                String Phone = scanner.nextLine();
                System.out.print("Enter the class: ");
                String Class = scanner.nextLine();
                System.out.print("Enter the Department: ");
                String Department = scanner.nextLine();
                students[count] = new Student(RegNo, Name, Email, Phone, Class, Department); // Creating a new student object and storing it in the array
                count  += 1; // Incrementing the counter variable
                break;
            case 2:
                // Searching for a student
                System.out.print("Enter the name of the student: ");
                String find_name = scanner.nextLine();
                System.out.print("Enter the Registraion no of the student: ");
                String find_reg = scanner.nextLine();
                for (int i = 0; i < count; i++) {
                    if (students[i].getName().equals(find_name) && students[i].getRegNo().equals(find_reg)) { // Checking if the name and registration number match
                        students[i].printDetails(); // Printing the details of the student
                        break;
                    }
                    if (i == count - 1) { // If no student is found
                        System.out.println("No student found.");
                    }
               
            case 3:
                // Display all students
                if (count == 0) {
                    System.out.println("No students added yet.");
                } else {
                    System.out.println("List of students:");
                    for (int i = 0; i < count; i++) {
                        students[i].printDetails();
                        System.out.println();
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    } while(choice <= 3);
    
    scanner.close(); // Close the scanner to free resources
}
}
