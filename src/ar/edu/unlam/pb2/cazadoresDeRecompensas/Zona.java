package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.*;

public class Zona {

	private String nombre;
    private Set<Profugo> profugos;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.profugos = new HashSet<>();
    }

    public void agregarProfugo(Profugo profugo) {
        this.profugos.add(profugo);
    }

    public Set<Profugo> getProfugos() {
        return new HashSet<>(profugos); // Devolvemos copia para proteger el conjunto interno
    }

    public String getNombre() {
        return nombre;
    }
	
	public void procesoCaptura(Cazador cazador) {
	    Set<Profugo> capturados = new HashSet<>();
	    List<Integer> habilidadesIntimidados = new ArrayList<>();

	    for (Profugo p : this.profugos) {
	        if (cazador.puedeCapturar(p)) {
	            cazador.capturar(p);
	            capturados.add(p); // se remueven después
	        } else {
	        	habilidadesIntimidados.add(p.getHabilidad());
	            cazador.intimidar(p);
	        }
	    }

	    // Quitar capturados de la zona
	    this.profugos.removeAll(capturados);

	    // Sumar experiencia
	    int minimoHabilidadIntimidado;

	    if (habilidadesIntimidados.isEmpty()) {
	        minimoHabilidadIntimidado = 0;
	    } else {
	        minimoHabilidadIntimidado = obtenerMinimo(habilidadesIntimidados);
	    }

	    int experienciaGanada = minimoHabilidadIntimidado + (2 * capturados.size());
	    
	    cazador.sumarExperiencia(experienciaGanada);
	}

	private Integer obtenerMinimo(List<Integer> lista) {
		int minimo = lista.get(0);
	    for (int valor : lista) {
	        if (valor < minimo) {
	            minimo = valor;
	        }
	    }
	    return minimo;
	}

}

