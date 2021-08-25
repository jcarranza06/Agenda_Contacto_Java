package UI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Contacto;

public class ContactoUI extends JPanel{

	private static final long serialVersionUID = 1L;
	
	
	Contacto contacto;

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public ContactoUI(Contacto contacto) {
		super();
		this.contacto = contacto;
		iniciarComponentes();
	}
	public void iniciarComponentes() {
		JLabel Nombre = new JLabel(contacto.getNombreContacto());
		this.add(Nombre);
		
		JButton btnModificar = new JButton("M");
		this.add(btnModificar);
		
		JButton btnEliminar = new JButton("E");
		this.add(btnEliminar);
		
		VentanaPrincipal.addContacto(this);	
	}
	
}
