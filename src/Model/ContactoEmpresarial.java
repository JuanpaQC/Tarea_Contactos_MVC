package Model;

public class ContactoEmpresarial extends Contacto {
    private String empresa;

    public ContactoEmpresarial(String nombre, String telefono, String empresa) {
        super(nombre, telefono);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Empresa: " + empresa;
    }
}
