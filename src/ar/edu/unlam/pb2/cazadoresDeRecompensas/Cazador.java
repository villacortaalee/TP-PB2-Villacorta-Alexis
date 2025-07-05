package ar.edu.unlam.pb2.cazadoresDeRecompensas;

import java.util.HashSet;
import java.util.Set;

public abstract class Cazador {
	
    protected String nombre;
    protected int experiencia;
    protected Set<Profugo> capturados = new HashSet<>();

    public Cazador(String nombre) {
    	
        if (nombre == null || nombre.isEmpty()) {
            throw new CazadorInvalidoException("El nombre no puede estar vacío.");
	        }
	        this.nombre = nombre;
	        this.experiencia = 0;
	    }

	    public void capturar(Profugo p) {
	        capturados.add(p);
	    }

	    public Set<Profugo> getCapturados() {
	        return new HashSet<>(capturados);
	    }

	    public int getExperiencia() {
	        return experiencia;
	    }

	    public void sumarExperiencia(int cantidad) {
	        this.experiencia += cantidad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int cantidadCapturas() {
	        return capturados.size();
	    }

	    public abstract Boolean puedeCapturar(Profugo p);
	    
	    public abstract void intimidar(Profugo p);

}

