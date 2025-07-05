package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class CazadorSigiloso extends Cazador{

	public CazadorSigiloso(String nombre) {
		super(nombre);
	}
	
	 @Override
    public Boolean puedeCapturar(Profugo p) {
        return this.experiencia > p.getInocencia() && p.getHabilidad() < 50;
    }

    @Override
    public void intimidar(Profugo p) {
        p.reducirInocencia(2);
        p.reducirHabilidad(5);
    }

}
