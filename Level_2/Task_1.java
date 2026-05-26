package Level_2;
import java.util.ArrayList;
import java.util.Scanner;


public class Task_1 {

    public static class Employee{
        String name;
        String surname;
        int ID;
        String job_title;
        int salary;

        //constructor
        public Employee(String name, String surname, int ID, String job_title, int salary){
            this.name = name;
            this.surname= surname;
            this.ID= ID;
            this.job_title = job_title;
            this.salary = salary;

        }

        //getters
        public String getName() {
            return name;
        }
        public String getSurname(){
            return surname;
        }
        public int getID(){
            return ID;
        }
        public String getJob_title(){
            return job_title;
        }
        public int getSalary(){
            return salary;
        }

        @Override
        public String toString(){
            return name + " | " + surname + " | " + ID + " | " + job_title + " | $" + salary;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList <Employee> employees = new ArrayList<>();

        while(true){
            System.out.println("\nBanking program:\n");
            System.out.println("1.Create\n2.Read\n3.Update\n4.Delete\n5.Exit\nEnter your choice [1-5]");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1 -> adding(s, employees);
                case 2 -> readAll(employees);
                case 3 -> update(s,employees);
                case 4 -> delete(s,employees);
                case 5 -> {
                    s.close();
                    return;
                }
                default -> System.out.println("Invalid input. PLease input from 1 to 5.");
            }
        }
    }

    public static void adding(Scanner s, ArrayList<Employee> employees){
        System.out.println("\nAdd new employee: ");

        System.out.print("Please input information needed: name: ");
        String name = s.nextLine();

        System.out.print("surname: ");
        String surname = s.nextLine();

        System.out.print("Identification number: ");
        int ID = s.nextInt();
        s.nextLine();

        System.out.print("job title: ");
        String job_title = s.nextLine();

        System.out.print("salary: ");
        int salary = s.nextInt();
        s.nextLine();

        Employee newEmployee = new Employee(name,surname,ID,job_title,salary);
        employees.add(newEmployee);

        System.out.println("You added new employee sucesfully!");
        System.out.println(newEmployee);
    }

    public static void readAll(ArrayList<Employee> employees){
        System.out.println("All employees:");

        if(employees.isEmpty()){
            System.out.println("There is no employees.");
            return;
        }

        System.out.printf("%-4s | %-12s | %-15s | %-8s | %-20s | %-7s%n", "N", "Name", "Surname", "ID", "Job Title", "Salary");

        for(int i =0; i < employees.size(); i++){
            Employee e = employees.get(i);
            System.out.printf("%-4d | %-12s | %-15s | %-8d | %-20s | $%-6d%n",(i+1), e.name, e.surname, e.ID, e.job_title, e.salary);
        }
        System.out.println("\nThe total number of employees in list is: "+ employees.size());
    }

    public static void update(Scanner s, ArrayList<Employee> employees){
        if(employees.isEmpty()){
            System.out.println("The list is empty. There is nothing to update.");
            return;
        }

        readAll(employees);
        System.out.print("Input the employee's number in the list: ");
        int index = s.nextInt();
        s.nextLine();
        index--;

        if( index < 0 || index >= employees.size()){
            System.out.println("The input is invalid.");
            return;
        }

        Employee upd_emp = employees.get(index);
        System.out.println("Updationg:\n" + upd_emp);

        while(true) {
            System.out.println("If you want to exit, please write [esc].\n\bWrite what do you want to update:");
            String answer = s.nextLine().toLowerCase();

            switch (answer) {
                case "name" -> {
                    System.out.println("The current name is " + upd_emp.name);
                    String newName = s.nextLine();
                    if (!newName.isEmpty()) {
                        upd_emp.name = newName;
                    }
                }
                case "surname" -> {
                    System.out.println("The current surname is " + upd_emp.surname);
                    String newSurname = s.nextLine();
                    if (!newSurname.isEmpty()) {
                        upd_emp.surname = newSurname;
                    }
                }
                case "job title" -> {
                    System.out.println("The current job_title is " + upd_emp.job_title);
                    String newJob_title = s.nextLine();
                    if (!newJob_title.isEmpty()) {
                        upd_emp.job_title = newJob_title;
                    }
                }
                case "salary" -> {
                    System.out.println("The current salary is " + upd_emp.salary);
                    int newSalary = s.nextInt();
                    s.nextLine();
                    upd_emp.salary = newSalary;
                }
                case "id" ->{
                    System.out.println("The current ID is " + upd_emp.ID);
                    int newID = s.nextInt();
                    s.nextLine();
                    upd_emp.ID = newID;
                }
                case "all" -> {
                    System.out.println("The current name is " + upd_emp.name);
                    String n = s.nextLine();
                    if(!n.isEmpty()) upd_emp.name = n;

                    System.out.println("The current surname is " + upd_emp.surname);
                    String surn = s.nextLine();
                    if(!surn.isEmpty()) upd_emp.surname = surn;

                    System.out.println("The current job_title is " + upd_emp.job_title);
                    String jt = s.nextLine();
                    if(!jt.isEmpty()) upd_emp.job_title = jt;

                    System.out.println("The current ID is " + upd_emp.ID);
                    int newID = s.nextInt();
                    upd_emp.ID = newID;

                    System.out.println("The current salary is " + upd_emp.salary);
                    int sal = s.nextInt();
                    upd_emp.salary = sal;

                    System.out.println("All fields are updated!");
                    return;
                }
                case "esc" -> {
                    System.out.println("You are exiting.");
                    return;
                }
                default -> {
                    System.out.println("Invalid input!");
                }
            }
        }
    }

    public static void delete(Scanner s, ArrayList<Employee> employees){
        if(employees.isEmpty()){
            System.out.println("The list is empty! You can't delete anything.");
            return;
        }

        readAll(employees);
        System.out.print("\nINput the number of employee in this list: ");
        int index = s.nextInt();
        index--;

        if( index < 0 || index >= employees.size()){
            System.out.println("The input is invalid.");
            return;
        }

        Employee removed = employees.remove(index);
        System.out.println("You delete the employee sucsefully.\nDeleted employee:\n" + removed);
    }
}