package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("populate_db.sql")){
            char[] buff = new char[2000];
            reader.read(buff);
            String query = String.valueOf(buff);

            String[] commands = query.split(";");
            for(String command:commands){

                System.out.println(Database.getInstance().executeUpdate(command));
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        Database.closeConnection();
    }
}
