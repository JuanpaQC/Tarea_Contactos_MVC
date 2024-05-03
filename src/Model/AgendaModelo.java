package Model;
import java.util.ArrayList;
import java.util.Date;

public class AgendaModelo {

    private ArrayList<Contacto> contactos;
    private ArrayList<Evento> eventos;

    public AgendaModelo() {
        contactos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(int indice) {
        contactos.remove(indice);
    }

    public void modificarContacto(int indice, String nombre, String telefono) {
        Contacto contacto = contactos.get(indice);
        contacto.setNombre(nombre);
        contacto.setTelefono(telefono);
        contactos.set(indice, contacto);
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }



    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void eliminarEvento(int indice) {
        eventos.remove(indice);
    }

    public void modificarEvento(int indice, String lugar, String fecha, String hora, String motivo) {
        Evento evento = eventos.get(indice);
        evento.setLugar(lugar);
        evento.setFecha(fecha);
        evento.setHora(hora);
        evento.setMotivo(motivo);
        eventos.set(indice, evento);
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
}
