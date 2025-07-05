package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class CazadorTest {
	
	
    @Test
    public void queUnCazadorUrbanoPuedaCapturarAUnProfugoNerviosoYConMenorInocencia() {
        Cazador c1 = new CazadorUrbano("Bond");
        c1.sumarExperiencia(80);
        Profugo p1 = new Profugo("Carlos", 50, 60, false);
        assertTrue(c1.puedeCapturar(p1));
    }

    @Test
    public void queUnCazadorSigilosoNoPuedaCapturarPeroSiPuedaIntimidarYReducirHabilidad() {
        Cazador cazador = new CazadorSigiloso("Snake");
        cazador.sumarExperiencia(100);

        Profugo profugo = new Profugo("Nico", 50, 70, true); // no puede capturar, habilidad > 50

        assertFalse(cazador.puedeCapturar(profugo));
        int habilidadAntes = profugo.getHabilidad();

        cazador.intimidar(profugo);

        assertEquals(Integer.valueOf(habilidadAntes - 5), profugo.getHabilidad());
    }

    @Test
    public void queUnCazadorRuralVayaAIntimidarYLuegoVuelvaNerviosoAlProfugo() {
        Cazador cazador = new CazadorRural("Rambo");
        cazador.sumarExperiencia(100);
        Profugo profugo = new Profugo("Pedro", 80, 60, false); // no nervioso => no capturable
        cazador.intimidar(profugo);
        assertTrue(profugo.esNervioso());
    }

    @Test
    public void queElCazadorEsteSumandoExperienciaCorrectamente() {
    	Cazador cazador = new CazadorSigiloso("Solid Snake");
        cazador.sumarExperiencia(100);

        Profugo p1 = new Profugo("Ines", 30, 45, true);  // capturable
        Profugo p2 = new Profugo("Zoe", 90, 70, true);   // será intimidado

        Zona zona = new Zona("Puente");
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);

        zona.procesoCaptura(cazador);

        int experienciaEsperada = 100 + 70 + (2 * 1); // habilidad de p2 antes de intimidar
        assertEquals(experienciaEsperada, cazador.getExperiencia());
    }

    @Test
    public void queElCazadorEsteGuardandoLosProfugosQueSonCapturados() {
    	Cazador cazador = new CazadorUrbano("Bond");
        cazador.sumarExperiencia(100);

        Profugo p1 = new Profugo("Leo", 40, 20, false); // capturable
        Profugo p2 = new Profugo("Fran", 70, 50, true); // no capturable (nervioso)

        Zona zona = new Zona("Ciudad");
        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);

        zona.procesoCaptura(cazador);

        Set<Profugo> capturados = cazador.getCapturados();

        assertTrue(capturados.contains(p1));
        assertFalse(capturados.contains(p2));
        assertEquals(1, capturados.size());
    }

    
}
