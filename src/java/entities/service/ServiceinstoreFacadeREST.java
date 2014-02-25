/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.service;

import entities.Serviceinstore;
import entities.ServiceinstorePK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author junxin
 */
@Stateless
@Path("entities.serviceinstore")
public class ServiceinstoreFacadeREST extends AbstractFacade<Serviceinstore> {
    @PersistenceContext(unitName = "OnlineAppointmentSystemPU")
    private EntityManager em;

    private ServiceinstorePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;businessid=businessidValue;serviceid=serviceidValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.ServiceinstorePK key = new entities.ServiceinstorePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> businessid = map.get("businessid");
        if (businessid != null && !businessid.isEmpty()) {
            key.setBusinessid(new java.lang.Integer(businessid.get(0)));
        }
        java.util.List<String> serviceid = map.get("serviceid");
        if (serviceid != null && !serviceid.isEmpty()) {
            key.setServiceid(new java.lang.Integer(serviceid.get(0)));
        }
        return key;
    }

    public ServiceinstoreFacadeREST() {
        super(Serviceinstore.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Serviceinstore entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Serviceinstore entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.ServiceinstorePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Serviceinstore find(@PathParam("id") PathSegment id) {
        entities.ServiceinstorePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Serviceinstore> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Serviceinstore> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
}
