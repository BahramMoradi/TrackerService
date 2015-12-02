
import com.google.gson.Gson;
import dk.dtu.locationservice.dao.UserDao;
import dk.dtu.locationservice.database.Database;
import dk.dtu.locationservice.dto.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bahram
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
/***
        List<User> users=new ArrayList<User>();
        users.add(new User(4542227786L,"Bahram","Developer"));
        users.add(new User(4542732770L,"Diman","Nurse"));
        users.add(new User(4560401012L,"Aziz","Not yet...."));
        
        UserDao ud=new UserDao();
        ud.addUser(users.get(0));
        * **/
        User u=new User(4542227786L,"Bahram","Mail@gmail.com","Helloworld");
        Gson g=new Gson();
        String str=g.toJson(u, User.class);
        System.err.println(str);
        
        
    }
    
}
