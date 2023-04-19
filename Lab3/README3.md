Create a java program that performs the following operation:
The program should collect an integer array from the user
After the array is entered, you need to create a menu of items
Find the Mean Value
Find the Median Value
Find the Mode Value
From the user-given array.
The program should have a minimum of 3 functions apart from the main function; each of the functions implements the Mean, Median, and Mode computation by accepting the array user has entered as a parameter and returning the value as a result. From the main method, you will display the result.

This is a Java program that allows the user to input an array of integers and then choose to calculate the mean, median, or mode of that array.

The program starts by importing the Scanner and Arrays classes. It then defines three methods to calculate the mean, median, and mode of an array of integers respectively.

The mean() method calculates the sum of all the elements in the array and divides it by the length of the array to find the mean.

The median() method sorts the array and then checks if the length of the array is even or odd. If it is even, it returns the average of the middle two elements. If it is odd, it returns the middle element.

The mode() method finds the mode of the array by counting how many times each element appears in the array and selecting the element with the highest count as the mode.

In the main method, the program prompts the user to input the number of elements they want to enter and then reads in the integers from the user. It then enters a loop where it prompts the user to choose to calculate the mean, median, or mode of the array. If the user chooses an invalid option, the program prints an error message and continues the loop. If the user chooses a valid option, the program calls the corresponding method and prints the result. The loop continues until the user chooses an option greater than 3.


The flow chart of the same has been attached:
![Untitled Diagram](https://user-images.githubusercontent.com/118504105/219405075-4b50e9aa-0739-4b4c-8024-8c765cce247f.jpg)
