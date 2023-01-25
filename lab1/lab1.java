import java.util.Scanner;
class lab1{
    public static void main (String[]args){
        Scanner obj = new Scanner(System.in);  
        System.out.print("Enter your user name:");
        String userInput = obj.nextLine();
        Scanner obj1 = new Scanner(System.in);  
        System.out.print("Enter your user Age:");
        Integer userInput1 = obj1.nextInt();
        Scanner obj2 = new Scanner(System.in); 
        System.out.print("Enter your user class:");
        String userInput2 = obj2.nextLine();
        Scanner obj3 = new Scanner(System.in);  
        System.out.print("Enter your Gender(as'm' or 'f')");
        char userInput3 = obj3.next().charAt(0);
        Scanner obj4 = new Scanner(System.in);  
        System.out.print("Enter your orgin State");
        String userInput4 = obj4.nextLine();
        System.out.println("Name:"+userInput+"\nAge :"+userInput1+"\nClass :"+userInput2+"\nGender :"+userInput3+"\nState :"+userInput4);

        if (userInput3 == 'm') 
        {
            System.out.println("MALE");
        }
        else if (userInput3 == 'f')
        {
            System.out.println("FEMALE");
        }
        else
        {
            System.out.println("INVALID INPUT");
        }

        switch (userInput4) {  
            case "Himachal Pradesh":
            System.out.println("The Student is from the northern states of India");
            break;
            case "Punjab":
            System.out.println("The Student is from the northern states of India");
            break;
            case "Uttarakhand":
            System.out.println("The Student is from the northern states of India");
            break;
            case "Uttar Pradesh" :
            System.out.println("The Student is from the northern states of India");
            break;
            case "Haryana":
            System.out.println("The Student is from the northern states of India");
            break;   
            case "Madhya Pradesh" :
            System.out.println("The Student is from the northern states of India");
            break;
            case "Chhattisgarh":
            System.out.println("The Student is from the northern states of India");
            break;  
            case "Rajasthan":
            System.out.println("The Student is from the western states of India");
            break;
            case "Gujarat":
            System.out.println("The Student is from the western states of India");
            break;
            case "Goa":
            System.out.println("The Student is from the western states of India");
            break;
            case "Maharashtra":
            System.out.println("The Student is from the western states of India");
            break; 
            case "Bihar":
            System.out.println("The Student is from the eastern states of India");
            break;
            case "Orissa":
            System.out.println("The Student is from the eastern states of India");
            break;
            case "West Bengal":
            System.out.println("The Student is from the eastern states of India");
            break;
            case "Assam":
            System.out.println("The Student is from the eastern states of India");
            break;
            case "Tamil Nadu":
            System.out.println("The Student is from the southern states of India");
            break;
            case "Karnataka":
            System.out.println("The Student is from the southern states of India");
            break;
            case "AP":
            System.out.println("The Student is from the southern states of India");
            break;
            case "Kerela":
            System.out.println("The Student is from the southern states of India");
            break;
            default:
            System.out.println("State not available");
                break;
        }
    }
}
