/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.dtu.locationservice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bahram
 */
public class Database {
    private static Database instance=null;
    private final String url="jdbc:postgresql://127.0.0.1:5432/trackerapp";
    private final String user="admin";
    private final String password="42227786";
    private final String driver="org.postgresql.Driver";

    
    private Database(){
    }
    public static Database getInstance(){
        synchronized(Database.class){
            if (instance==null){
                instance=new Database();
            }
        }
        return instance;
    }
    public synchronized Connection connect() throws ClassNotFoundException, SQLException{
      Class.forName(driver);
      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      Connection conn = DriverManager.getConnection(url,user,password);
      return conn;
    }
    
}
