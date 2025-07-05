package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class AgenciaTest {

	@Test
	public void queSePuedanObtenerTodosLosProfugosCapturadosPorLaAgencia() {
	    Agencia agencia = new Agencia();

	    Cazador cazador1 = new CazadorRural("Rambo");
	    Cazador cazador2 = new CazadorUrbano("Bond");

	    Profugo p1 = new Profugo("Ines", 10, 30, true);
	    Profugo p2 = new Profugo("Lautaro", 20, 40, false);

	    cazador1.capturar(p1);
	    cazador2.capturar(p2);

	    agencia.registrarCazador(cazador1);
	    agencia.registrarCazador(cazador2);

	    Set<Profugo> capturados = agencia.obtenerTodosLosCapturados();

	    assertEquals(2, capturados.size());
	    assertTrue(capturados.contains(p1));
	    assertTrue(capturados.contains(p2));
	}
	
	@Test
	public void queSeObtengaElProfugoMasHabilCapturado() {
	    Agencia agencia = new Agencia();

	    Cazador cazador = new CazadorSigiloso("Snake");

	    Profugo p1 = new Profugo("P1", 10, 40, true);
	    Profugo p2 = new Profugo("P2", 15, 95, false);

	    cazador.capturar(p1);
	    cazador.capturar(p2);

	    agencia.registrarCazador(cazador);

	    Profugo masHabil = agencia.obtenerMasHabilCapturado();

	    assertEquals(p2, masHabil);
	}
	
	@Test
	public void queSeObtengaElCazadorConMasCapturas() {
	    Agencia agencia = new Agencia();

	    Cazador uno = new CazadorRural("Uno");
	    Cazador dos = new CazadorUrbano("Dos");

	    Profugo p1 = new Profugo("P1", 10, 10, false);
	    Profugo p2 = new Profugo("P2", 20, 20, true);
	    Profugo p3 = new Profugo("P3", 30, 30, true);

	    uno.capturar(p1);
	    dos.capturar(p2);
	    dos.capturar(p3);

	    agencia.registrarCazador(uno);
	    agencia.registrarCazador(dos);

	    Cazador mayor = agencia.obtenerCazadorConMasCapturas();

	    assertEquals(dos, mayor);
	}
	
}
