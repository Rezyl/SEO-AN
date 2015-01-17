package com.ppro.spring.model;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Entity
@Table(name = "page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long pageID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_fk", referencedColumnName = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "creation_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationDate;
    @Column(name = "url")
    private String url;

    public Long getPageID() {
        return pageID;
    }

    public void setPageID(Long pageID) {
        this.pageID = pageID;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
