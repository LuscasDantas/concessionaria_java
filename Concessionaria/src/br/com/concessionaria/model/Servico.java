package br.com.concessionaria.model;

import br.com.concessionaria.dao.DAOServicos;
import br.com.concessionaria.view.FormServicos;

import java.sql.SQLException;

public class Servico {
	
	private static int idServico = 0;
	private static double valor = 0;
	private static String nome = "";
	private static String descricao = "";

	public Servico(int idServico, String nome, String descricao, double valor) {
		super();
		this.idServico = idServico;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Servico() {
		
	}
	
	public static void cadastrarServico() {
		Servico servico = new Servico();
		servico.setNome(FormServicos.txtNome.getText());
		servico.setDescricao(FormServicos.textDescricao.getText());
		servico.setValor(Double.parseDouble(FormServicos.txtValor.getText()));
		
		try {
			DAOServicos.cadastrarServico(servico);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editarServico() {
		Servico servico = new Servico();
		servico.setNome(FormServicos.txtNome.getText());
		servico.setDescricao(FormServicos.textDescricao.getText());
		servico.setValor(Double.parseDouble(FormServicos.txtValor.getText()));
		
		try {
			DAOServicos.editarServico(servico);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getIdServico() {
		return idServico;
	}

	public static void setIdServico(int idServico) {
		Servico.idServico = idServico;
	}

	public static double getValor() {
		return valor;
	}

	public static void setValor(double valor) {
		Servico.valor = valor;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Servico.nome = nome;
	}

	public static String getDescricao() {
		return descricao;
	}

	public static void setDescricao(String descricao) {
		Servico.descricao = descricao;
	}

}
