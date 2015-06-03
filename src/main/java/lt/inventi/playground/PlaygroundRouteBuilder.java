package lt.inventi.playground;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.*;

/**
 * Fifth task
 */

public class PlaygroundRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("cxf:bean:pingPongEndpoint")
            .log(LoggingLevel.INFO, "${body}");
    }
}

