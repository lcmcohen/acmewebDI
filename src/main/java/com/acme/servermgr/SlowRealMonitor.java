package com.acme.servermgr;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Implement a fake server monitor such as would be used for unit tests, annotated as a Spring Service.
 */
@Service
@Primary    // Use of this may cause unit tests to fail since they expect a canned output
public class SlowRealMonitor   implements IMonitorableServer      {

    public String determineServerStatus() {
        Boolean goodStatus = true;
        int     origNumCPUs;
        Runtime rt = Runtime.getRuntime();

        origNumCPUs = rt.availableProcessors();
        wait4seconds();
        if (rt.availableProcessors() != origNumCPUs) {
            goodStatus = false;
        }

        return goodStatus ? "Server is up and running well, #CPUs available is: " + origNumCPUs
                : "Server is up with a varying number of available CPUs";

    }



    private void wait4seconds()
    {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
