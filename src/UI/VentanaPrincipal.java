package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Contacto;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JPanel ContenedorContactos;
	JPanel panelGrandeContactos;
	JPanel panelGrandeFormulario;
	private JTextField nombre, telefono, operadora, email, pais;
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		iniciarComponentes();
	}
	public void iniciarComponentes() {
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JButton btnCrear = new JButton("Nuevo");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisibleFormulario();
			}
		});
		panel_1.add(btnCrear);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisibleContactos();
			}
		});
		panel_1.add(btnNewButton_1);
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		panelGrandeContactos = new JPanel();
		panelGrandeContactos.setBounds(0, 0, 494, 337);
		panel_2.add(panelGrandeContactos);
		panelGrandeContactos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 23, 204, 275);
		panelGrandeContactos.add(scrollPane);
		
		ContenedorContactos = new JPanel();
		ContenedorContactos.setBounds(23, 27, 124, 103);
		scrollPane.setViewportView(ContenedorContactos);
		ContenedorContactos.setLayout(new BoxLayout(ContenedorContactos, BoxLayout.Y_AXIS));
		
		JPanel contacto = new JPanel();
		ContenedorContactos.add(contacto);
		
		
		panelGrandeFormulario = new JPanel();
		panelGrandeFormulario.setBounds(0, 0, 494, 337);
		panel_2.add(panelGrandeFormulario);
		panelGrandeFormulario.setLayout(new BoxLayout(panelGrandeFormulario, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("     ");
		panelGrandeFormulario.add(lblNewLabel);
		
		JPanel panelNombre = new JPanel();
		panelGrandeFormulario.add(panelNombre);
		
		JLabel lblnombre = new JLabel("Nombre");
		panelNombre.add(lblnombre);
		
		nombre = new JTextField();
		panelNombre.add(nombre);
		nombre.setColumns(10);
		
		JPanel paneltelefono = new JPanel();
		panelGrandeFormulario.add(paneltelefono);
		
		JLabel lbltelefono = new JLabel("telefono");
		paneltelefono.add(lbltelefono);
		
		telefono = new JTextField();
		paneltelefono.add(telefono);
		telefono.setColumns(10);
		
		JPanel panelOperadora = new JPanel();
		panelGrandeFormulario.add(panelOperadora);
		
		JLabel lbloperadora = new JLabel("operadora");
		panelOperadora.add(lbloperadora);
		
		operadora = new JTextField();
		panelOperadora.add(operadora);
		operadora.setColumns(10);
		
		JPanel panelEmail = new JPanel();
		panelGrandeFormulario.add(panelEmail );
		
		JLabel lblEmail  = new JLabel("Email ");
		 panelEmail.add(lblEmail);
		
		email  = new JTextField();
		 panelEmail.add(email);
		email.setColumns(10);
		
		JPanel panelPais = new JPanel();
		panelGrandeFormulario.add(panelPais);
		
		JLabel lblPais = new JLabel("Pais");
		panelPais.add(lblPais);
		
		pais = new JTextField();
		panelPais.add(pais);
		pais.setColumns(10);
		
		JButton btnFuncionCrear = new JButton("Crear");
		btnFuncionCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panelGrandeFormulario.add(btnFuncionCrear);
		
		
	}
	public static void addContacto(ContactoUI contacto) {
		ContenedorContactos.add(contacto);
	}
	public void setVisibleContactos() {
		this.panelGrandeContactos.setVisible(true);
		this.panelGrandeFormulario.setVisible(false);
		System.out.println(1);
		
	}
	public void setVisibleFormulario() {
		this.panelGrandeContactos.setVisible(false);
		this.panelGrandeFormulario.setVisible(true);
		System.out.println(2);
	}
}
