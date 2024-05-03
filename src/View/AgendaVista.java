package View;
import Model.Contacto;
import Model.Evento;
import java.util.ArrayList;

public class AgendaVista {

    public void mostrarContactos(ArrayList<Contacto> contactos) {
        for (Contacto contacto : contactos) {
            System.out.println(contacto.getNombre() + " - " + contacto.getTelefono());
        }
    }

    public void mostrarEventos(ArrayList<Evento> eventos) {
        for (Evento evento : eventos) {
            System.out.println(evento.getLugar() + " - " + evento.getFecha() + " - " + evento.getHora() + " - " + evento.getMotivo());
        }
    }
}
