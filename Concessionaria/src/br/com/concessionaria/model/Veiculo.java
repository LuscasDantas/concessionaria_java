package br.com.concessionaria.model;

import br.com.concessionaria.view.FormVeiculos;

public class Veiculo {

	private static int idVeiculo = 0;
	private static double valor = 0;
	private static String modelo = "";
	private static String chassi = "";
	private static String cor = "";
	private static String placa = "";
	private static String ano = "";

	public Veiculo(int idVeiculo, double valor, String modelo, String chassi, String cor, String placa, String ano) {
		super();
		this.idVeiculo = idVeiculo;
		this.modelo = modelo;
		this.chassi = chassi;
		this.cor = cor;
		this.placa = placa;
		this.ano = ano;
		this.valor = valor;
	}

	public Veiculo() {

	}

	public void cadastrarVeiculo() {
		Veiculo veiculo = new Veiculo();
		veiculo.setModelo(FormVeiculos.txtModelo.getText());
		veiculo.setChassi(FormVeiculos.txtChassi.getText());
		veiculo.setCor(FormVeiculos.txtCor.getText());
		veiculo.setPlaca(FormVeiculos.txtPlaca.getText());
		veiculo.setAno(FormVeiculos.txtAno.getText());
		veiculo.setValor((double) FormVeiculos.txtValor.getValue());
	}

	public static int getIdVeiculo() {
		return idVeiculo;
	}

	public static void setIdVeiculo(int idVeiculo) {
		Veiculo.idVeiculo = idVeiculo;
	}

	public static double getValor() {
		return valor;
	}

	public static void setValor(double valor) {
		Veiculo.valor = valor;
	}

	public static String getModelo() {
		return modelo;
	}

	public static void setModelo(String modelo) {
		Veiculo.modelo = modelo;
	}

	public static String getChassi() {
		return chassi;
	}

	public static void setChassi(String chassi) {
		Veiculo.chassi = chassi;
	}

	public static String getCor() {
		return cor;
	}

	public static void setCor(String cor) {
		Veiculo.cor = cor;
	}

	public static String getPlaca() {
		return placa;
	}

	public static void setPlaca(String placa) {
		Veiculo.placa = placa;
	}

	public static String getAno() {
		return ano;
	}

	public static void setAno(String ano) {
		Veiculo.ano = ano;
	}

}
