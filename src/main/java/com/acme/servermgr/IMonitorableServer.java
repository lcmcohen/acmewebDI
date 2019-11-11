package com.acme.servermgr;

/**
 * Declare contract for what a server monitor must be capable of doing.
 */
public interface IMonitorableServer {

    /**
     * A way to get a general description of the server's status.
     * @return A String with various basic info about server.
     */
    String determineServerStatus();


    // TODO probably should have other definitions of what a server monitor can do
}
