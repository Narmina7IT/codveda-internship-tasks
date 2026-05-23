package Level_1.Task_2;
import java.util.Random;
import java.util.Scanner;

//here we guess the number
//Guessing number using random every step!!!
public class Task_2_opposite2{

    public static int guessing(int min, int max, Random random){

        return random.nextInt(min, max +1);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Hello! I'm computer, programmed to find the number you thought.\nYou can give me number of attempts, in which I will try to guess: ");
        int attempts = input.nextInt();
        input.nextLine();
        System.out.println("Now I know everything. We can start!");
        int min = 0;
        int max = 100;
        int i, guessednumber=0;
        boolean isWon = false;

        for(i =1; i<=attempts; i++){
            
            guessednumber = guessing(min, max, random);
            System.out.println("I guess it's: "+ guessednumber +"\nYour answers should be [too high/too low/yes]");
            String answer = input.nextLine();
          
            if(answer.equals("too high")){
                max = guessednumber - 1;
            }
            else if(answer.equals("too low")){
                min = guessednumber + 1;
            }
            else if(answer.equals("yes")){
                isWon = true;
                break;
            }
            else{
                System.out.println("Please write valid answers.");
                i--;
                continue;
            }

            //if we lie to computer
            if(min> max){
                break;
            }
        }

        if(isWon == true){
            System.out.println("Yes! I'm right! Your number is: "+ guessednumber +".\nI guessed it in " + i+ " attempts.");
        }
        else if(min> max){
            System.out.println("Wait! Your answers are contradicting! I don't want to play with u!");
        }
        else{
            System.out.println("I couldn't guess your number in "+ attempts + " attempts. You win!");
        }

        input.close();
    }
}
