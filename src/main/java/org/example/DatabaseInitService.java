package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;

public class DatabaseInitService {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("init_db.sql")){
         char[] buff = new char[1000];
         reader.read(buff);
         String query = String.valueOf(buff);
         String[] commands = query.split(";");
         for(String command:commands){
                 System.out.println(Database.getInstance().executeUpdate(command));

         }
//            System.out.println(Database.getInstance().executeUpdate("DROP TABLE project_worker1"));
//            System.out.println(Database.getInstance().executeUpdate("DROP TABLE worker1"));
//            System.out.println(Database.getInstance().executeUpdate("DROP TABLE project1"));
//            System.out.println(Database.getInstance().executeUpdate("DROP TABLE client1"));


        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        Database.closeConnection();

    }
}
