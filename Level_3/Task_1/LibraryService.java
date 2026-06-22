//LibraryService.java
package Level_3.Task_1;
import java.sql.*;

public class LibraryService {

    public static void addUser(String name) {
        String sql = "INSERT INTO USERS (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConn();
             PreparedStatement prepstmt = conn.prepareStatement(sql)) {
            prepstmt.setString(1, name);
            prepstmt.executeUpdate();
            System.out.println("The user is added to the system.");
        } catch (SQLException e) {
            System.out.println("THere is an error!" + e.getMessage());
        }
    }

    public static void addBook(String title, String author) {
        String sql = "INSERT INTO BOOKS (title,author) VALUES (?,?)";
        try (Connection conn = DatabaseConnection.getConn();
             PreparedStatement prepstmt = conn.prepareStatement(sql)) {
            prepstmt.setString(1, title);
            prepstmt.setString(2, author);
            prepstmt.executeUpdate();
            System.out.println("The book is added: " + title);
        } catch (SQLException e) {
            System.out.println("There is an error! " + e.getMessage());
        }
    }

    public static void borrowBook(int userId, int bookId) {

        String sql = "INSERT INTO TRANSACTIONS (user_id, book_id, borrow_date, status) SELECT ?, ?, CURDATE(), 'BORROWED' WHERE EXISTS (SELECT 1 FROM USERS WHERE id = ?)"+
                     "AND EXISTS (SELECT 1 FROM BOOKS WHERE id = ?) " +
                     "AND NOT EXISTS (SELECT 1 FROM TRANSACTIONS WHERE book_id = ? AND status = 'BORROWED')";

        try (Connection conn = DatabaseConnection.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            ps.setInt(3, userId);
            ps.setInt(4, bookId);
            ps.setInt(5, bookId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("You borrowed book sucessfully!");
            } else {
                System.out.println("You can't borrow book (invalid user/book or already borrowed).");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void returnBook(int bookId){

        String sql = "UPDATE TRANSACTIONS SET return_date = CURDATE(), status = 'RETURNED' WHERE book_id = ? AND status = 'BORROWED'";

        try (Connection conn = DatabaseConnection.getConn();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, bookId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("You borrowed book sucessfully!");
            } else {
                System.out.println("You can't borrow book (book is not existiong/is returned).");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void getAllUsers() {
        String sql = "SELECT * FROM USERS";
        try (Connection conn = DatabaseConnection.getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("name") + ".");
            }
        } catch (SQLException e) {
            System.out.println("There is an error!" + e.getMessage());
        }
    }

    public static void getAllBooks() {
        String sql = "SELECT * FROM BOOKS";
        try (Connection conn = DatabaseConnection.getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("title") + " - " + rs.getString("author"));
            }
        } catch (SQLException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public static void getAllTransactions() {
        String sql = "SELECT * FROM TRANSACTIONS";
        try (Connection conn = DatabaseConnection.getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("%d. the book's id: %d. user's id: %d. borrowed: %s - returned: %s.\n", rs.getInt("id"), rs.getInt("book_id"), rs.getInt("user_id"), rs.getDate("borrow_date"), rs.getDate("return_date"));
            }
        } catch (SQLException e) {
            System.out.println("There si ab error!" + e.getMessage());
        }
    }

    public static void updateUser(int userId, String newName){

        try(Connection conn = DatabaseConnection.getConn()){

            String sql1 = "SELECT 1 FROM USERS WHERE id = ?";
            try (PreparedStatement prepstmt = conn.prepareStatement(sql1)) {

                prepstmt.setInt(1, userId);
                try (ResultSet rs = prepstmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("There is no user with such ID.");
                        return;
                    }
                }
            }

            String sql = "UPDATE USERS SET name = ? WHERE id = ?";
            try(PreparedStatement prepstmt = conn.prepareStatement(sql)){
                prepstmt.setString(1, newName);
                prepstmt.setInt(2, userId);
                prepstmt.executeUpdate();
                System.out.println("The user with " + userId + " id is updated!");
            }

        } catch (SQLException e) {
            System.out.println("There is an error!" + e.getMessage());
        }

    }

    public static void updateBook(int bookId, String field,String newValue){
        try(Connection conn = DatabaseConnection.getConn()){

            String sql1 = "SELECT 1 FROM BOOKS WHERE id = ?";
            try (PreparedStatement prepstmt = conn.prepareStatement(sql1)) {

                prepstmt.setInt(1, bookId);
                try (ResultSet rs = prepstmt.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("There is no book with such ID.");
                        return;
                    }
                }
            }

            String sql;
            if(field.equalsIgnoreCase("title")){
                sql = "UPDATE BOOKS SET title = ? WHERE id = ?";
            } else if(field.equalsIgnoreCase("author")){
                sql = "UPDATE BOOKS SET author = ? WHERE id = ?";
            } else{
                System.out.println("Invalid field!");
                return;
            }

            try(PreparedStatement prepstmt = conn.prepareStatement(sql)){
                prepstmt.setString(1, newValue);
                prepstmt.setInt(2, bookId);
                prepstmt.executeUpdate();
                System.out.println("The book with " + bookId + " id is updated!");
            }

        } catch (SQLException e) {
            System.out.println("There is an error!" + e.getMessage());
        }

    }

    public static void deleteUser(int userId){
        try(Connection conn = DatabaseConnection.getConn()){

            String sql1 = "DELETE FROM TRANSACTIONS WHERE user_id = ?";
            try(PreparedStatement prepstmt = conn.prepareStatement(sql1)){
                prepstmt.setInt(1,userId);
                prepstmt.executeUpdate();
            }

            String sql2 = "DELETE FROM USERS WHERE id = ?";
            try(PreparedStatement prepstmt = conn.prepareStatement(sql2)){
                prepstmt.setInt(1,userId);

                int rows = prepstmt.executeUpdate();
                if(rows > 0){
                    System.out.println("the user has been deleted sucessfully!");
                } else{
                    System.out.println("NO user with such ID is found.");
                }
            }

        } catch (SQLException e) {
            System.out.println("There is an error!" + e.getMessage());
        }

    }

    public static void deleteBook(int bookId){
        try(Connection conn = DatabaseConnection.getConn()){

            String sql1 = "DELETE FROM TRANSACTIONS WHERE book_id = ?";
            try(PreparedStatement prepstmt = conn.prepareStatement(sql1)){
                prepstmt.setInt(1,bookId);
                prepstmt.executeUpdate();
            }

            String sql2 = "DELETE FROM BOOKS WHERE id = ?";
            try(PreparedStatement prepstmt = conn.prepareStatement(sql2)){
                prepstmt.setInt(1,bookId);

                int rows = prepstmt.executeUpdate();
                if(rows > 0){
                    System.out.println("the book is deleted!");
                } else{
                    System.out.println("No book with such ID is found.");
                }
            }

        } catch (SQLException e) {
            System.out.println("There is an error!" + e.getMessage());
        }


    }

}
