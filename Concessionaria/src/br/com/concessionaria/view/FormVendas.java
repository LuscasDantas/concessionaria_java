package br.com.concessionaria.view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.concessionaria.dao.DAOVendas;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.model.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormVendas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton btnEditar;
	public static JButton btnCadastrar;
	public static JButton btnPesquisar;
	public static JTextField txtIdVenda;
	public static JTextField txtValorTotal;
	public static JComboBox<String> cmbCliente;
	public static JComboBox<String> cmbVeiculo;
	public static JComboBox<String> cmbColaborador;

	/**
	 * Create the panel.
	 */
	public FormVendas() {
		setToolTipText("");
		setLayout(null);
		setBounds(10, 11, 1113, 513);

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

		JLabel lblClienteVenda = new JLabel("Cliente:");
		lblClienteVenda.setBounds(34, 185, 46, 14);
		add(lblClienteVenda);

		JLabel lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setBounds(34, 230, 77, 14);
		add(lblColaborador);

		cmbColaborador = new JComboBox<>();
		cmbColaborador.setBounds(112, 226, 216, 22);
		this.add(cmbColaborador);
		this.preencheCmbColaborador();

		cmbCliente = new JComboBox<>();
		cmbCliente.setBounds(112, 181, 216, 22);
		this.add(cmbCliente);
		this.preencheCmbCliente();

		cmbVeiculo = new JComboBox<>();
		cmbVeiculo.setBounds(112, 129, 216, 22);
		this.add(cmbVeiculo);
		this.preencheCmbVeiculo();

		/*
		 * Botões
		 */
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCmbColaborador();
				preencheCmbCliente();
				preencheCmbVeiculo();
			}
		});
		btnAtualizar.setBounds(155, 352, 110, 23);
		add(btnAtualizar);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Venda.cadastrarVenda();
			}
		});
		btnCadastrar.setBounds(35, 352, 110, 23);
		this.add(btnCadastrar);
		
//		btnPesquisar = new JButton("PESQUISAR");
//		btnPesquisar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				DAOVendas.pesquisarVenda();
//			}
//		});
//		btnPesquisar.setBounds(275, 352, 110, 23);
//		this.add(btnPesquisar);


		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services.limparCampos(FormVendas.class);
				btnCadastrar.setEnabled(true);
				preencheCmbColaborador();
				preencheCmbCliente();
				preencheCmbVeiculo();
			}
		});
		btnLimpar.setBounds(34, 386, 110, 23);
		this.add(btnLimpar);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(34, 273, 62, 14);
		add(lblValorTotal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setBounds(112, 270, 160, 20);
		add(txtValorTotal);
		txtValorTotal.setColumns(10);		

		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOVendas.deletarVenda();
			}
		});
		btnDeletar.setBounds(155, 386, 110, 23);
		this.add(btnDeletar);

	}

	public void preencheCmbColaborador() {
		ArrayList<Colaborador> colaboradores = new ArrayList<>();
		Colaborador colaborador = new Colaborador();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

			String selectColaboradoresQuery = "SELECT * FROM colaboradores WHERE cargo = 'Atendente' ORDER BY nome ASC";

			Statement selectColaboradoresStmt = con.createStatement();
			ResultSet colaboradoresResult = selectColaboradoresStmt.executeQuery(selectColaboradoresQuery);

			cmbColaborador.removeAllItems();
			cmbColaborador.addItem("Selecione");

			while (colaboradoresResult.next()) {
				// Recuperar os dados do colaborador
				int id = colaboradoresResult.getInt("id");
				String nome = colaboradoresResult.getString("nome");

				colaborador = new Colaborador();
				colaborador.setIdColaborador(id);
				colaborador.setNome(nome);
				
				colaboradores.add(colaborador);

				// Preencher os campos da interface com os dados do colaborador
				cmbColaborador.addItem(id + " - " + nome);
			}

			con.close();
			colaboradoresResult.close();
			selectColaboradoresStmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void preencheCmbCliente() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		Cliente cliente = new Cliente();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

			String selectClientesQuery = "SELECT * FROM clientes ORDER BY nome ASC";

			Statement selectClientesStmt = con.createStatement();
			ResultSet clientesResult = selectClientesStmt.executeQuery(selectClientesQuery);
			
			cmbCliente.removeAllItems();
			cmbCliente.addItem("Selecione");

			while (clientesResult.next()) {
				// Recuperar os dados do cliente
				int idCliente = clientesResult.getInt("id");
				String nomeCliente = clientesResult.getString("nome");

				cliente = new Cliente();
				cliente.setIdCliente(idCliente);
				cliente.setNome(nomeCliente);
				
				clientes.add(cliente);
				
				// Preencher os campos da interface com os dados do cliente
				cmbCliente.addItem(idCliente + " - " + nomeCliente);
			}
			con.close();
			clientesResult.close();
			selectClientesStmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void preencheCmbVeiculo() {
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		
		Veiculo veiculo = new Veiculo();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

			String selectVeiculosQuery = "SELECT * FROM veiculos ORDER BY modelo ASC";

			Statement selectVeiculosStmt = con.createStatement();
			ResultSet veiculosResult = selectVeiculosStmt.executeQuery(selectVeiculosQuery);
			
			cmbVeiculo.removeAllItems();
			cmbVeiculo.addItem("Selecione");

			while (veiculosResult.next()) {
				// Recuperar os dados do veiculo
				int idVeiculo = veiculosResult.getInt("id");
				String modelo = veiculosResult.getString("modelo");

				veiculo = new Veiculo();
				veiculo.setIdVeiculo(idVeiculo);
				veiculo.setModelo(modelo);
				
				veiculos.add(veiculo);
				
				// Preencher os campos da interface com os dados do veiculo
				cmbVeiculo.addItem(idVeiculo + " - " + modelo);
			}
			con.close();
			veiculosResult.close();
			selectVeiculosStmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
