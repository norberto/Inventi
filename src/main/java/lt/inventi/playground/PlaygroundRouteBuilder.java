package lt.inventi.playground;

import org.apache.camel.builder.*;

/**
 * 8th task
 */

public class PlaygroundRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("cxf:bean:pingPongEndpoint")
                .to("cxf:bean:mockEndpoint");
    }
}
