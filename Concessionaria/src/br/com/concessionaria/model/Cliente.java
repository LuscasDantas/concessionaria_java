package br.com.concessionaria.model;

import java.sql.SQLException;
import br.com.concessionaria.view.FormClientes;
import br.com.concessionaria.view.FormColaboradores;
import br.com.concessionaria.dao.DAOClientes;
import br.com.concessionaria.dao.DAOColaboradores;

public class Cliente {

	private static int idCliente = 0;
	private static String nome = "";
	private static String cpf = "";
	private static String telefone = "";
	private static String endereco = "";

	public Cliente(int idCliente, String nome, String cpf, String telefone, String endereco) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public Cliente() {
	}

	public static void cadastrarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(FormClientes.txtNome.getText());
		cliente.setCpf(FormClientes.txtCPF.getText());
		cliente.setTelefone(FormClientes.txtTelefone.getText());
		cliente.setEndereco(FormClientes.txtEndereco.getText());
		
		try {
			DAOClientes.cadastrarCliente(cliente);
					
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editarColaborador() {
		Cliente cliente = new Cliente();
		cliente.setNome(FormClientes.txtNome.getText());
		cliente.setCpf(FormClientes.txtCPF.getText());
		cliente.setEndereco(FormClientes.txtEndereco.getText());
		cliente.setTelefone(FormClientes.txtTelefone.getText());
		
		try {
			DAOClientes.editarCliente(cliente);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getIdCliente() {
		return idCliente;
	}

	public static void setIdCliente(int idCliente) {
		Cliente.idCliente = idCliente;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Cliente.nome = nome;
	}

	public static String getCpf() {
		return cpf;
	}

	public static void setCpf(String cpf) {
		Cliente.cpf = cpf;
	}

	public static String getTelefone() {
		return telefone;
	}

	public static void setTelefone(String telefone) {
		Cliente.telefone = telefone;
	}

	public static String getEndereco() {
		return endereco;
	}

	public static void setEndereco(String endereco) {
		Cliente.endereco = endereco;
	}

	
}
