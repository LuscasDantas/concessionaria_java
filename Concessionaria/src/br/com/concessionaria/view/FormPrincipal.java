/*
 *  @authors Lucas e Andrez
*/
package br.com.concessionaria.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.concessionaria.controller.BackupController;
import br.com.concessionaria.controller.RestoreController;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
		CardLayout layout = (CardLayout) (geralPanel.getLayout());

		/*
		 * Painel de veículos
		 */
		FormVeiculos veiculosPanel = new FormVeiculos();
		veiculosPanel.setBounds(10, 11, 1004, 485);
		geralPanel.add(veiculosPanel, "veiculos");
		veiculosPanel.setLayout(null);
		veiculosPanel.setVisible(false);

		/*
		 * Painel de Serviços
		 */
		FormServicos servicosPanel = new FormServicos();
		servicosPanel.setBounds(10, 11, 1004, 485);
		geralPanel.add(servicosPanel, "servicos");
		servicosPanel.setLayout(null);
		servicosPanel.setVisible(false);

		/*
		 * Painel de clientes
		 */
		FormClientes clientesPanel = new FormClientes();
		clientesPanel.setBounds(10, 11, 1004, 485);
		geralPanel.add(clientesPanel, "clientes");
		clientesPanel.setLayout(null);
		clientesPanel.setVisible(false);

		/*
		 * Painel de colaboradores
		 */
		FormColaboradores colaboradoresPanel = new FormColaboradores();
		colaboradoresPanel.setBounds(10, 11, 1004, 485);
		geralPanel.add(colaboradoresPanel, "colaboradores");
		colaboradoresPanel.setLayout(null);
		colaboradoresPanel.setVisible(false);

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
		mnItemColaboradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(geralPanel, "colaboradores");
			}
		});
		mnCadastro.add(mnItemColaboradores);

		JMenuItem mnItemServicos = new JMenuItem("Serviços");
		mnItemServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(geralPanel, "servicos");
			}
		});
		mnCadastro.add(mnItemServicos);

		JMenuItem mnItemVeiculos = new JMenuItem("Veículos");
		mnItemVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(geralPanel, "veiculos");
			}
		});
		mnCadastro.add(mnItemVeiculos);
		
		/*
		 * Menu Backup Itens
		 */
		JMenuItem mnItemBackup = new JMenuItem("Realizar Backup");
		mnItemBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackupController.main(new String[0]);
			}
		});
		mnBackup.add(mnItemBackup);
		
		JMenuItem mnItemRestaurar = new JMenuItem("Restaurar Backup");
		mnItemRestaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestoreController.main(new String[0]);			
			}
		});
		mnBackup.add(mnItemRestaurar);

	}
}
