package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfugoTest {

    @Test
    public void queSePuedaCrearUnProfugoCorrectamente() {
        Profugo p1 = new Profugo("Carlos", 50, 80, true);

        assertEquals("Carlos", p1.getNombre());
        assertEquals(Integer.valueOf(50), p1.getInocencia());
        assertEquals(Integer.valueOf(80), p1.getHabilidad());
        assertTrue(p1.esNervioso());
    }

    @Test(expected = ProfugoInvalidoException.class)
    public void queNoSePuedaCrearUnProfugoCuyoNombreEsteVacio() {
        new Profugo("", 40, 70, false);
    }

    @Test(expected = ProfugoInvalidoException.class)
    public void queNoSePuedaCrearUnProfugoQueTengaUnNivelDeHabilidadMayorA120() {
        new Profugo("Carlos", 40, 120, false);
    }

    @Test
    public void queAlReducirElNivelDeInocenciaYDeHabilidadNoSeaMenorACero() {
        Profugo p1 = new Profugo("Pepe", 3, 4, true);

        p1.reducirInocencia(10);
        p1.reducirHabilidad(10);

        assertEquals(Integer.valueOf(0), p1.getInocencia());
        assertEquals(Integer.valueOf(0), p1.getHabilidad());
    }

    @Test(expected = IllegalArgumentException.class)
    public void queNoSePuedaReducirElNivelDeHabilidadDelProfugoConNumerosNegativos() {
        Profugo p1 = new Profugo("Juan", 20, 30, false);
        p1.reducirHabilidad(-5);
    }

    @Test
    public void queSePuedaCambiarElEstadoDeNerviosismoDelProfugo() {
        Profugo p1 = new Profugo("Ana", 40, 60, true);
        p1.setNervioso(false);
        assertFalse(p1.esNervioso());
    }
	
	
	

}
