package Model;

public class ContactoFamiliar extends Contacto {
    private String relacion;

    public ContactoFamiliar(String nombre, String telefono, String relacion) {
        super(nombre, telefono);
        this.relacion = relacion;
    }

    public String getRelacion() {
        return relacion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Relación: " + relacion;
    }
}
