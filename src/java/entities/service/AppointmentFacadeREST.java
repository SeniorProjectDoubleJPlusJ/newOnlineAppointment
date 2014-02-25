/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.service;

import entities.Appointment;
import entities.AppointmentPK;
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
@Path("entities.appointment")
public class AppointmentFacadeREST extends AbstractFacade<Appointment> {
    @PersistenceContext(unitName = "OnlineAppointmentSystemPU")
    private EntityManager em;

    private AppointmentPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;businessid=businessidValue;empolyeeid=empolyeeidValue;customerid=customeridValue;serviceid=serviceidValue;appointmentdate=appointmentdateValue;appointmenttime=appointmenttimeValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.AppointmentPK key = new entities.AppointmentPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> businessid = map.get("businessid");
        if (businessid != null && !businessid.isEmpty()) {
            key.setBusinessid(new java.lang.Integer(businessid.get(0)));
        }
        java.util.List<String> empolyeeid = map.get("empolyeeid");
        if (empolyeeid != null && !empolyeeid.isEmpty()) {
            key.setEmpolyeeid(new java.lang.Integer(empolyeeid.get(0)));
        }
        java.util.List<String> customerid = map.get("customerid");
        if (customerid != null && !customerid.isEmpty()) {
            key.setCustomerid(new java.lang.Integer(customerid.get(0)));
        }
        java.util.List<String> serviceid = map.get("serviceid");
        if (serviceid != null && !serviceid.isEmpty()) {
            key.setServiceid(new java.lang.Integer(serviceid.get(0)));
        }
        java.util.List<String> appointmentdate = map.get("appointmentdate");
        if (appointmentdate != null && !appointmentdate.isEmpty()) {
            key.setAppointmentdate(new java.util.Date(appointmentdate.get(0)));
        }
        java.util.List<String> appointmenttime = map.get("appointmenttime");
        if (appointmenttime != null && !appointmenttime.isEmpty()) {
            key.setAppointmenttime(new java.util.Date(appointmenttime.get(0)));
        }
        return key;
    }

    public AppointmentFacadeREST() {
        super(Appointment.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Appointment entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Appointment entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.AppointmentPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Appointment find(@PathParam("id") PathSegment id) {
        entities.AppointmentPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Appointment> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Appointment> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
