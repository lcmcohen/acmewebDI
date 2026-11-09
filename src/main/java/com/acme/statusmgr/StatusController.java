package com.acme.statusmgr;

import java.util.concurrent.atomic.AtomicLong;

import com.acme.statusmgr.beans.ServerStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for all web/REST requests about the status of servers
 *
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 *    All start with /server
 *    /status  will give back status of server
 *    a param of 'name' specifies a requestor name to appear in response
 *
 * Examples:
 *    http://localhost:8080/server/status
 *
 *    http://localhost:8080/server/status?name=Noach
 *
 *
 *
 */

@RestController
@RequestMapping("/server")
public class StatusController {

    static {
        // For debug/demo purposes only, dump out class path to stdout to show where resources will come from
        System.out.println("*** JAVA CLASS PATH***\n" +
                System.getProperty("java.class.path").replace  (":", "      :      ") + "***********\n");
    }

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();

    @RequestMapping("/status")
    public ServerStatus greeting(@RequestParam(value="name", defaultValue="Anonymous") String name) {
        return new ServerStatus(counter.incrementAndGet(),
                            String.format(template, name));
    }




    /**
     * Handle a POST HTTP message telling us about items that have gone low on inventory.
     * This is code for a Spring web server, method would go into
     * a class declared as:
     *          @RestController
     *          @RequestMapping("/server")
     *          public class StatusController { ... }
     *
     */
@PostMapping("/lowinventory")
public String handleLowInventory(@RequestBody String requestBody) {
        System.out.println("RAW MSG:\n\n" + requestBody);

    try {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode outerJson = mapper.readTree(requestBody);

        String innerMessageStr = outerJson.path("Message").asText();

        // Step 3: Parse the inner string into a secondary JsonNode
        JsonNode innerJson = mapper.readTree(innerMessageStr);

        // Step 4: Safely extract your visual fields!
        String itemName = innerJson.path("itemName").asText("Unknown Item");

        System.out.println("\n\n********");
        System.out.println("Item Name: " + itemName);
        System.out.println("********\n\n");

        // Process the request body (string)
        System.out.println("\n\n********\n\nACE HARDWARE has received LOW INVENTORY Message about: " + itemName);
        System.out.println("We have the requested items in stock and are shipping them out.");
        System.out.println("\n*******\n\n");

    } catch (Exception e) {
        System.out.println("Failed to parse JSON: " + e.getMessage());
    }


    // Return a response string
    return "Processed: " + requestBody;
}
}
