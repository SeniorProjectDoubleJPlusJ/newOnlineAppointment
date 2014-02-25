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
@Table(name = "SERVICEFOREMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceforemployee.findAll", query = "SELECT s FROM Serviceforemployee s"),
    @NamedQuery(name = "Serviceforemployee.findByUserid", query = "SELECT s FROM Serviceforemployee s WHERE s.serviceforemployeePK.userid = :userid"),
    @NamedQuery(name = "Serviceforemployee.findByServiceid", query = "SELECT s FROM Serviceforemployee s WHERE s.serviceforemployeePK.serviceid = :serviceid"),
    @NamedQuery(name = "Serviceforemployee.findByServicetime", query = "SELECT s FROM Serviceforemployee s WHERE s.servicetime = :servicetime")})
public class Serviceforemployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServiceforemployeePK serviceforemployeePK;
    @Column(name = "SERVICETIME")
    @Temporal(TemporalType.TIME)
    private Date servicetime;
    @JoinColumn(name = "SERVICEID", referencedColumnName = "SERVICEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Services services;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Serviceforemployee() {
    }

    public Serviceforemployee(ServiceforemployeePK serviceforemployeePK) {
        this.serviceforemployeePK = serviceforemployeePK;
    }

    public Serviceforemployee(int userid, int serviceid) {
        this.serviceforemployeePK = new ServiceforemployeePK(userid, serviceid);
    }

    public ServiceforemployeePK getServiceforemployeePK() {
        return serviceforemployeePK;
    }

    public void setServiceforemployeePK(ServiceforemployeePK serviceforemployeePK) {
        this.serviceforemployeePK = serviceforemployeePK;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceforemployeePK != null ? serviceforemployeePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceforemployee)) {
            return false;
        }
        Serviceforemployee other = (Serviceforemployee) object;
        if ((this.serviceforemployeePK == null && other.serviceforemployeePK != null) || (this.serviceforemployeePK != null && !this.serviceforemployeePK.equals(other.serviceforemployeePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Serviceforemployee[ serviceforemployeePK=" + serviceforemployeePK + " ]";
    }
    
}
