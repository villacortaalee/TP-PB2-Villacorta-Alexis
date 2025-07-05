package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class CazadorSigiloso extends Cazador{

	public CazadorSigiloso(String nombre) {
		super(nombre);
	}
	
	 @Override
    public Boolean puedeCapturar(Profugo miProfugo) {
		 
		 Boolean estadoInicial = false;
		 
		 if(this.experiencia > miProfugo.getInocencia() && miProfugo.getHabilidad() < 50) {
			 estadoInicial = true;
		 }else {
			 estadoInicial = false;
		 }
		 
		 return estadoInicial;

    }

    @Override
    public void intimidar(Profugo miProfugo) {
    	miProfugo.reducirInocencia(2);
    	miProfugo.reducirHabilidad(5);
    }

}
