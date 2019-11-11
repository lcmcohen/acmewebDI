package com.acme.servermgr;

import org.springframework.stereotype.Service;

/**
 * Implement a fake server monitor such as would be used for unit tests, annotated as a Spring Service.
 */
@Service
public class FakeMonitor implements MonitorableServer {
    @Override
    public String determineServerStatus() {
        return "Server is up";
    }
}
