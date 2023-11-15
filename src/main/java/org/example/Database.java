package org.example;
import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();
    private static Connection connection;

    private Database(){
        String url = PropertiesReader.getConnectionURLForMySql();
        String name = PropertiesReader.getDatabaseUser();
        String password = PropertiesReader.getDatabasePassword();

        try{
            connection = DriverManager.getConnection(url, name, password);
        }catch(SQLException e){
            System.out.println("Exception. Reason:" + e.getMessage());
            throw new RuntimeException("Cannot create connection");
        }
    }

    public static Database getInstance(){
        return INSTANCE;
    }
    public static Connection getConnection(){
        return connection;
    }

    public ResultSet executeResult(String query){
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }catch(SQLException e){
            System.out.println("Exception. Reason:" + e.getMessage());
            throw new RuntimeException("Cannot run query");
        }
    }

    public int executeUpdate(String query){
        try(Statement statement = connection.createStatement()){
            return statement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("Exception. Reason:" + e.getMessage());
            throw new RuntimeException("Cannot run query");
        }
    }

    public static void closeConnection(){
        try{
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
