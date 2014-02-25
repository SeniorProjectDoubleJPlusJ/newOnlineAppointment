/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author junxin
 */
@Embeddable
public class ServiceinstorePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "BUSINESSID")
    private int businessid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICEID")
    private int serviceid;

    public ServiceinstorePK() {
    }

    public ServiceinstorePK(int businessid, int serviceid) {
        this.businessid = businessid;
        this.serviceid = serviceid;
    }

    public int getBusinessid() {
        return businessid;
    }

    public void setBusinessid(int businessid) {
        this.businessid = businessid;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) businessid;
        hash += (int) serviceid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceinstorePK)) {
            return false;
        }
        ServiceinstorePK other = (ServiceinstorePK) object;
        if (this.businessid != other.businessid) {
            return false;
        }
        if (this.serviceid != other.serviceid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceinstorePK[ businessid=" + businessid + ", serviceid=" + serviceid + " ]";
    }
    
}
