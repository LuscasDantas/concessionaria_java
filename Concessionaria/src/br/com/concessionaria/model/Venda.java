package br.com.concessionaria.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.concessionaria.dao.DAOVeiculos;
import br.com.concessionaria.dao.DAOVendas;
import br.com.concessionaria.dao.DAOColaboradores;
import br.com.concessionaria.dao.DAOClientes;
import br.com.concessionaria.dao.DAOVeiculos;
import br.com.concessionaria.view.FormColaboradores;
import br.com.concessionaria.view.FormVendas;

public class Venda {
	
	private static int idVenda = 0;
    private static Veiculo veiculo;
    private static Cliente cliente;
    private static Colaborador colaborador;
    private static double valorTotal = 0;
    
    // Construtor da classe
    public Venda(int idVenda, Colaborador colaborador, Veiculo veiculo, Cliente cliente) {
    	this.idVenda = idVenda;
        this.colaborador = colaborador;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }
        
	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int getIdVenda() {
		return idVenda;
	}

	public static void setIdVenda(int idVenda) {
		Venda.idVenda = idVenda;
	}

	public static Veiculo getVeiculo() {
		return veiculo;
	}

	public static void setVeiculo(Veiculo veiculo) {
		Venda.veiculo = veiculo;
	}

	public static Cliente getCliente() {
		return cliente;
	}

	public static void setCliente(Cliente cliente) {
		Venda.cliente = cliente;
	}

	public static Colaborador getColaborador() {
		return colaborador;
	}

	public static void setColaborador(Colaborador colaborador) {
		Venda.colaborador = colaborador;
	}

	public static double getValorTotal() {
		return valorTotal;
	}

	public static void setValorTotal(double valorTotal) {
		Venda.valorTotal = valorTotal;
	}


	public static void cadastrarVenda() {
		Venda venda = new Venda();

		venda.setColaborador(getColaboradorSelecionado());
		venda.setVeiculo(getVeiculoSelecionado());
		venda.setCliente(getClienteSelecionado());
		venda.setValorTotal(Double.parseDouble(FormVendas.txtValorTotal.getText()));
		
//		try {
//			
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	/*
	 * Capturar o colaborador selecionado
	 */
	public static Colaborador getColaboradorSelecionado() {

		Object selectedColaborador = FormVendas.cmbColaborador.getSelectedItem();

		if (selectedColaborador != null) {

			String idColaborador = selectedColaborador.toString();
			String[] itens = idColaborador.split("-");

			Colaborador colaborador = new Colaborador();
			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = DriverManager
						.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

				String query = "SELECT * FROM colaboradores WHERE id = " + itens[0] + " ;";

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					// Recuperar os dados do colaborador
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String cpf = rs.getString("cpf");
					String telefone = rs.getString("telefone");
					String endereco = rs.getString("endereco");
					double salario = rs.getDouble("salario");
					String cargo = rs.getString("cargo");

					colaborador = new Colaborador();
					colaborador.setIdColaborador(id);
					colaborador.setNome(nome);
					colaborador.setCpf(cpf);
					colaborador.setTelefone(telefone);
					colaborador.setEndereco(endereco);
					colaborador.setSalario(salario);
					colaborador.setCargo(cargo);

				}

				con.close();
				rs.close();
				stmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return colaborador;
		}
		return null; // Retorne null ou trate o caso em que nenhum item está selecionado
	}
	
	/*
	 * Capturar o cliente selecionado
	 */
	public static Cliente getClienteSelecionado() {

		Object selectedCliente = FormVendas.cmbCliente.getSelectedItem();

		if (selectedCliente != null) {

			String idCliente = selectedCliente.toString();
			String[] itens = idCliente.split("-");

			Cliente cliente = new Cliente();
			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = DriverManager
						.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

				String query = "SELECT * FROM clientes WHERE id = " + itens[0] + " ;";

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					// Recuperar os dados do cliente
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String cpf = rs.getString("cpf");
					String telefone = rs.getString("telefone");
					String endereco = rs.getString("endereco");

					cliente = new Cliente();
					cliente.setIdCliente(id);
					cliente.setNome(nome);
					cliente.setCpf(cpf);
					cliente.setTelefone(telefone);
					cliente.setEndereco(endereco);

				}

				con.close();
				rs.close();
				stmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(cliente.getIdCliente());
			System.out.println(cliente.getNome());
			return cliente;
		}
		return null; // Retorne null ou trate o caso em que nenhum item está selecionado
	}

	/*
	 * Capturar o cliente selecionado
	 */
	public static Veiculo getVeiculoSelecionado() {

		Object selectedVeiculo = FormVendas.cmbVeiculo.getSelectedItem();

		if (selectedVeiculo != null) {

			String idVeiculo = selectedVeiculo.toString();
			String[] itens = idVeiculo.split("-");

			Veiculo veiculo = new Veiculo();
			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = DriverManager
						.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

				String query = "SELECT * FROM veiculos WHERE id = " + itens[0] + " ;";

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					// Recuperar os dados do veiculo
					int id = rs.getInt("id");
					String modelo = rs.getString("modelo");
					String chassi = rs.getString("chassi");
					String cor = rs.getString("cor");
					String placa = rs.getString("placa");
					String ano = rs.getString("ano");
					double valor = rs.getDouble("valor");

					veiculo = new Veiculo();
					veiculo.setIdVeiculo(id);
					veiculo.setModelo(modelo);
					veiculo.setChassi(chassi);
					veiculo.setCor(cor);
					veiculo.setPlaca(placa);
					veiculo.setAno(ano);
					veiculo.setValor(valor);

				}

				con.close();
				rs.close();
				stmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(veiculo.getIdVeiculo());
			System.out.println(veiculo.getModelo());
			return veiculo;
		}
		return null; // Retorne null ou trate o caso em que nenhum item está selecionado
	}	
	
//	public static void editarvenda() {
//		Venda venda = new Venda();
//
//		venda.setValorTotal(Double.parseDouble(FormVendas.txtValorTotal.getText()));
//		
//		try {
//			DAOVendas.editarvenda(venda);
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	
    
    
}
