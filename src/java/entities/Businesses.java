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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "BUSINESSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Businesses.findAll", query = "SELECT b FROM Businesses b"),
    @NamedQuery(name = "Businesses.findByBusinessid", query = "SELECT b FROM Businesses b WHERE b.businessid = :businessid"),
    @NamedQuery(name = "Businesses.findByStorename", query = "SELECT b FROM Businesses b WHERE b.storename = :storename"),
    @NamedQuery(name = "Businesses.findByPhone", query = "SELECT b FROM Businesses b WHERE b.phone = :phone"),
    @NamedQuery(name = "Businesses.findByAddress", query = "SELECT b FROM Businesses b WHERE b.address = :address")})
public class Businesses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BUSINESSID")
    private Integer businessid;
    @Size(max = 255)
    @Column(name = "STORENAME")
    private String storename;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @JoinTable(name = "EMPLOYEEINSTORE", joinColumns = {
        @JoinColumn(name = "BUSINESSID", referencedColumnName = "BUSINESSID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERID", referencedColumnName = "USERID")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businesses")
    private Collection<Serviceinstore> serviceinstoreCollection;
    @JoinColumn(name = "EMPLOYERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users employerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businesses")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(mappedBy = "businessid")
    private Collection<Schedule> scheduleCollection;

    public Businesses() {
    }

    public Businesses(Integer businessid) {
        this.businessid = businessid;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Serviceinstore> getServiceinstoreCollection() {
        return serviceinstoreCollection;
    }

    public void setServiceinstoreCollection(Collection<Serviceinstore> serviceinstoreCollection) {
        this.serviceinstoreCollection = serviceinstoreCollection;
    }

    public Users getEmployerid() {
        return employerid;
    }

    public void setEmployerid(Users employerid) {
        this.employerid = employerid;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessid != null ? businessid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Businesses)) {
            return false;
        }
        Businesses other = (Businesses) object;
        if ((this.businessid == null && other.businessid != null) || (this.businessid != null && !this.businessid.equals(other.businessid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Businesses[ businessid=" + businessid + " ]";
    }
    
}
