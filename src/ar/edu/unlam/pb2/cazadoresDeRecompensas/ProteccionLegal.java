package ar.edu.unlam.pb2.cazadoresDeRecompensas;

public class ProteccionLegal implements IProfugo {
    private IProfugo profugoInicial;
    
    // IProfugo profugoInicial = new Profugo("Pablo", 45, 25, true);
    
    public ProteccionLegal(IProfugo profugoInicial) {
        this.profugoInicial = profugoInicial;
    }

    @Override
    public Integer getInocencia() {
        int inocenciaProfugoInicial = profugoInicial.getInocencia();
        if (inocenciaProfugoInicial < 40) {
            return 40;
        } else {
            return inocenciaProfugoInicial;
        }
    }

    @Override
    public Integer getHabilidad() {
        return profugoInicial.getHabilidad();
    }

    @Override
    public Boolean esNervioso() {
        return profugoInicial.esNervioso();
    }

    @Override
    public void reducirInocencia(Integer cantidad) {
        Integer inocenciaActual = profugoInicial.getInocencia();
        
        Integer cantidadReal;
        
        // Queremos bajar solo hasta 40, no más
        Integer inocenciaResultante = inocenciaActual - cantidad;
        
        if (inocenciaResultante < 40) {
            cantidadReal = inocenciaActual - 40;
        } else {
            cantidadReal = cantidad;
        }
        
        profugoInicial.reducirInocencia(cantidadReal);
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

