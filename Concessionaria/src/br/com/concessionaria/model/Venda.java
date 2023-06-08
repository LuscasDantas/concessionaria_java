package br.com.concessionaria.model;

import java.sql.SQLException;

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


	public static void cadastrarVenda() {
		Venda venda = new Venda();

		venda.setColaborador(FormVendas.cmbColaborador.getSelectedItem().toString());

		venda.setValorTotal(Double.parseDouble(FormVendas.txtValorTotal.getText()));
		
		try {
			DAOvendas.cadastrarvenda(venda);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editarvenda() {
		Venda venda = new Venda();

		venda.setValorTotal(Double.parseDouble(FormVendas.txtValorTotal.getText()));
		
		try {
			DAOVendas.editarvenda(venda);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Colaborador getColaborador() {
		return colaborador;
	}

	public static void setColaborador(Colaborador colaborador) {
		Venda.colaborador = colaborador;
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

	public static int getIdVenda() {
		return idVenda;
	}

	public static void setIdVenda(int idVenda) {
		Venda.idVenda = idVenda;
	}

	public static double getValorTotal() {
		return valorTotal;
	}

	public static void setValorTotal(double valorTotal) {
		Venda.valorTotal = valorTotal;
	}
    
    
}
