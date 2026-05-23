package Level_1;
import java.util.Random;
import java.util.Scanner;

//Guessing number using random every step(computer generates and we guess)
public class Task_2{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.printf("Hello! I'm computer, programmed to find the number you thought.\nYou can give me number of attempts, in which You will try to guess.\nThe number of attempts: ");
        int attempts = input.nextInt();
        input.nextLine();
        System.out.println("I will guess the number between 0 and 100.\nLet's start!");
        int guessed_number = random.nextInt(0,101);

        for(int i =1; i<=attempts; i++){

            if(!input.hasNextInt()){
                System.out.println("Please write valid inputs.");
                input.nextLine();
                i--;
                continue;
            }

            int number = input.nextInt();

            if((i == attempts) && !(number == guessed_number)){
                System.out.println("You culdn't acknowledge my number! I win!\nThe number was "+ guessed_number + ".");
            }
            else if(number == guessed_number){
                System.out.println("Yes! You are right! The number I guessed is "+ guessed_number+".");
                break;
            }
            else if(number > guessed_number){
                System.out.println("too high");
            }
            else if(number < guessed_number){
                System.out.println("too low");
            }
        }

        input.close();
    }
}