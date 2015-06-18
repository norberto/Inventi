package lt.inventi.playground;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.*;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;

/**
 * Task #10. Tas pats, kas ir 4 užduotyje, tik pirma rezultatų failas turi atsigulti kažkokioje ActiveMQ eilėje,
 * o iš jos kitas "route'as" turi turinį įrašyti į "result" failą (pavadinimo sudarymo taisyklės išlieka).
 */
public class PlaygroundRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("file://files/?noop=true")
            .split(body(String.class).tokenize("\n"))
            .aggregationStrategy(new AggregationStrategy() {
                public Exchange aggregate(Exchange olde, Exchange newe) {
                    if (olde == null) {
                        newe.getIn().setBody(newe.getIn().getBody(String.class));
                      // System.out.println(newe.getIn().getBody(String.class));
                        return newe;
                    }

                    String oldExchange = olde.getIn().getBody(String.class);
                    String newExchange = newe.getIn().getBody(String.class);
                    olde.getIn().setBody(oldExchange + newExchange);
                   // System.out.println(olde.getIn().getBody(String.class));
                    return olde;
                }
            })
            .setBody(body().prepend(simple("${property.CamelSplitIndex}++ ")))
            .end()
            .to("activemq:queue:in");

            from("activemq:queue:in")
            .to("file://files/results/?fileName=${file:name.noext}-result");
        ;
    }
}

