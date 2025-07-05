package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class EntrenamientoElite implements IProfugo {
    private IProfugo profugoInicial;

    public EntrenamientoElite(IProfugo profugoInicial) {
        this.profugoInicial = profugoInicial;
    }

    @Override
    public Integer getInocencia() {
        return profugoInicial.getInocencia();
    }

    @Override
    public Integer getHabilidad() {
        return profugoInicial.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return false; // Nunca nervioso, sin importar el profugoInicial
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
        /* En este caso nunca cambia de estado*/
    }

    @Override
    public String getNombre() {
        return profugoInicial.getNombre();
    }
}

