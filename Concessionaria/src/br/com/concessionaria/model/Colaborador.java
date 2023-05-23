package br.com.concessionaria.model;

import java.sql.SQLException;
import javax.swing.JComboBox;
import br.com.concessionaria.dao.DAOColaboradores;
import br.com.concessionaria.view.FormColaboradores;

public class Colaborador {

	private static int idColaborador = 0;
	private static String nome = "";
	private static String cpf = "";
	private static String telefone = "";
	private static String endereco = "";
	private static String cargo = "";

	public Colaborador(int idColaborador, String nome, String cpf, String telefone, String endereco ,String cargo) {
		super();
		this.idColaborador = idColaborador;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cargo = cargo;
	}
	public Colaborador() {
	}

	public static void cadastrarColaborador() {
		Colaborador colaborador = new Colaborador();
	
		//JComboBox combo = new JComboBox();
		
		colaborador.setNome(FormColaboradores.txtNome.getText());
		colaborador.setCpf(FormColaboradores.txtCPF.getText());
		colaborador.setEndereco(FormColaboradores.txtEndereco.getText());
		colaborador.setTelefone(FormColaboradores.txtTelefone.getText());
	    colaborador.setCargo(FormColaboradores.cmbCargo.getSelectedItem().toString());
		
		try {
			DAOColaboradores.cadastrarColaborador();
					
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int getIdColaborador() {
		return idColaborador;
	}
	public static void setIdColaborador(int idColaborador) {
		Colaborador.idColaborador = idColaborador;
	}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Colaborador.nome = nome;
	}
	public static String getCpf() {
		return cpf;
	}
	public static void setCpf(String cpf) {
		Colaborador.cpf = cpf;
	}
	public static String getTelefone() {
		return telefone;
	}
	public static void setTelefone(String telefone) {
		Colaborador.telefone = telefone;
	}
	public static String getEndereco() {
		return endereco;
	}
	public static void setEndereco(String endereco) {
		Colaborador.endereco = endereco;
	}
	public static Object getCargo() {
		return cargo;
	}
	public static void setCargo(String cargo) {
		Colaborador.cargo = cargo;
	}

	
}
