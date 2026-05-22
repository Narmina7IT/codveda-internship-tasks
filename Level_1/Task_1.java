package Level_1;
import java.util.Scanner;

//Simple Calculator
public class Task_1{

    public static float addition(float a, float b){
        return a+b;
    }

    public static float substraction(float a, float b){
        return a-b;
    }

    public static float multiplication(float a, float b){
        return a*b;
    }

    public static float division(float a, float b){
        if(b==0){
            throw new IllegalArgumentException("You can NOT divide by zero!");
        }
        return a/b;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Input the first number:");
        float a = input.nextFloat();
        System.out.println("Input the second number:");
        float b = input.nextFloat();
        input.nextLine();

        System.out.println("What kind of arithmetic operation u want?");
        String operation = input.nextLine();

        float result;

        switch (operation){
            case "addition", "+" -> result = addition(a,b);

            case "substraction", "-" ->  result = substraction(a,b);

            case "multiplication","*" -> result = multiplication(a,b);

            case "division", "/" -> result = division(a,b);

            default -> {
                System.out.println("Unknown operation!");
                input.close();
                return;
            }
        }

        if(result==(int)result){
            System.out.println("The result is: "+ (int)result);
        }
        else {
            System.out.println("The result is: "+ result);
        }

        input.close();
    }
}