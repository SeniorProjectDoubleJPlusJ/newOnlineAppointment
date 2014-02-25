/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author junxin
 */
@Entity
@Table(name = "SERVICES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByServiceid", query = "SELECT s FROM Services s WHERE s.serviceid = :serviceid"),
    @NamedQuery(name = "Services.findByServicename", query = "SELECT s FROM Services s WHERE s.servicename = :servicename")})
public class Services implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICEID")
    private Integer serviceid;
    @Size(max = 255)
    @Column(name = "SERVICENAME")
    private String servicename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "services")
    private Collection<Serviceinstore> serviceinstoreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "services")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "services")
    private Collection<Serviceforemployee> serviceforemployeeCollection;

    public Services() {
    }

    public Services(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    @XmlTransient
    public Collection<Serviceinstore> getServiceinstoreCollection() {
        return serviceinstoreCollection;
    }

    public void setServiceinstoreCollection(Collection<Serviceinstore> serviceinstoreCollection) {
        this.serviceinstoreCollection = serviceinstoreCollection;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<Serviceforemployee> getServiceforemployeeCollection() {
        return serviceforemployeeCollection;
    }

    public void setServiceforemployeeCollection(Collection<Serviceforemployee> serviceforemployeeCollection) {
        this.serviceforemployeeCollection = serviceforemployeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceid != null ? serviceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.serviceid == null && other.serviceid != null) || (this.serviceid != null && !this.serviceid.equals(other.serviceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Services[ serviceid=" + serviceid + " ]";
    }
    
}
