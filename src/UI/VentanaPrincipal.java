package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Agenda;
import data.Contacto;
import logic.Main;
import logic.CargarDatos;
import logic.GuardarDatos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JPanel ContenedorContactos;
	JPanel panelGrandeContactos;
	JPanel panelGrandeFormulario;
	private JTextField nombre, telefono, operadora, email, pais;
	Main main;
	int contadorId=0;
	String[] variablesModificar = new String[6];
	boolean modificar=false;
	
	JLabel labelINombre, labelITelefono, labelIOperadora, labelIEmail, labelIPais;
	
	
	JButton btnFuncionCrear, btnFuncionModificar;
	
	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("cierrelo");
				Main.cerrar();
			}
		});
		iniciarComponentes();
	}
	public void iniciarComponentes() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JButton btnCrear = new JButton("Nuevo");
		btnCrear.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCrear.setForeground(Color.WHITE);
		btnCrear.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-rollOver.png")));
		btnCrear.setBorder(null);
		btnCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCrear.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-simple.png")));
		
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisibleFormulario();
			}
		});
		panel_1.add(btnCrear);
		
		JButton btnNewButton_1 = new JButton("atras");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-rollOver.png")));
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-simple.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisibleContactos();
			}
		});
		panel_1.add(btnNewButton_1);
		//btnNewButton_1.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		panelGrandeContactos = new JPanel();
		panelGrandeContactos.setOpaque(false);
		panelGrandeContactos.setBounds(0, 0, 494, 337);
		panel_2.add(panelGrandeContactos);
		panelGrandeContactos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground((Color.WHITE));;
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 23, 240, 275);
		panelGrandeContactos.add(scrollPane);
		
		ContenedorContactos = new JPanel();
		ContenedorContactos.setBackground(Color.WHITE);
		ContenedorContactos.setBounds(23, 27, 124, 103);
		scrollPane.setViewportView(ContenedorContactos);
		ContenedorContactos.setLayout(new BoxLayout(ContenedorContactos, BoxLayout.Y_AXIS));
		
		JPanel paneIInfo = new JPanel();
		paneIInfo.setOpaque(false);
		
		paneIInfo.setBounds(280, 23, 220, 240);
		panelGrandeContactos.add(paneIInfo);
		paneIInfo.setLayout(new BoxLayout(paneIInfo, BoxLayout.Y_AXIS));
		
		JLabel labelIdes = new JLabel("<html>Seleccione un contacto para verlo a detalle:<br>  <br> </html>");
		labelIdes.setFont(new Font("Dialog", Font.BOLD, 13));
		paneIInfo.add(labelIdes);
		
		labelINombre = new JLabel("Nombre: ");
		labelINombre.setFont(new Font("Dialog", Font.BOLD, 13));
		paneIInfo.add(labelINombre);
		
		labelITelefono = new JLabel("telefono: ");
		labelITelefono.setFont(new Font("Dialog", Font.BOLD, 13));
		paneIInfo.add(labelITelefono);
		
		labelIOperadora = new JLabel("Operadora: ");
		labelIOperadora.setFont(new Font("Dialog", Font.BOLD, 13));
		paneIInfo.add(labelIOperadora);
		
		labelIEmail = new JLabel("Email: ");
		labelIEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		paneIInfo.add(labelIEmail);
		
		labelIPais = new JLabel("Pais: ");
		labelIPais.setFont(new Font("Dialog", Font.BOLD, 13));
		paneIInfo.add(labelIPais);
		
		/*JPanel contacto = new JPanel();
		ContenedorContactos.add(contacto);*/
		
		
		panelGrandeFormulario = new JPanel();
		panelGrandeFormulario.setOpaque(false);
		panelGrandeFormulario.setBounds(0, 0, 494, 337);
		panel_2.add(panelGrandeFormulario);
		panelGrandeFormulario.setLayout(new BoxLayout(panelGrandeFormulario, BoxLayout.Y_AXIS));
		panelGrandeFormulario.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("     ");
		panelGrandeFormulario.add(lblNewLabel);
		
		JPanel panelNombre = new JPanel();
		panelNombre.setOpaque(false);
		panelGrandeFormulario.add(panelNombre);
		
		JLabel lblnombre = new JLabel("Nombre");
		panelNombre.add(lblnombre);
		
		nombre = new JTextField();
		panelNombre.add(nombre);
		nombre.setColumns(10);
		
		JPanel paneltelefono = new JPanel();
		paneltelefono.setOpaque(false);
		panelGrandeFormulario.add(paneltelefono);
		
		JLabel lbltelefono = new JLabel("telefono");
		paneltelefono.add(lbltelefono);
		
		telefono = new JTextField();
		paneltelefono.add(telefono);
		telefono.setColumns(10);
		
		JPanel panelOperadora = new JPanel();
		panelOperadora.setOpaque(false);
		panelGrandeFormulario.add(panelOperadora);
		
		JLabel lbloperadora = new JLabel("operadora");
		panelOperadora.add(lbloperadora);
		
		operadora = new JTextField();
		panelOperadora.add(operadora);
		operadora.setColumns(10);
		
		JPanel panelEmail = new JPanel();
		panelEmail.setOpaque(false);
		panelGrandeFormulario.add(panelEmail );
		
		JLabel lblEmail  = new JLabel("Email ");
		 panelEmail.add(lblEmail);
		
		email  = new JTextField();
		 panelEmail.add(email);
		email.setColumns(10);
		
		JPanel panelPais = new JPanel();
		panelPais.setOpaque(false);
		panelGrandeFormulario.add(panelPais);
		
		JLabel lblPais = new JLabel("Pais");
		panelPais.add(lblPais);
		
		pais = new JTextField();
		panelPais.add(pais);
		pais.setColumns(10);
		
		btnFuncionCrear = new JButton("Crear");
		btnFuncionCrear.setFont(new Font("Dialog", Font.BOLD, 14));
		btnFuncionCrear.setForeground(Color.WHITE);
		btnFuncionCrear.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-rollOver.png")));
		btnFuncionCrear.setBorder(null);
		btnFuncionCrear.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFuncionCrear.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-simple.png")));
		btnFuncionCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarContacto();
				GuardarDatos.escribir(Main.agenda.getListaContactos());
			}
		});
		panelGrandeFormulario.add(btnFuncionCrear);
		
		btnFuncionModificar = new JButton("Modificar");
		btnFuncionModificar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnFuncionModificar.setForeground(Color.WHITE);
		btnFuncionModificar.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-rollOver.png")));
		btnFuncionModificar.setBorder(null);
		btnFuncionModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFuncionModificar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnNuevo-simple.png")));
		btnFuncionModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				variablesModificar[0]=nombre.getText();variablesModificar[1]=telefono.getText();variablesModificar[2]=operadora.getText();variablesModificar[3]=email.getText();variablesModificar[4]=pais.getText();
				Main.setVariablesModificar(variablesModificar);
				Main.modificarContacto1();
				vaciarJTextField();
				setVisibleContactos();
				visibleBoton(0);
			}
		});
		panelGrandeFormulario.add(btnFuncionModificar);
		visibleBoton(0);
		
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
		vaciarJTextField();
		btnFuncionCrear.setVisible(true);
		btnFuncionModificar.setVisible(false);
		System.out.println(2);
	}
	public void agregarContacto() {
		try {
			comprobarId();
			Main.crearContacto(nombre.getText(), Integer.parseInt(telefono.getText())  , operadora.getText(), email.getText(), pais.getText(), (contadorId));
			vaciarJTextField();
			
			contadorId++;
			JOptionPane.showMessageDialog(null, "Contacto Agregado");
			setVisibleContactos();
		} catch (Exception e2) {
	        JOptionPane.showMessageDialog(null, "Inserte valores validos");
		}
		System.out.println(":D");
		
	}
	public void comprobarId() {
		for (int i=0; i< Main.agenda.getListaContactos().size() ;i++) {
			if(contadorId == Main.agenda.getListaContactos().get(i).getId() ) {
				contadorId++;
				
			}
			
		}
		for (int i=0; i< Main.agenda.getListaContactos().size() ;i++) {
			if(contadorId == Main.agenda.getListaContactos().get(i).getId() ) {
				comprobarId();
				
			}
		}
	}
	public void addcontador() {
		contadorId++;
	}
	
	public void modificarContacto(int i) {
		variablesModificar = new String[6];
		Contacto contMod= getContactoUIPorId(i).getContacto();
		System.out.println("modificable: "+ contMod);
		nombre.setText(contMod.getNombreContacto());
		telefono.setText(Integer.toString(contMod.getTelefono()));
		operadora.setText(contMod.getOperadora());
		email.setText(contMod.getEmail());
		pais.setText(contMod.getPais());
		
		
		variablesModificar[5]=Integer.toString(i);
		
	}
	public ContactoUI getContactoUIPorId(int i) {
		ContactoUI a=null;
		for (int p=0; p<ContenedorContactos.getComponentCount();p++) {
			ContactoUI b= (ContactoUI) ContenedorContactos.getComponent(p);
			Contacto bc= b.getContacto();
			if (i==bc.getId()) {
				a = (ContactoUI)ContenedorContactos.getComponent(p);
				
			}	
		}
		return a;
	}
	
	public Integer getIndexContactoUIPorId(int i) {
		int q=-1;
		ContactoUI a=null;
		for (int p=0; p<ContenedorContactos.getComponentCount();p++) {
			ContactoUI b= (ContactoUI) ContenedorContactos.getComponent(p);
			Contacto bc= b.getContacto();
			if (i==bc.getId()) {
				a = (ContactoUI)ContenedorContactos.getComponent(p);
				q=p;
			}	
		}
		return q;
	}
	
	public void  actualizarContactoUi(Contacto con) {
		getContactoUIPorId(con.getId()).modificarContactoUI(con);
	}
	public void vaciarJTextField() {
		nombre.setText("");
		operadora.setText("");
		telefono.setText("");
		email.setText("");
		pais.setText("");
	}
	public void visibleBoton(int i) {
		if (i==0) {
			btnFuncionCrear.setVisible(true);
			btnFuncionModificar.setVisible(false);
		}else if (i==1) {
			btnFuncionCrear.setVisible(false);
			btnFuncionModificar.setVisible(true);
		}
		
	}
	public void eliminarContactoUI(int i) {
		int a=getIndexContactoUIPorId(i);
		System.out.println("eliminando... "+ a);
		ContenedorContactos.remove(a);
		System.out.println("eliminado");
		ContenedorContactos.setVisible(false);
		ContenedorContactos.setVisible(true);
	}
	
	public void showContacto (int id) {
		System.out.println("oprimido: "+id);
		Contacto a = getContactoUIPorId(id).getContacto();

		labelINombre.setText("Nombre: " + a.getNombreContacto());
		labelITelefono.setText("Telefono: " + Integer.toString(a.getTelefono()));
		labelIOperadora.setText("Operadora: " + a.getOperadora());
		labelIEmail.setText("Email: " + a.getEmail());
		labelIPais.setText("Pais: " + a.getPais());
	}
	public void setVisibleBtn(int i) {
		switch (i) {
		case 1:
			btnFuncionCrear.setVisible(true);
			btnFuncionModificar.setVisible(false);
		case 2:
			btnFuncionCrear.setVisible(false);
			btnFuncionModificar.setVisible(true);
		
		}
	}
}
