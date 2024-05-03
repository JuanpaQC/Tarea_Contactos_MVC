package Controller;
import java.util.ArrayList;
import java.util.Date;

import Model.AgendaModelo;
import Model.Contacto;
import Model.ContactoEmpresarial;
import Model.ContactoFamiliar;
import Model.Evento;
import View.AgendaVista;

public class AgendaControlador {
    private AgendaModelo modelo;
    private AgendaVista vista;

    public AgendaControlador(AgendaModelo modelo, AgendaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarContacto(String nombre, String telefono, String tipo, String detalle) {
        Contacto nuevoContacto;
        if (tipo.equals("Familiar")) {
            nuevoContacto = new ContactoFamiliar(nombre, telefono, detalle);
        } else if (tipo.equals("Empresarial")) {
            nuevoContacto = new ContactoEmpresarial(nombre, telefono, detalle);
        } else {
            nuevoContacto = new Contacto(nombre, telefono); // Tratar otro tipo de contacto como genérico
        }
        modelo.agregarContacto(nuevoContacto);
    }



    public void eliminarContacto(int indice) {
        modelo.eliminarContacto(indice);
    }

    public void modificarContacto(int indice, String nombre, String telefono) {
        modelo.modificarContacto(indice, nombre, telefono);
    }

    public void agregarEvento(String nombre, String fecha, String hora, String lugar) {
        Evento evento = new Evento(nombre, fecha, hora, lugar);
        modelo.agregarEvento(evento);
    }

    public void eliminarEvento(int indice) {
        modelo.eliminarEvento(indice);
    }

    public void modificarEvento(int indice, String nombre, String fecha, String hora, String lugar) {
        modelo.modificarEvento(indice, nombre, fecha, hora, lugar);
    }

    public ArrayList<Contacto> getContactos() {
        return modelo.getContactos();
    }

    public ArrayList<Evento> getEventos() {
        return modelo.getEventos();
    }
}