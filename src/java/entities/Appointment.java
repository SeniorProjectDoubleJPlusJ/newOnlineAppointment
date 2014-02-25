/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author junxin
 */
@Entity
@Table(name = "APPOINTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByBusinessid", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.businessid = :businessid"),
    @NamedQuery(name = "Appointment.findByEmpolyeeid", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.empolyeeid = :empolyeeid"),
    @NamedQuery(name = "Appointment.findByCustomerid", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.customerid = :customerid"),
    @NamedQuery(name = "Appointment.findByServiceid", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.serviceid = :serviceid"),
    @NamedQuery(name = "Appointment.findByAppointmentdate", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.appointmentdate = :appointmentdate"),
    @NamedQuery(name = "Appointment.findByAppointmenttime", query = "SELECT a FROM Appointment a WHERE a.appointmentPK.appointmenttime = :appointmenttime")})
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppointmentPK appointmentPK;
    @JoinColumn(name = "SERVICEID", referencedColumnName = "SERVICEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Services services;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "EMPOLYEEID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;
    @JoinColumn(name = "BUSINESSID", referencedColumnName = "BUSINESSID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Businesses businesses;

    public Appointment() {
    }

    public Appointment(AppointmentPK appointmentPK) {
        this.appointmentPK = appointmentPK;
    }

    public Appointment(int businessid, int empolyeeid, int customerid, int serviceid, Date appointmentdate, Date appointmenttime) {
        this.appointmentPK = new AppointmentPK(businessid, empolyeeid, customerid, serviceid, appointmentdate, appointmenttime);
    }

    public AppointmentPK getAppointmentPK() {
        return appointmentPK;
    }

    public void setAppointmentPK(AppointmentPK appointmentPK) {
        this.appointmentPK = appointmentPK;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers1() {
        return users1;
    }

    public void setUsers1(Users users1) {
        this.users1 = users1;
    }

    public Businesses getBusinesses() {
        return businesses;
    }

    public void setBusinesses(Businesses businesses) {
        this.businesses = businesses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentPK != null ? appointmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentPK == null && other.appointmentPK != null) || (this.appointmentPK != null && !this.appointmentPK.equals(other.appointmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Appointment[ appointmentPK=" + appointmentPK + " ]";
    }
    
}
