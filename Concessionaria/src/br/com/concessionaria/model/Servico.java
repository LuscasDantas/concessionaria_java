package br.com.concessionaria.model;

public class Servico {
	
	private static int idServico = 0;
	private static double valor = 0;
	private static String nome = "";
	private static String descricao = "";

	public Servico() {
		super();
		// TODO Auto-generated constructor stub
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
