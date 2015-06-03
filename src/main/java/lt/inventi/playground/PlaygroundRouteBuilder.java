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

/** TODO
 *
 * 1] Github pakeisti root i base dir(re-base i ../), kad includintu pom.xml and stuff (turetume galeti kompiliuoti)
 * 2] Xpath pertvarkyti xpath (dunno kaip tiksliai, nes ne viska supratau. -> ask later)
 *
 */