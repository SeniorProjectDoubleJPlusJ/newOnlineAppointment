/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author junxin
 */
@Entity
@Table(name = "SERVICEINSTORE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceinstore.findAll", query = "SELECT s FROM Serviceinstore s"),
    @NamedQuery(name = "Serviceinstore.findByBusinessid", query = "SELECT s FROM Serviceinstore s WHERE s.serviceinstorePK.businessid = :businessid"),
    @NamedQuery(name = "Serviceinstore.findByServiceid", query = "SELECT s FROM Serviceinstore s WHERE s.serviceinstorePK.serviceid = :serviceid"),
    @NamedQuery(name = "Serviceinstore.findByPrice", query = "SELECT s FROM Serviceinstore s WHERE s.price = :price"),
    @NamedQuery(name = "Serviceinstore.findByServicetime", query = "SELECT s FROM Serviceinstore s WHERE s.servicetime = :servicetime")})
public class Serviceinstore implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServiceinstorePK serviceinstorePK;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "SERVICETIME")
    @Temporal(TemporalType.TIME)
    private Date servicetime;
    @JoinColumn(name = "SERVICEID", referencedColumnName = "SERVICEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Services services;
    @JoinColumn(name = "BUSINESSID", referencedColumnName = "BUSINESSID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Businesses businesses;

    public Serviceinstore() {
    }

    public Serviceinstore(ServiceinstorePK serviceinstorePK) {
        this.serviceinstorePK = serviceinstorePK;
    }

    public Serviceinstore(int businessid, int serviceid) {
        this.serviceinstorePK = new ServiceinstorePK(businessid, serviceid);
    }

    public ServiceinstorePK getServiceinstorePK() {
        return serviceinstorePK;
    }

    public void setServiceinstorePK(ServiceinstorePK serviceinstorePK) {
        this.serviceinstorePK = serviceinstorePK;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getServicetime() {
        return servicetime;
    }

    public void setServicetime(Date servicetime) {
        this.servicetime = servicetime;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
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
        hash += (serviceinstorePK != null ? serviceinstorePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceinstore)) {
            return false;
        }
        Serviceinstore other = (Serviceinstore) object;
        if ((this.serviceinstorePK == null && other.serviceinstorePK != null) || (this.serviceinstorePK != null && !this.serviceinstorePK.equals(other.serviceinstorePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Serviceinstore[ serviceinstorePK=" + serviceinstorePK + " ]";
    }
    
}
