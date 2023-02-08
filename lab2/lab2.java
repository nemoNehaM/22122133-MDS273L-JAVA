import java.util.Scanner;

public class lab2{
    static String[] names = new String[1024];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Enter a Name");
            System.out.println("2. Search a Name");
            System.out.println("3. Remove a Name");
            System.out.println("4. Show all Names");
            System.out.print("Enter an option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:{
                System.out.print("Enter a name: ");
                String name = sc.next();
        
                for (int i = 0; i < count; i++) {
                    if (names[i].equalsIgnoreCase(name)) {
                        System.out.println("Name already exists.");
                        return;
                    }
                }
        
                names[count++] = name;
                System.out.println("Name has been added.");
            }
                    break;
                case 2:{
                System.out.print("Search for a name: ");
                String name = sc.next();
        
                int index = -1;
                for (int i = 0; i < count; i++) {
                    if (names[i].equalsIgnoreCase(name)) {
                        index = i;
                        break;
                    }
                }
        
                if (index == -1) {
                    System.out.println("Name not in array.");
                } else {
                    System.out.println("Name" + index);
                }
            }
                    break;
                case 3:{
                System.out.print("Enter a name to remove: ");
                String name = sc.next();
        
                int index = -1;
                for (int i = 0; i < count; i++) {
                    if (names[i].equalsIgnoreCase(name)) {
                        index = i;
                        break;
                    }
                }
        
                if (index == -1) {
                    System.out.println("Name not in array.");
                } else {
                    for (int i = index; i < count - 1; i++) {
                        names[i] = names[i + 1];
                    }
                    count--;
                    System.out.println("Name removed.");
                }
            }
                    break;
                case 4:
                {
                    if (count == 0) {
                    System.out.println("No names in array.");
                    return;
                }
                
                System.out.println("All names in the array:");
                for (int i = 0; i < count; i++) {
                System.out.println(i + ". " + names[i]); }
                    
                }
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);

        sc.close();
    }
}
    