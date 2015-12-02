/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.dtu.locationservice.ws;

import com.google.gson.Gson;
import dk.dtu.locationservice.dao.UserDao;
import dk.dtu.locationservice.dto.User;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Bahram
 */
@Path("user")
public class UserWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserWebService
     */
    public UserWebService() {
    }

    /**
     * Retrieves representation of an instance 
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUSer() {
        //TODO return proper representation object
        
        return "{\"Name\":\"Bahram\"}";
    }

    /**
     * using This method for creating user
     * PUT method for updating or creating an instance of UserWebService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putUser(String content) {
        String message="OK";
        Gson gson=new Gson();
        User u=gson.fromJson(content, User.class);
        UserDao dao=new UserDao();
        try{
        dao.addUser(u);}catch(Exception e){
            message=e.getMessage();
        }
        return message;
    }
     
      /**
     * Using this method only for updating user by it cridential (mail)
     * POST method for updating or creating an instance of UserWebService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postUser(String user) {
        String message="OK Updated";
        Gson gson=new Gson();
        User u=gson.fromJson(user, User.class);
        UserDao dao=new UserDao();
        try{
        dao.updateUser(u);
        }catch(Exception e){
            message=e.getMessage();
        }
        return message;
    
        
        //return "{\"from\":\"put mehod\"}";
    }
    
    
}
