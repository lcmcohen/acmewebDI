package com.acme.servermgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple methods for use in school project
 */
@Component
public class ServerManager {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    /**
     * Reference to a class that knows how to get details about what we are interested in on a server
     */
    @Autowired
    private IMonitorableServer monitor;


    /**
     * Get the status of this server
     * @return a descriptive string about the servers status
     */
     public String getCurrentServerStatus() {
         LOGGER.info("Will attempt to get server status from the {} Monitor", monitor);

        String status = monitor.determineServerStatus();
        LOGGER.info("Obtained server status '{}' from the {} Monitor", status, monitor);
        return status;
    }

    /**
     * Find out if this server is operating normally
     * @return Boolean indicating if server is operating normally
     */
     public Boolean isOperatingNormally()
    {
        return true;
    }    //TODO should eventually use the monitor interface
}
