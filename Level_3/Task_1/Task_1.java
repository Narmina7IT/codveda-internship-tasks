package Level_3.Task_1;

//Task_1.java
import java.util.Scanner;
import static Level_3.Task_1.LibraryService.*;


public class Task_1 {
    public static void CRUD(Scanner s){

        while(true){
            System.out.println("This is a library Management System!\nOptions to do:\n1.Add user\n2.Add book\n3.Borrow book\n4.Return book\n5.Show users\n6.Show books\n7.Show transactions\n8.Update user");
            System.out.println("9.Update book\n10.Delete user\n11.Delete book\n12.Exit");
            System.out.print("Your option: ");
            String answer = s.nextLine();
            switch(answer.toLowerCase()){
                case "1", "add user" -> {
                    System.out.print("Write the name of the user: ");
                    String name = s.nextLine();
                    addUser(name);
                }
                case "2", "add book" -> {
                    System.out.print("Please write the title of the book: ");
                    String title = s.nextLine();
                    System.out.print("The author of the book: ");
                    String author = s.nextLine();
                    addBook(title, author);
                }
                case "3", "borrow book" -> {
                    System.out.print("ENter the user's ID: ");
                    int userId = s.nextInt();
                    s.nextLine();
                    System.out.print("Enter the book's ID: ");
                    int bookId = s.nextInt();
                    borrowBook(userId, bookId);
                }
                case "4", "return book" -> {
                    System.out.print("Enter the book's ID: ");
                    int bookId = s.nextInt();
                    returnBook(bookId);
                }
                case "5", "show users" -> getAllUsers();
                case "6", "show books" -> getAllBooks();
                case "7", "show transactions" -> getAllTransactions();
                case "8", "update user" -> {
                    System.out.print("Which user's information you want to change? Please input the ID: ");
                    int userId = s.nextInt();
                    s.nextLine();
                    System.out.print("Input new name: ");
                    String newName = s.nextLine();
                    updateUser(userId, newName);
                }
                case "9", "update book" -> {
                    System.out.print("Which book's data you want to change? Input it's ID: ");
                    int bookId = s.nextInt();
                    s.nextLine();
                    System.out.print("What do you want to change[title/author]: ");
                    String field = s.nextLine();
                    System.out.print("Enter new value: ");
                    String newValue = s.nextLine();
                    updateBook(bookId, field, newValue);
                }
                case "10", "delete user" -> {
                    System.out.print("Please enter the user's ID: ");
                    int userId = s.nextInt();
                    deleteUser(userId);
                }
                case "11", "delete book" -> {
                    System.out.print("Please enter the book's ID: ");
                    int bookId = s.nextInt();
                    deleteBook(bookId);
                }
                case "12", "exit" -> {
                    System.out.println("You are quitiing.\nGood buy!");
                    return;
                }
                default -> {
                    System.out.println("Inavalid input.PLease try again.");
                }
            }
        }
    }

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        CRUD(s);
    }
}
