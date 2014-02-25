/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Businesses;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author junxin
 */
@Stateless
@Path("entities.businesses")
public class BusinessesFacadeREST extends AbstractFacade<Businesses> {

    @PersistenceContext(unitName = "OnlineAppointmentSystemPU")
    private EntityManager em;

    public BusinessesFacadeREST() {
        super(Businesses.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Businesses entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Businesses entity) {
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
    public Businesses find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Businesses> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Businesses> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    @GET
    @Path("/list")
    @Produces("text/html")
    public String getBuinesses() {
        List<Businesses> results = em.createQuery("SELECT b FROM Businesses b").getResultList();
        String answer = "<div style=\"width: 300px; height: 500px; overflow-y: scroll;\">"
                + "<table width=\"280\">"
                + "<thead><tr><th>Select</th><th>Id</th><th>Business</th></tr></thead>";

        for (Businesses result : results) {
            answer += "<tr><th><input type=\"radio\" name=\"businessid\" onclick=\"setId("
                    + result.getBusinessid() + ")\"/></th><th>"
                    + result.getBusinessid() + "</th><th>"
                    + result.getStorename() + "<br>"
                    + result.getAddress() + "<br>"
                    + result.getPhone() + "</th></tr>";
        }
        answer += "</table></div>";
        return answer;
    }

    @POST
    @Path("/create")
    @Consumes({"application/x-www-form-urlencoded", "text/plain"})
    public String createUser(@QueryParam("storename") String storename,
            @QueryParam("phone") String phone,
            @QueryParam("address") String address,
            @CookieParam("username") String username,
            @CookieParam("password") String password) {

        try {
            Users employer = (Users) em.createQuery("SELECT u FROM Users u WHERE u.username='" + username + "' and u.password='" + password + "'").getSingleResult();
            List<Businesses> businesses = em.createNamedQuery("Businesses.findAll").getResultList();
            int id = businesses.get(businesses.size() - 1).getBusinessid();
            id++;
            Businesses newBusiness = new Businesses(id);
            newBusiness.setStorename(storename);
            newBusiness.setPhone(phone);
            newBusiness.setAddress(address);
            newBusiness.setEmployerid(employer);
            super.create(newBusiness);
            return id+"";
        } catch (Exception e) {
            return "Error! Register Imcomplete!";
        }

    }

}
