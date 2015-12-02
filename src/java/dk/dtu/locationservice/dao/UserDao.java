/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.dtu.locationservice.dao;

import dk.dtu.locationservice.database.Database;
import dk.dtu.locationservice.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private String add_user="INSERT INTO tracker.users(phone, name,mail, decription)VALUES (?, ?, ?,?);";
    private String upadate_user="UPDATE tracker.users SET  phone=?, name=?, decription=? WHERE mail=?;";
    private String delete_by_mail="DELETE FROM tracker.users WHERE mail=?;";
    
    public long addUser(User user) throws ClassNotFoundException, SQLException, Exception{
        long id=-1;
        Connection conn=Database.getInstance().connect();
        PreparedStatement ps=null;
        try{
        ps=conn.prepareStatement(add_user);
        ps.setLong(1, user.getPhone());
        ps.setString(2, user.getName());
        ps.setString(3, user.getMail());
        ps.setString(4, user.getDescription());
        id=ps.executeUpdate();
        }catch(Exception e){
           
            if (conn != null) {
                conn.close();
            }
            throw new Exception(e);
        }
     finally {
        if (ps != null) {
            ps.close();
        }
        if(conn!=null){
            conn.close();  
        }
       
    }  
        return id;     
    }
 public void deleteUserByMail(String mail) throws ClassNotFoundException, SQLException, Exception{
    
     Connection conn=Database.getInstance().connect();
     PreparedStatement ps=null;
     try{
         ps=conn.prepareStatement(delete_by_mail);
         ps.setString(1, mail);
         ps.executeUpdate();
     }catch(Exception e){
         if(ps!=null){
             ps.close();
         }
        if(conn!=null){
            conn.close();
        }
        throw new Exception(e);
     }
    
 }
 
 public void updateUser(User user) throws ClassNotFoundException, SQLException, Exception{
    
     Connection conn=Database.getInstance().connect();
     PreparedStatement ps=null;
     try{
         ps=conn.prepareStatement(upadate_user);
         ps.setLong(1, user.getPhone());
         ps.setString(2,user.getName());
         ps.setString(3, user.getDescription());
         ps.setString(4, user.getMail());
         ps.executeUpdate();
     }catch(Exception e){
         if(ps!=null){
             ps.close();
         }
        if(conn!=null){
            conn.close();
        }
        throw new Exception(e);
     }
    
 }


    
}
