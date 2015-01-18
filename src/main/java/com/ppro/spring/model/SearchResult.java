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
@Table(name = "key_word")
public class SearchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "key_word_id")
    private Long searchResultID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_fk", referencedColumnName = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "creation_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationDate;
    @Column(name = "searched_word")
    private String searchedWord;
    @Column(name = "position")
    private Integer position;
    @Column(name = "server")
    @Enumerated(EnumType.STRING)
    private Server server;

    public Long getSearchResultID() {
        return searchResultID;
    }

    public void setSearchResultID(Long searchResultID) {
        this.searchResultID = searchResultID;
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

    public String getSearchedWord() {
        return searchedWord;
    }

    public void setSearchedWord(String searchedWord) {
        this.searchedWord = searchedWord;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
