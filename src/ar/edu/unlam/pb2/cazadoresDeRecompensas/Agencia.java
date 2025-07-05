package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.*;

public class Agencia {

    private Set<Cazador> cazadores;

    public Agencia() {
        this.cazadores = new HashSet<>();
    }

    public void registrarCazador(Cazador cazador) {
        this.cazadores.add(cazador);
    }

    /* Punto 1) Todos los prófugos capturados por todos los cazadores */
    public Set<Profugo> obtenerTodosLosCapturados() {
        Set<Profugo> capturados = new HashSet<>();

        for (Cazador cazador : cazadores) {
            capturados.addAll(cazador.getCapturados());
        }

        return capturados;
    }

    /* Punto 2) El prófugo capturado con mayor habilidad */
    public Profugo obtenerMasHabilCapturado() {
        Profugo masHabil = null;
        Integer habilidadMaxima = -1;

        for (Cazador cazador : cazadores) {
            for (Profugo profugo : cazador.getCapturados()) {
                if (profugo.getHabilidad() > habilidadMaxima) {
                    habilidadMaxima = profugo.getHabilidad();
                    masHabil = profugo;
                }
            }
        }

        return masHabil;
    }

    /* 3) El cazador con más capturas realizadas */
    public Cazador obtenerCazadorConMasCapturas() {
        Cazador mejorCazador = null;
        Integer maxCapturas = -1;

        for (Cazador cazador : cazadores) {
            Integer capturas = cazador.getCapturados().size();
            if (capturas > maxCapturas) {
                maxCapturas = capturas;
                mejorCazador = cazador;
            }
        }

        return mejorCazador;
    }
}