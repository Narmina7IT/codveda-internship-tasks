package Level_2;
import java.io.*;


public class Task_2 {
    public static void main(String[] args) {
        //Please prepare the file named Text on your desktop in advance !!!
        try (BufferedReader in = new BufferedReader(new FileReader("/home/hp/Desktop/Text.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("/home/hp/Desktop/Textout.txt"))) {

            String line;
            int lines = 0;
            int wordCounter = 0;
            int chars = 0;

            while ((line = in.readLine()) != null) {
                lines++;
                chars+= line.length();
                String[] words = line.split("[^a-zA-z0-9':;/\\|]+");
                for(String word : words){
                    if(!word.isEmpty()){
                        wordCounter++;
                    }
                }
            }
            out.write("The total number of lines in the file: " + lines);
            out.newLine();
            out.write("Word counter: " + wordCounter);
            out.newLine();
            out.write("The number of characters in the file is: " + chars);
            out.newLine();

            System.out.println("U copied the file sucsessfully!");
        } catch(FileNotFoundException e){
            System.out.println("Error " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
