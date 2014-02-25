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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "SCHEDULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByScheduleid", query = "SELECT s FROM Schedule s WHERE s.scheduleid = :scheduleid"),
    @NamedQuery(name = "Schedule.findByMopen", query = "SELECT s FROM Schedule s WHERE s.mopen = :mopen"),
    @NamedQuery(name = "Schedule.findByMclose", query = "SELECT s FROM Schedule s WHERE s.mclose = :mclose"),
    @NamedQuery(name = "Schedule.findByTopen", query = "SELECT s FROM Schedule s WHERE s.topen = :topen"),
    @NamedQuery(name = "Schedule.findByTclose", query = "SELECT s FROM Schedule s WHERE s.tclose = :tclose"),
    @NamedQuery(name = "Schedule.findByWopen", query = "SELECT s FROM Schedule s WHERE s.wopen = :wopen"),
    @NamedQuery(name = "Schedule.findByWclose", query = "SELECT s FROM Schedule s WHERE s.wclose = :wclose"),
    @NamedQuery(name = "Schedule.findByRopen", query = "SELECT s FROM Schedule s WHERE s.ropen = :ropen"),
    @NamedQuery(name = "Schedule.findByRclose", query = "SELECT s FROM Schedule s WHERE s.rclose = :rclose"),
    @NamedQuery(name = "Schedule.findByFopen", query = "SELECT s FROM Schedule s WHERE s.fopen = :fopen"),
    @NamedQuery(name = "Schedule.findByFclose", query = "SELECT s FROM Schedule s WHERE s.fclose = :fclose"),
    @NamedQuery(name = "Schedule.findBySopen", query = "SELECT s FROM Schedule s WHERE s.sopen = :sopen"),
    @NamedQuery(name = "Schedule.findBySclose", query = "SELECT s FROM Schedule s WHERE s.sclose = :sclose"),
    @NamedQuery(name = "Schedule.findBySunopen", query = "SELECT s FROM Schedule s WHERE s.sunopen = :sunopen"),
    @NamedQuery(name = "Schedule.findBySunclose", query = "SELECT s FROM Schedule s WHERE s.sunclose = :sunclose")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SCHEDULEID")
    private Integer scheduleid;
    @Column(name = "MOPEN")
    @Temporal(TemporalType.TIME)
    private Date mopen;
    @Column(name = "MCLOSE")
    @Temporal(TemporalType.TIME)
    private Date mclose;
    @Column(name = "TOPEN")
    @Temporal(TemporalType.TIME)
    private Date topen;
    @Column(name = "TCLOSE")
    @Temporal(TemporalType.TIME)
    private Date tclose;
    @Column(name = "WOPEN")
    @Temporal(TemporalType.TIME)
    private Date wopen;
    @Column(name = "WCLOSE")
    @Temporal(TemporalType.TIME)
    private Date wclose;
    @Column(name = "ROPEN")
    @Temporal(TemporalType.TIME)
    private Date ropen;
    @Column(name = "RCLOSE")
    @Temporal(TemporalType.TIME)
    private Date rclose;
    @Column(name = "FOPEN")
    @Temporal(TemporalType.TIME)
    private Date fopen;
    @Column(name = "FCLOSE")
    @Temporal(TemporalType.TIME)
    private Date fclose;
    @Column(name = "SOPEN")
    @Temporal(TemporalType.TIME)
    private Date sopen;
    @Column(name = "SCLOSE")
    @Temporal(TemporalType.TIME)
    private Date sclose;
    @Column(name = "SUNOPEN")
    @Temporal(TemporalType.TIME)
    private Date sunopen;
    @Column(name = "SUNCLOSE")
    @Temporal(TemporalType.TIME)
    private Date sunclose;
    @JoinColumn(name = "BUSINESSID", referencedColumnName = "BUSINESSID")
    @ManyToOne
    private Businesses businessid;

    public Schedule() {
    }

    public Schedule(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Integer getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Date getMopen() {
        return mopen;
    }

    public void setMopen(Date mopen) {
        this.mopen = mopen;
    }

    public Date getMclose() {
        return mclose;
    }

    public void setMclose(Date mclose) {
        this.mclose = mclose;
    }

    public Date getTopen() {
        return topen;
    }

    public void setTopen(Date topen) {
        this.topen = topen;
    }

    public Date getTclose() {
        return tclose;
    }

    public void setTclose(Date tclose) {
        this.tclose = tclose;
    }

    public Date getWopen() {
        return wopen;
    }

    public void setWopen(Date wopen) {
        this.wopen = wopen;
    }

    public Date getWclose() {
        return wclose;
    }

    public void setWclose(Date wclose) {
        this.wclose = wclose;
    }

    public Date getRopen() {
        return ropen;
    }

    public void setRopen(Date ropen) {
        this.ropen = ropen;
    }

    public Date getRclose() {
        return rclose;
    }

    public void setRclose(Date rclose) {
        this.rclose = rclose;
    }

    public Date getFopen() {
        return fopen;
    }

    public void setFopen(Date fopen) {
        this.fopen = fopen;
    }

    public Date getFclose() {
        return fclose;
    }

    public void setFclose(Date fclose) {
        this.fclose = fclose;
    }

    public Date getSopen() {
        return sopen;
    }

    public void setSopen(Date sopen) {
        this.sopen = sopen;
    }

    public Date getSclose() {
        return sclose;
    }

    public void setSclose(Date sclose) {
        this.sclose = sclose;
    }

    public Date getSunopen() {
        return sunopen;
    }

    public void setSunopen(Date sunopen) {
        this.sunopen = sunopen;
    }

    public Date getSunclose() {
        return sunclose;
    }

    public void setSunclose(Date sunclose) {
        this.sunclose = sunclose;
    }

    public Businesses getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Businesses businessid) {
        this.businessid = businessid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleid != null ? scheduleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleid == null && other.scheduleid != null) || (this.scheduleid != null && !this.scheduleid.equals(other.scheduleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Schedule[ scheduleid=" + scheduleid + " ]";
    }
    
}
