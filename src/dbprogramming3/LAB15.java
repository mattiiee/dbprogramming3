package dbprogramming3;

import java.sql.*;

public class LAB15 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root";
        String password = "mysql@sit";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,username,password);
            Statement statement = con.createStatement();
            String sql = "SELECT * from student";
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = results.getMetaData();

            for (int i = 1; i < rsMetaData.getColumnCount(); i++){
                System.out.println(rsMetaData.getColumnName(i));
            }

            while (results.next()) {
                for (int i= 1; i<= rsMetaData.getColumnCount(); i++)
                    System.out.printf("%-12s\t", results.getObject(i));
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
