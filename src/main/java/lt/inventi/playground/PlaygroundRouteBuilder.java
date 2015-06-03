package lt.inventi.playground;

import org.apache.camel.*;
import org.apache.camel.builder.*;
/**
 * First task: 'Hello world!' every two seconds (using Processor).
 */
public class PlaygroundRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("timer://timer?period=2000")
                .process(new Processor() {
                    public void process(Exchange msg) {
                        System.out.println("Hello world!");
                    }
                }
        );
    }
}

