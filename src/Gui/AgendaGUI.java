package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Controller.AgendaControlador;
import Model.Contacto;
import Model.Evento;
import Model.AgendaModelo;
import View.AgendaVista;



public class AgendaGUI {
    private AgendaControlador controlador;

    public AgendaGUI(AgendaControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarVentanaPrincipal() {
        JFrame ventanaPrincipal = new JFrame("Agenda");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuContactos = new JMenu("Contactos");
        JMenuItem itemAgregarContacto = new JMenuItem("Agregar Contacto");
        itemAgregarContacto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaAgregarContacto();
            }
        });
        JMenuItem itemListarContactos = new JMenuItem("Listar Contactos");
        itemListarContactos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaListarContactos();
            }
        });
        JMenuItem itemEliminarContacto = new JMenuItem("Eliminar Contacto");
        itemEliminarContacto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaEliminarContacto();
            }
        });
        JMenuItem itemModificarContacto = new JMenuItem("Modificar Contacto");
        itemModificarContacto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaModificarContacto();
            }
        });

        // Eventos

        JMenu menuEventos = new JMenu("Eventos");
        JMenuItem itemAgregarEvento = new JMenuItem("Agregar Evento");
        itemAgregarEvento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaAgregarEvento();
            }
        });

        JMenuItem itemListarEventos = new JMenuItem("Listar Eventos");

        itemListarEventos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaListarEventos();
            }
        });

        JMenuItem itemEliminarEvento = new JMenuItem("Eliminar Evento");

        itemEliminarEvento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaEliminarEvento();
            }
        });

        JMenuItem itemModificarEvento = new JMenuItem("Modificar Evento");

        itemModificarEvento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaModificarEvento();
            }
        });


        menuContactos.add(itemAgregarContacto);
        menuContactos.add(itemListarContactos);
        menuContactos.add(itemEliminarContacto);
        menuContactos.add(itemModificarContacto);

        menuEventos.add(itemAgregarEvento);
        menuEventos.add(itemListarEventos);
        menuEventos.add(itemEliminarEvento);
        menuEventos.add(itemModificarEvento);


        menuBar.add(menuContactos);
        menuBar.add(menuEventos);

        ventanaPrincipal.setJMenuBar(menuBar);

        ventanaPrincipal.setSize(400, 300);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);

    }

    public void mostrarVentanaAgregarContacto() {
        JFrame ventanaAgregarContacto = new JFrame("Agregar Contacto");
        ventanaAgregarContacto.setLayout(new GridLayout(6, 2));

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel labelTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();
        JLabel labelTipo = new JLabel("Tipo:");
        String[] tipos = {"Familiar", "Empresarial"};
        JComboBox<String> comboBoxTipo = new JComboBox<>(tipos);
        JLabel labelDetalle = new JLabel(""); // Inicialmente vacío

        comboBoxTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipoSeleccionado = (String) comboBoxTipo.getSelectedItem();
                if (tipoSeleccionado.equals("Familiar")) {
                    labelDetalle.setText("Relación:");
                } else if (tipoSeleccionado.equals("Empresarial")) {
                    labelDetalle.setText("Empresa:");
                }
            }
        });

        JTextField txtDetalle = new JTextField(); // Campo adicional

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String telefono = txtTelefono.getText();
                String tipo = (String) comboBoxTipo.getSelectedItem();
                String detalle = txtDetalle.getText(); // Obtener valor del campo adicional

                // Llama al controlador con los datos proporcionados
                controlador.agregarContacto(nombre, telefono, tipo, detalle);
                ventanaAgregarContacto.dispose();
            }
        });

        ventanaAgregarContacto.add(labelNombre);
        ventanaAgregarContacto.add(txtNombre);
        ventanaAgregarContacto.add(labelTelefono);
        ventanaAgregarContacto.add(txtTelefono);
        ventanaAgregarContacto.add(labelTipo);
        ventanaAgregarContacto.add(comboBoxTipo);
        ventanaAgregarContacto.add(labelDetalle);
        ventanaAgregarContacto.add(txtDetalle); // Agregar campo adicional
        ventanaAgregarContacto.add(new JLabel());
        ventanaAgregarContacto.add(btnAgregar);

        ventanaAgregarContacto.pack();
        ventanaAgregarContacto.setLocationRelativeTo(null);
        ventanaAgregarContacto.setVisible(true);
    }


    public void mostrarVentanaListarContactos() {
        JFrame ventanaListarContactos = new JFrame("Listar Contactos");
        ventanaListarContactos.setLayout(new BorderLayout());

        ArrayList<Contacto> contactos = controlador.getContactos();
        JTextArea txtAreaContactos = new JTextArea();
        for (Contacto contacto : contactos) {
            txtAreaContactos.append(contacto.toString() + "\n");
        }

        ventanaListarContactos.add(new JScrollPane(txtAreaContactos), BorderLayout.CENTER);

        ventanaListarContactos.setSize(300, 200);
        ventanaListarContactos.setLocationRelativeTo(null);
        ventanaListarContactos.setVisible(true);
    }

    public void mostrarVentanaEliminarContacto() {
        JFrame ventanaEliminarContacto = new JFrame("Eliminar Contacto");
        ventanaEliminarContacto.setLayout(new GridLayout(2, 1));

        ArrayList<Contacto> contactos = controlador.getContactos();
        String[] nombresContactos = new String[contactos.size()];
        for (int i = 0; i < contactos.size(); i++) {
            nombresContactos[i] = contactos.get(i).getNombre();
        }
        JComboBox<String> comboBoxNombres = new JComboBox<>(nombresContactos);
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = comboBoxNombres.getSelectedIndex();
                controlador.eliminarContacto(indiceSeleccionado);
                ventanaEliminarContacto.dispose();
            }
        });

        ventanaEliminarContacto.add(comboBoxNombres);
        ventanaEliminarContacto.add(btnEliminar);

        ventanaEliminarContacto.pack();
        ventanaEliminarContacto.setLocationRelativeTo(null);
        ventanaEliminarContacto.setVisible(true);
    }

    public void mostrarVentanaModificarContacto() {
        JFrame ventanaModificarContacto = new JFrame("Modificar Contacto");
        ventanaModificarContacto.setLayout(new GridLayout(4, 2));

        ArrayList<Contacto> contactos = controlador.getContactos();
        String[] nombresContactos = new String[contactos.size()];
        for (int i = 0; i < contactos.size(); i++) {
            nombresContactos[i] = contactos.get(i).getNombre();
        }
        JComboBox<String> comboBoxNombres = new JComboBox<>(nombresContactos);

        JLabel labelNombre = new JLabel("Nuevo Nombre:");
        JTextField txtNuevoNombre = new JTextField();
        JLabel labelTelefono = new JLabel("Nuevo Teléfono:");
        JTextField txtNuevoTelefono = new JTextField();

        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = comboBoxNombres.getSelectedIndex();
                String nuevoNombre = txtNuevoNombre.getText();
                String nuevoTelefono = txtNuevoTelefono.getText();
                controlador.modificarContacto(indiceSeleccionado, nuevoNombre, nuevoTelefono);
                ventanaModificarContacto.dispose();
            }
        });

        ventanaModificarContacto.add(comboBoxNombres);
        ventanaModificarContacto.add(new JLabel());
        ventanaModificarContacto.add(labelNombre);
        ventanaModificarContacto.add(txtNuevoNombre);
        ventanaModificarContacto.add(labelTelefono);
        ventanaModificarContacto.add(txtNuevoTelefono);
        ventanaModificarContacto.add(new JLabel());
        ventanaModificarContacto.add(btnModificar);

        ventanaModificarContacto.pack();
        ventanaModificarContacto.setLocationRelativeTo(null);
        ventanaModificarContacto.setVisible(true);
    }


    public void mostrarVentanaAgregarEvento() {
        JFrame ventanaAgregarEvento = new JFrame("Agregar Evento");
        ventanaAgregarEvento.setLayout(new GridLayout(5, 2));

        JLabel labelLugar = new JLabel("Lugar:");
        JTextField txtLugar = new JTextField();
        JLabel labelFecha = new JLabel("Fecha:");
        JTextField txtFecha = new JTextField();
        JLabel labelHora = new JLabel("Hora:");
        JTextField txtHora = new JTextField();
        JLabel labelMotivo = new JLabel("Motivo:");
        JTextField txtMotivo = new JTextField();
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lugar = txtLugar.getText();
                String fecha = txtFecha.getText();
                String hora = txtHora.getText();
                String motivo = txtMotivo.getText();
                controlador.agregarEvento(lugar, fecha, hora, motivo);
                ventanaAgregarEvento.dispose();
            }
        });

        ventanaAgregarEvento.add(labelLugar);
        ventanaAgregarEvento.add(txtLugar);
        ventanaAgregarEvento.add(labelFecha);
        ventanaAgregarEvento.add(txtFecha);
        ventanaAgregarEvento.add(labelHora);
        ventanaAgregarEvento.add(txtHora);
        ventanaAgregarEvento.add(labelMotivo);
        ventanaAgregarEvento.add(txtMotivo);
        ventanaAgregarEvento.add(new JLabel());
        ventanaAgregarEvento.add(btnAgregar);

        ventanaAgregarEvento.pack();
        ventanaAgregarEvento.setLocationRelativeTo(null);
        ventanaAgregarEvento.setVisible(true);
    }

    public void mostrarVentanaListarEventos() {
        JFrame ventanaListarEventos = new JFrame("Listar Eventos");
        ventanaListarEventos.setLayout(new BorderLayout());

        ArrayList<Evento> eventos = controlador.getEventos();
        JTextArea txtAreaEventos = new JTextArea();
        for (Evento evento : eventos) {
            txtAreaEventos.append(evento.toString() + "\n");
        }

        ventanaListarEventos.add(new JScrollPane(txtAreaEventos), BorderLayout.CENTER);

        ventanaListarEventos.setSize(300, 200);
        ventanaListarEventos.setLocationRelativeTo(null);
        ventanaListarEventos.setVisible(true);
    }

    public void mostrarVentanaEliminarEvento() {
        JFrame ventanaEliminarEvento = new JFrame("Eliminar Evento");
        ventanaEliminarEvento.setLayout(new GridLayout(2, 1));

        ArrayList<Evento> eventos = controlador.getEventos();
        String[] nombresEventos = new String[eventos.size()];
        for (int i = 0; i < eventos.size(); i++) {
            nombresEventos[i] = eventos.get(i).getLugar();
        }
        JComboBox<String> comboBoxNombres = new JComboBox<>(nombresEventos);
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = comboBoxNombres.getSelectedIndex();
                controlador.eliminarEvento(indiceSeleccionado);
                ventanaEliminarEvento.dispose();
            }
        });

        ventanaEliminarEvento.add(comboBoxNombres);
        ventanaEliminarEvento.add(btnEliminar);

        ventanaEliminarEvento.pack();
        ventanaEliminarEvento.setLocationRelativeTo(null);
        ventanaEliminarEvento.setVisible(true);
    }

    public void mostrarVentanaModificarEvento() {
        JFrame ventanaModificarEvento = new JFrame("Modificar Evento");
        ventanaModificarEvento.setLayout(new GridLayout(1, 2));

        ArrayList<Evento> eventos = controlador.getEventos();
        String[] LugaresEventos = new String[eventos.size()];
        for (int i = 0; i < eventos.size(); i++) {
            LugaresEventos[i] = eventos.get(i).getLugar();
        }
        JComboBox<String> comboBoxLugares = new JComboBox<>(LugaresEventos);

        JLabel labelLugar = new JLabel("Nuevo Lugar:");
        JTextField txtNuevoLugar = new JTextField();
        JLabel labelFecha = new JLabel("Nueva Fecha:");
        JTextField txtNuevaFecha = new JTextField();
        JLabel labelHora = new JLabel("Nueva Hora:");
        JTextField txtNuevaHora = new JTextField();
        JLabel labelMotivo = new JLabel("Nuevo Motivo:");
        JTextField txtNuevoMotivo = new JTextField();
        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = comboBoxLugares.getSelectedIndex();
                String nuevoLugar = txtNuevoLugar.getText();
                String nuevaFecha = txtNuevaFecha.getText();
                String nuevaHora = txtNuevaHora.getText();
                String nuevoMotivo = txtNuevoMotivo.getText();
                controlador.modificarEvento(indiceSeleccionado, nuevoLugar, nuevaFecha, nuevaHora, nuevoMotivo);
                ventanaModificarEvento.dispose();
            }
        });

        ventanaModificarEvento.add(comboBoxLugares);
        //ventanaModificarEvento.add(new JLabel());
        ventanaModificarEvento.add(labelLugar);
        ventanaModificarEvento.add(txtNuevoLugar);
        ventanaModificarEvento.add(labelFecha);
        ventanaModificarEvento.add(txtNuevaFecha);
        ventanaModificarEvento.add(labelHora);
        ventanaModificarEvento.add(txtNuevaHora);
        ventanaModificarEvento.add(labelMotivo);
        ventanaModificarEvento.add(txtNuevoMotivo);
        //ventanaModificarEvento.add(new JLabel());
        ventanaModificarEvento.add(btnModificar);

        ventanaModificarEvento.pack();
        ventanaModificarEvento.setLocationRelativeTo(null);
        ventanaModificarEvento.setVisible(true);
    }

    public static void main(String[] args) {
        AgendaModelo modelo = new AgendaModelo();
        AgendaVista vista = new AgendaVista();
        AgendaControlador controlador = new AgendaControlador(modelo, vista);
        AgendaGUI gui = new AgendaGUI(controlador);
        gui.mostrarVentanaPrincipal();
    }
}