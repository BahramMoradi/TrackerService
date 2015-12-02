/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.dtu.locationservice.dao;

import dk.dtu.locationservice.dto.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Bahram
 */
public class UserDaoTest {
    private static List<User> users;
    private static UserDao userdao;
    
    
    @BeforeClass
    public static void init(){
        System.err.println("Runing init");
        userdao = new UserDao();
        users=new ArrayList<User>();
        users.add(new User(4542227786L,"Bahram","bahmo25@gmail.com","Developer"));
        users.add(new User(4542732770L,"Diman","dimanmoradi@hotmail.com","Nurse"));
        users.add(new User(4560401012L,"Aziz","aziz.moradi@hotmail.com","Not yet...."));
    }

    /**
     * Test of addUser method, of class UserDao.
     */
    @Test
    public void testAddUser() throws Exception {
        
        long result = userdao.addUser(users.get(0));
        assertTrue(result!=-1);
        
    }
   @Test
   public void testDeleteUserByMail() throws Exception{
        long row=userdao.addUser(users.get(1));
        System.err.println("Row affected : "+row);
        assertTrue(row!=-1);
        userdao.deleteUserByMail(users.get(1).getMail());
       
   
   
   }
    
}
