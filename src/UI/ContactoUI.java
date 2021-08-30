package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.BorderFactory;
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
		this.setBackground(Color.decode("#1566cf"));
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.WHITE));
		//this.setSize(204, 80);
		//this.setPreferredSize(new Dimension(180,60));
		this.setMaximumSize(new Dimension(250,60));
		iniciarComponentes();
	}
	public void iniciarComponentes() {
		Nombre = new JLabel(contacto.getNombreContacto());
		this.add(Nombre);
		Nombre.setPreferredSize(new Dimension(100,35));
		Nombre.setFont(new Font("Roboto", Font.BOLD, 15));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Main.vp.showContacto(contacto.getId());
			}
		});
		
		JButton btnModificar = new JButton(" ");
		btnModificar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnModificar-simple.png")));
		btnModificar.setBorder(null);
		btnModificar.setBorderPainted(false); // Elimina el recuadro que rodea al boton
		btnModificar.setMargin(new Insets(-3,-3,-3,-3)); 
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnModificar-rollOver.png")));

		
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mod" + contacto.getId());	
				Main.vp.setVisibleFormulario();
				Main.vp.setVisibleBtn(2);
				Main.modificarContacto(contacto.getId());
			}
		});
		this.add(btnModificar);
		
		
		JButton btnEliminar = new JButton(" ");
		btnEliminar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnEliminar-Simple.png")));
		btnEliminar.setBorder(null);
		btnEliminar.setBorderPainted(false); // Elimina el recuadro que rodea al boton
		btnEliminar.setMargin(new Insets(-3,-3,-3,-3)); 
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnEliminar-rollOver.png")));

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
