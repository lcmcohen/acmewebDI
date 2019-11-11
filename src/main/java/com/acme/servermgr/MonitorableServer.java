package com.acme.servermgr;

/**
 * Declare contract for what a server monitor must be capable of doing.
 */
public interface MonitorableServer {
    String determineServerStatus();
}
