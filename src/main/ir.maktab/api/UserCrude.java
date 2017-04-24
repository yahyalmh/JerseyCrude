package api;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.List;

import model.EntityManager;
import model.User;

import javax.ws.rs.*;
import javax.xml.ws.Response;

/**
 * Created by asus x555L on 2017/03/01.
 */
@Path("/user")
public class UserCrude {
    @GET
    @Path("/list")
    @Produces("application/json,text/html")
    public List<User> getUser(){
        List<User> userList=new ArrayList<User>();
        User u=new User();
        u.setId(12);
        u.setPass("13545");
        u.setUsername("yahya");
        userList.add(u);
     List<User> users=EntityManager.readUser(-1);
        return userList;
    }
    @POST
    @Path("/adduser")
    @Consumes("application/json,text/html")
    @Produces("text/plain")
    public Response addUsers(User user){
        EntityManager.addUser(user);
        return (Response) javax.ws.rs.core.Response.ok("Entity not found for UUID: ").build();
    }
}
