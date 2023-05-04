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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.CardLayout;

public class FormPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
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
		
		/*
		 * Menu bar itens
		 */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setPreferredSize(new Dimension(90, 26));
		menuBar.add(mnCadastro);
		
		JMenu mnRelatorio = new JMenu("Relatório");
		mnRelatorio.setPreferredSize(new Dimension(90, 26));
		menuBar.add(mnRelatorio);
		
		JMenu mnBackup = new JMenu("Backup");
		mnBackup.setPreferredSize(new Dimension(90, 26));
		menuBar.add(mnBackup);
		
		/*
		 * Instancia o contentPane
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Instancia o painel Geral card layout
		 */
		JPanel geralPanel = new JPanel();
		geralPanel.setBounds(10, 11, 1004, 486);
		contentPane.add(geralPanel);
		geralPanel.setLayout(new CardLayout(0, 0));
		CardLayout layout = (CardLayout)(geralPanel.getLayout());
		
		/*
		 * Painel de veículos
		 */
		Veiculos veiculosPanel = new Veiculos();
		veiculosPanel.setBounds(10, 11, 1004, 485);
		geralPanel.add(veiculosPanel, "veiculos");
		veiculosPanel.setLayout(null);
		veiculosPanel.setVisible(false);
		
		/*
		 * Painel de clientes
		 */
		JPanel clientesPanel = new JPanel();
		geralPanel.add(clientesPanel, "clientes");
		clientesPanel.setLayout(null);
		
		/*
		 * Menu Cadastro itens
		 */
		JMenuItem mnItemClientes = new JMenuItem("Clientes");
		mnItemClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(geralPanel, "clientes");
			}
		});
		mnCadastro.add(mnItemClientes);
		
		JMenuItem mnItemColaboradores = new JMenuItem("Colaboradores");
		mnCadastro.add(mnItemColaboradores);
		
		JMenuItem mnItemServicos = new JMenuItem("Serviços");
		mnCadastro.add(mnItemServicos);
		
		JMenuItem mnItemVeiculos = new JMenuItem("Veículos");
		mnItemVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(geralPanel, "veiculos");
			}
		});
		mnCadastro.add(mnItemVeiculos);
		
		JLabel lblNewLabel = new JLabel("testando layout");
		lblNewLabel.setBounds(358, 31, 131, 93);
		clientesPanel.add(lblNewLabel);
		
	}
}
