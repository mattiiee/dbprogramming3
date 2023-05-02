package dbprogramming3;

import java.sql.*;

public class Dbprogramming3 {
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
            String sql = "select * from student";
            ResultSet results = statement.executeQuery(sql);

            while (results.next()){
                System.out.println(results.getString(1) + " " + results.getString(2) +
                        " " + results.getString(3)+ " " + results.getString(4));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
