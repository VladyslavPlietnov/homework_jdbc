package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseQueryService {
    public static ArrayList<LongestProject> findLongestProject(){
        ArrayList<LongestProject> outcome = new ArrayList<>();
        try(FileReader reader = new FileReader("find_longest_project.sql") ){
            char[] buff = new char[1000];
            reader.read(buff);
            String query = String.valueOf(buff);
            query = query.replace("project","project1");
            query = query.replace("worker","worker1");
            query = query.replace("client","client1");
            query = query.replace("project1_worker1","project_worker1");
            ResultSet result = Database.getInstance().executeResult(query);
           try {
                while (result.next()){
                    outcome.add(new LongestProject(result.getInt("ID"),result.getDouble("MONTHS")));
                }
            }catch (SQLException e){
               System.out.println("reason: " + e.getMessage());
           }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return outcome;
    }

    public static ArrayList<MaxProjectsClient> findMaxProjectsClient(){
        ArrayList<MaxProjectsClient> outcome = new ArrayList<>();
        try(FileReader reader = new FileReader("find_max_projects_client.sql") ){
            char[] buff = new char[1000];
            reader.read(buff);
            String query = String.valueOf(buff);
            query = query.replace("project","project1");
            query = query.replace("worker","worker1");
            query = query.replace("client","client1");
            query = query.replace("project1_worker1","project_worker1");
            ResultSet result = Database.getInstance().executeResult(query);
            try {
                while (result.next()){
                    outcome.add(new MaxProjectsClient(result.getInt("id"),result.getString("NAME")));
                }
            }catch (SQLException e){
                System.out.println("reason: " + e.getMessage());
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return outcome;
    }
    public static ArrayList<MaxSalaryWorker> findMaxSalaryWorker(){
        ArrayList<MaxSalaryWorker> outcome = new ArrayList<>();
        try(FileReader reader = new FileReader("find_max_salary_worker.sql") ){
            char[] buff = new char[1000];
            reader.read(buff);
            String query = String.valueOf(buff);
            query = query.replace("project","project1");
            query = query.replace("worker","worker1");
            query = query.replace("client","client1");
            query = query.replace("project1_worker1","project_worker1");
            ResultSet result = Database.getInstance().executeResult(query);
            try {
                while (result.next()){
                    outcome.add(new MaxSalaryWorker(result.getString("NAME"),result.getInt("SALARY")));
                }
            }catch (SQLException e){
                System.out.println("reason: " + e.getMessage());
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return outcome;
    }
    public static ArrayList<YoungestEldestWorker> findYoungestEldestWorkers(){
        ArrayList<YoungestEldestWorker> outcome = new ArrayList<>();
        try(FileReader reader = new FileReader("find_youngest_eldest_workers.sql") ){
            char[] buff = new char[1000];
            reader.read(buff);
            String query = String.valueOf(buff);
            query = query.replace("project","project1");
            query = query.replace("worker","worker1");
            query = query.replace("client","client1");
            query = query.replace("project1_worker1","project_worker1");
            ResultSet result = Database.getInstance().executeResult(query);
            try {
                while (result.next()){
                    outcome.add(new YoungestEldestWorker(result.getString("NAME"),result.getString("BIRTHDAY"),result.getString("TYPE")));
                }
            }catch (SQLException e){
                System.out.println("reason: " + e.getMessage());
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return outcome;
    }
    public static ArrayList<ProjectPrice> printProjectPrices(){
        ArrayList<ProjectPrice> outcome = new ArrayList<>();
        try(FileReader reader = new FileReader("print_project_prices.sql") ){
            char[] buff = new char[1000];
            reader.read(buff);
            String query = String.valueOf(buff);
            query = query.replace("project","project1");
            query = query.replace("worker","worker1");
            query = query.replace("client","client1");
            query = query.replace("project1_worker1","project_worker1");
            ResultSet result = Database.getInstance().executeResult(query);
            try {
                while (result.next()){
                    outcome.add(new ProjectPrice(result.getInt("NAME"),result.getDouble("PRICE")));
                }
            }catch (SQLException e){
                System.out.println("reason: " + e.getMessage());
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        return outcome;
    }


    public static void main(String[] args) {
        findLongestProject().forEach(a -> System.out.println(a.toString()));
        System.out.println("\n");
        findMaxProjectsClient().forEach(a -> System.out.println(a.toString()));
        System.out.println("\n");
        findMaxSalaryWorker().forEach(a -> System.out.println(a.toString()));
        System.out.println("\n");
        findYoungestEldestWorkers().forEach(a -> System.out.println(a.toString()));
        System.out.println("\n");
        printProjectPrices().forEach(a -> System.out.println(a.toString()));
        Database.closeConnection();
    }
}
