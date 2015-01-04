package com.ppro.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 6.11.14
 */
@Entity
@Table (name = "profile")
public class Profile {

    @Id
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "url")
    private String url;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
    private List<SearchResult> historyOfSearch = new ArrayList<SearchResult>();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<SearchResult> getHistoryOfSearch() {
        return historyOfSearch;
    }

    public void setHistoryOfSearch(List<SearchResult> historyOfSearch) {
        this.historyOfSearch = historyOfSearch;
    }
}
