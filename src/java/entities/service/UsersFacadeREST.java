/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Users;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static javax.servlet.SessionTrackingMode.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 *
 * @author junxin
 */
@Stateless
@Path("entities.users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "OnlineAppointmentSystemPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Users entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @POST
    @Path("/login/{username}/{password}")
    @Consumes("text/plain")
    public String login(@PathParam("username") String username,
            @PathParam("password") String password) {
        String s = "SELECT u From Users u "
                + "WHERE u.username='" + username + "' AND u.password='" + password + "'";

        List<Users> users = em.createQuery(s).getResultList();
        if (!users.isEmpty()) {
            return "Log In";
        } else {
            return "Incorrect Username Or Password";
        }
    }

    @POST
    @Path("/create")
    @Consumes({"application/x-www-form-urlencoded", "text/plain"})
    public String createUser(@QueryParam("username") String username,
            @QueryParam("password") String password,
            @QueryParam("re_password") String re_password,
            @QueryParam("firstname") String firstname,
            @QueryParam("lastname") String lastname,
            @QueryParam("gender") String gender,
            @QueryParam("phone") String phone,
            @QueryParam("email") String email) {

        List<Users> users = em.createQuery("SELECT u FROM Users u WHERE u.username='" + username + "'").getResultList();

        if (!users.isEmpty()) {
            return "Username is already exist, please use another username.";
        } else {
            users = em.createNamedQuery("Users.findAll").getResultList();
            int id = users.get(users.size() - 1).getUserid();
            id++;
            Users newUser = new Users(id, username, password);
            newUser.setFirstname(firstname);
            newUser.setLastname(lastname);
            newUser.setGender(gender);
            newUser.setPhone(phone);
            newUser.setEmail(email);
            super.create(newUser);
            return "Register Successful";
        }
    }

}
