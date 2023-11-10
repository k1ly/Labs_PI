package by.belstu.it.lyskov.lab10;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class JdbcServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        int minAge = Integer.parseInt(req.getParameter("minAge"));
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc;user=sa;password=Kirill1203;trustServerCertificate=true";
            Connection connection = DriverManager.getConnection(url);

            writer.println("Users:");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                writer.println("ID = " + resultSet.getInt("id") +
                        ", Name = " + resultSet.getString("name") +
                        ", Age = " + resultSet.getInt("age"));
            }
            resultSet.close();
            statement.close();

            writer.println("\nUsers with condition:");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where age >= ?");
            preparedStatement.setInt(1, minAge);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                writer.println("ID = " + resultSet.getInt("id") +
                        ", Name = " + resultSet.getString("name") +
                        ", Age = " + resultSet.getInt("age"));
            }
            resultSet.close();
            preparedStatement.close();

            writer.println("\nCount of users with condition:");
            CallableStatement callableStatement = connection.prepareCall("{call countUsersByMinAge(?,?)}");
            callableStatement.setInt(1, minAge);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.execute();
            writer.println("Count = " + callableStatement.getInt(2));
            callableStatement.close();

            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}