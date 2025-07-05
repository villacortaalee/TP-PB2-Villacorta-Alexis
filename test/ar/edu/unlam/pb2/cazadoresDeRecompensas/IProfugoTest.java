package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import static org.junit.Assert.*;

import org.junit.Test;

public class IProfugoTest {

	@Test
    public void queElProfugoConArtesMarcialesTengaHabilidadDoblada() {
        IProfugo profugoInicial = new Profugo("Juan", 20, 40, true);
        IProfugo profugoEntrenado = new ArtesMarcialesAvanzadas(profugoInicial);

        assertEquals(Integer.valueOf(80), profugoEntrenado.getHabilidad());
    }

    @Test
    public void queLaHabilidadNoSupereElMaximoConArtesMarciales() {
        IProfugo profugoInicial = new Profugo("Ana", 10, 60, false);
        IProfugo profugoEntrenado = new ArtesMarcialesAvanzadas(profugoInicial);

        assertEquals(Integer.valueOf(100), profugoEntrenado.getHabilidad()); // 60*2 = 120 → tope = 100
    }

    @Test
    public void queElEntrenamientoEliteEviteNerviosismo() {
        IProfugo profugoInicial = new Profugo("Sasha", 50, 30, true);
        IProfugo profugoElite = new EntrenamientoElite(profugoInicial);
        assertFalse(profugoElite.esNervioso());
    }

    @Test
    public void queLaProteccionLegalEviteBajarInocenciaMenorA40() {
        IProfugo profugoInicial = new Profugo("Pablo", 45, 25, true);
        IProfugo profugoProtegido = new ProteccionLegal(profugoInicial);
        profugoProtegido.reducirInocencia(10); // 45 → 35 → debería quedar en 40 por protección
        assertEquals(Integer.valueOf(40), profugoProtegido.getInocencia());
    }

    @Test
    public void queLosEntrenamientosSePuedanEncadenar() {
        IProfugo profugoInicial = new Profugo("Leo", 50, 30, true);
        IProfugo combinado = new ProteccionLegal(
                                new EntrenamientoElite(
                                  new ArtesMarcialesAvanzadas(profugoInicial)));

        assertFalse(combinado.esNervioso()); // Por entrenamiento elite
        assertEquals(Integer.valueOf(60), combinado.getHabilidad()); // 30*2
        combinado.reducirInocencia(20);
        assertEquals(Integer.valueOf(40), combinado.getInocencia()); // no baja de 40
    }

}
