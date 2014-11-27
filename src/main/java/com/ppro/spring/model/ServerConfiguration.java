package com.ppro.spring.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 6.11.14
 */
@Entity
@Table
public class ServerConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long configurationID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVER_ID", nullable = false)
    private Server server;

    @Column
    private String configurationKey;

    @Column
    private String configurationValue;

    public Long getConfigurationID() {
        return configurationID;
    }

    public void setConfigurationID(Long configurationID) {
        this.configurationID = configurationID;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public String getConfigurationKey() {
        return configurationKey;
    }

    public void setConfigurationKey(String configurationKey) {
        this.configurationKey = configurationKey;
    }

    public String getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }
}
