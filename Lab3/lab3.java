import java.util.Scanner;
import java.util.Arrays;

public class lab3 {
// function to calculate mean
public static float mean(int[] arr) {
int count = 0;
for (int i = 0; i < arr.length; i++) {
count += arr[i];
}
return count / arr.length;
}
// function to calculate median
public static float median(int[] arr) {
    Arrays.sort(arr);
    int middleval = arr.length / 2;  
    if(arr.length % 2 == 0) {
        return  (arr[middleval - 1] + arr[middleval]) / 2; 
    } else {
        return arr[middleval]; 
    }
}

// function to calculate mode
public static float mode(int[] arr) {
    int maxval = 0;
    int mode = 0;
    for(int i =0;i<arr.length;i++){
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == arr[i]) { 
                count++;
            }
        }
        if(count>maxval){
            mode = arr[i];      
            maxval = count;
        }
    }
    return mode;
}

public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    // take input from user for number of elements
    System.out.print("Enter the number of elements to enter: ");
    int n = scanner.nextInt();

    // initialize an array of n elements
    int[] arr = new int[n];

    // take input from user for n elements and store them in the array
    System.out.print("Enter " + n+" integers: ");
    for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
    }
    
    int options;

    // loop until user enters an invalid input
    do {
        // display menu to user
        System.out.println("1. To Find mean" + "2. Find median" + "3. Find mode");
        System.out.print("Enter your input: ");
        options = scanner.nextInt();
        scanner.nextLine();
        switch (options) {
            case 1:
                // call mean function and display result
                float mean = mean(arr);
                System.out.println("The mean of the given array is: " + mean);
                break;
            case 2:
                // call median function and display result
                float median = median(arr);
                System.out.println("The median of the given array is : " + median);
                break;
            case 3:
                // call mode function and display result
                float mode = mode(arr);
                System.out.println("The mode of the given array is : " + mode);
                break;
            default:
                // display message for invalid input
                System.out.println("Invalid Input");
                break;
        }
    } while(options<=3);

}
}
