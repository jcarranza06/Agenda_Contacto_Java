package data;

import UI.ContactoUI;
import java.io.Serializable;

public class Contacto implements Serializable{
    
	private static final long serialVersionUID = 1L;
	final int id;
	String nombreContacto;
    int telefono;
    String operadora;
    String email;
    String pais;
    ContactoUI contUI;

    public void setNombreContacto(String nombreContacto){
        this.nombreContacto = nombreContacto;
    }

    public String getNombreContacto(){
        return this.nombreContacto;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return this.id;
    }

    
    public String getOperadora() {
        return this.operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPais(){
        return this.pais;
    }

    public void setPais(String pais){
        this.pais = pais;
    }


    public Contacto(String nombreContacto, int telefono, String operadora, String email, String pais, int id){
        this.nombreContacto = nombreContacto;
        this.telefono = telefono;
        this.operadora = operadora;
        this.email = email;
        this.pais = pais;
        this.id=id;
        
        contUI =new ContactoUI(this);
        System.out.println(contUI);
    }
    public Contacto(String nombreContacto, int telefono, String operadora, String email, String pais, int id, boolean flag){
        this.nombreContacto = nombreContacto;
        this.telefono = telefono;
        this.operadora = operadora;
        this.email = email;
        this.pais = pais;
        this.id=id;
        
    }

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombreContacto=" + nombreContacto + ", telefono=" + telefono + ", operadora="
				+ operadora + ", email=" + email + ", pais=" + pais + "]";
	}
    
}
