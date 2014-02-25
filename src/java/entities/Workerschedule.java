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
@Table(name = "WORKERSCHEDULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workerschedule.findAll", query = "SELECT w FROM Workerschedule w"),
    @NamedQuery(name = "Workerschedule.findByScheduleid", query = "SELECT w FROM Workerschedule w WHERE w.scheduleid = :scheduleid"),
    @NamedQuery(name = "Workerschedule.findByMopen", query = "SELECT w FROM Workerschedule w WHERE w.mopen = :mopen"),
    @NamedQuery(name = "Workerschedule.findByMclose", query = "SELECT w FROM Workerschedule w WHERE w.mclose = :mclose"),
    @NamedQuery(name = "Workerschedule.findByTopen", query = "SELECT w FROM Workerschedule w WHERE w.topen = :topen"),
    @NamedQuery(name = "Workerschedule.findByTclose", query = "SELECT w FROM Workerschedule w WHERE w.tclose = :tclose"),
    @NamedQuery(name = "Workerschedule.findByWopen", query = "SELECT w FROM Workerschedule w WHERE w.wopen = :wopen"),
    @NamedQuery(name = "Workerschedule.findByWclose", query = "SELECT w FROM Workerschedule w WHERE w.wclose = :wclose"),
    @NamedQuery(name = "Workerschedule.findByRopen", query = "SELECT w FROM Workerschedule w WHERE w.ropen = :ropen"),
    @NamedQuery(name = "Workerschedule.findByRclose", query = "SELECT w FROM Workerschedule w WHERE w.rclose = :rclose"),
    @NamedQuery(name = "Workerschedule.findByFopen", query = "SELECT w FROM Workerschedule w WHERE w.fopen = :fopen"),
    @NamedQuery(name = "Workerschedule.findByFclose", query = "SELECT w FROM Workerschedule w WHERE w.fclose = :fclose"),
    @NamedQuery(name = "Workerschedule.findBySopen", query = "SELECT w FROM Workerschedule w WHERE w.sopen = :sopen"),
    @NamedQuery(name = "Workerschedule.findBySclose", query = "SELECT w FROM Workerschedule w WHERE w.sclose = :sclose"),
    @NamedQuery(name = "Workerschedule.findBySunopen", query = "SELECT w FROM Workerschedule w WHERE w.sunopen = :sunopen"),
    @NamedQuery(name = "Workerschedule.findBySunclose", query = "SELECT w FROM Workerschedule w WHERE w.sunclose = :sunclose")})
public class Workerschedule implements Serializable {
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
    @JoinColumn(name = "WORKERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users workerid;

    public Workerschedule() {
    }

    public Workerschedule(Integer scheduleid) {
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

    public Users getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Users workerid) {
        this.workerid = workerid;
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
        if (!(object instanceof Workerschedule)) {
            return false;
        }
        Workerschedule other = (Workerschedule) object;
        if ((this.scheduleid == null && other.scheduleid != null) || (this.scheduleid != null && !this.scheduleid.equals(other.scheduleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Workerschedule[ scheduleid=" + scheduleid + " ]";
    }
    
}
