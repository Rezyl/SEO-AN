package com.ppro.spring.model;

import java.util.List;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 6.11.14
 */
@Entity
@Table (name = "server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVER_ID", unique = true, nullable = false)
    private Long serverID;

    @Column
    private String name;
    @Column
    private String url;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "server")
    private List<ServerConfiguration> configurations;

    public Long getServerID() {
        return serverID;
    }

    public void setServerID(Long serverID) {
        this.serverID = serverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ServerConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<ServerConfiguration> configurations) {
        this.configurations = configurations;
    }
}
