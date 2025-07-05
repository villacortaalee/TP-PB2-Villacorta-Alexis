package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZonaTest {

    @Test
    public void queSeCreeUnaZonaQueContengaUnaListaDeProfugos() {
    	  Zona zona = new Zona("Centro");

          Profugo p1 = new Profugo("Juan", 10, 50, true);
          Profugo p2 = new Profugo("Ana", 20, 30, false);

          zona.agregarProfugo(p1);
          zona.agregarProfugo(p2);

          assertEquals("Centro", zona.getNombre());
          assertTrue(zona.getProfugos().contains(p1));
          assertTrue(zona.getProfugos().contains(p2));
          assertEquals(2, zona.getProfugos().size());
    }

    @Test
    public void queSeCaptureAUnProfugoCorrectamenteYNoPermitaDuplicados() {
    	 Zona zona = new Zona("Norte");

         Profugo p1 = new Profugo("Lucas", 15, 40, false);
         zona.agregarProfugo(p1);
         zona.agregarProfugo(p1); // intento agregar el mismo prófugo

         assertEquals(1, zona.getProfugos().size());
    }

    @Test
    public void queSeIntimideAlProfugoCuandoNoSePuedeCapturar() {
    	Zona zona = new Zona("Barrio");
        Cazador cazador = new CazadorUrbano("Bond");
        cazador.sumarExperiencia(50);

        Profugo profugo = new Profugo("Roberto", 60, 70, true); // nervioso, no capturable por urbano
        zona.agregarProfugo(profugo);

        zona.procesoCaptura(cazador);

        // Debe seguir en la zona (no capturado)
        assertTrue(zona.getProfugos().contains(profugo));

        // Nivel de inocencia reducido en 2 (si es urbano, se vuelve no nervioso)
        assertEquals(Integer.valueOf(58), profugo.getInocencia());
        assertFalse(profugo.esNervioso());
    }

    @Test
    public void queLaZonaSeQuedeSinProfugosCapturados() {
    	 Zona zona = new Zona("Centro");
         Cazador cazador = new CazadorSigiloso("Snake");
         cazador.sumarExperiencia(100);

         Profugo p1 = new Profugo("Ana", 30, 40, true);  // capturable
         Profugo p2 = new Profugo("Luis", 70, 60, true);  // no capturable, se intimida

         zona.agregarProfugo(p1);
         zona.agregarProfugo(p2);

         zona.procesoCaptura(cazador);

         // p1 capturado y eliminado
         assertFalse(zona.getProfugos().contains(p1));

         // p2 no capturado y sigue en la zona
         assertTrue(zona.getProfugos().contains(p2));
    }

    @Test
    public void queLaExperienciaDelCazadorSeSumeCorrectamente() {
    	Zona zona = new Zona("Subte");
        Cazador cazador = new CazadorSigiloso("Snake");
        cazador.sumarExperiencia(50);

        Profugo p1 = new Profugo("Uno", 30, 49, true);  // capturable
        Profugo p2 = new Profugo("Dos", 70, 60, true);  // no capturable, se intimida

        zona.agregarProfugo(p1);
        zona.agregarProfugo(p2);

        zona.procesoCaptura(cazador);

        // experiencia += mínima habilidad de intimidados + 2 * capturados
        int esperado = 50 + 60 + (2 * 1); // 50 inicial + 60 (p2) + 2 (1 capturado)
        assertEquals(esperado, cazador.getExperiencia());
    }

    @Test
    public void queNoSePuedaCapturarNiIntimidarSiLaZonaEstaVacia() {
    	Zona zona = new Zona("Vacía");
        Cazador cazador = new CazadorRural("Rambo");
        cazador.sumarExperiencia(100);

        zona.procesoCaptura(cazador);

        // Zona sigue vacía
        assertTrue(zona.getProfugos().isEmpty());

        // No se suma experiencia ni se capturan prófugos
        assertTrue(cazador.getCapturados().isEmpty());
        assertEquals(100, cazador.getExperiencia());
    }
}

