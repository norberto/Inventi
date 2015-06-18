package lt.inventi.playground;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.*;

/**
 * 9th task
 */

public class PlaygroundRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("cxf:bean:pingPongEndpoint")
            .log(LoggingLevel.INFO, "Request Received")
            .to("cxf:bean:mockEndpoint")
            .log(LoggingLevel.INFO, "Response Sent");
    }
}
