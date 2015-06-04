package lt.inventi.playground;

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
            .setHeader("msg", ns.xpath("//pin:input/text()"))
            .setBody(header("msg").prepend(prefix).append(postfix));
    }
}

