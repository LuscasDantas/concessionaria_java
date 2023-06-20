package br.com.concessionaria.view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import br.com.concessionaria.dao.DAOOrdemServico;
import br.com.concessionaria.model.Cliente;
import br.com.concessionaria.model.Servico;
import br.com.concessionaria.model.Veiculo;
import br.com.concessionaria.utils.Services;
import br.com.concessionaria.model.Colaborador;
import br.com.concessionaria.model.OrdemServico;

import javax.swing.JTextField;

public class FormOS extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton btnEditar;
	public static JTextField txtIdOS;
	public static JButton btnCadastrar;
	public static JButton btnPesquisar;
	public static JTextField txtValorOS;
	public static JComboBox<String> cmbCliente;
	public static JComboBox<String> cmbVeiculo;
	public static JComboBox<String> cmbServico;
	public static JComboBox<String> cmbColaborador;
	public static JTextField pesquisaPlaca;
	public static JTextField pesquisaValor;
	public static JTextField pesquisaServico;
	public static JTextField pesquisaCliente;
	public static JTextField pesquisaColaborador;
	public static JTextField pesquisaVeiculo;
	

	/**
	 * Create the panel.
	 */
	public FormOS() {
		
		setLayout(null);
		setBounds(10, 11, 1004, 485);
		
		JLabel lblCadOS = new JLabel("ORDENS DE SERVIÇO");
		lblCadOS.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadOS.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCadOS.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadOS.setBounds(420, 33, 221, 25);
		this.add(lblCadOS);

		JLabel lblIdVenda = new JLabel("ID:");
		lblIdVenda.setBounds(34, 81, 25, 14);
		add(lblIdVenda);
		
		txtIdOS = new JTextField();
		txtIdOS.setBounds(62, 78, 57, 20);
		add(txtIdOS);
		txtIdOS.setColumns(10);
		
		JLabel lblServicoOS = new JLabel("Serviço:");
		lblServicoOS.setBounds(34, 133, 46, 14);
		add(lblServicoOS);

		JLabel lblClienteOS = new JLabel("Cliente:");
		lblClienteOS.setBounds(34, 185, 46, 14);
		add(lblClienteOS);

		JLabel lblColaboradorOS = new JLabel("Colaborador:");
		lblColaboradorOS.setBounds(34, 230, 77, 14);
		add(lblColaboradorOS);
		
		JLabel lblVeiculoOS = new JLabel("Veículo:");
		lblVeiculoOS.setBounds(34, 274, 46, 14);
		add(lblVeiculoOS);
		
		cmbColaborador = new JComboBox<>();
		cmbColaborador.setBounds(121, 226, 250, 22);
		this.add(cmbColaborador);
		this.preencheCmbColaborador();

		cmbCliente = new JComboBox<>();
		cmbCliente.setBounds(121, 181, 250, 22);
		this.add(cmbCliente);
		this.preencheCmbCliente();

		cmbVeiculo = new JComboBox<>();
		cmbVeiculo.setBounds(121, 270, 250, 22);
		this.add(cmbVeiculo);
		this.preencheCmbVeiculo();
		
		cmbServico = new JComboBox<>();
		cmbServico.setBounds(121, 133, 250, 22);
		this.add(cmbServico);
		this.preencheCmbServico();
		
		JLabel lblValorOS = new JLabel("Valor Total:");
		lblValorOS.setBounds(34, 316, 77, 14);
		add(lblValorOS);
		
		txtValorOS = new JTextField();
		txtValorOS.setBounds(121, 313, 160, 22);
		add(txtValorOS);
		txtValorOS.setColumns(10);
		
		/*
		 * Botões
		 */
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCmbColaborador();
				preencheCmbCliente();
				preencheCmbVeiculo();
				preencheCmbServico();
			}
		});
		btnAtualizar.setBounds(155, 396, 110, 23);
		add(btnAtualizar);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              OrdemServico.cadastrarOS();
			}
		});
		btnCadastrar.setBounds(35, 396, 110, 23);
		this.add(btnCadastrar);
		
		btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOOrdemServico.pesquisarOS();				
			}
		});
		btnPesquisar.setBounds(775, 430, 110, 23);
		this.add(btnPesquisar);


		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Services.limparCampos(FormVendas.class);
				btnCadastrar.setEnabled(true);
				preencheCmbColaborador();
				preencheCmbCliente();
				preencheCmbVeiculo();
				preencheCmbServico();
			}
		});
		btnLimpar.setBounds(34, 430, 110, 23);
		this.add(btnLimpar);
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBackground(new Color(255, 0, 0));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOOrdemServico.deletarOS();
			}
		});
		btnDeletar.setBounds(155, 430, 110, 23);
		this.add(btnDeletar);
		
		JLabel lblPesquisa = new JLabel("PESQUISA");
		lblPesquisa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPesquisa.setBounds(581, 113, 216, 25);
		add(lblPesquisa);
		
		JLabel lblpesquisaPlaca = new JLabel("Pesquisar placa:");
		lblpesquisaPlaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblpesquisaPlaca.setBounds(515, 173, 114, 14);
		add(lblpesquisaPlaca);
		
		pesquisaPlaca = new JTextField();
		pesquisaPlaca.setColumns(10);
		pesquisaPlaca.setBounds(635, 170, 177, 20);
		add(pesquisaPlaca);
		
		JLabel lblServicoOS_1 = new JLabel("Serviço:");
		lblServicoOS_1.setBounds(515, 217, 46, 14);
		add(lblServicoOS_1);
		
		JLabel lblClienteOS_1 = new JLabel("Cliente:");
		lblClienteOS_1.setBounds(516, 261, 46, 14);
		add(lblClienteOS_1);
		
		JLabel lblColaboradorOS_1 = new JLabel("Colaborador:");
		lblColaboradorOS_1.setBounds(515, 302, 77, 14);
		add(lblColaboradorOS_1);
		
		JLabel lblVeiculoOS_1 = new JLabel("Veículo:");
		lblVeiculoOS_1.setBounds(515, 350, 46, 14);
		add(lblVeiculoOS_1);
		
		JLabel lblValorOS_1 = new JLabel("Valor Total:");
		lblValorOS_1.setBounds(515, 400, 77, 14);
		add(lblValorOS_1);
		
		pesquisaValor = new JTextField();
		pesquisaValor.setColumns(10);
		pesquisaValor.setBounds(635, 396, 130, 22);
		add(pesquisaValor);
		
		pesquisaServico = new JTextField();
		pesquisaServico.setBounds(635, 214, 250, 20);
		add(pesquisaServico);
		pesquisaServico.setColumns(10);
		
		pesquisaCliente = new JTextField();
		pesquisaCliente.setColumns(10);
		pesquisaCliente.setBounds(635, 258, 250, 20);
		add(pesquisaCliente);
		
		pesquisaColaborador = new JTextField();
		pesquisaColaborador.setColumns(10);
		pesquisaColaborador.setBounds(635, 301, 250, 20);
		add(pesquisaColaborador);
		
		pesquisaVeiculo = new JTextField();
		pesquisaVeiculo.setColumns(10);
		pesquisaVeiculo.setBounds(635, 347, 250, 20);
		add(pesquisaVeiculo);

	}
	
	/*
	 * Funções de preencher as Combos
	 */
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
	
	public void preencheCmbColaborador() {
		ArrayList<Colaborador> colaboradores = new ArrayList<>();
		Colaborador colaborador = new Colaborador();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

			String selectColaboradoresQuery = "SELECT * FROM colaboradores WHERE cargo = 'Mecanico' ORDER BY nome ASC";

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
	
	public void preencheCmbServico() {
		ArrayList<Servico> servicos = new ArrayList<>();
		
		Servico servico = new Servico();
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

			String selectServicosQuery = "SELECT * FROM servicos ORDER BY nome ASC";

			Statement selectServicosStmt = con.createStatement();
			ResultSet servicosResult = selectServicosStmt.executeQuery(selectServicosQuery);
			
			cmbServico.removeAllItems();
			cmbServico.addItem("Selecione");

			while (servicosResult.next()) {
				// Recuperar os dados do servico
				int idServico = servicosResult.getInt("id");
				String nome = servicosResult.getString("nome");

				servico = new Servico();
				servico.setIdServico(idServico);
				servico.setNome(selectServicosQuery);
				
				servicos.add(servico);
				
				// Preencher os campos da interface com os dados do servico
				cmbServico.addItem(idServico + " - " + nome);
			}
			con.close();
			servicosResult.close();
			selectServicosStmt.close();

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
