package com.acme.statusmgr.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus {

    private  long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * This will refer to an instance of the ServerManager class (no longer static)
     */
    private ServerManager serverManager;

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain and save reference to the ServerManager
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");
    }

    public ServerStatus() {

    }

    public long getId() {
        return id;
    }

    public String getContentHeader() {

        return contentHeader;
    }


    public String getStatusDesc() {
        return serverManager.getCurrentServerStatus();
    }


}
