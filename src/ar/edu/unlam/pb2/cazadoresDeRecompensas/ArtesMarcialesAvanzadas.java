package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class ArtesMarcialesAvanzadas implements IProfugo{

	private IProfugo profugoInicial;

    public ArtesMarcialesAvanzadas(IProfugo profugoInicial) {
        this.profugoInicial = profugoInicial;
    }

    @Override
    public Integer getInocencia() {
        return profugoInicial.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        int habilidadOriginal = profugoInicial.getHabilidad();
        int habilidadDoblada = habilidadOriginal * 2;

        if (habilidadDoblada > 100) {
            return 100;
        } else {
            return habilidadDoblada;
        }
    }

    @Override
    public Boolean esNervioso() {
        return profugoInicial.esNervioso();
    }

    @Override
    public void reducirInocencia(Integer cantidad) {
        profugoInicial.reducirInocencia(cantidad);
    }

    @Override
    public void reducirHabilidad(Integer cantidad) {
        profugoInicial.reducirHabilidad(cantidad);
    }

    @Override
    public void setNervioso(Boolean nervioso) {
        profugoInicial.setNervioso(nervioso);
    }

    @Override
    public String getNombre() {
        return profugoInicial.getNombre();
    }

}
