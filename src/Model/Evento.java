package Model;
import java.util.Date;


public class Evento {

    private String lugar;
    private String fecha;
    private String hora;
    private String motivo;

    public Evento(String lugar, String fecha, String hora, String motivo){
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getMotivo() {
        return motivo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "lugar='" + lugar + '\'' +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
