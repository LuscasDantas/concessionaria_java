/*
 *  @authors Lucas e Andrez
*/
package br.com.concessionaria.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;

public class FormPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static JMenu mnCadastro;
	static JMenu mnRelatorio;
	static JMenu mnBackup;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
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
	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Instancia o contentPane
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Instancia o painel
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1004, 503);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1004, 36);
		panel.add(menuBar);
		
		mnCadastro = new JMenu("Cadastro");
		mnCadastro.setPreferredSize(new Dimension(90, 26));
		menuBar.add(mnCadastro);
		
		JMenuItem mnItemClientes = new JMenuItem("Clientes");
		mnCadastro.add(mnItemClientes);
		
		JMenuItem mnItemFuncionarios = new JMenuItem("Funcionários");
		mnCadastro.add(mnItemFuncionarios);
		
		JMenuItem mnItemServicos = new JMenuItem("Serviços");
		mnCadastro.add(mnItemServicos);
		
		JMenuItem mnItemVeiculos = new JMenuItem("Veículos");
		mnItemVeiculos.setHorizontalTextPosition(SwingConstants.LEFT);
		mnItemVeiculos.setHorizontalAlignment(SwingConstants.LEFT);
		mnCadastro.add(mnItemVeiculos);
		
		mnRelatorio = new JMenu("Relatório");
		mnRelatorio.setPreferredSize(new Dimension(90, 26));
		menuBar.add(mnRelatorio);
		
		mnBackup = new JMenu("Backup");
		mnBackup.setPreferredSize(new Dimension(90, 26));
		menuBar.add(mnBackup);
		
	}
}
