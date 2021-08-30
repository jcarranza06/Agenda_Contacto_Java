package UI;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Contacto;
import logic.CargarDatos;
import logic.Main;

public class ContactoUI extends JPanel implements Serializable{

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
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Main.vp.showContacto(contacto.getId());
			}
		});
		
		JButton btnModificar = new JButton("m");
		btnModificar.setBorder(null);
		//btnModificar.setIcon(new ImageIcon("\\img\\btnSencillo-simple.jpg"));
		//btnModificar.setIcon(new ImageIcon(Main.vp.getClass().getResource("/img/btnSencillo-simple.jpg")));
		//btnModificar.setIcon(new ImageIcon("\\img\\btnSencillo-simple.png"));
		//btnModificar.setIcon(new ImageIcon("C:\\Users\\juane\\OneDrive\\Documentos\\AgendaContactosJava\\img\\btnSencillo-simple.png"));
		/*btnModificar.setMargin(new Insets(0, 0, 0, 0));
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);*/
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mod" + contacto.getId());	
				Main.vp.setVisibleFormulario();
				Main.modificarContacto(contacto.getId());
			}
		});
		this.add(btnModificar);
		
		
		JButton btnEliminar = new JButton("e");
		
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("elim"+ contacto.getId());
				//CargarDatos.leer();		
				Main.eliminarContacto(contacto.getId());
			}
		});
		this.add(btnEliminar);
		
		VentanaPrincipal.addContacto(this);	
	}
	
	public void modificarContactoUI(Contacto contacte) {
		this.contacto=contacte;
		Nombre.setText(contacto.getNombreContacto());
	}

	@Override
	public String toString() {
		return "ContactoUI [Nombre=" + Nombre + ", contacto=" + contacto + "]";
	}
	
	
}
