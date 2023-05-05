package br.com.concessionaria.model;

import br.com.concessionaria.view.FormPrincipal;
import br.com.concessionaria.view.Veiculos;

public class Veiculo {
	
	private static int idVeiculo = 0;
	private static double valor = 0;
	private static String modelo = "";
	private static String chassi = "";
	private static String cor = "";
	private static String placa = "";
	private static String ano = "";
	
	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void CadastrarVeiculo() {

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

	@Override
	public String toString() {
		return "Veiculo [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
