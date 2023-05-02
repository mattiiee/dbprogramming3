package dbprogramming3;

import java.sql.*;

public class LAB9 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root";
        String password = "mysql@sit";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection con = DriverManager.getConnection(URL,username,password);
            System.out.println("Database Connected");
            Statement statement = con.createStatement();
            String sql = "insert into student(studentID,firstname,lastname,email,deptID) " +
                    "values('11111','aaaa','bbbb','aaaa@gmailc.com','IT')";

            statement.executeUpdate(sql);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
