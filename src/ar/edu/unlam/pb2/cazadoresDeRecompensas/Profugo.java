package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class Profugo implements IProfugo {

	private String nombre;
	private Integer lvlInocencia;
	private Integer lvlHabilidad;
	private Boolean esNervioso;

	public Profugo(String nombre, Integer lvlInocencia, Integer lvlHabilidad, Boolean esNervioso) {
		
		this.nombre = nombre;
		this.lvlInocencia = lvlInocencia;
		this.lvlHabilidad = lvlHabilidad;
		this.esNervioso=esNervioso;
		
		if(nombre.isEmpty() || nombre == null) {
			throw new ProfugoInvalidoException("El nombre del prófugo no puede estar vacío");
		} else 
		if(lvlHabilidad < 1) {
			throw new ProfugoInvalidoException("El nivel de habilidad del Profugo no puede ser menor a 1");
		} else
		if(lvlHabilidad > 100) {
			throw new ProfugoInvalidoException("El nivel de habilidad del Profugo no puede ser mayor a 100");
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getlvlHabilidad() {
		return this.lvlHabilidad;
	}

	public Integer getInocencia() {
		return this.lvlInocencia;
	}

	public Integer getHabilidad() {
		return this.lvlHabilidad;
	}
	
	public Boolean esNervioso() {
		return this.esNervioso;
	}

	@Override
	 public void reducirHabilidad(Integer cantidad) {
        if (cantidad < 0) {
    	        throw new IllegalArgumentException("No se puede reducir habilidad con un valor negativo.");
        }
        if (lvlHabilidad - cantidad < 0) {
        		lvlHabilidad = 0;
        } else {
        		lvlHabilidad -= cantidad;
        }
    }

	@Override
	public void reducirInocencia(Integer cantidad) {
	    if (cantidad < 0) {
	        throw new IllegalArgumentException("No se puede reducir inocencia con un valor negativo.");
	    }
	    else if (lvlInocencia - cantidad < 0) 
	    		lvlInocencia = 0;
    		else
    			lvlInocencia -= cantidad;
	}

	@Override
	public void setNervioso(Boolean nervioso) {
		this.esNervioso = nervioso;
	}
	
}
