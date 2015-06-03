package lt.inventi.playground;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.*;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;

/**
 * Task #3. Panaudoti Camel'io komponentą, kuris nuskaito ir rašo į failus.
 * Jeigu failas buvo tuščias, nieko nedaroma. Kitaip reikia failo turinį paversti
 * mažosiomis raidėmis, pridėti savo kažkokią signatūrą ir viską įrašyti į kitą
 * failą su "-result" priedėliu prie failo vardo (prieš failo išplėtimą).
 *
 * Užduočiai atlikti reikia kaip galima labiau naudoti Camel priemones, kur tik įmanoma (ir pavyks rasti).
 * Privaloma panaudoti "simple" (ir "file") kalbą.
 */
public class PlaygroundRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("file://files?noop=true")
            .split(body(String.class).tokenize("\n"))
            .aggregationStrategy(new AggregationStrategy() {
                public Exchange aggregate(Exchange olde, Exchange newe) {
                    if (olde == null) {
                        newe.getIn().setBody(newe.getIn().getBody(String.class));
//                        System.out.println(newe.getIn().getBody(String.class));
                        return newe;
                    }

                    String oldExchange = olde.getIn().getBody(String.class);
                    String newExchange = newe.getIn().getBody(String.class);
                    olde.getIn().setBody(oldExchange + newExchange);
//                    System.out.println(olde.getIn().getBody(String.class));
                    return olde;
                }
            })
            .setBody(body().prepend(simple("${property.CamelSplitIndex}++ ")))
            .end()
            .to("file://files/results?fileName=${file:name.noext}-result")
        ;
    }
}

