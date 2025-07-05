package ar.edu.unlam.pb2.cazadoresDeRecompensas;

@SuppressWarnings("serial")
public class CazadorInvalidoException extends RuntimeException{
	public CazadorInvalidoException(String mensaje) {
        super(mensaje);
    }
}

