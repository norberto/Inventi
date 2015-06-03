package lt.inventi.playground;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.*;

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
        from("file://files")
            .filter(simple("${file:length} > 0"))
                .convertBodyTo(String.class)
                .transform(simple("${body.toLowerCase()}"))
                .transform(simple("${body} \n--- I AM AMAZING --- "))
            .end()
            .to("file://files/results?fileName=${file:name.noext}-result.${file:ext}")
        ;
    }
}

