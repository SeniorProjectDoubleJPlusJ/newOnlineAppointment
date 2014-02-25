/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author junxin
 */
@Embeddable
public class AppointmentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSINESSID")
    private int businessid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPOLYEEID")
    private int empolyeeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICEID")
    private int serviceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPOINTMENTDATE")
    @Temporal(TemporalType.DATE)
    private Date appointmentdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPOINTMENTTIME")
    @Temporal(TemporalType.TIME)
    private Date appointmenttime;

    public AppointmentPK() {
    }

    public AppointmentPK(int businessid, int empolyeeid, int customerid, int serviceid, Date appointmentdate, Date appointmenttime) {
        this.businessid = businessid;
        this.empolyeeid = empolyeeid;
        this.customerid = customerid;
        this.serviceid = serviceid;
        this.appointmentdate = appointmentdate;
        this.appointmenttime = appointmenttime;
    }

    public int getBusinessid() {
        return businessid;
    }

    public void setBusinessid(int businessid) {
        this.businessid = businessid;
    }

    public int getEmpolyeeid() {
        return empolyeeid;
    }

    public void setEmpolyeeid(int empolyeeid) {
        this.empolyeeid = empolyeeid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public Date getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(Date appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public Date getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(Date appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessid;
        hash += (int) empolyeeid;
        hash += (int) customerid;
        hash += (int) serviceid;
        hash += (appointmentdate != null ? appointmentdate.hashCode() : 0);
        hash += (appointmenttime != null ? appointmenttime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppointmentPK)) {
            return false;
        }
        AppointmentPK other = (AppointmentPK) object;
        if (this.businessid != other.businessid) {
            return false;
        }
        if (this.empolyeeid != other.empolyeeid) {
            return false;
        }
        if (this.customerid != other.customerid) {
            return false;
        }
        if (this.serviceid != other.serviceid) {
            return false;
        }
        if ((this.appointmentdate == null && other.appointmentdate != null) || (this.appointmentdate != null && !this.appointmentdate.equals(other.appointmentdate))) {
            return false;
        }
        if ((this.appointmenttime == null && other.appointmenttime != null) || (this.appointmenttime != null && !this.appointmenttime.equals(other.appointmenttime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AppointmentPK[ businessid=" + businessid + ", empolyeeid=" + empolyeeid + ", customerid=" + customerid + ", serviceid=" + serviceid + ", appointmentdate=" + appointmentdate + ", appointmenttime=" + appointmenttime + " ]";
    }
    
}
