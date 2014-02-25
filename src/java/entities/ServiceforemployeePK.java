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
public class ServiceforemployeePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICEID")
    private int serviceid;

    public ServiceforemployeePK() {
    }

    public ServiceforemployeePK(int userid, int serviceid) {
        this.userid = userid;
        this.serviceid = serviceid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
        hash += (int) userid;
        hash += (int) serviceid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceforemployeePK)) {
            return false;
        }
        ServiceforemployeePK other = (ServiceforemployeePK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.serviceid != other.serviceid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ServiceforemployeePK[ userid=" + userid + ", serviceid=" + serviceid + " ]";
    }
    
}
