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
    public void configure() throws Exception {
        from("cxf:bean:pingPongEndpoint")
                .filter()
                .xpath("//pin:echoInput/pin:input/text()", ns)
                .process(new Processor() {
                         public void process(Exchange msg) {
                             String temp = msg.getIn().getBody(String.class);
                             temp = temp.replaceAll("echoInput", "echoInputResponse");
                             temp = temp.replaceAll("input", "echoInputReturn");
                             msg.getIn().setBody(temp);
                         }
                 });
    }
}

