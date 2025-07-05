package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class CazadorUrbano extends Cazador {

    public CazadorUrbano(String nombre) {
        super(nombre);
    }

    @Override
    public Boolean puedeCapturar(Profugo miProfugo) {
    	
    	Boolean estadoInicial = false;
    	
    	if(this.experiencia > miProfugo.getInocencia() && !miProfugo.esNervioso()) {
    		estadoInicial = true;
    	}else {
    		estadoInicial = false;
    	}
    	
        return estadoInicial;
    }

    @Override
    public void intimidar(Profugo miProfugo) {
    	miProfugo.reducirInocencia(2);
    	miProfugo.setNervioso(false);
    }
}
