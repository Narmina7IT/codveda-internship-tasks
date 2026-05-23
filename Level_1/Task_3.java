package Level_1;
import java.util.Scanner;

//Calculation of factorial using recursion
public class Task_3{

    public static int factorial(int n){
        if(n == 1 || n == 0){//factorial of 1 and 0 is 1
            return 1;
        }
        else{

            return n*factorial(n-1);
        }
    }

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Input the number");
        int n = input.nextInt();
        if(n<0){
            System.out.println("There is no factorial function for negative numbers.");
            input.close();
            return;
        }
        System.out.println("The result of "+ n + "! is " + factorial(n) +".");
        
        input.close();
    }
}