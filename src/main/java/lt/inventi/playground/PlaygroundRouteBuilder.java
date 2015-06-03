package lt.inventi.playground;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.*;
import org.apache.camel.builder.xml.Namespaces;

/**
 * 6th task
 * Part: xpath
 */

public class PlaygroundRouteBuilder extends RouteBuilder {
    Namespaces ns = new Namespaces("pin", "http://pingpong.bpel.tps");
    String prefix = "<pin:echoInputResponse xmlns:pin=\"http://pingpong.bpel.tps\">\n" + "<pin:echoInputReturn>";
    String postfix = "</pin:echoInputReturn>\n" + "</pin:echoInputResponse>\n";

    public void configure() throws Exception {
        from("cxf:bean:pingPongEndpoint")
                .filter(ns.xpath("//pin:echoInput/pin:input"))
                .setBody(ns.xpath("//pin:input/text()"))
                .end()
                .setBody(body().append(postfix).prepend(prefix))
                .log(LoggingLevel.INFO, "\n\n${body}\n");
    }
}

