package br.com.concessionaria.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.concessionaria.view.FormOS;
import br.com.concessionaria.dao.DAOOrdemServico;

public class OrdemServico {
	
	private static int idOrdemServico = 0;
    private static Veiculo veiculo;
    private static Cliente cliente;
    private static Colaborador colaborador;
    private static Servico servico;
    private static double valorOS = 0;
    
    // Construtor da classe
    public OrdemServico(int idOrdemServico, Colaborador colaborador, Veiculo veiculo, Cliente cliente, Servico servico, double valorTotal) {
    	this.idOrdemServico = idOrdemServico;
        this.colaborador = colaborador;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.servico = servico;
        this.valorOS = valorTotal;
    }
        
	public OrdemServico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int getIdOrdemServico() {
		return idOrdemServico;
	}

	public static void setIdOrdemServico(int idOrdemServico) {
		OrdemServico.idOrdemServico = idOrdemServico;
	}

	public static Veiculo getVeiculo() {
		return veiculo;
	}

	public static void setVeiculo(Veiculo veiculo) {
		OrdemServico.veiculo = veiculo;
	}

	public static Cliente getCliente() {
		return cliente;
	}

	public static void setCliente(Cliente cliente) {
		OrdemServico.cliente = cliente;
	}

	public static Colaborador getColaborador() {
		return colaborador;
	}

	public static void setColaborador(Colaborador colaborador) {
		OrdemServico.colaborador = colaborador;
	}

	public static Servico getServico() {
		return servico;
	}

	public static void setServico(Servico servico) {
		OrdemServico.servico = servico;
	}

	public static double getValorOS() {
		return valorOS;
	}

	public static void setValorTotal(double valorTotal) {
		OrdemServico.valorOS = valorTotal;
	}
	
	public static void cadastrarOS() {
		OrdemServico ordemServico = new OrdemServico();

		ordemServico.setCliente(getClienteSelecionado());
		ordemServico.setColaborador(getColaboradorSelecionado());
		ordemServico.setServico(getServicoSelecionado());
		ordemServico.setVeiculo(getVeiculoSelecionado());
		ordemServico.setValorTotal(Double.parseDouble(FormOS.txtValorOS.getText()));
		
		try {
			DAOOrdemServico.cadastrarOS(ordemServico);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Capturar o cliente selecionado
	 */
	public static Cliente getClienteSelecionado() {

		Object selectedCliente = FormOS.cmbCliente.getSelectedItem();

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
				return cliente;
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				e.printStackTrace();
			}
		
		}
		return null;
	}
	
	/*
	 * Capturar o colaborador selecionado
	 */
	public static Colaborador getColaboradorSelecionado() {

		Object selectedColaborador = FormOS.cmbColaborador.getSelectedItem();

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
				return colaborador;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	/*
	 * Capturar o colaborador selecionado
	 */
	public static Servico getServicoSelecionado() {

		Object selectedServico = FormOS.cmbServico.getSelectedItem();

		if (selectedServico != null) {

			String idServico = selectedServico.toString();
			String[] itens = idServico.split("-");

			Servico servico = new Servico();
			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = DriverManager
						.getConnection("jdbc:sqlite:src/br/com/concessionaria/dao/concessionaria.db");

				String query = "SELECT * FROM servicos WHERE id = " + itens[0] + " ;";

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					// Recuperar os dados do servico
					Integer id = rs.getInt("id");
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");
					double valor = rs.getDouble("valor");

					servico = new Servico();
					servico.setIdServico(id);
					servico.setNome(nome);
					servico.setDescricao(descricao);
					servico.setValor(valor);
				}

				con.close();
				rs.close();
				stmt.close();
				return servico;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	/*
	 * Capturar o cliente selecionado
	 */
	public static Veiculo getVeiculoSelecionado() {

		Object selectedVeiculo = FormOS.cmbVeiculo.getSelectedItem();

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
				
				return veiculo;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				e.printStackTrace();
			}
		
		}
		return null;
	}	
}
