package lt.inventi.playground;

import org.apache.camel.builder.*;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

/**
 * 6th task
 * Part: jaxb
 */
public class PlaygroundRouteBuilder extends RouteBuilder {
    DataFormat jaxb = new JaxbDataFormat("tps.bpel.pingpong");
    public void configure() throws Exception {
       from("cxf:bean:pingPongEndpoint")
               .unmarshal(jaxb)
               .beanRef("requestManager", "fromRequestToResponse");
    }
}