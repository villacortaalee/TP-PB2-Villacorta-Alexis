package ar.edu.unlam.pb2.cazadoresDeRecompensas;

@SuppressWarnings("serial")
public class ProfugoInvalidoException extends RuntimeException{
	public ProfugoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
