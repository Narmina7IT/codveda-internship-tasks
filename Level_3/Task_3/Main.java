package Level_3.Task_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Hello! This is a BST program.");

        while(true){
            System.out.println("\nSearch Tree.\nChoose your options:\n1.Insert\n2.Delete\n3.Search\n4.Traverse\n5.Show the tree\n6.Exit");
            System.out.print("Your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch(choice){
                case 1 -> {
                    System.out.print("What input: ");
                    int n = s.nextInt();
                    bst.insert(n);
                    System.out.println("Inserted: " + n);
                }
                case 2 ->{
                    System.out.print("What input: ");
                    int n = s.nextInt();
                    bst.delete(n);
                    System.out.println("Deleted: " + n);
                }
                case 3 ->{
                    System.out.print("What input: ");
                    int n = s.nextInt();
                    boolean found = bst.search(n);
                    System.out.println(found ? "Found" : "Not found");
                }
                case 4 ->{
                    System.out.print("Using order[pre/post/in]: ");
                    String answer = s.nextLine();
                    if(answer.equalsIgnoreCase("pre")){
                        bst.preorder();
                    } else if (answer.equalsIgnoreCase("post")){
                        bst.postorder();
                    } else if (answer.equalsIgnoreCase("in")){
                        bst.inorder();
                    } else {
                        System.out.println("Invalid order type. Please try again");
                    }
                }
                case 5 ->{
                    bst.printTree();
                }
                case 6 ->{
                    System.out.println("Good Bye!");
                    return;
                }
            }
        }
    }
}
