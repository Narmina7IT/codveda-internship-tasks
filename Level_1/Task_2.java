package Level_1;
import java.util.Random;
import java.util.Scanner;

//Number guessing game
public class Task_2{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Hello! I generated a number between 0 and 100.");
		System.out.println("Try to guess it!");
        System.out.println("How many attempts do you want?");
		int attempts = input.nextInt();
        System.out.println("The number is between 0 and 100. Try to guess the number. Let's start!");
        int secretNumber = random.nextInt(101);

        for(int i =1; i<=attempts; i++){

            if(!input.hasNextInt()){
                System.out.println("Please write valid inputs.");
                input.nextLine();
                i--;
                continue;
            }

            int number = input.nextInt();

            if(i == attempts && !(number == secretNumber)){
                System.out.println("You culdn't acknowledge my number! I win!\nThe number was "+ secretNumber + ".");
            }
            else if(number == secretNumber){
                System.out.println("Yes! You are right! The secret number was "+ secretNumber+".");
                break;
            }
            else if(number > secretNumber){
                System.out.println("too high. Attempts left: " + (attempts -i));
            }
            else if(number < secretNumber){
                System.out.println("too low. Attempts left: " + (attempts -i));
            }
        }

        input.close();
    }
}
