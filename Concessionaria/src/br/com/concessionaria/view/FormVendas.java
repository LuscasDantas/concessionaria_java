package br.com.concessionaria.view;

import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FormVendas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtIdVenda;
	public static JTextField txtVeiculoVenda;
	public static JTextField txtClienteVenda;
	public static JComboBox<String> cmbColaborador;

	@Override
	public void addNotify() {
		super.addNotify();
		// Chame o método que deseja executar ao abrir a tela
		preencheCmbColaborador();
		atualizarTela();
	}

	public void atualizarTela() {
		FormVendas formVendas = new FormVendas();
		formVendas.revalidate();
		formVendas.repaint();
	}

	/**
	 * Create the panel.
	 */
	public FormVendas() {
		setToolTipText("");
		setLayout(null);
		setBounds(10, 11, 1004, 485);

		JLabel lblCadVendas = new JLabel("VENDAS");
		lblCadVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadVendas.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadVendas.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadVendas.setBounds(459, 32, 100, 25);
		this.add(lblCadVendas);

		JLabel lblIdVenda = new JLabel("ID:");
		lblIdVenda.setBounds(34, 81, 25, 14);
		add(lblIdVenda);

		txtIdVenda = new JTextField();
		txtIdVenda.setBounds(56, 78, 40, 20);
		add(txtIdVenda);
		txtIdVenda.setColumns(10);

		JLabel lblVeiculoVenda = new JLabel("Veículo:");
		lblVeiculoVenda.setBounds(34, 133, 46, 14);
		add(lblVeiculoVenda);

		txtVeiculoVenda = new JTextField();
		txtVeiculoVenda.setBounds(112, 133, 160, 20);
		add(txtVeiculoVenda);
		txtVeiculoVenda.setColumns(10);

		JLabel lblClienteVenda = new JLabel("Cliente:");
		lblClienteVenda.setBounds(34, 185, 46, 14);
		add(lblClienteVenda);

		txtClienteVenda = new JTextField();
		txtClienteVenda.setColumns(10);
		txtClienteVenda.setBounds(112, 185, 160, 20);
		add(txtClienteVenda);

		JLabel lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setBounds(34, 230, 77, 14);
		add(lblColaborador);

		cmbColaborador = new JComboBox<String>();
		cmbColaborador.setBounds(112, 226, 160, 22);
		this.add(cmbColaborador);
		

		
	}
	public void preencheCmbColaborador() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

			String selectColaboradoresQuery = "SELECT * FROM colaboradores WHERE cargo = 'Atendente' ORDER BY nome ASC";

			PreparedStatement selectColaboradoresStmt = con.prepareStatement(selectColaboradoresQuery);
			ResultSet colaboradoresResult = selectColaboradoresStmt.executeQuery();

			while (colaboradoresResult.next()) {
				// Recuperar os dados do colaborador
				int idColaborador = colaboradoresResult.getInt("id");
				String nomeColaborador = colaboradoresResult.getString("nome");

				// Preencher os campos da interface com os dados do colaborador
				cmbColaborador.addItem(Integer.toString(idColaborador) + " - " + nomeColaborador);
			}

			colaboradoresResult.close();
			selectColaboradoresStmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
