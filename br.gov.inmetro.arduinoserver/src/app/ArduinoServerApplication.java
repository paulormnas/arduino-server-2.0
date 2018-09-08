package app;

import org.glassfish.jersey.server.ResourceConfig;

public class ArduinoServerApplication extends ResourceConfig {
    public ArduinoServerApplication() {
        // Define the package which contains the service classes.
        packages("br.gov.inmetro.arduinoserver.services");
    }
}