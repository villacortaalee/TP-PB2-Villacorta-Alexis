package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public interface IProfugo{
	
	Integer getInocencia();
    Integer getHabilidad();
    Boolean esNervioso();
    
	void reducirHabilidad(Integer cantidad);
	void reducirInocencia(Integer cantidad);
	void setNervioso(Boolean nervioso);
	
	String getNombre();
	
}
