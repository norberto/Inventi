package lt.inventi.playground;

import org.apache.camel.builder.*;
import java.util.Random;

/**
 * Task #2. Pagal Timer'į generuojamas atsitiktinis skaičius (bent 3 variantus, pvz. daugiau už X, daugiau už Y, kitaip)
 * ir priklausomai nuo jo reikšmės, veiksmas perduodamas į kitus "route'us" (direct).
 * Juose išvedamas kažkoks (kiekvienam atvejui skirtingas) tekstas į konsolę bei pati atsitiktinio skaičiaus reikšmė.
 * Iš Java kodo gali būti išvedamas tik tekstas bei skaičius,
 * o sąlyga turėtų būti tikrinama su Camel DSL direktyvomis (reikia susirasti, kokiomis). - Camel choice when
 */
public class PlaygroundRouteBuilder extends RouteBuilder {

    public static final int X = 27;
    public static final int Y = 77;
    public static int temp;
    public static class RandomGenerator {
        public int out(){
            Random random = new Random();
            temp = random.nextInt(150);
            return temp;
        }
    }

    public static class Output {
        public void lessThanX(){ System.out.println("Less than X: " + temp); }
        public void lessThanY(){ System.out.println("Less than Y: " + temp); }
        public void moreThanXY(){ System.out.println("Larger than X and Y: " + temp); }

    }
    public void configure() throws Exception {
        from("timer://timer?period=2000")
            .beanRef("randomGenerator")
                .choice()
                .when(simple("${body} < " + X)).to("bean:output?method=lessThanX")
                .when(simple("${body} < " + Y)).to("bean:output?method=lessThanY")
                .otherwise().to("bean:output?method=moreThanXY");
    }
}

