/*
 *  @authors Lucas e Andrez
*/
package br.com.concessionaria.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtUserName;
	private static JPasswordField passwordField;
	static String Client = "AD820DE7200CF1C42D0D28465B4DF85B287363E8B48C5241845EB74B5A93632F";
	static String Corp = "67E7DB05D3FCBC58F6366CA59E83E92EC922BD542F96687E4CC8129C5C52BAC5";
	//static String Client = "37B9FC9718F32B6F8CC447812D6E9EE6309D3DFFEA9EEC4315D96390227834E1";
	//static String Corp = "9863D98D2031A799645BA7F451EFFAE03B7FE2E8EAB625DD4C05D504B7771A19";
	static String senhaout;
	static String senha;
	static MessageDigest algorithm = null;
	static byte messageDigest[] = null;
	static StringBuilder hexString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Concessionária Top");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 640, 370);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (txtUserName.getText().equals("")) {
					System.out.println("Digite o usuário!");
				}
				if (passwordField == null) {
					System.out.println("Digite a senha!");
				}
				ChecarLogin();
			}
		});
		
		btnEntrar.setBounds(250, 267, 151, 41);
		panel.add(btnEntrar);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUsuario.setBounds(141, 122, 97, 22);
		panel.add(lblUsuario);
		
		txtUserName = new JTextField();
		lblUsuario.setLabelFor(txtUserName);
		txtUserName.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtUserName.setBounds(235, 122, 200, 25);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSenha.setBounds(141, 171, 97, 22);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					ChecarLogin();
				}
			}
		});
		passwordField.setBounds(235, 173, 200, 25);
		panel.add(passwordField);
		
	}
	
	public static void ChecarLogin() {

		senha = new String(passwordField.getPassword());
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try {
			messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		senhaout = hexString.toString();

		if (txtUserName.getText().equals("OPERADOR") && (senhaout.equals(Client))) {
			FormPrincipal principal = new FormPrincipal();
			principal.setVisible(true);
			principal.setLocationRelativeTo(null);
			principal.mnRelatorio.setVisible(false);
			principal.mnBackup.setVisible(false);
		}

		else if (txtUserName.getText().equals("ADMIN") && (senhaout.equals(Corp))) {
			FormPrincipal principal = new FormPrincipal();
			principal.setVisible(true);
			principal.setLocationRelativeTo(null);
			
		} else {
			//System.out.println("Usuário ou senha errado!");
			JOptionPane.showMessageDialog(null, "Usuário ou senha errado");
			txtUserName.setText("");
			passwordField.setText("");
		}
	}
}
