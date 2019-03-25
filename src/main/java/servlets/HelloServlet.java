package servlets;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import database.DBConnector;


public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM student");
            writer.print("Hello, ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                writer.print(resultSet.getString("name")+", ");
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException sqlEx){
                    System.out.println(sqlEx);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                }catch (SQLException sqlEx){
                    System.out.println(sqlEx);
                }
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();

        PreparedStatement statement1 = null;

        String sql = "INSERT INTO student (name) VALUES (?)";
        String name = req.getParameter("studentName");

        try {
            Connection conn = new DBConnector().getConn();
            statement1= conn.prepareStatement(sql);
            statement1.setString(1,name);
            int i = statement1.executeUpdate();
            writer.print(i+" records inserted");
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        }
    }
}

