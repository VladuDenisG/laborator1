package ro.ulbs.proiectaresoftware.lab6.advanced;

import lab5.AplicatieCuBursa;
import lab5.StudentBursier;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AplicatieCuBursaTest {

    @Test
    void testSorteaza() {
        AplicatieCuBursa app = new AplicatieCuBursa();
        List<StudentBursier> lista = app.genereaza();

        app.sorteaza(lista);

        assertNotNull(lista);
        assertEquals(5, lista.size());
        assertEquals("ISM141/1", lista.get(0).getFormatieDeStudiu());
        assertEquals("Mihalcea", lista.get(0).getNume());

        assertEquals("ISM141/2", lista.get(1).getFormatieDeStudiu());
        assertEquals("Popa", lista.get(1).getNume());

        assertEquals("TI131/1", lista.get(2).getFormatieDeStudiu());
        assertEquals("Popescu", lista.get(2).getNume());
        assertEquals(100.0, lista.get(2).getCuantumBursa());

        assertEquals("TI131/1", lista.get(3).getFormatieDeStudiu());
        assertEquals("Popescu", lista.get(3).getNume());
        assertEquals(780.8, lista.get(3).getCuantumBursa());

        assertEquals("TI131/1", lista.get(4).getFormatieDeStudiu());
        assertEquals("Prodan", lista.get(4).getNume());;


    }
}