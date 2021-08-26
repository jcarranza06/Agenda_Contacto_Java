package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Contacto;
import logic.Main;

public class ContactoUI extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel Nombre;
	
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
		Nombre = new JLabel(contacto.getNombreContacto());
		this.add(Nombre);
		
		JButton btnModificar = new JButton("M");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mod" + contacto.getId());	
				Main.vp.setVisibleFormulario();
				Main.modificarContacto(contacto.getId());
			}
		});
		this.add(btnModificar);
		
		
		JButton btnEliminar = new JButton("E");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("elim"+ contacto.getId());
				
			}
		});
		this.add(btnEliminar);
		
		VentanaPrincipal.addContacto(this);	
	}
	
	public void modificarContactoUI(Contacto contacte) {
		this.contacto=contacte;
		Nombre.setText(contacto.getNombreContacto());
	}
	
}
